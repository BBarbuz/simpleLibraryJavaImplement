import java.util.Scanner;
import java.util.ArrayList;

class Tools {
    public Boolean availability(int a) {
        return a > 0;
    }
}
public class Main {
    public static void main(String[] args) {

        boolean mainLoop = true;
        int choice;
        String name;
        int input;
        boolean loopCheck;
        int usersCounter = 0;
        Scanner scanner = new Scanner(System.in);

        // Enter all books into ArrayList
        ArrayList<Book> book = new ArrayList<>();
        book.add(new Book(0, "Zrozumiec programowanie", "Gynveal Coldwind",3));
        book.add(new Book(1, "Programistą być", "Mateusz Rus", 1));
        book.add(new Book(2, "Zostań Ultrasamoukiem", "Scott H.Young",2));


        // Create the user ArrayList
        ArrayList<User> user = new ArrayList<>();

        System.out.println("\n\tSettings MENU\t");
        System.out.println("Add first library user");

        // Enter users
        do
        {
            System.out.print("Enter user name: ");
            name = scanner.nextLine();
            user.add(new User(usersCounter, name));
            usersCounter++;

            System.out.println("\nChoose option 1 or 2");
            System.out.println("1. Add another user\n2. Move to library (You can add more users later)");
            System.out.print("\tYour choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

        }while(choice == 1);

        // Choose user to began using library
        System.out.println("\nChoose user to began using library: ");
        for (User u : user)
            System.out.println(u.getId() + ".\t" + u.getName());

        System.out.print("\tYour choice: ");
        choice = scanner.nextInt();
        scanner.nextLine();

        User currentUser = user.get(choice);
        Tools tool = new Tools();
        Book bookInstance;


        while (mainLoop) {

            System.out.println("\n\tMENU\t");
            System.out.println("Choose one option 1 - 4");
            System.out.println("1. Borrow the book\n2. Return the book to library\n3. Check borrowed books\n4. Check availability\n5. Switch user\n6. Exit");
            System.out.print("\n Your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // Books borrow
                case 1:
                    loopCheck = true;
                    while(loopCheck) {
                        for (Book a : book)
                            System.out.println(a.getBook_id() + ". " + a.getTitle() + "\t\t| book availability: " + tool.availability(a.getAmount()));
                        System.out.print("\nPick book which you would like to borrow by choose the number: ");

                        input = scanner.nextInt();
                        scanner.nextLine();

                        loopCheck = false;

                        // check if user do not try borrow the same book twice
                        for (Integer b : currentUser.getBookId())
                            if (input == b) {
                                System.out.println("\nYou can't borrow the same book twice!\n");
                                loopCheck = true;
                                break;
                            }

                        //check the availability of specific book
                        Book checkBook = book.get(input);
                        if (!tool.availability(checkBook.getAmount()))
                        {
                            System.out.println("\nYou can't borrow this book all copies are on loan\n");
                            loopCheck = true;
                        }

                        // change amount of books in library after operation and add book to user account
                        if(!loopCheck)
                        {
                            bookInstance = book.get(input);
                            bookInstance.setAmount(bookInstance.getAmount() - 1);
                            currentUser.addBook(input);
                        }
                    }
                    break;


                // Books return
                case 2:
                    System.out.println("Pick book which you want to return to library");

                    for (Integer b : currentUser.getBookId())
                        System.out.println(book.get(b));

                    System.out.print("Your choice: ");
                    input = scanner.nextInt();
                    scanner.nextLine();

                    // change amount of books in library after operation and remove book from user account
                    bookInstance = book.get(input);
                    bookInstance.setAmount(bookInstance.getAmount() + 1);
                    currentUser.removeBook(input);
                    break;


                // Show borrowed books. If empty tell about it.
                case 3:

                    if (currentUser.getBookId().isEmpty())
                        System.out.printf("\n%s, you don't have any borrowed books right now\n", currentUser.getName());
                    else {
                        for (Integer b : currentUser.getBookId()) {
                            System.out.println(book.get(b));
                        }
                    }

                    break;


                // Show book availability
                case 4:
                    for (Book a : book)
                        System.out.println(a.getBook_id() + ". " + a.getTitle() + "\t\t| book availability: "+ tool.availability(a.getAmount()));
                    break;

                // Switch between users
                case 5:
                    System.out.println("\nChoose the user: ");
                    for (User u : user){
                        System.out.println(u.getId() + ".\t" + u.getName());
                    }

                    System.out.print("\tYour choice: ");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    currentUser = user.get(choice);
                    break;

                // Exit program
                case 6:
                    mainLoop = false;
                    break;
            }
        }

        scanner.close();
    }
}
