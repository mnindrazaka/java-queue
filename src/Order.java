import java.util.ArrayList;

public class Order {
    private ArrayList<OrderItem> items;
    private String name;

    public Order(String name) {
        this.name = name;
        items = new ArrayList<>();
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getSubTotal();
        }
        return total;
    }

    public String getName() {
        return name;
    }

    public ArrayList<OrderItem> getItems() {
        return items;
    }

    public void addItem(Product product, int amount) {
        items.add(new OrderItem(product, amount));
    }
}
