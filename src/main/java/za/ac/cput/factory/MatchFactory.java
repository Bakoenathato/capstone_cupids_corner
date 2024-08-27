package za.ac.cput.factory;

/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import za.ac.cput.domain.Match;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;

public class MatchFactory {
    public static Match buildMatch(int matchId, UserProfile profile1, UserProfile profile2) {
        if (Helper.isZero(matchId) || profile1 == null || profile2 == null)
            return null;

        return new Match.Builder().setMatchId(matchId)
                .setProfile1(profile1)
                .setProfile2(profile2)
                .build();
    }
}
