/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof.model;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author duc
 */
public class WOF extends Application {
    
    @Override
    public void start(Stage primaryStage) {        
        Wheel w = new Wheel();
        BorderPane root = new BorderPane();
        root.setId("root");
        //root.getChildren().add(w);
        root.setRight(w);
        
        Scene scene = new Scene(root, 1200, 680);
        primaryStage.setTitle("Hello World!");
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
