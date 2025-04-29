import java.lang.IllegalArgumentException;

public class Employee { // convention name is uppercase first
    private String name;
    private double baseSalary;
    public static final double maxSalary = 20000000; // final is the value can not be change
    private double heSoLuong;

    public Employee() { // default constructor
        this.name = "NONAME";
        this.heSoLuong = 1;
    }

    public Employee(String name, double heSoLuong) { // default constructor
        this.name = name;
        this.heSoLuong = heSoLuong;
    }

    public double tinhLuong() {
        return baseSalary * this.heSoLuong;
    }

    public boolean tanghesoluong(double delta) {
        double heSoMoi = this.heSoLuong + delta;
        double newSalary = this.baseSalary * (heSoMoi / this.heSoLuong);
        if (newSalary > maxSalary) {
            System.out.println("Invalid salary increase.");
            return false;
        } else {
            this.heSoLuong = heSoMoi;
            System.out.println("Valid increase.");
            return true;
        }
    }

    public void inTT() {
        System.out.println("Employee: ");
        System.out.printf("Name: %s\n", this.name);
        System.out.printf("baseSalary: %.2f%n", this.baseSalary);
        System.out.printf("maxSalary: %.2f%n", this.maxSalary);
        System.out.printf("heSoLuong: %.2f%n", this.heSoLuong);
        double luong = this.tinhLuong();
        System.out.printf("Luong cua nhan vien: %.2f%n", luong);
        System.out.println("");
        return;
    }

    public void setTenNhanVien(String name) {
        this.name = name;
    }

    public String getTenNhanVien() {
        return this.name;
    }

    public void setLuongCoBan(double baseSalary) {
        if (baseSalary <= 0) {
            throw new IllegalArgumentException("Base salary must be greater than zero");
        }
        this.baseSalary = baseSalary;
    }

    public double getLuongCoBan() {
        return this.baseSalary;
    }

    public void setHeSoLuong(double heSoLuong) {
        if (heSoLuong <= 0) {
            throw new IllegalArgumentException("He so luong must be greater than zero");
        }
        this.heSoLuong = heSoLuong;
    }

    public double getHeSoLuong() {
        return this.heSoLuong;
    }

    public String getName() {
        return this.name;
    }
}