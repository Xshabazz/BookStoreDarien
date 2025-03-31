package model;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L; // Recommended for Serializable classes

    private int id;
    private String title;
    private String author;
    private String genre;
    private double price;
    private int available;

    public Book(int id, String title, String author, String genre, double price, int available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
        this.available = available;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public String getGenre(){
        return genre;
    }
    public int getId(){
        return id;
    }
    public double getPrice(){
        return price;
    }
    public int getAvailable(){
        return available;
    }
}
//heyy