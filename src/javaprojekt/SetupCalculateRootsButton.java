package javaprojekt;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.List;

public class SetupCalculateRootsButton {
    /**
     * Setup button "Calculate roots" which calculates solutions of equation if
     * coefficients of equations are entered into input textfields
     */
    public void setupCalculateRootsButton(
            Button button,TextField coefficientA, TextField coefficientB, TextField coefficientC,
            TextField rootX1, TextField rootX2)
    {
        button.setOnAction(event2 -> {
            BigDecimal a = RootsOfQuadraticEquation.convertStringToBigDecimal(coefficientA.getText());
            BigDecimal b = RootsOfQuadraticEquation.convertStringToBigDecimal(coefficientB.getText());
            BigDecimal c = RootsOfQuadraticEquation.convertStringToBigDecimal(coefficientC.getText());
            //If string entered into coefficient 'a' textfield cannot be converted to BigDecimal
            //(i.e. checking if use entered non-number or decimal number in wrong format #,##)
            if (a==null)
            {
                coefficientA.setText("Please enter decimal number!");
                coefficientA.setStyle("-fx-font: 18 arial; -fx-text-inner-color: red;");
            }
            //Iff string entered into coefficient 'b' textfield cannot be converted to BigDecimal
            //(i.e. checking if use entered non-number or decimal number in wrong format #,##)
            if (b==null)
            {
                coefficientB.setText("Please enter decimal number!");
                coefficientB.setStyle("-fx-font: 18 arial; -fx-text-inner-color: red;");
            }
            //If string entered into coefficient 'c' textfield cannot be converted to BigDecimal
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
                {
                    rootX1.setText(solutions.get(0).toPlainString());
                    rootX2.setText("-");
                }
                if (solutions.size()==2)
                {
                    rootX1.setText(solutions.get(0).toPlainString());
                    rootX2.setText(solutions.get(1).toPlainString());
                }
            }
            catch (NumberFormatException nfe)
            {
                rootX1.setText("no roots");
                rootX2.setText("no roots");
            }

        });
    }
}
