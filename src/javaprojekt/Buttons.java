package javaprojekt;


import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

/**
 * Class for setting up actions of 3 buttons: button "Clear", button "Calculate roots"
 * and button "Write to file"
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

    /**
     * Setup button which writes input (coefficients 'a', 'b', 'c') and
     * output (solutions 'x1' and 'x2') data into file "text.txt"
     */
    public void setupWriteToFileButton(
            Button writeToFileButton,TextField coefficientA, TextField coefficientB,
            TextField coefficientC,TextField rootX1,TextField rootX2){
            writeToFileButton.setOnAction(event -> {
            String a=coefficientA.getText();
            String b=coefficientB.getText();
            String c=coefficientC.getText();
            String x1=rootX1.getText();
            String x2=rootX2.getText();
            File file = new File("tekst.txt");
            try
            {
                FileWriter fw = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.println("a="+a+",  b="+b+",  c="+c+",  x1="+x1+",  x2="+x2);
                pw.close();
            }
            catch(IOException ex)
            {
                System.out.println("Could not write to file");
                System.exit(0);
            }
        });
    }

}
