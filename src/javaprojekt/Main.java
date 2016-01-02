package javaprojekt;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *Class for launching the JavaFX-based quadratic equation solver.
 */

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        new QuadraticEquationCalculator();
    }
}
