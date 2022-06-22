package OOP_1;

public class Author {
    protected String nameAuthor;
    protected char gender;
    protected String email;

    public Author(String nameAuthor, char gender, String email){
        this.nameAuthor = nameAuthor;
        this.gender = gender;
        this.email = email;
    }
    public void setNameAuthor(String nameAuthor) {
            this.nameAuthor = nameAuthor;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public char getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String toString(){
        return String.format("Автор: %s, пол: %s, email: %s", this.nameAuthor, this.gender, this.email);
    }
    
}
