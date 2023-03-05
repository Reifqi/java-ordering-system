package order;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MenuManagementImpl implements MenuManagement {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void addMenuItem(Order order) {
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

    @Override
    public void displayOrder(Order order) {
        if (order.getItems().isEmpty()) {
            System.out.println("Belum ada pesanan.");
        } else {
            System.out.println("Pesanan Anda:");
            System.out.println(order);
        }
        System.out.println();
    }

    @Override
    public void saveOrder(Order order) {
        try {
            File file = new File("./db/order.txt");
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(order);
            printWriter.close();
            System.out.println("Pesanan berhasil disimpan di file order.txt");
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan file.");
        }
        System.out.println();
    }
}
