package za.ac.cput.domain.match;

import jakarta.persistence.*;
import za.ac.cput.domain.user.User;

import java.util.Objects;

@Entity
public class PotentialMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user1_id")
    private User user1;

    @ManyToOne
    @JoinColumn(name = "user2_id")
    private User user2;

    @Enumerated(EnumType.STRING)
    private MatchStatus matchStatus;

    protected PotentialMatch() {}

    private PotentialMatch(Builder builder) {
        this.id = builder.id;
        this.user1 = builder.user1;
        this.user2 = builder.user2;
        this.matchStatus = builder.matchStatus;
    }

    public long getId() {
        return id;
    }

    public User getUser1() {
        return user1;
    }

    public User getUser2() {
        return user2;
    }

    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PotentialMatch that)) return false;
        return getId() == that.getId() && Objects.equals(getUser1(), that.getUser1()) && Objects.equals(getUser2(), that.getUser2()) && getMatchStatus() == that.getMatchStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser1(), getUser2(), getMatchStatus());
    }

    @Override
    public String toString() {
        return "PotentialMatch{" +
                "id=" + id +
                ", user1=" + user1 +
                ", user2=" + user2 +
                ", matchStatus=" + matchStatus +
                '}';
    }

    public static class Builder {
        private long id;
        private User user1;
        private User user2;
        private MatchStatus matchStatus;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setUser1(User user1) {
            this.user1 = user1;
            return this;
        }

        public Builder setUser2(User user2) {
            this.user2 = user2;
            return this;
        }

        public Builder setMatchStatus(MatchStatus matchStatus) {
            this.matchStatus = matchStatus;
            return this;
        }

        public Builder copy(PotentialMatch potentialMatch) {
            this.id = potentialMatch.id;
            this.user1 = potentialMatch.user1;
            this.user2 = potentialMatch.user2;
            this.matchStatus = potentialMatch.matchStatus;
            return this;
        }

        public PotentialMatch build() {
            return new PotentialMatch(this);
        }
    }
}
