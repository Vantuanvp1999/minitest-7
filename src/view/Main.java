package view;

import controller.OrderManager;
import model.ClothingOrder;
import model.ElectronicsOrder;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        OrderManager orderManager = new OrderManager();
        orderManager.add(new ElectronicsOrder("E01", "Tuan",20190506,1500,12));
        orderManager.add(new ElectronicsOrder("E02", "Tuan",20200408,1200,10));
        orderManager.add(new ClothingOrder("C01","Ha",20210401,1600,"M"));
        orderManager.add(new ClothingOrder("C02","Ha",20241127,1300,"XL"));
        do {
            System.out.println("1. Add new order");
            System.out.println("2. Remove order");
            System.out.println("3. Display all order");
            System.out.println("4. Display revenue report");
            System.out.println("5. Sort by order date");
            System.out.println("6. Sort by customer name");
            System.out.println("7. Sort by total price");
            System.out.println("8. Print history");
            System.out.println("9. Save to file");
            System.out.println("10. Load from file");
            System.out.println("0. Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addOrder(sc, orderManager);
                    break;
                case 2:
                    System.out.println("Enter the order ID");
                    String orderID = sc.next();
                    orderManager.remove(orderID);
                    break;
                case 3:
                    orderManager.displayAllOrders();
                    break;
                case 4:
                    orderManager.displayRevenuedReport();
                    break;
                case 5:
                    orderManager.sortByOrderDate();
                    break;
                    case 6:
                        orderManager.sortByCustomerName();
                        break;
                        case 7:
                            orderManager.sortByTotalPrice();
                            break;
                            case 8:
                                orderManager.printHistory();
                                break;
                                case 9:
                                    orderManager.saveToFile("D:\\Module 2\\Minitest7\\src\\storage\\demo");
                                    break;
                                    case 10:
                                        orderManager.loadFromFile("D:\\Module 2\\Minitest7\\src\\storage\\demo");
                                        break;
                                        case 0:
                                            System.out.println("Goodbye");
            }
        }while (choice != 0);
    }

    private static void addOrder(Scanner sc, OrderManager orderManager) {
        int vehicleType;
        do {
            System.out.println("Choose order type");
            System.out.println("1. Electronics order");
            System.out.println("1. Clothing order");
            System.out.println("0. Exit");
            vehicleType = sc.nextInt();
            switch (vehicleType) {
                case 1:
                    System.out.println("Enter order ID");
                    String orderID = sc.next();
                    System.out.println("Enter customer name");
                    String customerName = sc.next();
                    System.out.println("Enter order date");
                    int orderDate = sc.nextInt();
                    System.out.println("Enter item price");
                    double itemPrice = sc.nextDouble();
                    System.out.println("Enter warranty months");
                    int warrantyMonths = sc.nextInt();
                    orderManager.add(new ElectronicsOrder(orderID,customerName,orderDate,itemPrice,warrantyMonths));
                    break;
                    case 2:
                        System.out.println("Enter order ID");
                        String orderID1 = sc.next();
                        System.out.println("Enter customer name");
                        String customerName1 = sc.next();
                        System.out.println("Enter order date");
                        int orderDate1 = sc.nextInt();
            System.out.println("Enter base price");
            double basePrice1 = sc.nextDouble();
            System.out.println("Enter size");
            String size1 = sc.next();
            orderManager.add(new ClothingOrder(orderID1,customerName1,orderDate1,basePrice1,size1));
            break;
        case 0:
            System.out.println("Exit");
    }
}while (vehicleType != 0);
    }
}