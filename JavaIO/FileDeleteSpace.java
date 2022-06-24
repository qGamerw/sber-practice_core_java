package JavaIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

public class FileDeleteSpace {
    
    public static void deleteSpace(String filer, String filew){
        
        BufferedReader br = null;
        PrintWriter pw = null;
        
        try {
            br = new BufferedReader(new FileReader(filer));
            pw = new PrintWriter(filew);
            String line;
            try {
                while ((line = br.readLine()) != null){
                    line = line.replaceAll("\\s+"," ");
                    line = line.replaceAll(" ,",", ");
                    line = line.replaceAll(" !","! ");
                    pw.println(line);
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        } catch (FileNotFoundException exception1) {
            exception1.printStackTrace();
        }
        finally{
            try {
                br.close();
                pw.close();
            } catch (IOException exception2) {
                exception2.printStackTrace();
            }
        }
    }
}
