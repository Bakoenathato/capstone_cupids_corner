package za.ac.cput.dto;

public class SwipeDTO {

    private long user1Id;
    private long user2Id;
    private String direction;

    public SwipeDTO(long user1Id, long user2Id, String direction) {
        this.user1Id = user1Id;
        this.user2Id = user2Id;
        this.direction = direction;
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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
