@Service
public class MatchAttemptServiceImpl implements MatchAttemptService {

    private final MatchAttemptRecordRepository repo;
    private final CompatibilityScoreRecordRepository scoreRepo;

    public MatchAttemptServiceImpl(
            MatchAttemptRecordRepository r,
            CompatibilityScoreRecordRepository s) {
        this.repo = r;
        this.scoreRepo = s;
    }

    public MatchAttemptRecord logMatchAttempt(MatchAttemptRecord a) {
        if (a.getResultScoreId() != null &&
                scoreRepo.findById(a.getResultScoreId()).isPresent()) {
            a.setStatus(MatchAttemptRecord.Status.MATCHED);
        } else {
            a.setStatus(MatchAttemptRecord.Status.PENDING_REVIEW);
        }
        return repo.save(a);
    }

    public MatchAttemptRecord updateAttemptStatus(Long id, String status) {
        MatchAttemptRecord a = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not found"));
        a.setStatus(MatchAttemptRecord.Status.valueOf(status));
        return repo.save(a);
    }

    public List<MatchAttemptRecord> getAttemptsByStudent(Long id) {
        return repo.findByInitiatorStudentIdOrCandidateStudentId(id, id);
    }

    public List<MatchAttemptRecord> getAllMatchAttempts() { return repo.findAll(); }
}
