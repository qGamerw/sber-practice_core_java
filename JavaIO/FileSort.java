package JavaIO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;

public class FileSort {
    
    public static void SortNames(String filer, String filew){
        
        BufferedReader br = null;
        PrintWriter pw = null;
        
        try {
            br = new BufferedReader(new FileReader(filer));
            pw = new PrintWriter(filew);
            String line;
            try {
                while ((line = br.readLine()) != null){
                    line = line.replaceAll(",","");
                    
                    String[] names = line.split(" ");
                    sortName(names);
                    
                    for (String name : names) {
                        pw.write(name + "\n");
                    }
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

    private static void sortName(String[] str){
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if ((str[i].compareTo(str[j])) > 0){
                    String buff = str[i];
                    str[i] = str[j];
                    str[j] = buff;
                }
            }
        }
    }
}
