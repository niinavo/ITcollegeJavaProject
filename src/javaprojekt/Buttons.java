package javaprojekt;


import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by user on 2.01.2016.
 */
public class Buttons {
    //QuadraticEquationCalculator calculator=new QuadraticEquationCalculator();
    static Button clearButton;
    static Button calculateRootsButton;

    Buttons(){
        QuadraticEquationCalculator calculator=new QuadraticEquationCalculator();
        //TextField coefficientA_=this.coefficientA;
        //setupClearButton_(coefficientA_,coefficientB_,
        //        coefficientC_, rootX1_, rootX2_);
    }

    /**
     * Setup button which clears contents of input and output textfields
     * and resets initial textfields style
     */
    public static void setupClearButton_(TextField coefficientA,TextField coefficientB,
                                         TextField coefficientC, TextField rootX1, TextField rootX2){
        clearButton.setOnAction(event1 -> {
            coefficientA.clear();
            coefficientB.clear();
            coefficientC.clear();
            coefficientA.setStyle("-fx-text-inner-color: black;");
            coefficientB.setStyle("-fx-text-inner-color: black;");
            coefficientC.setStyle("-fx-text-inner-color: black;");
            rootX1.clear();
            rootX2.clear();
            rootX1.setDisable(true);
            rootX1.setEditable(false);
            rootX2.setDisable(true);
            rootX2.setEditable(false);
        });
    }

    /**
     * Setup button which calculates solutions of equation if
     * coefficients of equations are entered into input textfield
     */
    public static void setupCalculateRootsButton_(TextField coefficientA,TextField coefficientB,
                                           TextField coefficientC, TextField rootX1, TextField rootX2){
        calculateRootsButton.setOnAction(event2 -> {
            final BigDecimal a = RootsOfQuadraticEquation.convertStringToBigDecimal(coefficientA.getText());
            final BigDecimal b = RootsOfQuadraticEquation.convertStringToBigDecimal(coefficientB.getText());
            final BigDecimal c = RootsOfQuadraticEquation.convertStringToBigDecimal(coefficientC.getText());
            if (a==null){
                coefficientA.setText("Please enter real number!");
                coefficientA.setStyle("-fx-font: 18 arial; -fx-text-inner-color: red;");
            }
            if (b==null){
                coefficientB.setText("Please enter real number!");
                coefficientB.setStyle("-fx-font: 18 arial; -fx-text-inner-color: red;");
            }
            if (c==null){
                coefficientC.setText("Please enter real number!");
                coefficientC.setStyle("-fx-font: 18 arial; -fx-text-inner-color: red;");
            }
            if (a==null || b==null || c==null){
                return;
            }

            try {
                final List<BigDecimal> solutions = javaprojekt.RootsOfQuadraticEquation.calculateSolutionsOfEquation(a, b, c);
                rootX1.setText(solutions.get(0).toPlainString());
                rootX1.setDisable(false);
                // checking if an equation has two solutions x1 and x2 (which can be equal to each other)
                if (solutions.size()>1){
                    rootX2.setText(solutions.get(1).toPlainString());
                    rootX2.setDisable(false);
                } else {
                    rootX2.setText("-");
                    rootX2.setDisable(true);
                }
            }
            catch (NumberFormatException nfe){
                rootX1.setText("-");
                rootX1.setDisable(true);
                rootX2.setText("-");
                rootX2.setDisable(true);
            }
        });
    }
}
