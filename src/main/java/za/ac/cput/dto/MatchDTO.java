package za.ac.cput.dto;

public class MatchDTO {

    private long matchId;
    private long user1Id;
    private long user2Id;

    public MatchDTO(long matchId, long user1Id, long user2Id) {
        this.matchId = matchId;
        this.user1Id = user1Id;
        this.user2Id = user2Id;
    }

    public long getMatchId() {
        return matchId;
    }

    public void setMatchId(long matchId) {
        this.matchId = matchId;
    }

    public long getUser1Id() {
        return user1Id;
    }

    public void setUser1Id(long user1Id) {
        this.user1Id = user1Id;
    }

    public long getUser2Id() {
        return user2Id;
    }

    public void setUser2Id(long user2Id) {
        this.user2Id = user2Id;
    }
}
