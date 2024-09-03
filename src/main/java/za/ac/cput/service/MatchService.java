package za.ac.cput.service;

/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Match;
import za.ac.cput.domain.MatchStatus;
import za.ac.cput.domain.User;
import za.ac.cput.repository.MatchRepository;
import za.ac.cput.repository.UserRepository;
import za.ac.cput.repository.UserprofileRepository;

import java.util.List;

@Service
public class MatchService implements IMatchService {

    private UserRepository profileRepository;
    private MatchRepository matchRepository;

    @Autowired
    MatchService(MatchRepository matchRepository, UserRepository profileRepository) {
        this.profileRepository = profileRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public Match create(Match match) {
        profileRepository.save(match.getProfile1());
        profileRepository.save(match.getProfile2());
        return matchRepository.save(match);
    }

    @Override
    public Match read(Long matchId) {
        return matchRepository.findById(matchId).orElse(null);
    }

    @Override
    public Match update(Match match) {
        profileRepository.save(match.getProfile1());
        profileRepository.save(match.getProfile2());
        return matchRepository.save(match);
    }

    @Override
    public void delete(Long matchId) {
        matchRepository.deleteById(matchId);
    }

    @Override
    public List<Match> getAll() {
        return matchRepository.findAll();
    }

    @Override
    public Match createMatch(User profile1, User profile2) {
        // profile 1 has a lower id than profile 2 to maintain order
        if ( profile1.getUserId() > profile2.getUserId() ) {
            User temp = profile1;
            profile1 = profile2;
            profile2 = temp;
        }

        Match match = new Match.Builder()
                .setProfile1(profile1)
                .setProfile2(profile2)
                .setStatus(MatchStatus.PENDING)
                .build();

        return matchRepository.save(match);
    }
}
