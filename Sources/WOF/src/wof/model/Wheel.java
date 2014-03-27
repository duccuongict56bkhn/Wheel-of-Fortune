/**
 * Wheel of Fortune
 *
 * Group 3: Dao Duc Cuong, Hoang Minh Tuan, Le Anh Tien
 *
 **/

package wof.model;

import java.util.HashMap;
import java.util.Map;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Description: Class for the wheel of application
 * @author duc cuong
 */

public class Wheel extends Parent {

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
    /**
     * Use array with only 1 element to prevent compilation error
     * "Local variable accessed with inner class, need to be declared final"
     */
    private double[] startAngle = {0};
    private double[] endAngle = {317};
  
    private final int cycle = 1;
    /**
     * The parent node that contains this wheel
     */
    private Node parentNode;

    private Map<String, String> value = new HashMap<String, String>();

    /**
     * Wheel status
     */
    private enum Status {
        SPINNING,
        HOLDING,
        STOP
    }
    
    private Status status;
    
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
        status = Status.STOP;
        setListOfValue();
    }
    
    public void setListOfValue() {
        value.put("24", "BANKRUPT");
        value.put("48", "700");
        value.put("72", "200");
        value.put("96", "100");
        value.put("120", "HAVLE");   // chia đôi
        value.put("144", "800");
        value.put("168", "300");
        value.put("192", "GIFT");
        value.put("216", "600");
        value.put("240", "LOSETURN");
        value.put("264", "400");
        value.put("288", "DOUBLE");
        value.put("312", "500");
        value.put("336", "BONUSTURN");
        value.put("360", "900");
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
        status = Status.SPINNING;
        System.out.println(status);
        
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent ae) {
                status = Status.STOP;
                System.out.println(status);
                startAngle[0] = endAngle[0];
                endAngle[0] = endAngle[0] * 1.8;
                if (endAngle[0] > 317 *10) {
                    startAngle[0] = 0;
                    endAngle[0] = 317;
                }
                // debug
                System.out.println("S: " + startAngle[0] + " , E:" + endAngle[0]);
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
