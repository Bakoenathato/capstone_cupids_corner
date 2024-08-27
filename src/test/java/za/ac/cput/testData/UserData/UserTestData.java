package za.ac.cput.testData.UserData;

import za.ac.cput.domain.Gender;
import za.ac.cput.domain.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;


public class UserTestData {
    public static User getBuiltUser1()  {

        byte[] sonicImage;
        try {
            sonicImage = Files.readAllBytes(Paths.get("src/main/resources/images/sonic.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //byte[] sonicImage = "sonic".getBytes();

        return new User.Builder()
                .setUserId(1L)
                .setUserName("Sonic")
                .setPassword("Seg@")
                .setEmail("sonic0@sega.example.com")
                .setFirstName("Ogilvie")
                .setLastName("Hedgehog")
                .setGender(Gender.MALE)
                .setDisplayImage(sonicImage)
                .build();
    }

    public static User getBuiltUser2() {

        byte[] tailsImage;
        try {
            tailsImage = Files.readAllBytes(Paths.get("src/main/resources/images/tails.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //byte[] tailsImage = "tails".getBytes();

        return new User.Builder()
                .setUserId(2L)
                .setUserName("Tails")
                .setPassword("MilesPrower")
                .setEmail("tails1@sega.example.com")
                .setFirstName("Miles")
                .setLastName("Prower")
                .setGender(Gender.MALE)
                .setDisplayImage(tailsImage)
                .build();
    }

    public static User getBuiltUser3() {

        byte[] amyRoseImage;
        try {
            amyRoseImage = Files.readAllBytes(Paths.get("src/main/resources/images/amy.jpg"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //byte[] amyRoseImage = "amyRose".getBytes();
        return new User.Builder()
                .setUserId(3L)
                .setUserName("AmyRose")
                .setPassword("PinkRose")
                .setEmail("amy2@sega.example.com")
                .setFirstName("Amy")
                .setLastName("Rose")
                .setGender(Gender.FEMALE)
                .setDisplayImage(amyRoseImage)
                .build();
    }

    public static User getBuiltUser4() {

        byte[] rougeImage;
        try {
            rougeImage = Files.readAllBytes(Paths.get("src/main/resources/images/rouge.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //byte[] rougeImage = "rougeBat".getBytes();
        return new User.Builder()
                .setUserId(4L)
                .setUserName("JewelThief")
                .setPassword("Jewels1")
                .setEmail("rouge@sega.example.com")
                .setFirstName("Rouge")
                .setLastName("The Bat")
                .setGender(Gender.FEMALE)
                .setDisplayImage(rougeImage)
                .build();
    }

}
