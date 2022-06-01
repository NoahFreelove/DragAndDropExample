package com.draganddropexample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Item extends Rectangle {
    private Color color;

    public Item(Color color) {
        super(64, 64);
        this.color = color;
        setFill(color);
        setOnMousePressed(e -> {
            Main.pointer.setSelectedObject(this);
        });
    }

    public Color getColor() {
        return color;
    }
}
