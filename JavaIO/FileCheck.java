package JavaIO;

public class FileCheck {
    public static void main(String[] args) {
        String filer = "JavaIO/Borodino.txt";
        String filew = "JavaIO/BorodinoDeleteSpace.txt";
        FileDeleteSpace.deleteSpace(filer, filew);

        String file ="JavaIO/listNames.txt";
        String fileSort = "JavaIO/SortNames.txt";
        FileSort.SortNames(file, fileSort);
    }
}
