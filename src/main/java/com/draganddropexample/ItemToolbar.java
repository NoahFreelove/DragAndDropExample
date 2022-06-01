package com.draganddropexample;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ItemToolbar extends HBox {
    public ItemToolbar(Item... items) {
        super(items);
        setPrefSize(64+items.length*64,100);
        setLayoutY(500);
        setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        for (int i = 0; i < items.length; i++) {
            items[i].setTranslateX(16*(i+1));
            items[i].setTranslateY(16);
        }
    }
}
