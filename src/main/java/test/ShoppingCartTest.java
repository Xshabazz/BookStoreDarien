package test;
import model.Book;
import model.ShoppingCart;
import dao.ShoppingCartDAO;

public class ShoppingCartTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Test 1: Add Books
        Book book1 = new Book(1, "Java Basics", "John Doe", "Programming", 39.99, 0);
        Book book2 = new Book(2, "Advanced Java", "Jane Smith", "Programming", 49.99, 1);
        cart.addBook(book1);
        cart.addBook(book2);
        System.out.println("Test 1: Add Books");
        System.out.println("Cart Contents: " + cart.getCartItems().size() + " items.");

        // Test 2: Remove Book
        cart.removeBook(book1);
        System.out.println("\nTest 2: Remove Book");
        System.out.println("Cart Contents: " + cart.getCartItems().size() + " items.");

        // Test 3: Get Total Price
        System.out.println("\nTest 3: Get Total Price");
        System.out.println("Total Price: $" + cart.getTotalPrice());

        // Test 4: Save & Load Cart
        ShoppingCartDAO.saveCart(cart);
        ShoppingCart loadedCart = ShoppingCartDAO.loadCart();
        System.out.println("\nTest 4: Save & Load Cart");
        System.out.println("Loaded Cart Items: " + loadedCart.getCartItems().size());

        // Test 5: Clear Cart
        cart.clearCart();
        System.out.println("\nTest 5: Clear Cart");
        System.out.println("Cart Contents After Clear: " + cart.getCartItems().size() + " items.");
    }
}
