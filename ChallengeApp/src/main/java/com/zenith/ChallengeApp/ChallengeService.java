package com.zenith.ChallengeApp;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// JPA

@Service
public class ChallengeService {
    // private List<Challenge> challenges = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    ChallengeRepository challengeRepository;
     
    public ChallengeService() {
        // challenges.add(new Challenge(1L, "Jan", "Description for Challenge 1"));
        // challenges.add(new Challenge(2L, "Feb", "Description for Challenge 2"));
        // challenges.add(new Challenge(3L, "Mar", "Description for Challenge 3"));
    }

    public List<Challenge> getAllChallenges() {
        return challengeRepository.findAll();
    }

    public Challenge getChallengeByMonth(String month) {
        Optional<Challenge> challenge = challengeRepository.findByMonthIgnoreCase(month);
        return challenge.orElse(null);
    }
    public Challenge getChallenge(Long id) {
        return challengeRepository.findById(id).orElse(null);
    }

    public boolean addChallenge(Challenge challenge) {
       if (challenge != null) {
           challenge.setId(nextId++);
           challengeRepository.save(challenge);
           return true;
       }else {
           return false;
       }
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge) {
        Optional<Challenge> challenge = challengeRepository.findById(id);
        if (challenge.isPresent()) {
            Challenge challengeToUpdate = challenge.get();
            challengeToUpdate.setMonth(updatedChallenge.getMonth());
            challengeToUpdate.setDescription(updatedChallenge.getDescription());
            challengeRepository.save(challengeToUpdate);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteChallenge(Long id) {
        if (challengeRepository.existsById(id)) {
            challengeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}