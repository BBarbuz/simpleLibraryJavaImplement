import java.util.ArrayList;
public class User {
    private final Integer id;
    private final String name;
    private final ArrayList<Integer> bookId = new ArrayList<>();


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

//    public toString(){
//        return String.format("%s", this.getName());
//    }


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
