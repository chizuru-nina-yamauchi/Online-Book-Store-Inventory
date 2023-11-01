package bookstore;

public class Inventory {
    private final Book[] books;
    private int bookCount; // Keep track of the number of books in the inventory

    public Inventory(int capacity) {
        books = new Book[(int) capacity];// capacity is "capacity of the array"
        bookCount = 0; // Initialize the size to 0
    }

    /* Example of how books array works: In this case, books.length is 2.
    //books.length =  the number of elements (or slots) that the books array can hold
    Book[] books = new Book[2];  // Create an array to store Book objects

   // The user enters information for the first book
    books[0] = new Book("1Q84", "Haruki Murakami", 23.0, 30);

    // The user enters information for the second book
    books[1] = new Book("Harry Potter", "J.K. Rowling", 18.0, 45);

    //two Book objects, one at index 0 and the other at index 1

     */
    public void addBook(String title, String author, double price, int quantity) {
        // Check if the inventory is full
        if (bookCount >= books.length) {
            System.out.println("Inventory is full. Cannot add more books.");
            return; // Exit the method
        }

        // Check for duplicate books based on title and author
        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && books[i].getTitle().equals(title) && books[i].getAuthor().equals(author)) {
                // Update the quantity of the existing book
                Book existingBook = books[i];
                existingBook.setQuantity((int) (existingBook.getQuantity() + quantity));
                return; // Exit the method after updating the quantity
            }
        }

        // If it's not a duplicate and there's space in the inventory, add the book
        Book book = new Book(title, author, price, quantity);
        books[bookCount] = book;
        bookCount++;
    }

    public void removeBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && books[i].getTitle().equals(title)) {
                // Shift the remaining books to fill the gap
                for (int j = i; j < bookCount - 1; j++) {
                    books[j] = books[j + 1];
                }
                books[bookCount - 1] = null; // Clear the last slot
                bookCount--;
                break;
            }
        }
    }
    public void displayInventory() {
        System.out.println("Current Inventory:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }
    }
    public Book searchBook(String query) {
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if (book != null && (book.getTitle().equalsIgnoreCase(query) || book.getAuthor().equalsIgnoreCase(query))) {
                return book;
            }
        }
        return null; // Book not found
    }
    public double calculateTotalValue() {
        double totalValue = 0.0;
        for (int i = 0; i < bookCount; i++) {
            Book book = books[i];
            if (book != null) {
                totalValue += book.getPrice() * book.getQuantity();
            }
        }
        return totalValue;
    }
}
