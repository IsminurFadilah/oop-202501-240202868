package main.java.com.upb.agripos;

public class Product {
    private String code;
    private String name;
    private int price;

    // Constructor dengan 3 parameter: String, String, int
    public Product(String code, String name, int price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return code + " - " + name + " (Rp " + price + ")";
    }
}