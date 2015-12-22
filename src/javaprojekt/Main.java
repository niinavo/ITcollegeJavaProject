package javaprojekt;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by user on 22.12.2015.
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        new QuadraticEquationCalculator();
    }
}
