package javaprojekt;

import javafx.scene.control.TextField;

public class SetupActionOfClearButton {
    /**
     * Setup button "Clear" which clears contents of input and output textfields
     * and resets initial textfields style
     */
    public static void setupActionOfClearButton(
            TextField coefficientA, TextField coefficientB, TextField coefficientC,
            TextField rootX1, TextField rootX2){

            coefficientA.clear();
            coefficientB.clear();
            coefficientC.clear();
            coefficientA.setStyle("-fx-text-inner-color: black;");
            coefficientB.setStyle("-fx-text-inner-color: black;");
            coefficientC.setStyle("-fx-text-inner-color: black;");
            rootX1.clear();
            rootX2.clear();
    }
}
