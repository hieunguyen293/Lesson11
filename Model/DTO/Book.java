package Lesson11.Model.DTO;

public class Book {

    int id;
    String name;
    int price;

    public Book(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public Book(String name, int price) {
        this.name = name;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
        @Override
    public String toString() {
        return "Book{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", price=" + price
                + '}';
    }

}
