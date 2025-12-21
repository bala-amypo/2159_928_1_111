package com.example.demo.service;

import com.example.demo.dto.StudentProfileDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.StudentProfile;
import com.example.demo.model.UserAccount;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentProfileRepository;
    private final UserAccountRepository userAccountRepository;

    public StudentProfileServiceImpl(StudentProfileRepository studentProfileRepository, 
                                   UserAccountRepository userAccountRepository) {
        this.studentProfileRepository = studentProfileRepository;
        this.userAccountRepository = userAccountRepository;
    }

    @Override
    public StudentProfile createProfile(StudentProfileDto dto, Long userId) {
        UserAccount user = userAccountRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (studentProfileRepository.findByUserAccountId(userId).isPresent()) {
            throw new IllegalArgumentException("User already has a profile");
        }

        validateDto(dto);

        StudentProfile profile = new StudentProfile();
        mapDtoToEntity(dto, profile);
        profile.setUserAccount(user);

        return studentProfileRepository.save(profile);
    }

    @Override
    public StudentProfile updateProfile(Long id, StudentProfileDto dto) {
        StudentProfile profile = studentProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));

        validateDto(dto);
        mapDtoToEntity(dto, profile);

        return studentProfileRepository.save(profile);
    }

    @Override
    public StudentProfile getProfile(Long id) {
        return studentProfileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public List<StudentProfile> getAllProfiles() {
        return studentProfileRepository.findAll();
    }

    private void validateDto(StudentProfileDto dto) {
        if (dto.getAge() != null && dto.getAge() <= 0) {
            throw new IllegalArgumentException("Age must be > 0");
        }
        if (dto.getRoomTypePreference() != null) {
            // Room type validation is handled by enum
        }
    }

    private void mapDtoToEntity(StudentProfileDto dto, StudentProfile profile) {
        profile.setName(dto.getName());
        profile.setAge(dto.getAge());
        profile.setCourse(dto.getCourse());
        profile.setYearOfStudy(dto.getYearOfStudy());
        profile.setGender(dto.getGender());
        profile.setRoomTypePreference(dto.getRoomTypePreference());
        profile.setSleepTime(dto.getSleepTime());
        profile.setWakeTime(dto.getWakeTime());
        profile.setSmoking(dto.getSmoking());
        profile.setDrinking(dto.getDrinking());
        profile.setNoiseTolerance(dto.getNoiseTolerance());
        profile.setStudyTime(dto.getStudyTime());
    }
}