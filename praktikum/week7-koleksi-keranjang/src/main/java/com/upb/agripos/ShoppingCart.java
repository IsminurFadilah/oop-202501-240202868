package main.java.com.upb.agripos;

import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    // Method addProduct menerima SATU parameter: Product
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Produk ditambahkan: " + product.toString());
    }

    public void removeProduct(Product product) {
        if (products.remove(product)) {
            System.out.println("Produk dihapus: " + product.toString());
        } else {
            System.out.println("Produk tidak ditemukan dalam keranjang");
        }
    }

    // Method printCart TANPA parameter
    public void printCart() {
        System.out.println("\n========== ISI KERANJANG ==========");
        if (products.isEmpty()) {
            System.out.println("Keranjang kosong");
        } else {
            int total = 0;
            for (int i = 0; i < products.size(); i++) {
                Product p = products.get(i);
                System.out.println((i + 1) + ". " + p.toString());
                total += p.getPrice();
            }
            System.out.println("===================================");
            System.out.println("Total: Rp " + total);
        }
        System.out.println("===================================\n");
    }

    public int getTotalPrice() {
        int total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public int getProductCount() {
        return products.size();
    }
}