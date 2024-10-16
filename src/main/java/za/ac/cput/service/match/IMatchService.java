package za.ac.cput.service.match;
/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import za.ac.cput.domain.match.Match;
import za.ac.cput.domain.user.User;
import za.ac.cput.service.IService;

import java.util.List;

public interface IMatchService extends IService<Match, Long> {
    List<Match> getAll();

    Match createMatch(User profile1, User profile2);
}
