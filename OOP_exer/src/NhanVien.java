public class NhanVien {
    private String name;
    private double baseSalary;
    public static final double maxSalary = 2.0E7;
    private double heSoLuong;

    public NhanVien() {
        this.name = "NONAME";
        this.heSoLuong = 1.0;
    }

    public NhanVien(String var1, double var2) {
        this.name = var1;
        this.heSoLuong = var2;
    }

    public double tinhLuong() {
        return this.baseSalary * this.heSoLuong;
    }

    public boolean tanghesoluong(double var1) {
        double var3 = this.heSoLuong + var1;
        double var5 = this.baseSalary * (var3 / this.heSoLuong);
        if (var5 > maxSalary) {
            System.out.println("Invalid salary increase.");
            return false;
        } else {
            this.heSoLuong = var3;
            System.out.println("Valid increase.");
            return true;
        }
    }

    public void inTT() {
        System.out.println("NhanVien: ");
        System.out.printf("Name: %s\n", this.name);
        System.out.printf("baseSalary: %.2f%n", this.baseSalary);
        System.out.printf("maxSalary: %.2f%n", maxSalary);
        System.out.printf("heSoLuong: %.2f%n", this.heSoLuong);
        double var1 = this.tinhLuong();
        System.out.printf("Luong cua nhan vien: %.2f%n", var1);
        System.out.println("");
    }

    public void setTenNhanVien(String var1) {
        this.name = var1;
    }

    public String getTenNhanVien() {
        return this.name;
    }

    public void setLuongCoBan(double var1) {
        if (var1 <= 0.0) {
            throw new IllegalArgumentException("Base salary must be greater than zero");
        } else {
            this.baseSalary = var1;
        }
    }

    public double getLuongCoBan() {
        return this.baseSalary;
    }

    public void setHeSoLuong(double var1) {
        if (var1 <= 0.0) {
            throw new IllegalArgumentException("He so luong must be greater than zero");
        } else {
            this.heSoLuong = var1;
        }
    }

    public double getHeSoLuong() {
        return this.heSoLuong;
    }

    public String getName() {
        return this.name;
    }
}
