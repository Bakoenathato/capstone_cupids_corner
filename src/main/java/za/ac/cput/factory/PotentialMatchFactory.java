package za.ac.cput.factory;

import za.ac.cput.domain.MatchStatus;
import za.ac.cput.domain.PotentialMatch;
import za.ac.cput.domain.User;

public class PotentialMatchFactory {
    public static PotentialMatch createPotentialMatch(User user1, User user2, MatchStatus matchStatus) {
        if (user1 == null || user2 == null || matchStatus == null)
            return null;

        return new PotentialMatch.Builder()
                .setUser1(user1)
                .setUser2(user2)
                .setMatchStatus(matchStatus)
                .build();
    }
}
