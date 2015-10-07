package ru.sa2.testing.javafx.app1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Preloader;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

/**
 * Created by Alexander Smirnov on 02.10.2015.
 * email:       alexander@pingala.ru
 * email-work:  aleksandrsmirnov@at-consulting.ru
 */
public class Main extends Application {

    RectangleMatrix rectangleMatrix;
    AnimationTimer epileptic;

    @Override
    public void start(Stage primaryStage) throws Exception {

        rectangleMatrix = new RectangleMatrix();

        epileptic = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int i = 0;
                while (i < 1000) {
                    rectangleMatrix.shuffleColor();
                    i++;
                }
            }
        };

        rectangleMatrix.addEventHandler(MouseEvent.MOUSE_CLICKED,
                event -> {
                    MouseButton pressedButton = event.getButton();
                    if (pressedButton == MouseButton.PRIMARY) {
                        epileptic.stop();
                        rectangleMatrix.shuffleColor();
                    } else if (pressedButton == MouseButton.MIDDLE) {
                        System.out.println("Enjoy!");
                        epileptic.start();
                    } else if (pressedButton == MouseButton.SECONDARY) {
                        epileptic.stop();
                        rectangleMatrix.displayRectangles();
                    }
                });

        rectangleMatrix.setOnScroll(event -> {
            System.out.println("resize");
            rectangleMatrix.changeRectanglesSize((int) (event.getDeltaY() / 40));
        });

        Scene scene = new Scene(rectangleMatrix, 400, 300);

        scene.heightProperty().addListener((observable, oldValue, newValue) -> {
            rectangleMatrix.displayRectangles();
        });

        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
            rectangleMatrix.displayRectangles();
        });

        rectangleMatrix.getScene().addEventHandler(KeyEvent.KEY_RELEASED,
                event -> {
                    System.out.println("pressed key"); //todo realize help by F1 key
                });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Epileptica");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}