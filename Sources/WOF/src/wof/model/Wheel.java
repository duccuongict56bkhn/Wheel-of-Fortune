/**
 * Wheel of Fortune
 *
 * Group 3: Dao Duc Cuong, Hoang Minh Tuan, Le Anh Tien
 *
 **/

package wof.model;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * Description: Class for the wheel of application
 * @author duc cuong
 */

public class Wheel extends StackPane {

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
    
    // temps
    private double[] startAngle = {0};
    private double[] endAngle = {305};
  
    private final int cycle = 1;
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
        height = 700.0;
        width = 700.0;
        rotateTime = 5;
        decreaseAcc = 2;
        setBackgroundImage();     
        radius = 300;
        this.setId("wheel");
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
    
    public void rotate(double from, double to) {
        timeline = new Timeline();
        timeline.setCycleCount(cycle);
        timeline.setAutoReverse(false);
        
        from = startAngle[0];
        to = endAngle[0];
        
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, new KeyValue(bgImageView.rotateProperty(), from)),
                new KeyFrame(Duration.millis(2000), new KeyValue(bgImageView.rotateProperty(),to,Interpolator.EASE_OUT))
        );
        //this.getChildren().add(bgImageView);
        timeline.play();
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                startAngle[0] = endAngle[0];
                endAngle[0] = endAngle[0] * 1.8;
                if (endAngle[0] > startAngle[0] * 4) {
                    startAngle[0] = 0;
                    endAngle[0] = 305;
                }
            }
        });
    }
    
    @Override
    public void setHeight(double height) {
        super.setHeight(height);
    }
    
    @Override
    public void setWidth(double width) {
        super.setHeight(width);
    }
    
    public double getStartAngle() {
        return startAngle[0];
    }

    public void setStartAngle(double startAngle) {
        this.startAngle[0] = startAngle;
    }

    public double getEndAngle() {
        return endAngle[0];
    }

    public void setEndAngle(double endAngle) {
        this.endAngle[0] = endAngle;
    }
}
