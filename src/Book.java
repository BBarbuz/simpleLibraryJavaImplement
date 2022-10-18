public class Book {
    private final Integer book_id;
    private final String title;
    private final String author;

    private Integer amount;

    Book(Integer book_id, String title, String author, Integer amount){     // constructor
        this.book_id = book_id;
        this.title = title;
        this.author = author;
        this.amount = amount;

    }

    public String toString(){       // for test purposes
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

    public Integer getAmount() {
        return amount;
    }


    //setters

    public void setAmount(Integer amount){
        this.amount = amount;
    }

}
