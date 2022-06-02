package com.draganddropexample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Drag and Drop Example
 * @author Noah Freelove
 * @version 1.0
 *
 * The Pointer class is the one that does most of the heavy lifting here.
 * The Item class and Item Toolbar class were just included to give a demo of how you could use it
 *
 *
 * HOW IT WORKS:
 * Mouse Moved -> pointer is updated with info on it's position
 * Mouse Clicked -> if an Item was clicked, the pointer gets a preview of it and attaches it to the cursor.
 * Mouse Released -> if an Item is currently being dragged, it will be dropped at the mouse position.
 */
public class Main extends Application {

    // I made these static, so you can access them from other classes. Makes it easy to manipulate.
    // A better solution is in the classes themselves you can make a method that returns the active instance of the class
    public static Pointer pointer;
    public static Group root;

    @Override
    public void start(Stage stage) {
        // create an empty group, so we can add our objects to it.
        root = new Group();

        // Create 3 new items
        Item item1 = new Item(Color.RED);
        Item item2 = new Item(Color.BLUE);
        Item item3 = new Item(Color.PURPLE);

        // Create our pointer (the object that will track our cursor's position
        pointer = new Pointer(stage);

        // create our toolbar ( not required, you could manually add the items to the scene, it just organizes them nicely )
        ItemToolbar toolbar = new ItemToolbar(item1, item2, item3);


        root.getChildren().add(toolbar);

        // Default javafx starter code from here on out:
        // Create the scene with the group we made earlier. This adds all the objects in the group to the scene
        // size is 600x600, but you can resize to whatever you'd like.
        Scene scene = new Scene(root, 600, 600);

        // set the background to a green with a hex code
        scene.setFill(Color.web("#013220"));

        // Set the window title text
        stage.setTitle("Drag & Drop Example");

        // Set our window's scene to the one we made
        stage.setScene(scene);

        // Don't let the user resize the window. I would recommend keeping this set to false for any games as well since
        // It's difficult to make your game's ui and everything else fit every arbitrary window size.
        // Just choose one size, or a set few with a common aspect ratio
        stage.setResizable(false);

        // Finally, show the window. Don't forget this line.
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}