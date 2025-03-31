package model;
import java.util.*;

public class ShoppingCart {
    private List<Book> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }

    public void addBook(Book book) {
        cartItems.add(book);
    }

    public void removeBook(Book book) {
        cartItems.remove(book);
    }

    public List<Book> getCartItems() {
        return cartItems;
    }

    public double getTotalPrice() {
        return cartItems.stream().mapToDouble(Book::getPrice).sum();
    }

    public void clearCart() {
        cartItems.clear();
    }
}
