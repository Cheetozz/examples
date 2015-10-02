package ru.sa2.testing.javafx.app1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.Random;

/**
 * Created by Alexander Smirnov on 02.10.2015.
 * email:       alexander@pingala.ru
 * email-work:  aleksandrsmirnov@at-consulting.ru
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

//        primaryStage.setWidth(400);
//        primaryStage.setHeight(300);


        Pane root = new Pane();

        Rectangle rectangle = new Rectangle();
        rectangle.setHeight(50);
        rectangle.setWidth(50);

        Button btn = new Button("LOL");
        btn.setLayoutX(200);
        btn.setLayoutY(200);
        btn.setOnAction(event -> {
            rectangle.setFill(Color.RED);
            System.out.println("lol");
        });
        //TODO сделать поле из квадратов, ,что бы при нажатии на пробел у них рандомно менялся цвет;

        rectangle.setOnMouseClicked(event -> {
            rectangle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        });


        root.getChildren().addAll(btn, rectangle);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
