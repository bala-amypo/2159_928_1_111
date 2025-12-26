@Service
public class RoomAssignmentServiceImpl implements RoomAssignmentService {

    private final RoomAssignmentRecordRepository repo;
    private final StudentProfileRepository studentRepo;

    public RoomAssignmentServiceImpl(
            RoomAssignmentRecordRepository r,
            StudentProfileRepository s) {
        this.repo = r;
        this.studentRepo = s;
    }

    public RoomAssignmentRecord assignRoom(RoomAssignmentRecord r) {
        StudentProfile a = studentRepo.findById(r.getStudentAId())
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        StudentProfile b = studentRepo.findById(r.getStudentBId())
                .orElseThrow(() -> new ResourceNotFoundException("not found"));

        if (!a.getActive() || !b.getActive())
            throw new IllegalArgumentException("both students must be active");

        r.setStatus(RoomAssignmentRecord.Status.ACTIVE);
        return repo.save(r);
    }

    public RoomAssignmentRecord updateStatus(Long id, String s) {
        RoomAssignmentRecord r = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        r.setStatus(RoomAssignmentRecord.Status.valueOf(s));
        return repo.save(r);
    }

    public RoomAssignmentRecord getAssignmentById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public List<RoomAssignmentRecord> getAssignmentsByStudent(Long id) {
        return repo.findByStudentAIdOrStudentBId(id, id);
    }

    public List<RoomAssignmentRecord> getAllAssignments() {
        return repo.findAll();
    }
}
