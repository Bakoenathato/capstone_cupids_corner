package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.user.UserProfile;
import za.ac.cput.testData.UserData.UserProfileTestData;

import static org.junit.jupiter.api.Assertions.*;

class UserprofileFactoryTest {

    @Test
    void getUserProfile() {
        UserProfile profile1 = UserProfileTestData.getUserProfileWithBuilder101();
        assertNotNull(profile1);
        System.out.println(profile1);
    }

}