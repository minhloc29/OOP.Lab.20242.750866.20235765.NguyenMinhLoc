public class TruongPhong extends Employee{
    private double phuCap;
    private int soNamDuongChuc;
    public TruongPhong() {
        super();
    }

    public TruongPhong(String name, double heSoLuong, double phuCap, int soNamDuongChuc) {
        super(name, heSoLuong);
        this.phuCap = phuCap;
        this.soNamDuongChuc = soNamDuongChuc;
    }

    public double tinhLuong(){
        return this.getLuongCoBan() * this.getHeSoLuong() + this.phuCap;
    }

    public void inTT(){
        System.out.println("Employee: ");
        System.out.printf("Name: %s\n", this.getName());
        System.out.printf("baseSalary: %.2f%n", this.getLuongCoBan());
        System.out.printf("maxSalary: %.2f%n", this.maxSalary);
        System.out.printf("heSoLuong: %.2f%n", this.getHeSoLuong());
        System.out.printf("Phu Cap: %.2f%n", this.phuCap);
        System.out.printf("So nam duong chuc: %d%n", this.soNamDuongChuc);
        double luong = this.tinhLuong();
        System.out.printf("Luong cua truong phong: %.2f%n", luong);
        System.out.println("");
        return;
    }
}
