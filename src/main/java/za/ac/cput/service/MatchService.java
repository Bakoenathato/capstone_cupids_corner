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
import za.ac.cput.repository.MatchRepository;
import za.ac.cput.repository.UserprofileRepository;

import java.util.List;

@Service
public class MatchService implements IMatchService {

    private UserprofileRepository profileRepository;
    private MatchRepository matchRepository;

    @Autowired
    MatchService(MatchRepository matchRepository, UserprofileRepository profileRepository) {
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
    public Match read(Integer matchId) {
        return matchRepository.findById(matchId).orElse(null);
    }

    @Override
    public Match update(Match match) {
        profileRepository.save(match.getProfile1());
        profileRepository.save(match.getProfile2());
        return matchRepository.save(match);
    }

    @Override
    public void delete(Integer matchId) {
        matchRepository.deleteById(matchId);
    }

    @Override
    public List<Match> getAll() {
        return matchRepository.findAll();
    }
}
