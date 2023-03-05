import java.util.Scanner;

import order.Database;
import order.MenuItem;
import order.Order;

public class Main {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Order order = new Order();
        int choice;

        do {
            displayMenu();
            choice = getChoice();
            switch (choice) {
                case 1:
                    addMenuItem(order);
                    break;
                case 2:
                    displayOrder(order);
                    break;
                case 3:
                    saveOrder(order);
                    break;
                case 4:
                    System.out.println("Terima kasih telah menggunakan aplikasi kami!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
                    break;
            }
        } while (choice != 4);
    }

    private static void displayMenu() {
        System.out.println("=== Aplikasi Pemesanan Makanan ===");
        System.out.println("1. Tambah pesanan");
        System.out.println("2. Tampilkan pesanan");
        System.out.println("3. Simpan pesanan");
        System.out.println("4. Keluar");
        System.out.println("=================================");
    }

    private static int getChoice() {
        System.out.print("Masukkan pilihan Anda: ");
        return scanner.nextInt();
    }

    private static void addMenuItem(Order order) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nomor meja: ");
        int tableNumber = scanner.nextInt();
        
        System.out.print("Masukkan nama makanan: ");
        String name = scanner.next();
    
        System.out.print("Masukkan harga makanan: ");
        int price = scanner.nextInt();
    
        System.out.print("Masukkan jumlah pesanan: ");
        int quantity = scanner.nextInt();
    
        MenuItem item = new MenuItem(name, price);
        item.setQuantity(quantity);
        order.addItem(item);
        order.setTableNumber(tableNumber);
    
        System.out.println("Pesanan berhasil ditambahkan!");
        System.out.println();
    }
    

    private static void displayOrder(Order order) {
        if (order.getItems().isEmpty()) {
            System.out.println("Belum ada pesanan.");
        } else {
            System.out.println("Pesanan Anda:");
            System.out.println(order);
        }
        System.out.println();
    }

    private static void saveOrder(Order order) {
        Database.saveOrder(order);
    }
}
