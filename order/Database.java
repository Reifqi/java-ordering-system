package order;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Database {
    public static void saveOrder(Order order) {
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

