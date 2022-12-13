import java.io.Serializable;
import java.util.Scanner;

public class ChuyenBay implements Serializable {
    public static Scanner sc=new Scanner(System.in);
    private String mamaybay;
    private String hangbay;
    private String matuyebay;
    private String thoigian;
    private String machuyenbay;
    private String ngaydi;
    private String di,den;
    private int ghephothong;
    private double giaghephothong;
    private int ghethuonggia;
    private double giaghethuonggia;
    public ChuyenBay(String hangbay,String machuyenbay,String matuyebay,String mamaybay,String thoigian,String ngaydi,String di,String den,int ghephothong,int ghethuonggia,double giaghephothong,double giaghethuonggia){
        this.hangbay=hangbay;
        this.machuyenbay=machuyenbay;
        this.matuyebay=matuyebay;
        this.mamaybay=mamaybay;
        this.thoigian=thoigian;
        this.ngaydi=ngaydi;
        this.di=di;
        this.den=den;
        this.ghephothong=ghephothong;
        this.ghethuonggia=ghethuonggia;
        this.giaghephothong=giaghephothong;
        this.giaghethuonggia=giaghethuonggia;
    }
    public ChuyenBay(){

    }

    public String getMamaybay() {
        return mamaybay;
    }

    public void setMamaybay(String mamaybay) {
        this.mamaybay = mamaybay;
    }

    public String getMachuyenbay() {
        return machuyenbay;
    }

    public void setMachuyenbay(String machuyenbay) {
        this.machuyenbay = machuyenbay;
    }
    public static Scanner getSc() {
        return sc;
    }

    public static void setSc(Scanner sc) {
        ChuyenBay.sc = sc;
    }

    public String getNgaydi() {
        return ngaydi;
    }

    public void setNgaydi(String ngaydi) {
        this.ngaydi = ngaydi;
    }
    public String getDi() {
        return di;
    }

    public void setDi(String di) {
        this.di = di;
    }

    public String getDen() {
        return den;
    }

    public void setDen(String den) {
        this.den = den;
    }

    public String getHangbay() {
        return hangbay;
    }

    public void setHangbay(String hangbay) {
        this.hangbay = hangbay;
    }

    public String getMatuyebay() {
        return matuyebay;
    }

    public void setMatuyebay(String matuyebay) {
        this.matuyebay = matuyebay;
    }

    public int getGhephothong() {
        return ghephothong;
    }

    public int getGhethuonggia() {
        return ghethuonggia;
    }

    public void setGhethuonggia(int ghethuonggia) {
        this.ghethuonggia = ghethuonggia;
    }

    public void setGhephothong(int ghephothong) {
        this.ghephothong = ghephothong;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public double getGiaghephothong() {
        return giaghephothong;
    }

    public void setGiaghephothong(double giaghephothong) {
        this.giaghephothong = giaghephothong;
    }

    public double getGiaghethuonggia() {
        return giaghethuonggia;
    }

    public void setGiaghethuonggia(double giaghethuonggia) {
        this.giaghethuonggia = giaghethuonggia;
    }
    public void input(){
        System.out.println("Nhập ngày đi: ");
        this.ngaydi=Check.checkDate();
        System.out.println("Nhập thời gian đi: ");
        this.thoigian=sc.nextLine();
        System.out.println("Nhập giá ghế phổ thông");
        this.giaghephothong=Check.CheckInputDouble();
        System.out.println("Nhập giá ghế thương gia");
        this.giaghethuonggia=Check.CheckInputDouble();
    }
    public void output() {
        System.out.printf("|%-22s|%-15s|%-13s|%-13s|%-13s|%-13s|%-13s|%-13s|%-15d|%-15d|%-15f|%-15f|\n",this.hangbay,this.matuyebay,this.machuyenbay,this.mamaybay,this.ngaydi,this.thoigian,this.di,this.den,this.ghephothong,this.ghethuonggia,this.giaghephothong,this.giaghethuonggia);
    }
}
