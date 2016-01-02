package TESTjavaprojekt;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * Start the JavaFX application for solving quadratic equations.
 *
 * @param Stage Primary stage.
 * @throws Exception JavaFX-related exception.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        new QuadraticEquationCalculator();
    }
}
