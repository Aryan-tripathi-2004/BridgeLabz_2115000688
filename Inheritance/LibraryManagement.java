class Book{
    private String title;
    private int publicationYear;

    public Book(String title, int publicationYear){
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public void displayInfo(){
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}
class Author extends Book{
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio){
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    public void displayInfo(){
        super.displayInfo();
        System.out.println("Name: " + name);
        System.out.println("Bio: " + bio);
    }
}

class LibraryManagement{
    public static void main(String args[]){
        Book author = new Author("Java Programming", 2019, "Aryan Tripathi", "Aryan Tripathi is a Java Developer");
        author.displayInfo();
    }
}