package com.draganddropexample;

import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * Pointer
 * @author Noah Freelove
 * @version 1.0
 * This class gets updated information about the mouse's position and when click events occur
 * When they do occur, if an Item {@link Item} detects it's been clicked, the selected object will be set
 * to an instance of the item that was clicked. This will then have it's position updated in accordance to the mouse
 * position until the mouse button is released.
 */
public class Pointer {
    // Current x and y pos of the mouse
    private double x;
    private double y;

    // Can be whatever Class you'd like to be in the item drag preview (must extend from node)
    private Rectangle selectedObject;

    /**
     * Sets up the mouse listen events
     * @param stage the stage you'd like to attach the listeners to
     */
    public Pointer(Stage stage) {
        // This will call updatePos() with the mouse's position when it is moved in any way in the window
        stage.addEventHandler( MouseEvent.MOUSE_DRAGGED, (mousePosition) -> {
            this.updatePos(mousePosition.getSceneX(), mousePosition.getSceneY());
        });

        // When a mouse button is released, call the onReleased() function
        stage.addEventHandler( MouseEvent.MOUSE_CLICKED, (e) -> {
            this.onReleased();
        });
    }

    /**
     * Updates the x and y cord of the pointer. Only called by the event listener ^
     * @param x the new x cord
     * @param y the new y cord
     */
    public void updatePos(double x, double y){
        this.x = x;
        this.y = y;

        // If an object is being dragged (the selected object variable is not null)
        // Update it's position to the mouse cursor with a 32 pixel offset so its centered around the mouse
        if(selectedObject !=null)
        {
            selectedObject.setX(x-32);
            selectedObject.setY(y-32);
        }
    }

    // Called by the event listener we added in the constructor. Called when a mouse button is released
    public void onReleased(){
        // we only want to place an object if there is one selected. When selected object is null it means there is nothing selected
        if(selectedObject !=null)
        {
            // Check if the position the mouse is trying to place the object at is valid.
            if(isValidPos(x,y)){
                // Create a new rectangle (replace this with an image if you're using custom images) at the mouse position of, and centered around the mouse
                double adjustedXPos = x-selectedObject.getWidth()/2;
                double adjustedYPos = y-selectedObject.getHeight()/2;

                Rectangle newObject = new Rectangle(adjustedXPos,adjustedYPos,selectedObject.getWidth(),selectedObject.getHeight());

                // Set the color of the new rectangle we created
                newObject.setFill(selectedObject.getFill());

                // Add it to the scene root
                Main.root.getChildren().add(newObject);
            }

        }
        // Remove the preview rectangle we created when we started dragging the mouse
        Main.root.getChildren().remove(selectedObject);
        selectedObject = null;
    }

    // Implement your own validation code here if you'd like to not let the user drag into certain areas
    // I just set it up to not let you drag it below the toolbar which starts at y = 400 px
    private boolean isValidPos(double xPosition, double yPosition){
        int lowerScreenBoundary = 500;
        if(yPosition < lowerScreenBoundary)
            return true;
        return false;


    } // This function can be simplified to: return yPosition < lowerScreenBoundary;

    //
    public void setSelectedObject(Item selectedObject) {
        this.selectedObject = new Rectangle(x-32,y-32,64,64);
        this.selectedObject.setFill(selectedObject.getColor());
        if(!Main.root.getChildren().contains(this.selectedObject))
        {
            Main.root.getChildren().add(this.selectedObject);
        }

    }
}
