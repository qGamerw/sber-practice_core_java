package JavaIO;

import java.io.*;

public class FileCheck {
    public static void main(String[] args) {
         
        String filer = "JavaIO/Borodino.txt";
        String filew = "JavaIO/BorodinoDeleteSpace.txt";
        
        String file ="JavaIO/listNames.txt";
        String fileSort = "JavaIO/sortNames.txt";
        

        try (FileOutputStream outputStream = new FileOutputStream("JavaIO/saveHero.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            FileInputStream fileInputStream = new FileInputStream("JavaIO/saveHero.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
           
            FileDeleteSpace.deleteSpace(filer, filew);
            FileSort.SortNames(file, fileSort);

            Hero hero = new Hero("Jack");
            Hero hero2 = new Hero();
            
            System.out.println(hero);
            hero.attack(5);

            objectOutputStream.writeObject(hero);

            hero2 = (Hero) objectInputStream.readObject();
            System.out.println(hero2);

        } catch (IOException exception){
            exception.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException){
            classNotFoundException.printStackTrace();
        }
    }
}
