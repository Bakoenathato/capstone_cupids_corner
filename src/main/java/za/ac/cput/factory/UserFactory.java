package za.ac.cput.factory;

//import za.ac.cput.domain.DisplayImage;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

import java.time.LocalDateTime;

/*UserFactory.java
UserFactory class
Author Mihle Sivuyise Bontsi (222406917)
Date: 24 March 2024
 */

public class UserFactory {
//    public static User buildUser(long userId, String userName, String password, String email, String firstName,
//                                 String lastName, Gender gender, DisplayImage displayImage) {
//        if ( || Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(password))
//            return null;
//        return new User.Builder().setUserId(userId)
//                .setUserName(userName)
//                .setPassword(password)
//                .setEmail(email)
//                .setFirstName(firstName)
//                .setLastName(lastName)
//                .setGender(gender)
//                .setDisplayImage(displayImage)
//                .build();
//    }
    public static User buildUser(String userName, String password, String email, String firstName,
                                 String lastName, Gender gender, byte[] displayImage, LocalDateTime createdAt){
        if (Helper.isNullOrEmpty(userName) || Helper.isNullOrEmpty(password) || Helper.isNullOrEmpty(email) ||
                Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                gender == null || displayImage == null || createdAt == null)
            throw new IllegalArgumentException("Invalid user data");

        return new User.Builder()
                .setUserName(userName)
                .setPassword(password)
                .setEmail(email)
                .setFirstName(firstName).setLastName(lastName)
                .setGender(gender)
                .setDisplayImage(displayImage)
                .build();

    }
}