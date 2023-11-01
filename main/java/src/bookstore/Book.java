package bookstore;

public class Book {
    //Declare the private attributes for title, author, price, quantity
    private String title;
    private String author;
    private double price;
    private int quantity;

    // a constructor to initialize the private attributes above
    public Book (String title, String author, double price, int quantity){ // parameters = set the limitation within inside of ()
        this.title = title; // left side is connecting to 'private attribute "title"'. right side is connecting to parameter here
        this.author = author;
        this.price = price;
        this.quantity = quantity;
    }
    // insert Getter and Setter (short cut = Strg + Einfig)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) { // void means this method doesn't have a return value
        this.title = title;
    }

    // I want the method to return a value. So don't use 'void' and put the primitive data type, and use the return keyword inside the method
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString(){
        return "Title: " + title + " Author: " + author + " Price: $" + price + " Quantity: " + quantity;
    }
}
