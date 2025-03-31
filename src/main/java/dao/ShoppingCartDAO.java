package dao;

import model.Book;
import model.ShoppingCart;

import java.io.*;
import java.util.*;

public class ShoppingCartDAO {
    private static final String FILE_PATH = "cart_data.txt";

    public static void saveCart(ShoppingCart cart) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(cart.getCartItems());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ShoppingCart loadCart() {
        ShoppingCart cart = new ShoppingCart();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            List<Book> cartItems = (List<Book>) ois.readObject();
            cartItems.forEach(cart::addBook);
        } catch (IOException | ClassNotFoundException e) {
            // File might not exist yet, return empty cart
        }
        return cart;
    }
}
