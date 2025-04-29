public class Giamdoc extends Employee implements QuanLy{
    private double phuCap;
    private double loiNhuanCongTy;

    public Giamdoc(String name, double heSoLuong, double phuCap, double loiNhuanCongTy) {
        super(name, heSoLuong);
        this.phuCap = phuCap;
        this.loiNhuanCongTy = loiNhuanCongTy;
    }
    public double tinhHoaHong() {
        return loiNhuanCongTy * 0.05;
    }

    public double tinhLuong() {
        return this.getLuongCoBan() + this.getHeSoLuong() + phuCap + this.tinhHoaHong();
    }

    public void inTT(){
        System.out.println("Employee: ");
        System.out.printf("Name: %s\n", this.getTenNhanVien());
        System.out.printf("baseSalary: %.2f%n", this.getLuongCoBan());
        System.out.printf("maxSalary: %.2f%n", this.maxSalary);
        System.out.printf("heSoLuong: %.2f%n", this.getHeSoLuong());
        double luong = this.tinhLuong();
        System.out.printf("Luong cua nhan vien: %.2f%n", luong);
        System.out.println("");
        return;
    }
}
