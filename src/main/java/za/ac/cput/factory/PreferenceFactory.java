package za.ac.cput.factory;
/*
    MatchingFactoryTest.java
    MatchingFactory class
    Author: Thato Mokoena (222667087)
    Date 19 May 2024
*/

import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Preference;
import za.ac.cput.domain.UserProfile;

public class PreferenceFactory {

    public static Preference buildPreference(long preferenceId, UserProfile profile, int minAge, int maxAge, int maxDistance, Gender genderPreference) {
        if (preferenceId <= 0 || profile == null || minAge <= 0 || maxAge <= 0 || maxDistance <= 0 || genderPreference == null)
            return null;

        return new Preference.Builder()
                .setPreferenceId(preferenceId)
                .setProfile(profile)
                .setMinAge(minAge)
                .setMaxAge(maxAge)
                .setMaxDistance(maxDistance)
                .setGenderPreference(genderPreference)
                .build();
    }

    public static Preference buildPreferenceWithoutProfile(long preferenceId, int minAge, int maxAge, int maxDistance, Gender genderPreference) {
        if (preferenceId <= 0 ||  minAge <= 0 || maxAge <= 0 || maxDistance <= 0 || genderPreference == null)
            return null;

        return new Preference.Builder()
                .setPreferenceId(preferenceId)
                .setMinAge(minAge)
                .setMaxAge(maxAge)
                .setMaxDistance(maxDistance)
                .setGenderPreference(genderPreference)
                .build();
    }
}
