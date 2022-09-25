public class OrderItem {
    private Product product;
    private int amount;


    public OrderItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public int getSubTotal() {
        return product.getPrice() * getAmount();
    }
}
