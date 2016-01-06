package javaprojekt;

import javafx.scene.control.TextField;
import java.io.*;

public class SetupActionOfWriteToFileButton {
    /**
     * Setup button which writes input (coefficients 'a', 'b', 'c') and
     * output (solutions 'x1' and 'x2') data into file "tekst.txt"
     */
    public static void setupActionOfWriteToFileButton(
            TextField coefficientA, TextField coefficientB,
            TextField coefficientC, TextField rootX1, TextField rootX2){
            String a=coefficientA.getText();
            String b=coefficientB.getText();
            String c=coefficientC.getText();
            String x1=rootX1.getText();
            String x2=rootX2.getText();
            File file = new File("tekst.txt");
            try
            {
                FileWriter fw = new FileWriter(file,true);
                PrintWriter pw = new PrintWriter(fw);
                pw.printf("a=%-5s b=%-5s c=%-5s x1=%-25s x2=%-25s %n",a,b,c,x1,x2);
                pw.close();
            }
            catch(IOException ex)
            {
                System.out.println("Could not write to file");
                System.exit(0);
            }
    }
}
