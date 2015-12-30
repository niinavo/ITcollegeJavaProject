package javaprojekt;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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

    QuadraticEquationCalculator(){
        setupScene();
    }

    private void setupScene() {
        stage.setTitle("QUADRATIC EQUATION SOLVER: JavaFX");
        Group root=new Group();
        Scene scene=new Scene(root,600,470);
        scene.setFill(Color.web("#D6EBF2"));

        VBox vbox = new VBox(15);
        vbox.setStyle("-fx-font: 20 arial; -fx-font-weight: normal");
        vbox.setPadding(new Insets(0, 0, 0, 10));
        //vbox.setAlignment(Pos.BOTTOM_LEFT);

        HBox hboxTitle=new HBox();
        hboxTitle.setPadding(new Insets(10,0,0,0));
        hboxTitle.setAlignment(Pos.CENTER);
        Label labelTitle=new Label("QUADRATIC EQUATION SOLVER");
        labelTitle.setStyle("-fx-font: 26 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        hboxTitle.getChildren().add(labelTitle);

        HBox hboxEquation=new HBox(15);
        hboxEquation.setPadding(new Insets(50,0,30,10));
        hboxEquation.setAlignment(Pos.CENTER_LEFT);
        Label labelQuadraticEquation=new Label("Quadratic equation:");
        labelQuadraticEquation.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        ImageView imv1 = new ImageView();
        Image imageQuadraticEquation = new Image(QuadraticEquationCalculator.class.getResourceAsStream("QuadraticEquation.png"));
        imv1.setImage(imageQuadraticEquation);
        hboxEquation.getChildren().addAll(labelQuadraticEquation,imv1);

        HBox hboxEnterCoefficients=new HBox();
        hboxEnterCoefficients.setPadding(new Insets(30,0,0,0));
        Label labelEnterCoefficients=new Label("Enter coefficients of quadratic equation");
        labelEnterCoefficients.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        hboxEnterCoefficients.getChildren().add(labelEnterCoefficients);

        HBox hboxACoeff=new HBox(5);
        //hboxEquation.setAlignment(Pos.BOTTOM_LEFT);
        Label aCoeff = new Label("a = ");
        aCoeff.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        hboxACoeff.getChildren().add(aCoeff);
        hboxACoeff.getChildren().add(coefficientA);

        HBox hboxBCoeff=new HBox(5);
        Label bCoeff = new Label("b = ");
        bCoeff.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        hboxBCoeff.getChildren().addAll(bCoeff);
        hboxBCoeff.getChildren().add(coefficientB);

        HBox hboxCCoeff=new HBox(5);
        Label cCoeff = new Label("c = ");
        cCoeff.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        hboxCCoeff.getChildren().addAll(cCoeff);
        hboxCCoeff.getChildren().add(coefficientC);

        HBox hboxRootsFormula=new HBox(25);
        hboxRootsFormula.setAlignment(Pos.CENTER_LEFT);
        Label labelEquationRoots=new Label("Roots of quadratic equation:");
        labelEquationRoots.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        ImageView imv2=new ImageView();
        Image imageQuadraticEquationRoots=new Image(QuadraticEquationCalculator.class.getResourceAsStream("QuadraticEquationRoots.png"));
        imv2.setImage(imageQuadraticEquationRoots);
        hboxRootsFormula.getChildren().addAll(labelEquationRoots,imv2);

        HBox hboxEquationRootX1=new HBox(5);
        Label labelRootX1 = new Label("x1 = ");
        labelRootX1.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        rootX1.setEditable(false);
        rootX1.setDisable(true);
        Button calculateRootsButton=new Button("Calculate roots");
        calculateRootsButton.setStyle("-fx-font: 22 arial; -fx-base: #66ccff;; -fx-text-fill: darkblue");

        calculateRootsButton.setOnAction(event1 -> {
            final BigDecimal a = convertStringToBigDecimal(coefficientA.getText());
            final BigDecimal b = convertStringToBigDecimal(coefficientB.getText());
            final BigDecimal c = convertStringToBigDecimal(coefficientC.getText());
            //System.out.println("a="+a+"; b="+b+"; c="+c);
            //System.out.println("discriminant: "+RootsOfQuadraticEquation.calculateDiscriminant(a,b,c));
            //System.out.println("square root of discriminant: "+RootsOfQuadraticEquation.calculateRootOfDiscriminant(a,b,c));
            //System.out.println("denominator: "+RootsOfQuadraticEquation.calculateDenominator(a));
            //System.out.println("numerator with addition: "+RootsOfQuadraticEquation.calculateNumeratorWithAddition(a,b,c));
            //System.out.println("numerator with addition: "+RootsOfQuadraticEquation.calculateNumeratorWithSubtraction(a,b,c));
            //System.out.println("solutions: "+RootsOfQuadraticEquation.calculateSolutionsOfEquation(a,b,c));
            try {
                final List<BigDecimal> solutions = RootsOfQuadraticEquation.calculateSolutionsOfEquation(a, b, c);
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
        hboxEquationRootX1.getChildren().addAll(labelRootX1,rootX1,new Label("   "),calculateRootsButton);

        HBox hboxEquationRootX2=new HBox(5);
        Label labelRootX2 = new Label("x2 = ");
        labelRootX2.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        rootX2.setEditable(false);
        rootX2.setDisable(true);
        hboxEquationRootX2.getChildren().addAll(labelRootX2,rootX2);

        vbox.getChildren().addAll(hboxTitle,hboxEnterCoefficients,hboxACoeff,
                hboxBCoeff, hboxCCoeff,hboxRootsFormula,hboxEquationRootX1,hboxEquationRootX2);
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
    public static BigDecimal convertStringToBigDecimal(String str)
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
