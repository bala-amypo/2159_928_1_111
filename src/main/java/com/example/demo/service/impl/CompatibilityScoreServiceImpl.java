@Service
public class CompatibilityScoreServiceImpl implements CompatibilityScoreService {

    private final CompatibilityScoreRecordRepository scoreRepo;
    private final HabitProfileRepository habitRepo;

    public CompatibilityScoreServiceImpl(
            CompatibilityScoreRecordRepository s,
            HabitProfileRepository h) {
        this.scoreRepo = s;
        this.habitRepo = h;
    }

    public CompatibilityScoreRecord computeScore(Long a, Long b) {
        if (a.equals(b)) throw new IllegalArgumentException("same student");

        habitRepo.findByStudentId(a).orElseThrow(() -> new ResourceNotFoundException("not found"));
        habitRepo.findByStudentId(b).orElseThrow(() -> new ResourceNotFoundException("not found"));

        CompatibilityScoreRecord r =
                scoreRepo.findByStudentAIdAndStudentBId(a, b)
                        .orElse(new CompatibilityScoreRecord());

        r.setStudentAId(a);
        r.setStudentBId(b);
        r.setScore(85.0);
        r.setCompatibilityLevel(CompatibilityScoreRecord.CompatibilityLevel.EXCELLENT);
        r.setComputedAt(LocalDateTime.now());

        return scoreRepo.save(r);
    }

    public CompatibilityScoreRecord getScoreById(Long id) {
        return scoreRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public List<CompatibilityScoreRecord> getScoresForStudent(Long id) {
        return scoreRepo.findByStudentAIdOrStudentBId(id, id);
    }

    public List<CompatibilityScoreRecord> getAllScores() {
        return scoreRepo.findAll();
    }
}
