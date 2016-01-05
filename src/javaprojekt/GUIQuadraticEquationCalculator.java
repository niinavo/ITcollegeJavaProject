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

/**
 * JavaFX application for solving quadratic equations a*x*x+b*x+c=0
 * if coefficients a,b and c are entered. Only case of real-number solutions
 * (roots) of equation is considered.
 *
 * @author Niina Voropajeva
 */


public class GUIQuadraticEquationCalculator {
    Stage stage = new Stage();
    /** TextField for entering coefficient a of quadratic equation. */
    TextField coefficientA = new TextField();
    /** TextField for entering coefficient b of quadratic equation. */
    TextField coefficientB = new TextField();
    /** TextField for entering coefficient c of quadratic equation. */
    TextField coefficientC = new TextField();
    /** TextField for calculated solution x1 of equation */
    TextField rootX1 = new TextField();
    /** TextField for calculated solution x2 of equation */
    TextField rootX2 = new TextField();

    /**Button clears contents of input and output textfields
     * and resets initial textfields style*/
    Button clearButton;
    /** Button calculates solutions of equation if
     * coefficients of equations are entered into input textfields */
    Button calculateRootsButton;
    /**
     * Setup button which writes input (coefficients 'a', 'b', 'c') and
     * output (solutions 'x1' and 'x2') data into file "tekst.txt"
     */
    Button writeToFileButton;

    GUIQuadraticEquationCalculator() {
        setupScene();
        SetupClearButton button1=new SetupClearButton();
        button1.setupClearButton(clearButton,coefficientA,coefficientB,coefficientC,rootX1,rootX2);
        SetupCalculateRootsButton button2=new SetupCalculateRootsButton();
        button2.setupCalculateRootsButton(calculateRootsButton,coefficientA,coefficientB,coefficientC,rootX1,rootX2);
        SetupWriteToFileButton button3=new SetupWriteToFileButton();
        button3.setupWriteToFileButton(writeToFileButton,coefficientA,coefficientB,coefficientC,rootX1,rootX2);
    }

