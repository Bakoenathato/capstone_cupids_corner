package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.User;
import za.ac.cput.testData.UserData.UserTestData;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    private static User user1, user2;

    @BeforeAll
    static void setUp() {
        user1 = UserTestData.getBuiltUser1();
        user2 = UserTestData.getBuiltUser3();

    }


    @Test
    @Order(1)
    void create() {
        User createdUser1 = userService.create(user1);
        User createdUser2 = userService.create(user2);
//        User createdUser3 = userService.create(user3);
//        User createdUser4 = userService.create(user4);
        assertNotNull(createdUser1);
        assertNotNull(createdUser2);
//        assertNotNull(createdUser3);
//        assertNotNull(createdUser4);
        System.out.println(createdUser1);
        System.out.println(createdUser2);
//        System.out.println(createdUser3);
//        System.out.println(createdUser4);
    }

    @Test
    @Order(2)
    void read() {
        User readUser1 = userService.read(user1.getId());
        User readUser2 = userService.read(user2.getId());
//        User readUser3 = userService.read(user3.getId());
//        User readUser4 = userService.read(user4.getId());
        assertNotNull(readUser1);
        assertNotNull(readUser2);
//        assertNotNull(readUser3);
//        assertNotNull(readUser4);
        System.out.println(readUser1);
        System.out.println(readUser2);
//        System.out.println(readUser3);
//        System.out.println(readUser4);
    }

    @Test
    @Disabled
    @Order(3)
    void update() {
        User newSonicUserName = new User.Builder().copy(user1).setUserName("Maurice").build();
        User updatedUser1 = userService.update(newSonicUserName);
        assertNotNull(updatedUser1);
        System.out.println(updatedUser1);

//        User newTailsUserName2 = new User.Builder().copy(user2).setUserName("TwoTails").build();
//        User updatedUser2 = userService.update(newTailsUserName2);
//        assertNotNull(updatedUser2);
//        System.out.println(updatedUser2);
//
//        User newAmyPassword = new User.Builder().copy(user3).setPassword("SonicRings").build();
//        User updatedUser3 = userService.update(newAmyPassword);
//        assertNotNull(updatedUser3);
//        System.out.println(updatedUser3);
//
//        User newRougePassword = new User.Builder().copy(user4).setPassword("Diamonds4Life").build();
//        User updatedUser4 = userService.update(newRougePassword);
//        assertNotNull(updatedUser4);
//        System.out.println(updatedUser4);
    }

    @Disabled
    @Test
    @Order(5)
    void delete() {
        userService.delete(user1.getId());
//        userService.delete(user2.getId());
//        userService.delete(user3.getId());
//        userService.delete(user4.getId());
    }

    @Test
    @Disabled
    @Order(4)
    void getAll() {
        System.out.println(userService.getAll());
    }
}