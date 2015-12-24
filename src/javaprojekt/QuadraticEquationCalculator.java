package javaprojekt;

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

    QuadraticEquationCalculator() {
        setupScene();
    }

    private void setupScene() {
        stage.setTitle("QUADRATIC EQUATION SOLVER: JavaFX");
        Group root=new Group();
        Scene scene=new Scene(root,600,300, Color.WHITE);

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(30, 0, 0, 10));

        HBox hboxEquation=new HBox(15);
        hboxEquation.setPadding(new Insets(10,0,0,10));
        hboxEquation.setAlignment(Pos.CENTER_LEFT);
        Label labelQuadraticEquation=new Label("Quadratic equation:");
        labelQuadraticEquation.setFont(new Font("Lucida Sans", 16));
        ImageView imv1 = new ImageView();
        Image imageQuadraticEquation = new Image(QuadraticEquationCalculator.class.getResourceAsStream("QuadraticEquation.png"));
        imv1.setImage(imageQuadraticEquation);
        hboxEquation.getChildren().addAll(labelQuadraticEquation,imv1);

        Label labelEnterCoefficients=new Label("Enter coefficients of quadratic equation (coefficient a is not equal to 0):");
        labelEnterCoefficients.setFont(new Font("Lucida Sans", 16));
        HBox hboxACoeff=new HBox(5);
        Label aCoeff = new Label("a = ");
        aCoeff.setFont(new Font("Lucida Sans", 16));
        hboxACoeff.getChildren().add(aCoeff);
        hboxACoeff.getChildren().add(coefficientA);

        HBox hboxBCoeff=new HBox(5);
        Label bCoeff = new Label("b = ");
        bCoeff.setFont(new Font("Lucida Sans", 16));
        hboxBCoeff.getChildren().addAll(bCoeff);
        hboxBCoeff.getChildren().add(coefficientB);

        HBox hboxCCoeff=new HBox(5);
        Label cCoeff = new Label("c = ");
        cCoeff.setFont(new Font("Lucida Sans", 16));
        hboxCCoeff.getChildren().addAll(cCoeff);
        hboxCCoeff.getChildren().add(coefficientC);

        HBox hboxRootsFormula=new HBox(15);
        hboxRootsFormula.setAlignment(Pos.CENTER_LEFT);
        Label labelEquationRoots=new Label("Roots of quadratic equation:");
        labelEquationRoots.setFont(new Font("Lucida Sans", 16));
        ImageView imv2=new ImageView();
        Image imageQuadraticEquationRoots=new Image(QuadraticEquationCalculator.class.getResourceAsStream("QuadraticEquationRoots.png"));
        imv2.setImage(imageQuadraticEquationRoots);
        Button calculateRootsButton=new Button("Calculate roots");
        calculateRootsButton.setFont(new Font("Lucida Sans", 16));
        hboxRootsFormula.getChildren().addAll(labelEquationRoots,imv2,calculateRootsButton);

        HBox hboxEquationRootX1=new HBox(5);
        Label labelRootX1 = new Label("x1 = ");
        labelRootX1.setFont(new Font("Lucida Sans", 16));
        TextField RootX1Field=new TextField();
        hboxEquationRootX1.getChildren().addAll(labelRootX1,RootX1Field);

        HBox hboxEquationRootX2=new HBox(5);
        Label labelRootX2 = new Label("x2 = ");
        labelRootX2.setFont(new Font("Lucida Sans", 16));
        TextField RootX2Field=new TextField();
        hboxEquationRootX2.getChildren().addAll(labelRootX2,RootX2Field);

        vbox.getChildren().addAll(labelEnterCoefficients,hboxACoeff,hboxBCoeff,hboxCCoeff,hboxRootsFormula,hboxEquationRootX1,hboxEquationRootX2);
        root.getChildren().addAll(hboxEquation,vbox);

        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> System.exit(0));
    }




}
