package order;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;
    private int tableNumber;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getTotal() {
        int total = 0;
        for (MenuItem item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }

    //Membuat string dari objek order
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Meja %d\n", tableNumber));
        for (MenuItem item : items) {
            sb.append(String.format("%s x%d (%d)\n", item.getName(), item.getQuantity(), item.getPrice()));
        }
        sb.append(String.format("Total: %d", getTotal()));
        return sb.toString();
    }
}
