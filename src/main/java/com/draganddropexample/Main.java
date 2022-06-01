package com.draganddropexample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    public static ItemToolbar toolbar;
    public static Pointer pointer;
    public static Group root;
    @Override
    public void start(Stage stage) {
        root = new Group();
        Item item1 = new Item(Color.RED);
        Item item2 = new Item(Color.BLUE);
        Item item3 = new Item(Color.PURPLE);

        pointer = new Pointer();

        // add on mouse move event
        stage.addEventHandler( MouseEvent.MOUSE_DRAGGED, (e) -> {
            pointer.updatePos(e.getSceneX(), e.getSceneY());
        });
        // add on release event
        stage.addEventHandler( MouseEvent.MOUSE_CLICKED, (e) -> {
            pointer.onReleased();
        });


        toolbar = new ItemToolbar(item1, item2, item3);
        root.getChildren().add(toolbar);

        Scene scene = new Scene(root, 600, 620);
        scene.setFill(Color.web("#013220"));

        stage.setTitle("Drag & Drop Example");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}