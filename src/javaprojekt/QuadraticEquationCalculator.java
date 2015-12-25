package javaprojekt;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.util.List;

/**
 * JavaFX application for solving quadratic equations a*x*x+b*x+c=0
 * if coefficients a,b and c are entered.
 *
 * @author Niina Voropajeva
 */


public class QuadraticEquationCalculator {
    Stage stage = new Stage();
    /** TextField for entering coefficient a of quadratic equation. */
    TextField coefficientA=new TextField();
    /** TextField for entering coefficient b of quadratic equation. */
    TextField coefficientB=new TextField();
    /** TextField for entering coefficient c of quadratic equation. */
    TextField coefficientC=new TextField();
    /** TextField for calculated solution x1 of equation*/
    TextField rootX1=new TextField();
    /** TextField for calculated solution x2 of equation */
    TextField rootX2=new TextField();

    QuadraticEquationCalculator() {
        setupScene();
    }

    private void setupScene() {
        stage.setTitle("QUADRATIC EQUATION SOLVER: JavaFX");
        Group root=new Group();
        Scene scene=new Scene(root,700,400);
        scene.setFill(Color.web("#F8F8F8"));
        //root.setStyle("-fx-background-color: #F8F8F8;");

        VBox vbox = new VBox();
        vbox.setStyle("-fx-font: 16 arial; -fx-font-weight: normal");
        vbox.setSpacing(20);
        vbox.setPadding(new Insets(40, 0, 0, 10));
        vbox.setAlignment(Pos.BOTTOM_LEFT);

        HBox hboxEquation=new HBox(15);
        hboxEquation.setPadding(new Insets(10,0,0,10));
        hboxEquation.setAlignment(Pos.CENTER_LEFT);
        Label labelQuadraticEquation=new Label("Quadratic equation:");
        labelQuadraticEquation.setStyle("-fx-font: 18 arial; -fx-font-weight: normal");
        //labelQuadraticEquation.setTextFill(Color.web("#191970"));
        //labelQuadraticEquation.setTextFill(Color.web("#000000"));
        ImageView imv1 = new ImageView();
        Image imageQuadraticEquation = new Image(QuadraticEquationCalculator.class.getResourceAsStream("QuadraticEquation.png"));
        imv1.setImage(imageQuadraticEquation);
        hboxEquation.getChildren().addAll(labelQuadraticEquation,imv1);

        Label labelEnterCoefficients=new Label("Enter coefficients of quadratic equation (coefficient a is not equal to 0):");
        labelEnterCoefficients.setStyle("-fx-font: 18 arial; -fx-font-weight: normal");
        //labelEnterCoefficients.setTextFill(Color.web("#191970"));
        HBox hboxACoeff=new HBox(5);
        hboxEquation.setAlignment(Pos.BOTTOM_LEFT);
        Label aCoeff = new Label("a = ");
        aCoeff.setStyle("-fx-font: 18 arial; -fx-font-weight: normal");
        //aCoeff.setTextFill(Color.web("#191970"));
        hboxACoeff.getChildren().add(aCoeff);
        hboxACoeff.getChildren().add(coefficientA);

        HBox hboxBCoeff=new HBox(5);
        Label bCoeff = new Label("b = ");
        bCoeff.setStyle("-fx-font: 18 arial; -fx-font-weight: normal");
        hboxBCoeff.getChildren().addAll(bCoeff);
        hboxBCoeff.getChildren().add(coefficientB);

        HBox hboxCCoeff=new HBox(5);
        Label cCoeff = new Label("c = ");
        cCoeff.setStyle("-fx-font: 18 arial; -fx-font-weight: normal");
        hboxCCoeff.getChildren().addAll(cCoeff);
        hboxCCoeff.getChildren().add(coefficientC);

        HBox hboxRootsFormula=new HBox(25);
        hboxRootsFormula.setAlignment(Pos.CENTER_LEFT);
        Label labelEquationRoots=new Label("Roots of quadratic equation:");
        labelEquationRoots.setStyle("-fx-font: 18 arial; -fx-font-weight: normal");
        ImageView imv2=new ImageView();
        Image imageQuadraticEquationRoots=new Image(QuadraticEquationCalculator.class.getResourceAsStream("QuadraticEquationRoots.png"));
        imv2.setImage(imageQuadraticEquationRoots);
        Button calculateRootsButton=new Button("Calculate roots");
        calculateRootsButton.setStyle("-fx-font: 18 arial; -fx-base: #66ccff;");
        //calculateRootsButton.setFont(new Font("Lucida Sans", 16));
        calculateRootsButton.setOnAction(event1 -> {
            final BigDecimal a = convertStringToBigDecimal(coefficientA.getText());
            final BigDecimal b = convertStringToBigDecimal(coefficientB.getText());
            final BigDecimal c = convertStringToBigDecimal(coefficientC.getText());
            final List<BigDecimal> solutions = RootsOfQuadraticEquation.calculateSolutionsOfEquation(a, b, c);
            rootX1.setText(solutions.get(0).toPlainString());
            rootX2.setText(solutions.get(1).toPlainString());

        });
        hboxRootsFormula.getChildren().addAll(labelEquationRoots,imv2,calculateRootsButton);

        HBox hboxEquationRootX1=new HBox(5);
        Label labelRootX1 = new Label("x1 = ");
        labelRootX1.setStyle("-fx-font: 18 arial; -fx-font-weight: normal");
        rootX1.setEditable(false);
        hboxEquationRootX1.getChildren().addAll(labelRootX1,rootX1);

        HBox hboxEquationRootX2=new HBox(5);
        Label labelRootX2 = new Label("x2 = ");
        labelRootX2.setStyle("-fx-font: 18 arial; -fx-font-weight: normal");
        rootX2.setEditable(false);
        hboxEquationRootX2.getChildren().addAll(labelRootX2,rootX2);

        vbox.getChildren().addAll(labelEnterCoefficients,hboxACoeff,hboxBCoeff,hboxCCoeff,hboxRootsFormula,hboxEquationRootX1,hboxEquationRootX2);
        root.getChildren().addAll(hboxEquation,vbox);

        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> System.exit(0));
    }

    /**
     * Converts String to BigDecimal.
     *@param str String to be converted to BigDecimal.
     *@return The BigDecimal corresponding to the provided String or Double.NaN
     *     if the conversion cannot be performed.
     */
    private static BigDecimal convertStringToBigDecimal(String str)
    {
        BigDecimal stringConvertedToNumber;
        try
        {
            stringConvertedToNumber = new BigDecimal(str);
        }
        catch (NumberFormatException nfe)
        {
            stringConvertedToNumber = null;
        }
        return stringConvertedToNumber;
    }




}
