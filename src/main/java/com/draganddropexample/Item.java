package com.draganddropexample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Item
 * @author Noah Freelove
 * @version 1.0
 *
 * Is a simple Rectangle with a width and height of 64 pixels. It takes a simple JavaFX color as input
 *
 * When the rectangle is clicked, it will communicate with the Pointer we created in Main{@link Main}
 *
 * It extends rectangle, so we can directly access it's properties without creating a separate Rectangle variable
 * */
public class Item extends Rectangle {
    private final Color color;

    public Item(Color color) {
        super(64, 64);
        this.color = color;
        setFill(color);

        // When the Rectangle is pressed. Communicate with the pointer that this is the *new* selected object
        // We can only do this because we made the pointer public and static
        // This arrow looking thing is called a lambda function btw. just lets you write one-line functions for interfaces
        setOnMousePressed(event -> Main.pointer.setSelectedObject(this));
    }

    // default getter
    public Color getColor() {
        return color;
    }
}
