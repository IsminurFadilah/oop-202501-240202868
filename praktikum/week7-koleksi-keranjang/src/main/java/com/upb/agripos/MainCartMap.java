package main.java.com.upb.agripos;

public class MainCartMap {
    public static void main(String[] args) {
        System.out.println("Ismi Nur Fadilah -240202868 (Week7)");

        Product p1 = new Product("P01", "Beras", 50000, 0);
        Product p2 = new Product("P02", "Pupuk", 30000, 0);
        Product p3 = new Product("P03", "Insektisida", 150000, 0);

        ShoppingCartMap cart = new ShoppingCartMap();
        cart.addProduct(p1);
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p2);
        cart.addProduct(p3);
        cart.printCart();

        System.out.println("\nSetelah menghapus " + p1.getCode() + " " + p1.getName() + " dari keranjang:");
        
        cart.removeProduct(p1);
        cart.printCart();
    }
}