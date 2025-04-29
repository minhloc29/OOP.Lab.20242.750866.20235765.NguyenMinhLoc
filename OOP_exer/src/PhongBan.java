import java.util.ArrayList;

public class PhongBan {
    private String tenPhongBan;
    private int soNhanVien;
    private ArrayList<Employee> danhSachNV;
    public static final int SO_NV_MAX = 100;

    public PhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
        this.soNhanVien = 0;
        this.danhSachNV = new ArrayList<>();

    }
    public boolean themNV(Employee nv){
        if(this.soNhanVien < SO_NV_MAX){
            this.soNhanVien++;
            danhSachNV.add(nv);
            return true;
        }
        return false;
    }

    public boolean xoaNV(Employee nv){
        if (this.soNhanVien > 0) {
            this.soNhanVien--;
            return danhSachNV.remove(nv);
        }
        return false;
    }
    public double tinhTongLuong() {
        double tong = 0;
        for (Employee nv : danhSachNV) {
            tong += nv.tinhLuong();
        }
        return tong;
    }
    public void inTT() {
        System.out.println("Tên phòng ban: " + tenPhongBan);
        System.out.println("Tổng lương phải trả: " + tinhTongLuong());
        System.out.println("Danh sách nhân viên:");
        for (Employee nv : danhSachNV) {
            nv.inTT();
        }
    }
}