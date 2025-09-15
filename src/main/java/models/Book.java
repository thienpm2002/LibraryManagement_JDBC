package models;

public class Book {
    private int id;
    private String name;
    private String author;
    private int stock;
    private String category;

    public Book(String name, String author, int stock, String category) {
        this.name = name;
        this.author = author;
        this.stock = stock;
        this.category = category;
    }

    public Book(int id, String name, String author, int stock, String category) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.stock = stock;
        this.category = category;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
