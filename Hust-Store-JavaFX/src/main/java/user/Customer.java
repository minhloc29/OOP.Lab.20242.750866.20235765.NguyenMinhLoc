package user;

public class Customer extends User {
    public Customer() {
    }

    public Customer(String userId, String name, String phoneNumber, String email) {
        super(userId, name, phoneNumber, email);
    }

    public Customer(String userId, String name, String phoneNumber, String email, String password) {
        super(userId, name, phoneNumber, email, password);
    }

    public boolean payByCash(double amount) {
        // Nên làm như thế nào?
        // Nếu tham chiếu đến Order và duyệt xem Customer đặt hàng với Order nào thì
        // cần có một List<Order> và duyệt xem Order nào có thông tin của
        // Customer này thì mới có thể lấy ra được số tiền cần trả
        // trong Order là Order.calculateTotalPrice() và
        // so sánh với amount xem đã trả đủ tiền chưa
        return true;
    }

    public boolean payByCard(String cardNumber, String expiryDate, String cvv) {
        // Tương tự payByCash
        return true;
    }
}
