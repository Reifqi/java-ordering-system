import java.util.Scanner;

import order.MenuManagement;
import order.MenuManagementImpl;
import order.Order;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Order order = new Order();
        MenuManagement menuManagement = new MenuManagementImpl();
        int choice;

        do {
            displayMenu();
            choice = getChoice();
            switch (choice) {
                case 1:
                    menuManagement.addMenuItem(order);
                    break;
                case 2:
                    menuManagement.displayOrder(order);
                    break;
                case 3:
                    menuManagement.saveOrder(order);
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
}
