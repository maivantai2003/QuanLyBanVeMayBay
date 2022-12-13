import java.io.Serializable;
import java.util.Scanner;
public class HoaDon implements Serializable {
    public static Scanner sc = new Scanner(System.in);
    private String mahoadon;
    private String manv;
    private String makhachhang;
    private String maphieudatcho;
    private String ngay;
    private double tongtien;
    public HoaDon() {}
    public HoaDon(String mahoadon,String manv,String makhachhang,String maphieudatcho,String ngay,double tongtien) {
        this.mahoadon = mahoadon;
        this.manv = manv;
        this.makhachhang=makhachhang;
        this.ngay = ngay;
        this.tongtien=tongtien;
        this.maphieudatcho=maphieudatcho;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getMahoadon() {
        return mahoadon;
    }
    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }
    public String getManv() {
        return manv;
    }
    public void setManv(String manv) {
        this.manv = manv;
    }
    public String getMaphieudatcho() {
        return maphieudatcho;
    }
    public void setMaphieudatcho(String maphieudatcho) {
        this.maphieudatcho = maphieudatcho;
    }
    public void output(){
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-20f|%-20s|\n",this.mahoadon,this.manv,this.makhachhang,this.ngay,this.tongtien,this.maphieudatcho);
    }
}
