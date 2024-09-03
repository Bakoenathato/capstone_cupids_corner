package za.ac.cput.factory;

/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import za.ac.cput.domain.Match;
import za.ac.cput.domain.MatchStatus;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;

public class MatchFactory {
    public static Match buildMatch(User profile1, User profile2, MatchStatus status) {
        if (profile1 == null || profile2 == null || status == null)
            return null;

        return new Match.Builder()
                .setProfile1(profile1)
                .setProfile2(profile2)
                .setStatus(status)
                .build();
    }
}
