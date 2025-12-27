@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping
    public MatchResult match(@RequestParam Long a, @RequestParam Long b) {
        return matchService.calculateMatch(a, b);
    }

    @GetMapping
    public List<MatchResult> all() {
        return matchService.getAllMatches();
    }
}
