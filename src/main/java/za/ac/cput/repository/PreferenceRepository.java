package za.ac.cput.repository;
/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Preference;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}
