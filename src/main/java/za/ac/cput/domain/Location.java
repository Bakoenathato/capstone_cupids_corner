package za.ac.cput.domain;

// author: Uzziah Phumelela Ngogela
// 222135654

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postalCode;

    private String city;

    private String province;

    private String area;

    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    private UserProfile userProfile;

    //@OneToOne(cascade = CascadeType.ALL)
    protected Location() {}

    private Location(Builder builder) {
        this.postalCode = builder.postalCode;
        this.city = builder.city;
        this.province = builder.province;
        this.area = builder.area;
        this.userProfile = builder.userProfile;
    }

    public Long getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getArea() {
        return area;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Objects.equals(getPostalCode(), location.getPostalCode()) && Objects.equals(getCity(), location.getCity()) && Objects.equals(getProvince(), location.getProvince()) && Objects.equals(getArea(), location.getArea()) && Objects.equals(getUserProfile(), location.getUserProfile());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPostalCode(), getCity(), getProvince(), getArea(), getUserProfile());
    }

    @Override
    public String toString() {
        return "Location{" +
                "postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", area='" + area + '\'' +
                ", userProfile=" + userProfile +
                '}';
    }

    public static class Builder {
        private Long postalCode;
        private String city;
        private String province;
        private String area;
        private UserProfile userProfile;

        public Builder setPostalCode(Long postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setProvince(String province) {
            this.province = province;
            return this;
        }

        public Builder setArea(String area) {
            this.area = area;
            return this;
        }

        public Builder setUserProfile(UserProfile userProfile) {
            this.userProfile = userProfile;
            return this;
        }

        public Builder copy(Location location) {
            this.postalCode = location.postalCode;
            this.city = location.city;
            this.province = location.province;
            this.area = location.area;
            this.userProfile = location.userProfile;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}