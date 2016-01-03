package javaprojekt;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class for setting up actions of 2 buttons: button "Clear" and button "Calculate roots"
 */
public class Buttons {

    /**
     * Setup button "Clear" which clears contents of input and output textfields
     * and resets initial textfields style
     */
    public void setupClearButton(
            TextField coefficientA,TextField coefficientB, TextField coefficientC,
            TextField rootX1, TextField rootX2,Button clearButton){

        clearButton.setOnAction(event1 -> {
            coefficientA.clear();
            coefficientB.clear();
            coefficientC.clear();
            coefficientA.setStyle("-fx-text-inner-color: black;");
            coefficientB.setStyle("-fx-text-inner-color: black;");
            coefficientC.setStyle("-fx-text-inner-color: black;");
            rootX1.clear();
            rootX2.clear();
        });
    }

    /**
     * Setup button "Calculate roots" which calculates solutions of equation if
     * coefficients of equations are entered into input textfields
     */
    public void setupCalculateRootsButton(
            TextField coefficientA,TextField coefficientB, TextField coefficientC,
            TextField rootX1, TextField rootX2,Button calculateRootsButton)
    {
        calculateRootsButton.setOnAction(event2 -> {
            BigDecimal a = RootsOfQuadraticEquation.convertStringToBigDecimal(coefficientA.getText());
            BigDecimal b = RootsOfQuadraticEquation.convertStringToBigDecimal(coefficientB.getText());
            BigDecimal c = RootsOfQuadraticEquation.convertStringToBigDecimal(coefficientC.getText());
            //Checking if string entered into coefficient 'a' textfield cannot be converted to BigDecimal
            //(i.e. checking if use entered non-number or decimal number in wrong format #,##)
            if (a==null)
            {
                coefficientA.setText("Please enter decimal number!");
                coefficientA.setStyle("-fx-font: 18 arial; -fx-text-inner-color: red;");
            }
            //Checking if string entered into coefficient 'b' textfield cannot be converted to BigDecimal
            //(i.e. checking if use entered non-number or decimal number in wrong format #,##)
            if (b==null)
            {
                coefficientB.setText("Please enter decimal number!");
                coefficientB.setStyle("-fx-font: 18 arial; -fx-text-inner-color: red;");
            }
            //Checking if string entered into coefficient 'c' textfield cannot be converted to BigDecimal
            //(i.e. checking if use entered non-number or decimal number in wrong format #,##)
            if (c==null)
            {
                coefficientC.setText("Please enter decimal number!");
                coefficientC.setStyle("-fx-font: 18 arial; -fx-text-inner-color: red;");
            }
            // If at least one of entered coefficients of equation cannot be converted to BigDecimal,
            // terminate execution of the subroutine and return control back to the point in the program from
            //which the subroutine was called.
            if (a==null || b==null || c==null)
            {
                return;
            }

            try
            {
                List<BigDecimal> solutions = javaprojekt.RootsOfQuadraticEquation.calculateSolutionsOfEquation(a, b, c);
                if (solutions.size()==1)
                {System.out.println("1");
                    rootX1.setText(solutions.get(0).toPlainString());
                    rootX2.setText("-");
                }
                if (solutions.size()==2)

                {System.out.println("2");
                    rootX1.setText(solutions.get(0).toPlainString());
                    rootX2.setText(solutions.get(1).toPlainString());
                }
                System.out.println("number of roots="+solutions.size());
            }
            catch (NumberFormatException nfe)
            {
                System.out.println("nfe");
                rootX1.setText("no roots");
                rootX2.setText("no roots");
            }
            System.out.println("x1="+rootX1.getText());
            System.out.println("x2="+rootX2.getText());

        });
    }

    public void setupChartButton(Button setupChart){
        System.out.println("chart");
        setupChart.setOnAction(event -> {
            Stage stage2 = new Stage();
            Pane layout = new Pane();
            layout.setStyle("-fx-background-color: lightskyblue;");

            stage2.setTitle("y = \u00BC(x+4)(x+1)(x-2)");
            stage2.setScene(new Scene(layout, Color.rgb(35, 39, 50)));
            stage2.show();
        });
    }
}
