package za.ac.cput.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

/*User.java
User class
Author Mihle Sivuyise Bontsi (222406917)
Date 17 May 2024+
.
 */
@Entity (name = "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
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

    @CreatedDate
    private LocalDateTime createdAt;

    protected User(){
    }

    private User(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.password = builder.password;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.createdAt = builder.createdAt;
        this.gender = builder.gender;
        this.displayImage = builder.displayImage;

    }

    public long getUserId() {
        return userId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getUserId() == user.getUserId() && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getFirstName(), user.getFirstName()) && Objects.equals(getLastName(), user.getLastName()) && getGender() == user.getGender() && Objects.deepEquals(getDisplayImage(), user.getDisplayImage()) && Objects.equals(getCreatedAt(), user.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUserName(), getPassword(), getEmail(), getFirstName(), getLastName(), getGender(), Arrays.hashCode(getDisplayImage()), getCreatedAt());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", displayImage=" + displayImage +
                ", createdAt=" + createdAt +
                '}';
    }

    public static class Builder {
        private long userId;
        private String userName;
        private String password;
        private String email;
        private String firstName;
        private String lastName;
        private LocalDateTime createdAt;
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
        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
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
            this.userId = user.userId;
            this.userName = user.userName;
            this.password = user.password;
            this.email = user.email;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.createdAt = user.createdAt;
            this.gender = user.gender;
            this.displayImage = user.displayImage;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


}






