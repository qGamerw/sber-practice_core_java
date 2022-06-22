package OOP_1;

public class BookCheck {
    public static void main(String[] args) {
        Author author = new Author("Ivan", 'm', "email.com");
        
        Book book = new Book(author.nameAuthor, author.gender, author.email, "Cats", 2012);
        Book book2 = new Book("Dasha", 'w', "email.ru", "dogs", 2011);
        
        System.out.println(author);
        System.out.println(String.format("Автор: %s, пол: %s, email: %s", book2.nameAuthor, book2.gender, book2.email));
        
        System.out.println(book);
        System.out.println(book2);

        System.out.println(book.getNameAuthor() + " - " + book.getNameBook());
    }
}
