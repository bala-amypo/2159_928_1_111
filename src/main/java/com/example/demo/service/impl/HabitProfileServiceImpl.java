@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository repo;

    public HabitProfileServiceImpl(HabitProfileRepository repo) {
        this.repo = repo;
    }

    public HabitProfile createOrUpdateHabit(HabitProfile h) {
        if (h.getStudyHoursPerDay() <= 0)
            throw new IllegalArgumentException("study hours");

        HabitProfile existing = repo.findByStudentId(h.getStudentId()).orElse(null);
        if (existing != null) {
            h.setId(existing.getId());
        }
        h.setUpdatedAt(LocalDateTime.now());
        return repo.save(h);
    }

    public HabitProfile getHabitByStudent(Long id) {
        return repo.findByStudentId(id).orElseThrow(() -> new ResourceNotFoundException("not found"));
    }

    public Optional<HabitProfile> getHabitById(Long id) { return repo.findById(id); }
    public List<HabitProfile> getAllHabitProfiles() { return repo.findAll(); }
}
