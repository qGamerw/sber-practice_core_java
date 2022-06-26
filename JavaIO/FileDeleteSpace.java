package JavaIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

public class FileDeleteSpace {
    
    public static void deleteSpace(String fileRead, String fileWrite) throws IOException{
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRead));
             PrintWriter printWriter = new PrintWriter(fileWrite);) { 

            
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
    }
}
