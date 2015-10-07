package ru.sa2.testing.javafx.app2;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Created by Alexander Smirnov on 07.10.2015.
 * email:       alexander@pingala.ru
 * email-work:  aleksandrsmirnov@at-consulting.ru
 */
public class RotationRectangle extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Pane root = new Pane();

        ImageView image = new ImageView(new Image("http://i7.youcomedy.me/5/9/big_9330ac4f02ae48cba3d116907d5b2f95.jpg"));
        image.setFitHeight(200);
        image.setFitWidth(250);
        image.setLayoutX(100);
        image.setLayoutY(100);

        RotateTransition rt = new RotateTransition(Duration.millis(500), image);
        rt.setCycleCount(1);

        Button btn1 = new Button("Left");
        btn1.setLayoutX(0);
        btn1.setLayoutY(0);

        btn1.setOnAction(event -> {
            rt.setByAngle(-360);
            rt.play();
        });

        Button btn2 = new Button("Right");
        btn2.setLayoutX(0);
        btn2.setLayoutY(30);

        btn2.setOnAction(event -> {
            rt.setByAngle(360);
            rt.play();
        });

        root.getChildren().addAll(btn1, btn2, image);

        Scene scene = new Scene(root, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
