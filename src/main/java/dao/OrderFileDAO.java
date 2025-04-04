package dao;

import model.Order;
import java.io.*;
import java.util.*;

public class OrderFileDAO {

    private static final String ORDER_FILE = "orders.txt"; // File to store orders

    // Reads all orders from the file
    public static List<Order> getAllOrdersFromFile() {
        List<Order> orders = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ORDER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 3) {
                    List<Integer> bookIds = new ArrayList<>();
                    for (int i = 0; i < data.length - 1; i++) {
                        bookIds.add(Integer.parseInt(data[i]));
                    }
                    orders.add(new Order(bookIds, data[data.length - 1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return orders;
    }

    // Adds a new order to the file
    public static boolean addOrderToFile(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ORDER_FILE, true))) {
            StringBuilder line = new StringBuilder();
            for (Integer bookId : order.getBookId()) {
                line.append(bookId).append(",");
            }
            line.append(order.getUserId()); // Add username as a final part of the order
            writer.write(line.toString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
