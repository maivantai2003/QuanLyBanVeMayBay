import java.io.Serializable;
public class NhanVienQuanLi extends NhanVien implements Serializable {
    public static double Thuong=200;
    public NhanVienQuanLi(){
        super();
    }
    public NhanVienQuanLi(String ten, int tuoi, String gioitinh, String dc, String day, String masonhanvien,double luong,String password){
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
