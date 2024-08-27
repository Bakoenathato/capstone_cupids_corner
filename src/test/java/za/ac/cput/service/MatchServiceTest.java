package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.DisplayImage;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Match;
import za.ac.cput.domain.User;
import za.ac.cput.factory.DisplayImageFactory;
import za.ac.cput.factory.MatchFactory;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.service.MatchService;
import za.ac.cput.testData.MatchTestData;
import za.ac.cput.testData.UserData.UserProfileTestData;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class MatchServiceTest {

    @Autowired
    private MatchService matchService;

    private Match match;



    @Test
    void a_create(){
        Match createdMatch1 = matchService.create(match);
        assertNotNull(createdMatch1);
        System.out.println(createdMatch1);
    }

//    @Test
//    void b_read() {
//        Match readMatch = matchService.read(match.getMatchId());
//        assertNotNull(readMatch);
//        System.out.println(readMatch);
//    }
//
//    @Test
//    void c_update() {
//        Match newMatch = new Match.Builder().copy(match)
//                .setMatchId(3)
//                .build();
//        Match updatedMatch = matchService.update(newMatch);
//        assertNotNull(updatedMatch);
//        System.out.println(updatedMatch);
//    }

    @Test
    void d_getAll() {
        System.out.println(matchService.getAll());
    }
}