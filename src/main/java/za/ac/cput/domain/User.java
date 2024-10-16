package za.ac.cput.domain;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Objects;

/*User.java
User class
Author Mihle Sivuyise Bontsi (222406917)
Date 17 May 2024
.
 */
@Entity (name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(length = 100000)
    private byte[] displayImage;

    /*
     password encoder
     private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder(12);
        @OneToMany(mappedBy = "user1", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Match> matchRequest = new HashSet<>();

        @OneToMany(mappedBy = "user2", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Match> matchedAccepted = new HashSet<>();

        @OneToMany(mappedBy = "swiper", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Swipe> swipesMade = new HashSet<>();

        @OneToMany(mappedBy = "swiped", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private Set<Swipe> swipesReceived = new HashSet<>();
    */


    protected User(){
    }

    private User(Builder builder) {
        this.id = builder.userId;
        this.userName = builder.userName;
        this.password = builder.password;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.displayImage = builder.displayImage;


    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public byte[] getDisplayImage() {
        return displayImage;
    }

//    public Set<Match> getAllMatches(){
//        Set<Match> allMatches = new HashSet<>(matchRequest);
//        allMatches.addAll(matchedAccepted);
//        return allMatches;
//    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId() == user.getId() && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName()) && getGender() == user.getGender() && Objects.deepEquals(getDisplayImage(), user.getDisplayImage()) /*&& Objects.equals(matchRequest, user.matchRequest) && Objects.equals(matchedAccepted, user.matchedAccepted) && Objects.equals(swipesMade, user.swipesMade) && Objects.equals(swipesReceived, user.swipesReceived )*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getPassword(), getEmail(), getFirstName(), getLastName(), getGender(), Arrays.hashCode(getDisplayImage()) /*, matchRequest, matchedAccepted, swipesMade, swipesReceived */);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", displayImage=" + Arrays.toString(displayImage) +
                /*", matchRequest=" + matchRequest +
                ", matchedAccepted=" + matchedAccepted +
                ", swipesMade=" + swipesMade +
                ", swipesReceived=" + swipesReceived + */
                '}';
    }

    public static class Builder {
        private long userId;
        private String userName;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private Gender gender;
        private byte[] displayImage;


        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;

        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;

        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;

        }
        public Builder setEmail(String email) {
            this.email = email;
            return this;

        }
        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;

        }
        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;

        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Builder setDisplayImage(byte[] displayImage) {
            this.displayImage = displayImage;
            return this;
        }

        public Builder copy(User user) {
            this.userId = user.id;
            this.userName = user.userName;
            this.password = user.password;
            this.email = user.email;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.gender = user.gender;
            this.displayImage = user.displayImage;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}






