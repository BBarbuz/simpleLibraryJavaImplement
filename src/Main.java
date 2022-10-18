import java.util.Scanner;
import java.util.ArrayList;

class Tools {
    public Boolean availability(int a) {
        return a > 0;
    }

    // public void showBorrowedBooks (User user, Book book)         in progress
}
public class Main {
    public static void main(String[] args) {

        boolean mainLoop = true;
        int choice;
        int input;
        boolean loopCheck;
        Scanner scanner = new Scanner(System.in);

        // enter all books into ArrayList

        ArrayList<Book> book = new ArrayList<>();
        book.add(new Book(0, "Zrozumiec programowanie", "Gynveal Coldwind",3));
        book.add(new Book(1, "Programistą być", "Mateusz Rus", 1));
        book.add(new Book(2, "Zostań Ultrasamoukiem", "Scott H.Young",2));


        // create the user instance

        User user1 = new User(0, "Julia");

        Tools tool = new Tools();
        Book bookInstance;


        while (mainLoop) {

            System.out.println("\n\tMENU\t");
            System.out.println("Choose one option 1 - 4");
            System.out.println("1. Borrow the book\n2. Return the book to library\n3. Check borrowed books\n4. Check availability\n5. Exit");
            System.out.print("\n Your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {


                case 1:             // Borrowing books mechanism
                    loopCheck = true;
                    while(loopCheck)
                    {
                        for (Book a : book)
                            System.out.println(a.getBook_id() + ". " + a.getTitle() + "\t\t| book availability: "+ tool.availability(a.getAmount()));

                        System.out.print("\nPick book which you would like to borrow by choose the number: ");

                        input = scanner.nextInt();
                        scanner.nextLine();

                        loopCheck = false;

                        for (Integer b : user1.getBookId())
                            if (input == b) {
                                System.out.println("\nYou can't borrow the same book twice!\n");
                                loopCheck = true;
                                break;
                            }

                        if(!loopCheck)                              // change amount of books in library after operation and add book to user account
                        {
                            bookInstance = book.get(input);
                            bookInstance.setAmount(bookInstance.getAmount() - 1);
                            user1.addBook(input);
                        }
                    }
                    break;


                case 2:                         // Books returning mechanism
                    System.out.println("Pick book which you want to return to library");

                    for (Integer b : user1.getBookId())
                        System.out.println(book.get(b));

                    System.out.print("Your choice: ");
                    input = scanner.nextInt();
                    scanner.nextLine();

                    bookInstance = book.get(input);                 // change amount of books in library after operation and remove book from user account
                    bookInstance.setAmount(bookInstance.getAmount() + 1);
                    user1.removeBook(input);
                    break;


                case 3:                         // Show borrowed books if empty - show it

                    if (user1.getBookId().isEmpty())
                        System.out.printf("\n%s, you don't have any borrowed books right now\n", user1.getName());
                    else {
                        for (Integer b : user1.getBookId()) {
                            System.out.println(book.get(b));
                        }
                    }

                    break;


                case 4:                         // Show book availability
                    for (Book a : book)
                        System.out.println(a.getBook_id() + ". " + a.getTitle() + "\t\t| book availability: "+ tool.availability(a.getAmount()));
                    break;


                case 5:                         // Exit program
                    mainLoop = false;
                    break;
            }
        }

        scanner.close();
    }
}
