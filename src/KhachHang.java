import java.io.Serializable;
import java.util.Scanner;

public class KhachHang extends ConNguoi implements Serializable {
    public static Scanner sc=new Scanner(System.in);
    private int CCCD;
    private String gmail;
    private int sdt;
    private String makhachhang;
    public KhachHang(){

    }
    public KhachHang(String ten, int tuoi, String gioitinh, String dc, String day, int CCCD, String gmail, int sdt,String makhachhang){
        super(ten, tuoi, gioitinh, dc, day);
        this.CCCD=CCCD;
        this.gmail=gmail;
        this.sdt=sdt;
        this.makhachhang=makhachhang;
    }

    public int getCCCD() {
        return CCCD;
    }
    public void setCCCD(int CCCD) {
        this.CCCD = CCCD;
    }

    public String getGmail() {
        return gmail;
    }
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
    public String getMakhachhang() {
        return makhachhang;
    }
    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public int getSdt() {
        return sdt;
    }
    public void setSdt(int sdt) {
        this.sdt = sdt;
    }
    public void input(){
        super.input();
        System.out.println("Nhap CCCD: ");
        CCCD=Check.CheckInput();
        System.out.println("Nhap Gmail: ");
        gmail=Check.CheckInputGmail();
        System.out.println("Nhập số điện thoại: ");
        sdt=Check.CheckInput();
    }
    public void output(){
      System.out.printf("|%-10s|%-18s|%-10d|%-10s|%-12s|%-12s|%-12d|%-20s|%-12d|\n",this.getMakhachhang(),this.getTen(),this.getTuoi(),this.getGioitinh(),this.getDc(),this.getDay(),this.getCCCD(),this.getGmail(),this.getSdt());
    }
}


