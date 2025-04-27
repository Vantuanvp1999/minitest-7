package controller;

import model.Order;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>();
    private LinkedList<String> ordersHistory = new LinkedList<>();
    public void add(Order order) {
        orders.add(order);
        ordersHistory.add("Add order "+order);
    }
    public void remove(String orderId) {
        for (Order o : orders) {
            if (o.getOrderId().equals(orderId)) {
                orders.remove(o);
            }
        }
        ordersHistory.remove("Remove order "+orderId);
    }
    public void displayAllOrders() {
        for (Order o : orders) {
            o.displayInfo();
        }
        ordersHistory.add("Display all orders");
    }
    public void displayRevenuedReport() {
        for (Order o : orders) {
            System.out.println("Order ID: "+o.getOrderId()+ "Total price: "+o.caculateTotalPrice());
        }
        ordersHistory.add("Display revenued report");
    }
    public void sortByOrderDate() {
        Collections.sort(orders);
        ordersHistory.add("Sort by order date");
    }
    public void sortByCustomerName() {
        Comparator byCustomerName = new Comparator<Order>() {
            public int compare(Order o1, Order o2) {
                return o1.getCustomerName().compareTo(o2.getCustomerName());
            }
        };
        Collections.sort(orders, byCustomerName);
        ordersHistory.add("Sort by customer name");
    }
    public void sortByTotalPrice() {
        Comparator byTotalPrice = new Comparator<Order>() {
            public int compare(Order o1, Order o2) {
                return (int) (o1.caculateTotalPrice() -o2.caculateTotalPrice());
            }
        };
        Collections.sort(orders, byTotalPrice);
        ordersHistory.add("Sort by total price");
    }
    public void printHistory() {
        for (String s : ordersHistory) {
            System.out.println(s);
        }
    }
    public void saveToFile(String fileName) {
        File file = new File(fileName);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(orders);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Order> loadFromFile(String fileName) {
        File file = new File(fileName);


        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            orders = (ArrayList<Order>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }

    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();

    }
}