    private void setupScene() {
        stage.setTitle("QUADRATIC EQUATION SOLVER: JavaFX");
        Group group = new Group();
        group.getChildren().add(buildOverallVerticalLayout());

        Scene scene = new Scene(group, 600, 500);
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
    private VBox buildOverallVerticalLayout() {
        VBox vbox = new VBox(13);
        vbox.setStyle("-fx-font: 20 arial; -fx-font-weight: normal");
        vbox.setPadding(new Insets(0, 0, 0, 15));
        vbox.getChildren().addAll(buildTitleBox(), buildEquation(), buildEnterCoefficientsBox(), buildAcoeffBox(),
                buildBCoeffBox(), buildCCoeffBox(), buildRootsFormula(), buildEquationRootX1(), buildEquationRootX2());
        return vbox;
    }

    /**
     * Provide a read-only horizontal box with title of application "QUADRATIC EQUATION SOLVER"
     * @return Horizontal box with title of application "QUADRATIC EQUATION SOLVER"
     */
    private HBox buildTitleBox() {
        HBox hboxTitle = new HBox();
        hboxTitle.setPadding(new Insets(10, 0, 0, 0));
        hboxTitle.setAlignment(Pos.CENTER);
        Label labelTitle = new Label("QUADRATIC EQUATION SOLVER");
        labelTitle.setStyle("-fx-font: 26 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        hboxTitle.getChildren().add(labelTitle);
        return hboxTitle;
    }

    /**
     * Provide a read-only horizontal box with text "Quadratic equation:" and quadratic equation
     * @return Horizontal box with text "Quadratic equation:" and quadratic equation
     */
    private HBox buildEquation() {
        HBox hboxEquation = new HBox(15);
        hboxEquation.setAlignment(Pos.CENTER_LEFT);
        Label labelQuadraticEquation = new Label("Quadratic equation:");
        labelQuadraticEquation.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        ImageView imv1 = new ImageView();
        Image imageQuadraticEquation = new Image(GUIQuadraticEquationCalculator.class.getResourceAsStream("QuadraticEquation.png"));
        imv1.setImage(imageQuadraticEquation);
        hboxEquation.getChildren().addAll(labelQuadraticEquation, imv1);
        return hboxEquation;
    }

    /**
     * Provide a horizontal box with text "Enter coefficients of quadratic equation"
     * @return Horizontal box with text "Enter coefficients of quadratic equation"
     */
    private HBox buildEnterCoefficientsBox() {
        HBox hboxEnterCoefficients = new HBox();
        Label labelEnterCoefficients = new Label("Enter coefficients of quadratic equation" +
                "\n (integers or decimal numbers #.##):");
        labelEnterCoefficients.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        hboxEnterCoefficients.getChildren().add(labelEnterCoefficients);
        return hboxEnterCoefficients;
    }

    /**
     * Provide a horizontal box with text "a=" and textfield for entering coefficient a of equation
     * @return Horizontal box with text "a=" and textfield for entering coefficient a of equation
     */
    private HBox buildAcoeffBox() {
        HBox hboxACoeff = new HBox(5);
        Label aCoeff = new Label("a = ");
        aCoeff.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        coefficientA.setPrefSize(260.0, 37.0);
        hboxACoeff.getChildren().addAll(aCoeff, this.coefficientA);
        return hboxACoeff;
    }

    /**
     * Provide a horizontal box with text "b=" and textfield for entering coefficient b of equation
     * @return Horizontal box with text "b=" and textfield for entering coefficient b of equation
     */
    private HBox buildBCoeffBox() {
        HBox hboxBCoeff = new HBox(5);
        Label bCoeff = new Label("b = ");
        bCoeff.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        coefficientB.setPrefSize(260.0, 37.0);
        hboxBCoeff.getChildren().addAll(bCoeff, this.coefficientB);
        return hboxBCoeff;
    }

    /**
     * Provide a horizontal box with text "c=", textfield for entering coefficient c of equation
     * and button "clear"
     * @return Horizontal box with text "c=", textfield for entering coefficient c of equation
     */
    private HBox buildCCoeffBox() {
        HBox hboxCCoeff = new HBox(5);
        Label cCoeff = new Label("c = ");
        cCoeff.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        coefficientC.setPrefSize(260.0, 37.0);
        clearButton = new Button("Clear");
        clearButton.setStyle("-fx-font: 22 arial; -fx-base: #66ccff;; -fx-text-fill: darkblue");
        hboxCCoeff.getChildren().addAll(cCoeff, this.coefficientC, new Label("   "), clearButton);
        return hboxCCoeff;
    }

    /**
     * Provide a read-only horizontal box with text "Roots of quadratic equation:"
     * and expession of roots of quadratic equation (i.e. quadratic formula)
     * @return Horizontal box with text "Roots of quadratic equation:"
     * and expession of roots of quadratic equation (i.e. quadratic formula)
     */
    private HBox buildRootsFormula() {
        HBox hboxRootsFormula = new HBox(25);
        hboxRootsFormula.setAlignment(Pos.CENTER_LEFT);
        Label labelEquationRoots = new Label("Roots of quadratic equation:");
        labelEquationRoots.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        ImageView imv2 = new ImageView();
        Image imageQuadraticEquationRoots = new Image(GUIQuadraticEquationCalculator.class.getResourceAsStream("QuadraticEquationRoots.png"));
        imv2.setImage(imageQuadraticEquationRoots);
        hboxRootsFormula.getChildren().addAll(labelEquationRoots, imv2);
        return hboxRootsFormula;
    }

    /**
     * Provide a horizontal box with text "x1=", textfield for calculated root x1 of equation
     * and button "calculate roots"
     * @return Horizontal box with text "x1=", textfield for calculated root x1 of equation
     * and button "calculate roots"
     */
    private HBox buildEquationRootX1() {
        HBox hboxEquationRootX1 = new HBox(5);
        Label labelRootX1 = new Label("x1 = ");
        labelRootX1.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        rootX1.setEditable(false);
        calculateRootsButton = new Button("Calculate roots");
        calculateRootsButton.setStyle("-fx-font: 22 arial; -fx-base: #66ccff;; -fx-text-fill: darkblue");
        hboxEquationRootX1.getChildren().addAll(labelRootX1, rootX1, new Label("  "), calculateRootsButton);
        return hboxEquationRootX1;
    }

    /**
     * Provide a horizontal box with text "x2=", textfield for calculated root x1 of equation
     * and button "calculate roots"
     * @return Horizontal box with text "x2=", textfield for calculated root x1 of equation
     * and button "calculate roots"
     */
    public HBox buildEquationRootX2() {
        HBox hboxEquationRootX2 = new HBox(5);
        Label labelRootX2 = new Label("x2 = ");
        labelRootX2.setStyle("-fx-font: 22 arial; -fx-font-weight: normal; -fx-text-fill: darkblue");
        rootX2.setEditable(false);
        writeToFileButton=new Button("Write to file");
        writeToFileButton.setStyle("-fx-font: 22 arial; -fx-base: #66ccff;; -fx-text-fill: darkblue");
        hboxEquationRootX2.getChildren().addAll(labelRootX2, rootX2, new Label("  "),writeToFileButton);
        return hboxEquationRootX2;
    }
}