import java.io.Serializable;
import java.util.Scanner;
public abstract class NhanVien extends ConNguoi implements Serializable {
    public static Scanner sc=new Scanner(System.in);
    private String masonhanvien;
    private double luong;
    private String password;
    public NhanVien(){}
    public NhanVien(String ten, int tuoi, String gioitinh, String dc, String day, String masonhanvien,double luong,String password){
        super(ten, tuoi, gioitinh, dc, day);
        this.masonhanvien=masonhanvien;
        this.luong=luong;
        this.password=password;
    }
    public NhanVien(String masonhanvien){
        this.masonhanvien=masonhanvien;
    }
    public void setMasonhanvien(String masonhanvien){
        this.masonhanvien=masonhanvien;
    }
    public String getMasonhanvien(){
        return masonhanvien;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void input() {
        super.input();
        System.out.println("Nhập lương: ");
        this.luong=Check.CheckInput();
        System.out.println("Nhập password");
        this.password=sc.nextLine();
    }
    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public void output() {
        System.out.printf("|%-10s|%-20s|%-5d|%-20s|%-10s|%-10s|%-15f|%-20s|\n",this.getMasonhanvien(),this.getTen(),this.getTuoi(),this.getGioitinh(),this.getDc(),this.getDay(),this.tinhluong(),this.getPassword());
    }
    public abstract double tinhluong();
}
