import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
public class Main {
    public static void main(String[] args) {

        ArrayList <Book> book = new ArrayList<>();
        book.add(new Book(0, "Zrozumiec programowanie", "Gynveal Coldwind"));
        book.add(new Book(1, "Programistą być", "Mateusz Rus"));
        book.add(new Book(2, "Zostań Ultrasamoukiem", "Scott H.Young"));

        User user1 = new User(0, "Julia");
        user1.addBook(0);
        user1.addBook(2);
        user1.removeBook(0);
        user1.addBook(1);
        user1.removeBook(2);



        //System.out.print(book.get(user1.getBookId()));


        System.out.println("\n\tMENU\t");
        System.out.println("Choose one option 1 - 4");
        System.out.println("1. Borrow the book\n2. Return the book to library\n3. Check borrowed books\n4. Check book availability");

        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Your choice: ");
        int choice = scanner.nextInt();
        scanner.close();

        //System.out.println(book.toString());

        switch(choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                for (Integer b : user1.getBookId()) {
                    System.out.println(book.get(b));
                }
                break;
            case 4:
                break;
        }


    }
}