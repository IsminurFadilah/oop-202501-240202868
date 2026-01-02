package main.java.com.upb.agripos;

import main.java.com.upb.InvalidQuantityException;

public class MainCart {
    public static void main(String[] args) throws InvalidQuantityException, ProductNotFoundException {
        System.out.println("Hello, I am Ismi Nur Fadilah-240202868 (Week7)");

        Product p1 = new Product("P01", "Beras", 50000, 0);
        Product p2 = new Product("P02", "Pupuk", 30000, 0);
        Product p3 = new Product("P03", "Furadan", 35000, 0);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1, 0);
        cart.addProduct(p2, 0);
        cart.addProduct(p3, 0);
        cart.printCart();

        System.out.println("\nSetelah menghapus " + p1.getCode() + " " + p1.getName() + " dari keranjang:");
        cart.removeProduct(p1);
        cart.printCart();
    }
}