package hust.soict.hedspi.hustbookstore;

import user.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum OrderStatus {
    PENDING,
    COMPLETED,
    CANCELLED
}

public class Order {
    private String orderId;
    private Customer customer;
    private Date dateTime;
    private List<OrderItem> orderItems = new ArrayList<>();
    private double totalAmount;
    private String paymentType;
    private int linkedInvoice;
    private String orderStatus;
    //private OrderStatus orderStatus;

    public Order() {
    }

    public Order(Customer customer) {
        this.customer = customer;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setLinkedInvoice(int linkedInvoice) {
        this.linkedInvoice = linkedInvoice;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.calculateTotalPrice();
        }
        return totalPrice;
    }


    public void processPayment() {
        // Phương thức này có chức năng gì???
        // if(screen.customer.payByCash()) ?
    }

    public void completeOrder() {
        StringBuilder strOrderItems = new StringBuilder();
        for (OrderItem orderItem : orderItems) {
            strOrderItems
                    .append("Product ID: ")
                    .append(orderItem.getProduct().getId())
                    .append("\nProduct Name: ")
                    .append(orderItem.getProduct().getName())
                    .append("\nQuantity: ")
                    .append(orderItem.getQuantity())
                    .append("\nPrice: ")
                    .append(orderItem.getUnitPrice())
                    .append("\nTotal Price: ")
                    .append(orderItem.calculateTotalPrice());
            orderItem.getProduct().decreaseStock(orderItem.getQuantity());
        }

        String str = "Order ID: " + this.orderId
                + "\nCustomerID: " + this.customer.getUserId()
                + "\nOrder Date: " + this.dateTime
                + "\nOrder Items: " + "\n" + strOrderItems.toString()
                + "\nTotal Amount: " + this.totalAmount
                + "\nPayment Type: " + this.paymentType
                + "\nLinked Invoice: " + this.linkedInvoice
                + "\nOrder Status: " + this.orderStatus;

        this.orderStatus = "Completed";
    }


}
