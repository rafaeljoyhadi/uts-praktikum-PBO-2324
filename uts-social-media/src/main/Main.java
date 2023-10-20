package main;
import controller.*;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();

        // * NOMOR 1
        controller.testShowUserPosts();

        // * NOMOR 2
        controller.testShowPost();

        // * NOMOR 3
        controller.testChangePostState();
    }
}
