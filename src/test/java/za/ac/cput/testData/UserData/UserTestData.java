package za.ac.cput.testData.UserData;

import za.ac.cput.domain.DisplayImage;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.User;
import za.ac.cput.factory.DisplayImageFactory;
import za.ac.cput.factory.UserFactory;
import za.ac.cput.util.Helper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;


public class UserTestData {
    public static User getBuiltUser1()  {

        byte[] sonicImage = "sonic".getBytes();

        return new User.Builder()
                .setUserId(1l)
                .setUserName("Sonic")
                .setPassword("Seg@")
                .setEmail("sonic0@sega.example.com")
                .setFirstName("Ogilvie")
                .setLastName("Hedgehog")
                .setGender(Gender.MALE)
                .setDisplayImage(sonicImage)
                .setCreatedAt(LocalDateTime.now())
                .build();
    }

    public static User getBuiltUser2() {
        byte[] tailsImage = "tails".getBytes();

        return new User.Builder()
                .setUserId(2l)
                .setUserName("Tails")
                .setPassword("MilesPrower")
                .setEmail("tails1@sega.example.com")
                .setFirstName("Miles")
                .setLastName("Prower")
                .setGender(Gender.MALE)
                .setDisplayImage(tailsImage)
                .setCreatedAt(LocalDateTime.now())
                .build();
    }

    public static User getBuiltUser3() {
        byte[] amyRoseImage = "amyRose".getBytes();
        return new User.Builder()
                .setUserId(3l)
                .setUserName("AmyRose")
                .setPassword("PinkRose")
                .setEmail("amy2@sega.example.com")
                .setFirstName("Amy")
                .setLastName("Rose")
                .setGender(Gender.FEMALE)
                .setDisplayImage(amyRoseImage)
                .setCreatedAt(LocalDateTime.now())
                .build();
    }

    public static User getBuiltUser4() {
        byte[] rougeImage = "rougeBat".getBytes();
        return new User.Builder()
                .setUserId(4l)
                .setUserName("JewelThief")
                .setPassword("Jewels1")
                .setEmail("rouge@sega.example.com")
                .setFirstName("Rouge")
                .setLastName("The Bat")
                .setGender(Gender.FEMALE)
                .setDisplayImage(rougeImage)
                .setCreatedAt(LocalDateTime.now())
                .build();
    }

}
