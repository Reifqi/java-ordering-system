package order;
public class MenuItem {
    private String name;
    private int price;
    private int quantity = 1;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return String.format("%s x%d = Rp%d", name, quantity, getTotalPrice());
    }
}
