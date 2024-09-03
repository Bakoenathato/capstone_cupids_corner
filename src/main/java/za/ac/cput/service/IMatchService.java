package za.ac.cput.service;
/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import za.ac.cput.domain.Match;
import za.ac.cput.domain.User;

import java.util.List;

public interface IMatchService extends IService<Match, Long> {
    List<Match> getAll();

    Match createMatch(User profile1, User profile2);
}
