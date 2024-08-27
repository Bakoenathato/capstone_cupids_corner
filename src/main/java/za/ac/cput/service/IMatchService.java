package za.ac.cput.service;
/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import za.ac.cput.domain.Match;

import java.util.List;

public interface IMatchService extends IService<Match, Integer> {
    List<Match> getAll();
}
