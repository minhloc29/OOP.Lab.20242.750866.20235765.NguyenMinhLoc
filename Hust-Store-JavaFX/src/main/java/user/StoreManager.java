package user;

public class StoreManager extends User {

    public StoreManager(String userId, String name, String phoneNumber, String email) {
        super(userId, name, phoneNumber, email);
    }

    public StoreManager(String userId, String name, String phoneNumber, String email, String password) {
        super(userId, name, phoneNumber, email, password);
    }

    public double calculateDailyRevenue() {
        // Chưa biết cách code
        return 0;
    }

    public double calculateMonthlyRevenue(int month, int year) {
        // Tương tự trên
        return 0;
    }

}
