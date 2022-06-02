package com.draganddropexample;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * ItemToolbar
 * @author Noah Freelove
 * @version 1.0
 *
 * ItemToolbar holds a collection of items in a Horizontal Box. They can be directly passed to the super constructor because:
 * item {@link Item} Extends Rectangle {@link javafx.scene.shape.Rectangle}, which extends Node {@link javafx.scene.Node}
 */
public class ItemToolbar extends HBox {

    // This constructor adds all the items into the Horizontal Box
    public ItemToolbar(Item... items) {
        super(items);
        // Set the size equal to the amount of items * the size of the rectangles (which we hardcoded to 64 pixels)
        setPrefSize(64+items.length*64,100);

        // set y position to near the bottom, but not touching the bottom border
        setLayoutY(500);

        // Set its background to Black.
        // JavaFX requires you to do this outrageous line of code to color Containers. Any other shape has setFill()
        setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        // Translate X is the offset of an object that is in a container. The layoutX is the position
        // Of the container relative to 0,0, while your translateX is the position of the object relative to the container.
        for (int i = 0; i < items.length; i++) {

            // Give each item a 16 pixel gap from one another
            items[i].setTranslateX(16*(i+1));

            // Move 16 pixels down from the top of the container
            items[i].setTranslateY(16);
        }
    }
}
