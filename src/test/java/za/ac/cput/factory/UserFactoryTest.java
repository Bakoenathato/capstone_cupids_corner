package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.User;
import za.ac.cput.testData.UserData.UserTestData;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void createUser() {
        User user1 = UserTestData.getBuiltUser1();
        assertNotNull(user1);
        System.out.println(user1);
    }

}