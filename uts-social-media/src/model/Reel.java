package model;
import java.sql.Timestamp;

public class Reel extends Post {
    private int duration;
    private int playedCount;

    public Reel(String postId, ContentState status, Timestamp timeupload, ContentType postType, int duration, int playedCount, User user) {
        super(postId, status, timeupload, postType, user);
        this.duration = duration;
        this.playedCount = playedCount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPlayedCount() {
        return playedCount;
    }

    public void setPlayedCount(int playedCount) {
        this.playedCount = playedCount;
    }

    @Override
    public String toString() {
        return "Reel [duration=" + duration + ", playedCount=" + playedCount + "] " + super.toString();
    }
}
