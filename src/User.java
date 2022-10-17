import java.util.ArrayList;
public class User {
    private Integer id;
    private String name;
    private ArrayList<Integer> bookId = new ArrayList<>();


    //constructor
    User(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public void addBook(Integer bookId){
        this.bookId.add(bookId);
    }

    public void removeBook(Integer bookId){
        this.bookId.remove(bookId);
    }


    // getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getBookId() {
        return bookId;
    }
}
