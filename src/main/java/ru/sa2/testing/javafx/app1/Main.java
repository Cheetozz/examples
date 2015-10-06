package ru.sa2.testing.javafx.app1;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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

        final Service<String> service = new Service<String>() {
            @Override
            protected Task<String> createTask() {
                return new Task<String>() {
                    @Override
                    protected String call() throws Exception {

                        while (true) {
                            System.out.println("hui");
                            rectangleMatrix.displayRectangles(); //fixme bad way :)
//                            displayer.handle(new Event(MouseEvent.MOUSE_CLICKED));
                            try {
                                TimeUnit.MILLISECONDS.sleep(300);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                };
            }
        };

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
                    }
                });

        Scene scene = new Scene(rectangleMatrix, 400, 300);

        scene.heightProperty().addListener((observable, oldValue, newValue) -> {
            rectangleMatrix.displayRectangles();
        });

        scene.widthProperty().addListener((observable, oldValue, newValue) -> {
            rectangleMatrix.displayRectangles();
        });

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}