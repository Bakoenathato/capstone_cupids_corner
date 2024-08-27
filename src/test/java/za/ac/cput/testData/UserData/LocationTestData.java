package za.ac.cput.testData.UserData;

import za.ac.cput.domain.Location;
import za.ac.cput.factory.LocationFactory;

public class LocationTestData {

    public static Location getLocationBuilder1() {
        return new Location.Builder()
                .setPostalCode(1401L)
                .setCity("Springs")
                .setProvince("GrandBlue")
                .setArea("EastBlue")
                .build();
    }

    public static Location getLocationBuilder2() {
        return new Location.Builder()
                .setPostalCode(1402L)
                .setCity("Valley")
                .setProvince("GreenField")
                .setArea("WestSide")
                .build();
    }

    public static Location getLocationBuilder3() {
        return new Location.Builder()
                .setPostalCode(1403L)
                .setCity("Mountain")
                .setProvince("HighPeak")
                .setArea("NorthRange")
                .build();
    }

    public static Location getLocationBuilder4() {
        return new Location.Builder()
                .setPostalCode(1404L)
                .setCity("Desert")
                .setProvince("SandDune")
                .setArea("SouthArea")
                .build();
    }

}
