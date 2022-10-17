import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        boolean loop = true;
        int choice;
        int input;
        Scanner scanner = new Scanner(System.in);

        // enter all books into ArrayList

        ArrayList<Book> book = new ArrayList<>();
        book.add(new Book(0, "Zrozumiec programowanie", "Gynveal Coldwind"));
        book.add(new Book(1, "Programistą być", "Mateusz Rus"));
        book.add(new Book(2, "Zostań Ultrasamoukiem", "Scott H.Young"));


        // create the user instance

        User user1 = new User(0, "Julia");


        while (loop) {

            System.out.println("\n\tMENU\t");
            System.out.println("Choose one option 1 - 4");
            System.out.println("1. Borrow the book\n2. Return the book to library\n3. Check borrowed books\n4. Exit");
            System.out.print("\n Your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();


            switch (choice) {
                case 1:                         // Borrowing books mechanism
                    for (Book a : book)
                        System.out.println(a.getBook_id() + ". " + a.getTitle());

                    System.out.print("\nPick book which you would like to borrow by choose the number: ");

                    input = scanner.nextInt();
                    scanner.nextLine();
                    user1.addBook(input);
                    break;
                case 2:                         // Books returning mechanism
                    System.out.println("Pick book which you want to return to library");

                    for (Integer b : user1.getBookId())
                        System.out.println(book.get(b));

                    System.out.print("Your choice: ");
                    input = scanner.nextInt();
                    scanner.nextLine();
                    user1.removeBook(input);
                    break;
                case 3:
                    for (Integer b : user1.getBookId()) {
                        System.out.println(book.get(b));
                    }
                    break;
                case 4:
                    loop = false;
                    break;
            }
        }
        scanner.close();
    }
}
