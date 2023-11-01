package scanner_input;
import bookstore.Inventory;
import bookstore.Book;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory(3);


        while (true) {
            System.out.println("Options:");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. Search for a book");
            System.out.println("4. Calculate total value");
            System.out.println("5. Display inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                String choiceInput = input.nextLine(); // the user enter the number of their choice
                int choice = Integer.parseInt(choiceInput);

                switch (choice) {
                    case 1: // add a book inventory information
                        System.out.println("Enter the title of the book: ");
                        String title = input.nextLine();

                        System.out.println("Enter the author of the book: ");
                        String author = input.nextLine();

                        System.out.println("Enter the price of the book: ");
                        String priceInfo = input.nextLine();
                        double price = Double.parseDouble(priceInfo);

                        System.out.println("Enter the quantity of the book: ");
                        String quantityInfo = input.nextLine();
                        int quantity = Integer.parseInt(quantityInfo);

                        inventory.addBook(title, author, price, (int) quantity);
                        break;

                    case 2:
                        System.out.println("Enter the title of the book to remove: ");
                        String bookToRemove = input.nextLine();
                        inventory.removeBook(bookToRemove);
                        break;

                    case 3:
                        System.out.println("Enter the title or author to search for: ");
                        String query = input.nextLine();
                        Book foundBook = inventory.searchBook(query);
                        if (foundBook != null) {
                            System.out.println("Found Book: " + foundBook);
                        } else {
                            System.out.println("Book not found.");
                        }
                        break;

                    case 4:
                        double totalValue = inventory.calculateTotalValue();
                        System.out.println("Total Value: $" + totalValue);
                        break;

                    case 5:
                        inventory.displayInventory();
                        break;

                    case 6:
                        System.out.println("Exiting the program.");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        break;
                }
            } catch (NumberFormatException e) { // the user enter the alphabet or the number with invalid format
                System.out.println("Please enter the number with valid format, or valid information. Try from the beginning.");
            }
        }
    }
}