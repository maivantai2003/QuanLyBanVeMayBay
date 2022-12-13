import java.io.Serializable;
import java.util.Scanner;

public class ConNguoi implements Serializable {
    private String ten;
    private int tuoi;
    private String gioitinh;
    private String dc;
    private String day;
    public static Scanner sc = new Scanner(System.in);
    public ConNguoi(){
    }
    public ConNguoi(String ten, int tuoi, String gioitin){
        this.ten=ten;
        this.tuoi=tuoi;
        this.gioitinh=gioitin;
    }
    public ConNguoi(String ten, int tuoi, String gioitinh,String dc, String day){
        this.ten=ten;
        this.tuoi=tuoi;
        this.gioitinh=gioitinh;
        this.dc=dc;
        this.day=day;
    }
    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void input(){
        System.out.println("Nhập tên: ");
        ten=sc.nextLine();
        System.out.println("Nhập tuổi: ");
        tuoi=Check.CheckInput();
        System.out.println("Nhập giới tính: ");
        gioitinh=sc.nextLine();
        System.out.println("Nhập địa chỉ: ");
        dc=sc.nextLine();
        System.out.println("Nhập ngày sinh: ");
        day=Check.checkDate();
    }
    public void output(){
        System.out.println("Tên: " + ten);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Giới tính: " + gioitinh);
        System.out.println("Địa chỉ: "+dc);
        System.out.println("Ngày sinh: "+day);
    }

}

