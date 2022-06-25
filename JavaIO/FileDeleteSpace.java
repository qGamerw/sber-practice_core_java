package JavaIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

public class FileDeleteSpace {
    
    public static void deleteSpace(String fileRead, String fileWrite){
        
        BufferedReader bufferedReader = null;
        PrintWriter printWriter = null;
        
        try { 
            bufferedReader = new BufferedReader(new FileReader(fileRead));
            printWriter = new PrintWriter(fileWrite);
            String line;
            try {
                while ((line = bufferedReader.readLine()) != null){
                    line = line.replaceAll("\\s+"," ");
                    line = line.replaceAll(" ,",", ");
                    line = line.replaceAll(" !","! ");
                    printWriter.println(line);
                }

            } catch (IOException eIoException) {
                eIoException.printStackTrace();
            }
        } catch (FileNotFoundException eFileNotFoundException) {
            eFileNotFoundException.printStackTrace();
        }
        finally{
            try {
                bufferedReader.close();
                printWriter.close();
            } catch (IOException eIoException) {
                eIoException.printStackTrace();
            }
        }
    }
}
