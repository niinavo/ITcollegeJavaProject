package javaprojekt;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class SetupClearButton {
    /**
     * Setup button "Clear" which clears contents of input and output textfields
     * and resets initial textfields style
     */
    public void setupClearButton(Button clearButton,
            TextField coefficientA, TextField coefficientB, TextField coefficientC,
            TextField rootX1, TextField rootX2){

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
}
