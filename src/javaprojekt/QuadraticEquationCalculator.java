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
    /**
     * TextField for entering coefficient a of quadratic equation.
     */
    TextField coefficientA = new TextField();
    /**
     * TextField for entering coefficient b of quadratic equation.
     */
    TextField coefficientB = new TextField();
    /**
     * TextField for entering coefficient c of quadratic equation.
     */
    TextField coefficientC = new TextField();
    /**
     * TextField for calculated solution x1 of equation
     */
    TextField rootX1 = new TextField();
    /**
     * TextField for calculated solution x2 of equation
     */
    TextField rootX2 = new TextField();

    Button clearButton;
    Button calculateRootsButton;

    ;

    QuadraticEquationCalculator() {
        setupScene();
        System.out.println("setupScene");
        Buttons buttons=new Buttons();
        buttons.setupClearButton(coefficientA,coefficientB,coefficientC,rootX1,rootX2,clearButton);
        buttons.setupCalculateRootsButton(coefficientA,coefficientB,coefficientC,rootX1,rootX2,calculateRootsButton);
    }

    public void setupScene() {
        stage.setTitle("TEST QUADRATIC EQUATION SOLVER: JavaFX");
        Group group = new Group();
        group.getChildren().add(buildOverallVerticalLayout());

        Scene scene = new Scene(group, 600, 470);
        scene.setFill(Color.web("#D6EBF2"));

        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> System.exit(0));
    }

    /**
     * Build overall presentation of application.
     *
     * @return Vertical box representing input and output of application.
     */
    public VBox buildOverallVerticalLayout() {
        VBox vbox = new VBox(13);
        vbox.setStyle("-fx-font: 20 arial; -fx-font-weight: normal");
        vbox.setPadding(new Insets(0, 0, 0, 15));
        vbox.getChildren().addAll(buildTitleBox(), buildEquation(), buildEnterCoefficientsBox(), buildAcoeffBox(),
                buildBCoeffBox(), buildCCoeffBox(), buildRootsFormula(), buildEquationRootX1(), buildEquationRootX2());
        return vbox;
    }

    public HBox buildTitleBox() {
        HBox hboxTitle = new HBox();
        hboxTitle.setPadding(new Insets(10, 0, 0, 0));
        hboxTitle.setAlignment(Pos.CENTER);
        Label labelTitle = new Label("QUADRATIC EQUATION SOLVER");
        labelTitle.setStyle("-fx-font: 26 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        hboxTitle.getChildren().add(labelTitle);
        return hboxTitle;
    }

    public HBox buildEquation() {
        HBox hboxEquation = new HBox(15);
        hboxEquation.setAlignment(Pos.CENTER_LEFT);
        Label labelQuadraticEquation = new Label("Quadratic equation:");
        labelQuadraticEquation.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        ImageView imv1 = new ImageView();
        Image imageQuadraticEquation = new Image(QuadraticEquationCalculator.class.getResourceAsStream("QuadraticEquation.png"));
        imv1.setImage(imageQuadraticEquation);
        hboxEquation.getChildren().addAll(labelQuadraticEquation, imv1);
        return hboxEquation;
    }

    public HBox buildEnterCoefficientsBox() {
        HBox hboxEnterCoefficients = new HBox();
        Label labelEnterCoefficients = new Label("Enter coefficients of quadratic equation");
        labelEnterCoefficients.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        hboxEnterCoefficients.getChildren().add(labelEnterCoefficients);
        return hboxEnterCoefficients;
    }

    public HBox buildAcoeffBox() {
        HBox hboxACoeff = new HBox(5);
        Label aCoeff = new Label("a = ");
        aCoeff.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        coefficientA.setPrefSize(251.0, 37.0);
        hboxACoeff.getChildren().addAll(aCoeff, this.coefficientA);
        return hboxACoeff;
    }

    public HBox buildBCoeffBox() {
        HBox hboxBCoeff = new HBox(5);
        Label bCoeff = new Label("b = ");
        bCoeff.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        coefficientB.setPrefSize(251.0, 37.0);
        hboxBCoeff.getChildren().addAll(bCoeff, this.coefficientB);
        return hboxBCoeff;
    }

    public HBox buildCCoeffBox() {
        HBox hboxCCoeff = new HBox(5);
        Label cCoeff = new Label("c = ");
        cCoeff.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        coefficientC.setPrefSize(251.0, 37.0);
        clearButton = new Button("Clear");
        clearButton.setStyle("-fx-font: 22 arial; -fx-base: #66ccff;; -fx-text-fill: darkblue");
        hboxCCoeff.getChildren().addAll(cCoeff, this.coefficientC, new Label("   "), clearButton);
        return hboxCCoeff;
    }

    public HBox buildRootsFormula() {
        HBox hboxRootsFormula = new HBox(25);
        hboxRootsFormula.setAlignment(Pos.CENTER);
        Label labelEquationRoots = new Label("Roots of quadratic equation:");
        labelEquationRoots.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        ImageView imv2 = new ImageView();
        Image imageQuadraticEquationRoots = new Image(QuadraticEquationCalculator.class.getResourceAsStream("QuadraticEquationRoots.png"));
        imv2.setImage(imageQuadraticEquationRoots);
        hboxRootsFormula.getChildren().addAll(labelEquationRoots, imv2);
        return hboxRootsFormula;
    }

    public HBox buildEquationRootX1() {
        HBox hboxEquationRootX1 = new HBox(5);
        Label labelRootX1 = new Label("x1 = ");
        labelRootX1.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        rootX1.setEditable(false);
        rootX1.setDisable(true);
        calculateRootsButton = new Button("Calculate roots");
        calculateRootsButton.setStyle("-fx-font: 22 arial; -fx-base: #66ccff;; -fx-text-fill: darkblue");
        hboxEquationRootX1.getChildren().addAll(labelRootX1, rootX1, new Label("   "), calculateRootsButton);
        return hboxEquationRootX1;
    }

    public HBox buildEquationRootX2() {
        HBox hboxEquationRootX2 = new HBox(5);
        Label labelRootX2 = new Label("x2 = ");
        labelRootX2.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        rootX2.setEditable(false);
        rootX2.setDisable(true);
        hboxEquationRootX2.getChildren().addAll(labelRootX2, rootX2);
        return hboxEquationRootX2;
    }
}

