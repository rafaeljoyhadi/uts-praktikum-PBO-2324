package model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public abstract class Post {
    private String postId;
    private ContentState status;
    private Timestamp timeupload;
    private ContentType postType;
    private User user;
    private List<Comment> comments;

    public Post(String postId, ContentState status, Timestamp timeupload, ContentType postType, User user) {
        this.postId = postId;
        this.status = status;
        this.timeupload = timeupload;
        this.postType = postType;
        this.user = user;
        this.comments = new ArrayList<>();
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public ContentState getStatus() {
        return status;
    }

    public void setStatus(ContentState status) {
        this.status = status;
    }

    public Timestamp getTimeupload() {
        return timeupload;
    }

    public void setTimeupload(Timestamp timeupload) {
        this.timeupload = timeupload;
    }

    public ContentType getPostType() {
        return postType;
    }

    public void setPostType(ContentType postType) {
        this.postType = postType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post [postId=" + postId + ", status=" + status + ", timeupload=" + timeupload + ", postType=" + postType
                + "]";
    }
}
