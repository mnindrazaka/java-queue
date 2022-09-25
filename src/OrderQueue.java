public class OrderQueue extends Queue<Order> {
    public OrderQueue(int size) {
        super(Order.class, size);
    }

    public void start(Order order) {
        super.enqueue(order);
    }

    public void finish() {
        if (isEmpty()) {
            System.out.println("Order is empty");
        } else {
            Order finishedOrder = super.dequeue();
            System.out.println("Finishing order with name : " + finishedOrder.getName());
        }
    }

    public Order[] getOrders() {
        return super.getQueue(Order.class);
    }

    public void printOrders() {
        if (isEmpty()) {
            System.out.println("Order is empty");
        } else {
            for (int i = 0; i < getOrders().length; i++) {
                Order currentOrder = getOrders()[i];
                System.out.println((i + 1) + ". " + currentOrder.getName() + " : Rp." + currentOrder.getTotal());
            }
        }
    }
}
