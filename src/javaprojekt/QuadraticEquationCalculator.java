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
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by user on 22.12.2015.
 */
public class QuadraticEquationCalculator {
    Stage stage=new Stage();
    
    QuadraticEquationCalculator(){
        setupScene2();
    }

    private void setupScene2() {
        stage.setTitle("QUADRATIC EQUATION SOLVER: JavaFX");
        Group root=new Group();
        Scene scene=new Scene(root,600,300, Color.WHITE);

        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(30, 0, 0, 10));
        HBox hboxEquation=new HBox(15);
        hboxEquation.setPadding(new Insets(10,0,0,10));
        hboxEquation.setAlignment(Pos.CENTER_LEFT);
        Label quadraticEquationLabel=new Label("Quadratic equation:");
        quadraticEquationLabel.setFont(new Font("Lucida Sans", 16));
        ImageView imv1 = new ImageView();
        Image image1 = new Image(QuadraticEquationCalculator.class.getResourceAsStream("QuadraticEquation.png"));
        imv1.setImage(image1);
        hboxEquation.getChildren().addAll(quadraticEquationLabel,imv1);

        Label labelEnterCoefficients=new Label("Enter coefficients of quadratic equation (coefficient a is not equal to 0):");
        labelEnterCoefficients.setFont(new Font("Lucida Sans", 16));
        HBox hboxA=new HBox(5);
        Label aCoeff = new Label("a = ");
        aCoeff.setFont(new Font("Lucida Sans", 16));
        TextField aCoeffField=new TextField();
        hboxA.getChildren().addAll(aCoeff,aCoeffField);
        //entryBox.getChildren().add(this.coefficientA);
        HBox hboxB=new HBox(5);
        Label bCoeff = new Label("b = ");
        bCoeff.setFont(new Font("Lucida Sans", 16));
        TextField bCoeffField=new TextField();
        hboxB.getChildren().addAll(bCoeff,bCoeffField);
        //entryBox.getChildren().add(this.coefficientB);
        HBox hboxC=new HBox(5);
        Label cCoeff = new Label("c = ");
        cCoeff.setFont(new Font("Lucida Sans", 16));
        TextField cCoeffField=new TextField();
        hboxC.getChildren().addAll(cCoeff,cCoeffField);
        //entryBox.getChildren().add(this.coefficientC);
        HBox hboxRoots=new HBox(15);
        hboxRoots.setAlignment(Pos.CENTER_LEFT);
        Label equationRoots=new Label("Roots of quadratic equation:");
        equationRoots.setFont(new Font("Lucida Sans", 16));
        ImageView imv2=new ImageView();
        Image image2=new Image(QuadraticEquationCalculator.class.getResourceAsStream("QuadraticEquationRoots.png"));
        imv2.setImage(image2);
        hboxRoots.getChildren().addAll(equationRoots,imv2);

        HBox hboxX1=new HBox(5);
        Label X1Root = new Label("x1 = ");
        X1Root.setFont(new Font("Lucida Sans", 16));
        TextField x1Field=new TextField();
        hboxX1.getChildren().addAll(X1Root,x1Field);

        HBox hboxX2=new HBox(5);
        Label X2Root = new Label("x2 = ");
        X2Root.setFont(new Font("Lucida Sans", 16));
        TextField X2Field=new TextField();
        Button calculateRootsButton=new Button("Calculate roots");
        calculateRootsButton.setFont(new Font("Lucida Sans", 16));
        hboxX2.getChildren().addAll(X2Root,X2Field,calculateRootsButton);

        vbox.getChildren().addAll(labelEnterCoefficients,hboxA,hboxB,hboxC,hboxRoots,hboxX1,hboxX2);
        root.getChildren().addAll(hboxEquation,vbox);

        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(event -> System.exit(0));
    }
}
