package com.draganddropexample;

import javafx.scene.shape.Rectangle;

public class Pointer {
    private double x;
    private double y;
    private Rectangle selectedObject;
    public Pointer() {}

    public void updatePos(double x, double y){
        this.x = x;
        this.y = y;
        if(selectedObject !=null)
        {
            selectedObject.setX(x-32);
            selectedObject.setY(y-32);
        }
    }

    public void onReleased(){
        if(selectedObject !=null)
        {
            if(isValidPos(x,y)){
                Rectangle newObject = new Rectangle(x-32,y-32,selectedObject.getWidth(),selectedObject.getHeight());
                newObject.setFill(selectedObject.getFill());
                Main.root.getChildren().add(newObject);
            }

        }
        Main.root.getChildren().remove(selectedObject);
        selectedObject = null;
    }

    // implement your own validation code here...
    private boolean isValidPos(double xPosition, double yPosition){
        if(yPosition < 400)
        {
            return true;
        }
        return false;
    }


    public void setSelectedObject(Item selectedObject) {
        this.selectedObject = new Rectangle(x-32,y-32,64,64);
        this.selectedObject.setFill(selectedObject.getColor());
        if(!Main.root.getChildren().contains(this.selectedObject))
        {
            Main.root.getChildren().add(this.selectedObject);
        }

    }
}
