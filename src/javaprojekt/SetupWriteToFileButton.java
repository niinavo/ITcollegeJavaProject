package javaprojekt;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.*;

public class SetupWriteToFileButton {
    /**
     * Setup button which writes input (coefficients 'a', 'b', 'c') and
     * output (solutions 'x1' and 'x2') data into file "tekst.txt"
     */
    public void setupWriteToFileButton(
            Button button, TextField coefficientA, TextField coefficientB,
            TextField coefficientC, TextField rootX1, TextField rootX2){
        button.setOnAction(event -> {
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
