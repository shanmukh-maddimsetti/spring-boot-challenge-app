package com.zenith.ChallengeApp;
import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChallengeController {
    public List<Challenge> challenges = new ArrayList<>();
    public ChallengeController() {
        challenges.add(new Challenge(1L, "Challenge 1", "Description for Challenge 1"));
        challenges.add(new Challenge(2L, "Challenge 2", "Description for Challenge 2"));
        challenges.add(new Challenge(3L, "Challenge 3", "Description for Challenge 3"));
    }

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges() {
        return challenges;
    }
}
