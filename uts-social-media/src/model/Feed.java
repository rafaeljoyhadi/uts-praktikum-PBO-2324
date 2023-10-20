package model;

import java.sql.Timestamp;

public class Feed extends Post {
    private String caption;
    private int likes;

    public Feed(String postId, ContentState status, Timestamp timeupload, ContentType postType, String caption, int likes, User user) {
        super(postId, status, timeupload, postType, user);
        this.caption = caption;
        this.likes = likes;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "Feed [caption=" + caption + ", likes=" + likes + "]";
    }
}
