package ru.sa2.testing.javafx.app1;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

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

//        displayRectangles();

    }

    public void displayRectangles(){

        rectangles.clear();

        System.out.println("pressed");

        double height = this.getHeight();
        double width = this.getWidth();
        int lines = (int)(height / rectangleHeight);
        int columns = (int)(width / rectangleWidth);
        int posX = 0, posY = 0;

        for (int line = 0; line < lines; line++){

            for (int column = 0; column < columns; column++){
                Rectangle rectangle = new Rectangle(rectangleWidth, rectangleHeight);
                rectangle.setX(column * rectangleWidth);
                rectangle.setY(line * rectangleHeight);
//                rectangle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                rectangle.setFill(Color.color(0.0, 0.0, Math.random()));

                rectangles.add(rectangle);
                this.getChildren().addAll(rectangle);

            }
//            posY *= line;
        }

    }

}
