package de.iav.helloworld;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Group root = new Group();
        Scene scene = new Scene(root, 500,500, Color.web("#FFFFFF",1));
        /*
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
        Text text = new Text(50,50, "Hello JavaFX");

        Text text2 = new Text(50,50, "Hello JavaFX");

        final Canvas canvas = new Canvas(350, 350);


        root.getChildren().add(text);
        text.setX(200);
        text.setY(200);
        text.setFont(new Font(45));
        //text.setF
        text.setFill(Color.web("#987654"));
        root.getChildren().add(canvas);
        drawSquares(canvas.getGraphicsContext2D());
        stage.setTitle("Hello!");
        stage.setScene(scene);


        //drawSquares(canvas.getGraphicsContext2D());
        //primaryStage.setScene(s);
        //primaryStage.show();


        stage.show();
    }
    private void drawSquares(GraphicsContext gc) {

        //gc.setFill(Color.rgb(120, 0, 5));
        //gc.fillPolygon(new double[] {260.0, 260.0, 260.0}, new double[] {60.0, 60.0, 60.0}, 3);

        //Polygon triangle = new Polygon();

        // Set the coordinates of the triangle's vertices
        //double[] coordinates = {100.0, 50.0, 50.0, 150.0, 150.0, 150.0};
        //triangle.getPoints().addAll(coordinates);

        // Set the fill color of the triangle
        //triangle.setFill(Color.RED);

        gc.setFill(Color.rgb(255, 120, 35));
        gc.fillRect(25, 30, 250, 250);

        gc.setFill(Color.rgb(5, 180, 180));
        gc.fillRect(85, 125, 130, 130);

        gc.setFill(Color.rgb(5, 254, 0));
        gc.fillOval(85, 225, 230, 130);




    }

    public static void main(String[] args) {
        launch();
    }
}