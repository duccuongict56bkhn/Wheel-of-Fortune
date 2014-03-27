/**
 * Wheel of Fortune
 *
 * Group 3: Dao Duc Cuong, Hoang Minh Tuan, Le Anh Tien
 *
 **/

package wof.model;

import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Description: Class for the wheel of application
 * @author duc cuong
 */

public class Wheel extends Group {

    /**
     * Angle in degree corresponds to each piece of the wheel
     */
    private final static int DEGREE_EACH = 24;
    /**
     * Radius of the wheel
     */
    private double radius;
    
    private double height;
    private double width; 
    /**
     * Background image of the wheel
     */
    private ImageView bgImageView;
    /**
     * Decrease acceleration angle 
     */
    private double decreaseAcc;
    /**
     * Time of wheel's rotation
     */
    private double rotateTime;
    /**
     * Timeline for the animation of wheel
     */
    private Timeline timeline;
    /**
     * The parent node that contains this wheel
     */
    private Node parentNode;
    
    /**
     * Wheel status
     */
    private enum Status {
        SPINNING,
        HOLDING,
        STOP
    }
    
    /**
     * Direction for rotation of wheel. It's determined by the mouse
     * direction that user makes.
     * Return values can be obtain use values() method
     */
    private enum Direction {
        LEFT,
        RIGHT,
        NONE
    }
    
    public Wheel() {
        height = 600.0;
        width = 600.0;
        rotateTime = 5;
        decreaseAcc = 2;
        setBackgroundImage();     
        radius = 300;
    }
    
    /**
     * Set parent node
     * @param node
     */
    public void setParentNode(Node node) {
        parentNode = node;
    }
    
    /**
     * Get parent Scene Graph Node that contains this wheel
     * @return 
     */
    public Node getParentNode() {
        return parentNode;
    }
    
    public final void setBackgroundImage() {
        Image img = new Image(getClass().getResource("Wheel.png").toExternalForm());
        bgImageView = new ImageView(img);
        bgImageView.setFitHeight(this.height);
        bgImageView.setFitWidth(this.width);
        bgImageView.setPreserveRatio(true);
                
        this.getChildren().add(bgImageView);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    
}
