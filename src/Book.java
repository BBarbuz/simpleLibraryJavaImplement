public class Book {
    private Integer book_id;
    private String title;
    private String author;

    Book(Integer book_id, String title, String author){     // constructor
        this.book_id = book_id;
        this.title = title;
        this.author = author;

    }

    public String toString(){       // for test purposes
        return String.format("%d. %s written by %s\n", this.book_id, this.title, this.author);
    }
    public String toStringColumns(){       // for test purposes
        return String.format("%d. %s written by %s\n", this.book_id, this.title, this.author);
    }

    //getters

    public Integer getBook_id() {
        return book_id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
