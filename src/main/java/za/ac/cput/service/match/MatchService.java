package za.ac.cput.service.match;

/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.match.Match;
import za.ac.cput.domain.user.User;
import za.ac.cput.repository.MatchRepository;
import za.ac.cput.repository.UserRepository;

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
        profileRepository.save(match.getUser1Id());
        profileRepository.save(match.getUser2Id());
        return matchRepository.save(match);
    }

    @Override
    public Match read(Long matchId) {
        return matchRepository.findById(matchId).orElse(null);
    }

    @Override
    public Match update(Match match) {
        profileRepository.save(match.getUser1Id());
        profileRepository.save(match.getUser2Id());
        return matchRepository.save(match);
    }

    @Override
    public boolean delete(Long matchId) {
        if (matchRepository.existsById(matchId)) {
            matchRepository.deleteById(matchId);
            profileRepository.deleteById(matchId);
            return true;
        } else {
            throw new IllegalStateException("Match with id " + matchId + " does not exist");
        }
//        matchRepository.deleteById(matchId);
    }

    @Override
    public List<Match> getAll() {
        return matchRepository.findAll();
    }

    @Override
    public Match createMatch(User profile1, User profile2) {
        // profile 1 has a lower id than profile 2 to maintain order
        if ( profile1.getId() > profile2.getId() ) {
            User temp = profile1;
            profile1 = profile2;
            profile2 = temp;
        }

        Match match = new Match.Builder()
                .setUser1Id(profile1)
                .setUser2Id(profile2)
                .build();

        return matchRepository.save(match);
    }
}
