package JavaIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
 
public class FileSort {
    
    public static void SortNames(String fileRead, String fileWrite) throws IOException{
        
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRead));
             PrintWriter printWriter = new PrintWriter(fileWrite);) {

            String line;
            try {
                while ((line = bufferedReader.readLine()) != null){
                    line = line.replaceAll(",","");
                    
                    String[] namesArr = line.split(" ");
                    sortName(namesArr);
                    
                    for (String name : namesArr) {
                        printWriter.write(name + "\n");
                    }
                }
            } catch (IOException eIoException) {
                eIoException.printStackTrace();
            }
        } catch (FileNotFoundException eFileNotFoundException) {
            eFileNotFoundException.printStackTrace();
        }
    }

    private static void sortName(String[] strArr){
        for (int i = 0; i < strArr.length; i++) {
            for (int j = i + 1; j < strArr.length; j++) {
                if ((strArr[i].compareTo(strArr[j])) > 0){
                    String buff = strArr[i];
                    strArr[i] = strArr[j];
                    strArr[j] = buff;
                }
            }
        }
    }
}
