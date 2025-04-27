package model;

public class ClothingOrder extends Order {
    private double basePrice;
    private String size;

    public ClothingOrder() {
    }

    public ClothingOrder(String orderId, String customerName, int orderDate, double basePrice, String size) {
        super(orderId, customerName, orderDate);
        this.basePrice = basePrice;
        this.size = size;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public void displayInfo() {
        System.out.println("Order ID: " + getOrderId()+ "customer name: " + getCustomerName()+ "order date: " + getOrderDate()+ "basePrice: " + basePrice+ "size: " + size);
    }

    @Override
    public double caculateTotalPrice() {
        if(size == "XL"|| size == "L"){
            return basePrice*1.1;
        }else {
            return basePrice;
        }
    }
}
