import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        // enter all books into ArrayList

        ArrayList<Book> book = new ArrayList<>();
        book.add(new Book(0, "Zrozumiec programowanie", "Gynveal Coldwind"));
        book.add(new Book(1, "Programistą być", "Mateusz Rus"));
        book.add(new Book(2, "Zostań Ultrasamoukiem", "Scott H.Young"));


        // create the user instance

        User user1 = new User(0, "Julia");


        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int choice;

        while (i < 5) {
            System.out.println("\n\tMENU\t");
            System.out.println("Choose one option 1 - 4");
            System.out.println("1. Borrow the book\n2. Return the book to library\n3. Check borrowed books\n4. Check book availability");
            System.out.print("\n Your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            i++;

            switch (choice) {
                case 1:                         // Borrowing books mechanism
                    for (Book a : book)
                        System.out.println(a.getBook_id() + ". " + a.getTitle());
                    System.out.print("\nPick book which you would like to borrow by choose the number: ");

                    int x = scanner.nextInt();
                    scanner.nextLine();
                    user1.addBook(x);
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
        scanner.close();
    }
}
