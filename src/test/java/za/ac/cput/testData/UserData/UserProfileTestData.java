package za.ac.cput.testData.UserData;

import za.ac.cput.domain.Location;
import za.ac.cput.domain.Preference;
import za.ac.cput.domain.User;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.factory.UserprofileFactory;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import static za.ac.cput.testData.UserData.LocationTestData.*;
import static za.ac.cput.testData.UserData.PreferenceTestData.*;
import static za.ac.cput.testData.UserData.UserTestData.*;


public class UserProfileTestData {

    public static UserProfile getUserProfileWithBuilder101() {
        User user101 = UserTestData.getBuiltUser1();
        Preference preference101 = PreferenceTestData.getPreferenceBuilder1();
        Location location101 = LocationTestData.getLocationBuilder1();

        return new UserProfile.Builder()
                .setUserID(user101)
                .setInterests("Running fast")
                .setProfile_visibility(true)
                .setCreated_at(LocalDateTime.now())
                .setLocation(location101)
                .setPreferenceID(preference101)
                .setReceivedLikes(new HashSet<>()) // likes
                .build();
    }

    public static UserProfile getUserProfileWithBuilder2() {
        User user2 = UserTestData.getBuiltUser2();
        Preference preference2 = PreferenceTestData.getPreferenceBuilder2();
        Location location2 = LocationTestData.getLocationBuilder2();

        return new UserProfile.Builder()
                .setUserID(user2)
                .setInterests("Adventuring and exploring")
                .setProfile_visibility(true)
                .setCreated_at(LocalDateTime.now())
                .setLocation(location2)
                .setPreferenceID(preference2)
                .setReceivedLikes(new HashSet<>()) // likes
                .build();
    }

    public static UserProfile getUserProfileWithBuilder3() {
        User user3 = UserTestData.getBuiltUser3();
        Preference preference3 = PreferenceTestData.getPreferenceBuilder3();
        Location location3 = LocationTestData.getLocationBuilder3();

        return new UserProfile.Builder()
                .setUserID(user3)
                .setInterests("Collecting roses")
                .setProfile_visibility(true)
                .setCreated_at(LocalDateTime.now())
                .setLocation(location3)
                .setPreferenceID(preference3)
                .setReceivedLikes(new HashSet<>()) // likes
                .build();
    }

    public static UserProfile getUserProfileWithBuilder4() {
        User user4 = UserTestData.getBuiltUser4();
        Preference preference4 = PreferenceTestData.getPreferenceBuilder4();
        Location location4 = LocationTestData.getLocationBuilder4();

        return new UserProfile.Builder()
                .setUserID(user4)
                .setInterests("Stealing jewels")
                .setProfile_visibility(true)
                .setCreated_at(LocalDateTime.now())
                .setLocation(location4)
                .setPreferenceID(preference4)
                .setReceivedLikes(new HashSet<>()) // likes
                .build();
    }

}