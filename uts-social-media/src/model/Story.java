package model;

import java.sql.Timestamp;

public class Story extends Post {
    private int duration;
    private int views;

    public Story(String postId, ContentState status, Timestamp timeupload, ContentType postType, int duration,
            int views, User user) {
        super(postId, status, timeupload, postType, user);
        this.duration = duration;
        this.views = views;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Story [duration=" + duration + ", views=" + views + "] " + super.toString();
    }
}
