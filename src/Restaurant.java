public class Restaurant {
    private OrderQueue orderQueue;
    private Product[] products;

    public Restaurant(Product[] products, int orderQueueSize) {
        this.products = products;
        orderQueue = new OrderQueue(orderQueueSize);
    }

    public OrderQueue getOrderQueue() {
        return orderQueue;
    }

    public Product[] getProducts() {
        return products;
    }

    public Product getProductByOption(int option) {
        return products[option - 1];
    }

    public void printProducts() {
        System.out.println("Product list : ");
        for (int i = 0; i < getProducts().length; i++) {
            Product product = getProducts()[i];
            System.out.println((i + 1) + ". " + product.getName() + " : Rp." + product.getPrice());
        }
    }
}
