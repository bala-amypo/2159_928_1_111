package com.example.demo.service;

import com.example.demo.dto.HabitProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.HabitProfile;
import com.example.demo.model.StudentProfile;
import com.example.demo.repository.HabitProfileRepository;
import com.example.demo.repository.StudentProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitProfileRepository;
    private final StudentProfileRepository studentProfileRepository;

    public HabitProfileServiceImpl(HabitProfileRepository habitProfileRepository, 
                                  StudentProfileRepository studentProfileRepository) {
        this.habitProfileRepository = habitProfileRepository;
        this.studentProfileRepository = studentProfileRepository;
    }

    @Override
    public HabitProfile createOrUpdate(Long studentId, HabitProfileDto dto) {
        StudentProfile student = studentProfileRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        validateDto(dto);

        HabitProfile profile = habitProfileRepository.findByStudentId(studentId)
                .orElse(new HabitProfile());

        mapDtoToEntity(dto, profile);
        profile.setStudent(student);

        return habitProfileRepository.save(profile);
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        return habitProfileRepository.findByStudentId(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Profile not found"));
    }

    private void validateDto(HabitProfileDto dto) {
        if (dto.getCleanlinessLevel() != null && (dto.getCleanlinessLevel() < 1 || dto.getCleanlinessLevel() > 5)) {
            throw new IllegalArgumentException("Cleanliness level must be in range 1-5");
        }
        if (dto.getNoisePreference() != null && (dto.getNoisePreference() < 1 || dto.getNoisePreference() > 5)) {
            throw new IllegalArgumentException("Noise preference must be in range 1-5");
        }
    }

    private void mapDtoToEntity(HabitProfileDto dto, HabitProfile profile) {
        profile.setSmoking(dto.getSmoking());
        profile.setDrinking(dto.getDrinking());
        profile.setSleepTime(dto.getSleepTime());
        profile.setWakeTime(dto.getWakeTime());
        profile.setCleanlinessLevel(dto.getCleanlinessLevel());
        profile.setNoisePreference(dto.getNoisePreference());
        profile.setStudyStyle(dto.getStudyStyle());
        profile.setSocialPreference(dto.getSocialPreference());
        profile.setVisitorsFrequency(dto.getVisitorsFrequency());
    }
}