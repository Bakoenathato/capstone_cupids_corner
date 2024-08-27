package za.ac.cput.service;

/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import za.ac.cput.domain.Preference;

import java.util.List;

public interface IPreferenceService extends IService<Preference, Long> {
    List<Preference> getAll();
}
