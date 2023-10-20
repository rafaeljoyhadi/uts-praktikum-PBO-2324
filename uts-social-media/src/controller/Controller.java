package controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class Controller {
    User user1;
    User user2;
    List<Post> posts;
    int deletedPostsUser1 = 0;
    int deletedPostsUser2 = 0;

    public Controller() {
        user1 = new User("1", "rafaeljoyhadi", "123", "Currently learning OOP");
        user2 = new User("2", "marcelandrean", "letmein", "I sleep");
        posts = new ArrayList<>();

        // POST USER 1
        Post post1 = new Feed("1", ContentState.PINNED, new Timestamp(System.currentTimeMillis()), ContentType.PICTURE,
                "Coding rn", 50, user1);
        posts.add(post1);

        Post post2 = new Story("2", ContentState.PINNED, new Timestamp(System.currentTimeMillis()), ContentType.VIDEO,
                30, 150, user1);
        posts.add(post2);

        Post post3 = new Reel("3", ContentState.SHOWED, new Timestamp(System.currentTimeMillis()), ContentType.VIDEO,
                15, 500, user1);
        posts.add(post3);

        Post post4 = new Reel("4", ContentState.SHOWED, new Timestamp(System.currentTimeMillis()), ContentType.PICTURE,
                10, 300, user1);
        posts.add(post4);

        // POST USER 2
        Post post5 = new Feed("5", ContentState.ARCHIVED, new Timestamp(System.currentTimeMillis()),
                ContentType.PICTURE,
                "Coding rn", 1000, user2);
        posts.add(post5);

        Post post6 = new Story("6", ContentState.ARCHIVED, new Timestamp(System.currentTimeMillis()), ContentType.VIDEO,
                340, 1520, user2);
        posts.add(post6);

        Post post7 = new Reel("7", ContentState.DELETED, new Timestamp(System.currentTimeMillis()), ContentType.VIDEO,
                115, 5010, user2);
        posts.add(post7);

        Post post8 = new Reel("8", ContentState.DELETED, new Timestamp(System.currentTimeMillis()), ContentType.PICTURE,
                1054, 3060, user2);
        posts.add(post8);

        Comment comment1 = new Comment("1", "That's a post", ContentState.SHOWED);
        Comment comment2 = new Comment("2", "That's a video", ContentState.SHOWED);

    }

    // * NOMOR 1 - SHOW USER POSTS
    public void showUserPosts(User user) {
        System.out.println();
        System.out.println("NOMOR 1 - SHOW USER POST");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");

        System.out.println();
        System.out.println("Posts for User " + user.getUsername() + ":");

        List<Post> pinnedPosts = new ArrayList<>();
        List<Post> showedPosts = new ArrayList<>();
        List<Post> archivedPosts = new ArrayList<>();

        // * PINNED > SHOWED > ARCHIVED > DELETED
        for (Post post : posts) {
            if (post.getStatus() == ContentState.PINNED) {
                pinnedPosts.add(post);
            } else if (post.getStatus() == ContentState.SHOWED) {
                showedPosts.add(post);
            } else if (post.getStatus() == ContentState.ARCHIVED) {
                archivedPosts.add(post);
            } else {
                if (post.getUser().getUserId().equals(user1.getUserId()) && post.getStatus() == ContentState.DELETED) {
                    deletedPostsUser1++;
                } else if (post.getUser().getUserId().equals(user2.getUserId())
                        && post.getStatus() == ContentState.DELETED) {
                    deletedPostsUser2++;
                }
            }
        }

        System.out.println("\n--- Pinned Posts ---");
        for (Post post : pinnedPosts) {
            displayPostInfo(post, dateFormat);
        }

        System.out.println("\n--- Showed Posts ---");
        for (Post post : showedPosts) {
            displayPostInfo(post, dateFormat);
        }

        System.out.println("\n--- Archived Posts ---");
        for (Post post : archivedPosts) {
            displayPostInfo(post, dateFormat);
        }

        System.out.println("\n--- Deleted Posts Count ---");
        System.out.println(user1.getUsername() + " - Deleted Posts Count: " + deletedPostsUser1);
        System.out.println(user2.getUsername() + " - Deleted Posts Count: " + deletedPostsUser2);
    }

    private void displayPostInfo(Post post, SimpleDateFormat dateFormat) {
        if (post instanceof Feed) {
            Feed feed = (Feed) post;
            System.out.println("Feed - Likes: " + feed.getLikes());
        } else if (post instanceof Story) {
            Story story = (Story) post;
            System.out.println("Story - Views: " + story.getViews());
        } else if (post instanceof Reel) {
            Reel reel = (Reel) post;
            System.out.println("Reel - Played Count: " + reel.getPlayedCount());
        }
        System.out.println("Post ID: " + post.getPostId());
        System.out.println("Post Type: " + post.getPostType());
        System.out.println("Time Upload: " + dateFormat.format(post.getTimeupload()));
        System.out.println();
    }

    public void testShowUserPosts() {
        showUserPosts(user1);
        showUserPosts(user2);
    }

    // * NOMOR 2 - SHOW POST
    public void showPost(String postId) {
        for (Post post : posts) {
            if (post.getPostId().equals(postId)) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
                System.out.println("Post Details for Post ID: " + postId);
                System.out.println("User: " + post.getUser().getUsername());
                System.out.println("Status: " + post.getStatus());
                System.out.println("Post Type: " + post.getPostType());
                System.out.println("Time Upload: " + dateFormat.format(post.getTimeupload()));

                if (post instanceof Feed) {
                    Feed feed = (Feed) post;
                    System.out.println("Caption: " + feed.getCaption());
                    System.out.println("Likes: " + feed.getLikes());
                } else if (post instanceof Story) {
                    Story story = (Story) post;
                    System.out.println("Duration: " + story.getDuration());
                    System.out.println("Views: " + story.getViews());
                } else if (post instanceof Reel) {
                    Reel reel = (Reel) post;
                    System.out.println("Duration: " + reel.getDuration());
                    System.out.println("Played Count: " + reel.getPlayedCount());
                }
                return;
            }
        }
        System.out.println("Post with ID " + postId + " not found.");
    }

    public void testShowPost() {
        System.out.println();
        System.out.println("NOMOR 2 - SHOW POST");
        showPost("1");
        System.out.println();
        showPost("2");
        System.out.println();
        showPost("3");
        System.out.println();
        showPost("4");
    }

    // * NOMOR 3 - CHANGE POST STATE
    public void changePostState(User user, String postId, ContentState newStatus) {
        for (Post post : posts) {
            if (post.getPostId().equals(postId) && post.getUser().getUserId().equals(user.getUserId())) {
                if (post.getStatus() == ContentState.SHOWED) {
                    // * SHOWED to ARCHIVED, PINNED, or DELETED
                    if (newStatus == ContentState.ARCHIVED || newStatus == ContentState.PINNED) {
                        post.setStatus(newStatus);
                        System.out.println("Post status changed to " + newStatus);
                        return;
                    }
                } else if (post.getStatus() == ContentState.ARCHIVED) {
                    // * ARCHIVED to DELETED
                    if (newStatus == ContentState.DELETED) {
                        post.setStatus(newStatus);
                        System.out.println("Post status changed to " + newStatus);
                    }

                } else if (post.getStatus() == ContentState.PINNED) {
                    // * PINNED to SHOWED
                    if (newStatus == ContentState.SHOWED) {
                        post.setStatus(newStatus);
                        System.out.println("Post status changed to " + newStatus);
                        return;
                    }
                }
                return;
            }
        }
        System.out.println("Post ID " + postId + " not found.");

    }

    public void testChangePostState() {
        System.out.println();
        System.out.println("NOMOR 3 - CHANGE POST STATE");
        // * SHOWED -> PINNED (HARUSNYA BERHASIL)
        changePostState(user1, "3", ContentState.PINNED);

        // * SHOWED -> DELETED (HARUSNYA GAGAL)
        changePostState(user1, "3", ContentState.DELETED);

        // * ARCHIVED -> DELETED (HARUSNYA BERHASIL)
        changePostState(user2, "5", ContentState.DELETED);

        // * POST TIDAK ADA
        changePostState(user1, "10", ContentState.PINNED);
    }
}
