package ru.sa2.testing.javafx.app1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexander Smirnov on 02.10.2015.
 * email:       alexander@pingala.ru
 * email-work:  aleksandrsmirnov@at-consulting.ru
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

//        Rectangle rectangle = new Rectangle();
//        rectangle.setHeight(50);
//        rectangle.setWidth(50);

        RectangleMatrix rectangleMatrix = new RectangleMatrix();

//        root.getChildren().addAll(rectangleMatrix);

        rectangleMatrix.setOnMouseClicked(event -> rectangleMatrix.displayRectangles());

        Scene scene = new Scene(rectangleMatrix, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                rectangleMatrix.displayRectangles();
//                try {
//                    TimeUnit.SECONDS.sleep(6);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        };
    }


    public static void main(String[] args) {
        launch(args);
    }
}
