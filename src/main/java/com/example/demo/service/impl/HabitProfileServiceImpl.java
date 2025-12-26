@Service
public class HabitProfileServiceImpl implements HabitProfileService {

    private final HabitProfileRepository habitRepo;

    public HabitProfileServiceImpl(HabitProfileRepository habitRepo) {
        this.habitRepo = habitRepo;
    }

    @Override
    public HabitProfile getForStudent(Long studentId) {
        return habitRepo.findByStudentId(studentId).orElse(null);
    }

    @Override
    public HabitProfile save(HabitProfile habit) {
        return habitRepo.save(habit);
    }

    @Override
    public List<HabitProfile> getAll() {
        return habitRepo.findAll();
    }
}
