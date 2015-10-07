package ru.sa2.testing.javafx.app1;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alexander Smirnov on 02.10.2015.
 * email:       alexander@pingala.ru
 * email-work:  aleksandrsmirnov@at-consulting.ru
 */
public class RectangleMatrix extends Pane {

    List<Rectangle> rectangles = new ArrayList<>();

    private int rectangleHeight;
    private int rectangleWidth;

    public RectangleMatrix () {
        this(50, 50);
    }

    public RectangleMatrix (int height, int width){
        this.rectangleHeight = height;
        this.rectangleWidth = width;
    }

    public void displayRectangles(){

        rectangles.clear();
        this.getChildren().clear();


        double height = this.getHeight();
        double width = this.getWidth();
        int lines = (int)(height / rectangleHeight);
        int columns = (int)(width / rectangleWidth);
        System.out.println("pressed");
        System.out.println("Lines:\t" + lines);
        System.out.println("Columns:\t" + columns);

        for (int line = 0; line < lines; line++){

            for (int column = 0; column < columns; column++){
                Rectangle rectangle = new Rectangle(rectangleWidth, rectangleHeight);
                rectangle.setX(column * rectangleWidth);
                rectangle.setY(line * rectangleHeight);
                rectangle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
//                rectangle.setFill(Color.color(0.0, 0.0, Math.random()));

//                RotateTransition rt = new RotateTransition(Duration.millis(3000), rectangle);
                RotateTransition rt = new RotateTransition(Duration.millis(new Random().nextInt(2500) + 500) , rectangle);
                rt.setByAngle(360);
                rt.setCycleCount(Animation.INDEFINITE);
                rt.setInterpolator(Interpolator.LINEAR);
                rt.setFromAngle(new Random().nextDouble() * 360 );
                rt.play();

                rectangles.add(rectangle);
//                System.out.println("Rectangle add");
                this.getChildren().addAll(rectangle);
            }
        }
    }

    public void shuffleColor(){
        if (rectangles.size() == 0) displayRectangles();

        for (Rectangle rectangle : rectangles){
            rectangle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        }
    }

    public void changeRectanglesSize(int delta){

        if (rectangleHeight - delta > 0) {
            rectangleHeight-=delta;
            rectangleWidth-=delta;
            displayRectangles();
        }
    }
}
