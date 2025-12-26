@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repo;

    public StudentProfileServiceImpl(StudentProfileRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public StudentProfile findByStudentId(String studentId) {
        return repo.findByStudentId(studentId).orElse(null);
    }

    @Override
    public StudentProfile save(StudentProfile student) {
        return repo.save(student);
    }

    @Override
    public void updateStudentStatus(Long id, boolean status) {
        StudentProfile s = repo.findById(id).orElse(null);
        if (s != null) {
            s.setActive(status);
            repo.save(s);
        }
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return repo.findAll();
    }
}
