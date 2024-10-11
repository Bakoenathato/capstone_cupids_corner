package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Match;
import za.ac.cput.domain.MatchStatus;
import za.ac.cput.domain.PotentialMatch;
import za.ac.cput.domain.User;
import za.ac.cput.dto.MatchDTO;
import za.ac.cput.dto.SwipeDTO;
import za.ac.cput.factory.MatchFactory;
import za.ac.cput.factory.PotentialMatchFactory;
import za.ac.cput.repository.PotentialMatchRepository;
import za.ac.cput.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PotentialMatchService implements IPotentialMatchService {


    private PotentialMatchRepository potentialMatchRepository;

    private MatchService matchService;

    //private UserRepository userRepository;
    // UserRepository userRepository

    private UserService userService;

    @Autowired
    public PotentialMatchService(PotentialMatchRepository potentialMatchRepository, MatchService matchService, UserService userService) {
        this.potentialMatchRepository = potentialMatchRepository;
        this.matchService = matchService;
        //this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public PotentialMatch create(PotentialMatch potentialMatch) {
        potentialMatchRepository.save(potentialMatch);
        return potentialMatch;
    }

    @Override
    public PotentialMatch read(Long id) {
        return potentialMatchRepository.findById(id).orElseThrow(()-> new IllegalStateException("PotentialMatch with " +
                "Id " + id + " does not exist"));
    }

    @Override
    public PotentialMatch update(PotentialMatch potentialMatch) {
        if (potentialMatchRepository.existsById(potentialMatch.getId())){
            return potentialMatchRepository.save(potentialMatch);
        } else {
            throw new IllegalStateException("PotentialMatch with Id " + potentialMatch.getId() + " does not exist");
        }
    }

    @Override
    public void delete(Long id) {
        potentialMatchRepository.deleteById(id);
    }

    @Override
    public List<PotentialMatch> getAll() {
        return potentialMatchRepository.findAll();
    }


    public MatchDTO processSwipe(SwipeDTO swipe) {
//        User user1 = userRepository.findById(swipe.getUser1Id())
//                .orElseThrow(() -> new IllegalStateException("User with id " + swipe.getUser1Id() + " does not exist"));
//
//        User user2 = userRepository.findById(swipe.getUser2Id())
//                .orElseThrow(() -> new IllegalStateException("User with id " + swipe.getUser2Id() + " does not exist"));

        User user1 = userService.read(swipe.getUser1Id());
        User user2 = userService.read(swipe.getUser2Id());

        if ("right".equalsIgnoreCase(swipe.getDirection())) {
            // check if there's an existing potential match in the opposite direction
            Optional<PotentialMatch> existingMatch = potentialMatchRepository.findByUser1_IdAndUser2_Id(user1.getId(), user2.getId());

            if (existingMatch.isPresent() && existingMatch.get().getMatchStatus() == MatchStatus.PENDING) {
                // both users have swiped right, create the match
                Match newMatch = MatchFactory.buildMatch(user1, user2);
                Match savedMatch = matchService.create(newMatch);

                // update the existing match status
                existingMatch.get().setMatchStatus(MatchStatus.MATCHED);
                potentialMatchRepository.save(existingMatch.get());

                // create a new MatchDTO to return
                return new MatchDTO(
                        savedMatch.getMatchId(),
                        savedMatch.getUser1Id().getId(),
                        savedMatch.getUser2Id().getId()
                        );
            } else {
                // create a new potential match
                PotentialMatch newPotentialMatch = PotentialMatchFactory.createPotentialMatch(
                        user1, user2, MatchStatus.PENDING
                );

                potentialMatchRepository.save(newPotentialMatch);
                }
            }
        else if ("left".equalsIgnoreCase(swipe.getDirection())) {
            // if swiped left we can reject the swiped user
            PotentialMatch newPotentialMatch = PotentialMatchFactory.createPotentialMatch(user1, user2, MatchStatus.REJECTED);
            potentialMatchRepository.save(newPotentialMatch);
        }

        // if no match was created
        return null;
    }
}
