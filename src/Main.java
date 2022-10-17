import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("\tMENU\t");
        System.out.println("Choose one option 1 - 4");
        System.out.println("1. Borrow the book\n2. Return the book to library\n3. Check borrowed books\n4. Check book availability");
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n Your choice: ");
        int choice = scanner.nextInt();
        scanner.close();

        switch(choice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }


    }
}