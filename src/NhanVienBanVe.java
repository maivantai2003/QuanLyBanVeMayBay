import java.io.Serializable;
import java.util.Scanner;

public class NhanVienBanVe extends NhanVien implements Serializable {
    public static Scanner sc=new Scanner(System.in);
    public static double Thuong=120;
    public NhanVienBanVe(){
        super();
    }
    public NhanVienBanVe(String ten, int tuoi, String gioitinh, String dc, String day, String masonhanvien,double luong,String password){
        super(ten, tuoi, gioitinh, dc, day, masonhanvien, luong,password);
    }
    @Override
    public void output() {
        super.output();
    }

    @Override
    public double tinhluong() {
        return this.getLuong()*Thuong;
    }
}

