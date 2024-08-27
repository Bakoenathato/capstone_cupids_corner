package za.ac.cput.factory;

import za.ac.cput.domain.Location;
import za.ac.cput.domain.UserProfile;
import za.ac.cput.util.Helper;

public class LocationFactory {

    public static Location createLocation(Long postalCode, String city, String province, String area, UserProfile userProfile) {
        if (postalCode == null || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(province)
                || Helper.isNullOrEmpty(area) || userProfile == null)
            return null;
        return new Location.Builder()
                .setPostalCode(postalCode)
                .setCity(city)
                .setProvince(province)
                .setArea(area)
                .setUserProfile(userProfile)
                .build();
    }

    public static Location createLocation(String city, String province, String area) {

        if (Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(province)
                || Helper.isNullOrEmpty(area))
            return null;
        return new Location.Builder().setCity(city)
                .setProvince(province)
                .setArea(area)
                .build();
    }

    public static Location buildLocationWithoutProfile(Long postalCode, String city, String province, String area) {
        if (postalCode == null || Helper.isNullOrEmpty(city) || Helper.isNullOrEmpty(province) || Helper.isNullOrEmpty(area))
            return null;

        return new Location.Builder()
                .setPostalCode(postalCode)
                .setCity(city)
                .setProvince(province)
                .setArea(area)
                .build();
    }
}