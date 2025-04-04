package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Order implements Serializable {
    private int id;
    private int userId;
    private int[] bookIds;
    private int quantity;
    private double totalPrice;
    private Date orderDate;

    public Order(int id, int userId, int bookId, int quantity, double totalPrice, Date orderDate) {
        this.id = id;
        this.userId = userId;
        this.bookIds = new int[]{bookId};
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    public Order(List<Integer> bookIds, String datum) {
    }


    public int getId() { return id; }
    public int getUserId() { return userId; }
    public int[] getBookId() { return bookIds; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return totalPrice; }
    public Date getOrderDate() { return orderDate; }
}
