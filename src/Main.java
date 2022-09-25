import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option;
        Scanner scan = new Scanner(System.in);
        Product[] products = new Product[]{
                new Product("Nasi goreng", 10000),
                new Product("Es teh", 3000)
        };
        Restaurant restaurant = new Restaurant(products, 5);


        do {
            System.out.println("=======================");
            System.out.println("Welcome to our restaurant");
            System.out.println("=======================");
            System.out.println("What do you want to do ?");
            System.out.println("1. Start order");
            System.out.println("2. Finish order");
            System.out.println("3. Show order queue");
            System.out.println("4. Exit");

            System.out.print("Please input your option : ");
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1 -> {
                    System.out.print("Please input customer name : ");
                    String name = scan.nextLine();
                    Order order = new Order(name);
                    String loop;
                    do {
                        restaurant.printProducts();

                        System.out.print("Input product option : ");
                        int productOption = scan.nextInt();

                        System.out.print("Input amount : ");
                        int amount = scan.nextInt();
                        scan.nextLine();

                        order.addItem(restaurant.getProductByOption(productOption), amount);

                        System.out.print("Do you want to add another item (y/n) ? ");
                        loop = scan.nextLine();
                    } while (loop.equalsIgnoreCase("y"));
                    restaurant.getOrderQueue().start(order);
                }
                case 2 -> {
                    restaurant.getOrderQueue().finish();
                    scan.nextLine();
                }
                case 3 -> {
                    restaurant.getOrderQueue().printOrders();
                    scan.nextLine();
                }
                case 4 -> System.out.println("Thank you");
                default -> System.out.println("Input invalid");
            }
        } while(option != 4);
    }
}