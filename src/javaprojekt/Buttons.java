package javaprojekt;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.List;

/**
 * Class for setting up actions of 2 buttons: button "Clear" and button "Calculate roots"
 */
public class Buttons {
    Button clearButton;
    Button calculateRootsButton;
    TextField coefficientA;
    TextField coefficientB;
    TextField coefficientC;
    TextField rootX1;
    TextField rootX2;

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
            if (a==null){
                coefficientA.setText("Please enter decimal number!");
                coefficientA.setStyle("-fx-font: 18 arial; -fx-text-inner-color: red;");
            }
            //Checking if string entered into coefficient 'b' textfield cannot be converted to BigDecimal
            //(i.e. checking if use entered non-number or decimal number in wrong format #,##)
            if (b==null){
                coefficientB.setText("Please enter decimal number!");
                coefficientB.setStyle("-fx-font: 18 arial; -fx-text-inner-color: red;");
            }
            //Checking if string entered into coefficient 'c' textfield cannot be converted to BigDecimal
            //(i.e. checking if use entered non-number or decimal number in wrong format #,##)
            if (c==null){
                coefficientC.setText("Please enter decimal number!");
                coefficientC.setStyle("-fx-font: 18 arial; -fx-text-inner-color: red;");
            }
            if (a==null || b==null || c==null){
                return;
            }

            try {
                List<BigDecimal> solutions = javaprojekt.RootsOfQuadraticEquation.calculateSolutionsOfEquation(a, b, c);
                rootX1.setText(solutions.get(0).toPlainString());
                // checking if an equation has two solutions x1 and x2 (which can be equal to each other)
                if (solutions.size()>1){
                    rootX2.setText(solutions.get(1).toPlainString());
                } else {
                    rootX2.setText("-");
                }
            }
            catch (NumberFormatException nfe){
                rootX1.setText("no roots");
                rootX2.setText("no roots");
            }
        });
    }
}
