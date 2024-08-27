package za.ac.cput.testData.UserData;

import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Preference;
import za.ac.cput.factory.PreferenceFactory;

public class PreferenceTestData {

    public static Preference getPreferenceBuilder1() {
        return new Preference.Builder()
                .setPreferenceId(1L)
                .setMinAge(20)
                .setMaxAge(45)
                .setMaxDistance(50)
                .setGenderPreference(Gender.FEMALE)
                .build();
    }

    public static Preference getPreferenceBuilder2() {
        return new Preference.Builder()
                .setPreferenceId(2L)
                .setMinAge(25)
                .setMaxAge(35)
                .setMaxDistance(30)
                .setGenderPreference(Gender.FEMALE)
                .build();
    }

    public static Preference getPreferenceBuilder3() {
        return new Preference.Builder()
                .setPreferenceId(3L)
                .setMinAge(18)
                .setMaxAge(28)
                .setMaxDistance(40)
                .setGenderPreference(Gender.MALE)
                .build();
    }

    public static Preference getPreferenceBuilder4() {
        return new Preference.Builder()
                .setPreferenceId(4L)
                .setMinAge(30)
                .setMaxAge(50)
                .setMaxDistance(60)
                .setGenderPreference(Gender.OTHER)
                .build();
    }

}
