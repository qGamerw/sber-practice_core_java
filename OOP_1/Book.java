package OOP_1;

public class Book extends Author{
    private String nameBook;
    private int year;

    public Book(String nameAuthor, char gender, String email, String nameBook, int year){
        super(nameAuthor, gender, email);
        this.nameBook = nameBook;
        this.year = year;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNameBook() {
        return nameBook;
    }

    public int getYear() {
        return year;
    }

    public String toString(){
        return String.format("Книжка: %s, Автор: %s, год: %s", this.nameBook, super.nameAuthor, this.year);
    }
}
