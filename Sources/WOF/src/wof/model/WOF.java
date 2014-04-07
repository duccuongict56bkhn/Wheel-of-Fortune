/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof.model;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;

/**
 *
 * @author duc
 */
public class WOF extends Application {
    
    private double S_WIDTH = 1200;
    private double S_HEIGHT = 680;
    
    @Override
    public void start(Stage primaryStage) {        
        final Wheel w = new Wheel();
        w.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                w.rotate(25, 450);
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(w);
        root.relocate(S_WIDTH, 0);

        Scene scene = new Scene(root, S_WIDTH, S_HEIGHT);
        primaryStage.setTitle("Wheel of Fortune Game");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
