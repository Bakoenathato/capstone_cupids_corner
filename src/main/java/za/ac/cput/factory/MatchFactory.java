package za.ac.cput.factory;

/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import za.ac.cput.domain.Match;
import za.ac.cput.domain.User;

public class MatchFactory {
    public static Match buildMatch(User user1Id, User user2Id) {
        if (user1Id == null || user2Id == null)
            return null;

        return new Match.Builder()
                .setUser1Id(user1Id)
                .setUser2Id(user2Id)
                .build();
    }
}
