package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.testData.UserData.UserProfileTestData;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserprofileServiceTest {

    @Autowired
    private UserprofileService userprofileService;

    private UserProfile userProfile1;

    @BeforeEach
    void setUp() {
        userProfile1 = UserProfileTestData.getUserProfileWithBuilder101();
    }

    @Test
    @Order(1)
    void create() {

    }

    @Test
    @Order(2)
    void read() {
    }

    @Test
    @Order(3)
    void update() {
    }

    @Disabled
    @Test
    @Order(5)
    void delete() {
    }

    @Test
    @Order(4)
    void getall() {
    }
}