import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachHoaDon implements ChucNang,reSize, Serializable {
    public static Scanner sc=new Scanner(System.in);
    private HoaDon[] hoadon;
    private int n;
    public DanhSachHoaDon(){
        this.n=0;
        this.hoadon=new HoaDon[n];
    }
    public HoaDon[] getHoadon() {
        return hoadon;
    }

    public void setHoadon(HoaDon[] hoadon) {
        this.hoadon = hoadon;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public DanhSachHoaDon(HoaDon[] hoadon, int n){
        this.n=n;
        this.hoadon=new HoaDon[this.n];
    }
    @Override
    public void Search() {
        System.out.println("enter ma hóa đơn cần tìm");
        String mahoadon=sc.nextLine();
        if(SeachMaHoaDOn(mahoadon)!=-1){
            System.out.printf("-----------------------------------------------------------------------------------------------------------\n");
            System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-20s|%-20s|\n","MãHóaĐơn","MãNhânViên","MãKháchHàng","Ngày","TổngTiền","MãPhiếuĐặtChỗ");
            System.out.printf("-----------------------------------------------------------------------------------------------------------\n");
            hoadon[SeachMaHoaDOn(mahoadon)].output();
        }else{
            System.out.println("Không Tìm Thấy Hóa Đơn");
        }
    }
    @Override
    public void Delete() {
        System.out.println("enter mã hóa đơn cần xóa: ");
        String mahoadon=sc.nextLine();
        if(SeachMaHoaDOn(mahoadon)==-1){
            System.out.println("Không tồn tại hóa đơn");
        }else{
            for(int i=SeachMaHoaDOn(mahoadon);i<hoadon.length-1;i++){
                hoadon[i]=hoadon[i+1];
            }
            hoadon[this.hoadon.length-1]=null;
            setSize(-1);
        }
    }
    public int SeachMaHoaDOn(String mahoadon){
        for(int i=0;i<hoadon.length;i++){
            if(hoadon[i].getMahoadon().compareTo(mahoadon)==0){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void setSize(int size) {
        this.hoadon= Arrays.copyOf(this.hoadon,this.hoadon.length+size);
        this.n+=size;
    }
    public void input(DanhSachKhachHang khachHang,DanhSachNhanVien nhanVien,DanhSachPhieuDatCho phieuDatCho){
        int lc;
        while (true){
            System.out.println("1. Nhập Hóa Đơn");
            System.out.println("2. Thoát");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    HoaDon hd=new HoaDon();
                    hd.setMahoadon("HD"+(hoadon.length+1));
                    String mave,makhachhang,manhanvien,madatcho,day;
                    while (true){
                        System.out.println("enter nhân viên bán vé: ");
                        manhanvien=sc.nextLine();
                        if(nhanVien.SearchIndexNhanVien(manhanvien)!=-1){
                            hd.setManv(manhanvien);
                            break;
                        }else{
                            System.out.println("enter again");
                        }
                    }
                    while (true){
                        System.out.println("enter mã Phiếu Đặt Chỗ");
                        madatcho=sc.nextLine();
                        if(phieuDatCho.SeachIndex(madatcho)!=-1){
                            hd.setMaphieudatcho(madatcho);
                            hd.setMakhachhang(phieuDatCho.getPhieudatcho().get(phieuDatCho.SeachIndex(madatcho)).getMakhachhang());
                            hd.setTongtien(phieuDatCho.getPhieudatcho().get(phieuDatCho.SeachIndex(madatcho)).getGia());
                            break;
                        }else{
                            System.out.println("enter again");
                        }
                    }
                    System.out.println("enter ngày xuất hóa đơn");
                    day=sc.nextLine();
                    hd.setNgay(day);
                    addHoaDon(hd);
                    break;
                case 2:
                    return;
            }
        }
    }
    public void output(){
        System.out.printf("-----------------------------------------------------------------------------------------------------------\n");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-20s|%-20s|\n","MãHóaĐơn","MãNhânViên","MãKháchHàng","Ngày","TổngTiền","MãPhiếuĐặtChỗ");
        System.out.printf("-----------------------------------------------------------------------------------------------------------\n");
        for(int i=0;i<hoadon.length;i++){
            hoadon[i].output();
            System.out.printf("-----------------------------------------------------------------------------------------------------------\n");
        }
    }
    public void addHoaDon(HoaDon hoaDon){
        setSize(1);
        hoadon[hoadon.length-1]=hoaDon;
    }
    public void editHoaDon(){
        int lc;
        System.out.println("enter mã hóa đơn cần sửa: ");
        String mahoadon=sc.nextLine();
        if(SeachMaHoaDOn(mahoadon)!=-1){
            do{
                System.out.println("1. Sửa Ngày Xuất Hóa Đơn");
                System.out.println("2. Sửa Giá Hóa Đơn");
                System.out.println("3. Thoát");
                System.out.println("enter lc");
                lc=Check.CheckInput();
                switch (lc){
                    case 1:
                        hoadon[SeachMaHoaDOn(mahoadon)].setNgay(Check.checkDate());
                        break;
                    case 2:
                        hoadon[SeachMaHoaDOn(mahoadon)].setTongtien(Check.CheckInputDouble());
                        break;
                }
            }while (lc!=3);
        }
    }
    public void thongke(){
        double s=0;
        for(HoaDon i:hoadon){
            s+=i.getTongtien();
        }
        System.out.println("Tổng Doanh Thu Bán Vé: "+s);
    }
    public void MenuHoaDon(DanhSachKhachHang khachHang,DanhSachNhanVien nhanVien,DanhSachPhieuDatCho phieuDatCho){
        int lc=0;
        do{
            System.out.println("1.Xem Hóa Đơn");
            System.out.println("2. Tìm Kiếm Hóa Đơn");
            System.out.println("3. Thêm Hóa Đơn");
            System.out.println("4. Xóa Hóa Đơn");
            System.out.println("5. Chỉnh Sửa Hóa Đơn");
            System.out.println("6. Xem tổng doanh thu bán vé");
            System.out.println("7. Thoát");
            System.out.println("enter lc");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    output();
                    break;
                case 2:
                    Search();
                    break;
                case 3:
                    input(khachHang,nhanVien,phieuDatCho);
                    break;
                case 4:
                    Delete();
                    break;
                case 5:
                    editHoaDon();
                    break;
                case 6:
                    thongke();
                    break;
            }
        }while (lc!=7);
    }
    public void XemHoaDon(String makhachhang){
        int temp=0;
        System.out.printf("-----------------------------------------------------------------------------------------------------------\n");
        System.out.printf("|%-15s|%-15s|%-15s|%-15s|%-20s|%-20s|\n","MãHóaĐơn","MãNhânViên","MãKháchHàng","Ngày","TổngTiền","MãPhiếuĐặtChỗ");
        System.out.printf("-----------------------------------------------------------------------------------------------------------\n");
        for(int i=0;i<hoadon.length;i++){
            if(hoadon[i].getMakhachhang().compareTo(makhachhang)==0){
                hoadon[i].output();
                temp=1;
            }
        }
        if(temp==0){
            System.out.println("Không có Hóa Đơn");
        }
    }
    public void XemHoaDonKhachHang(){
        System.out.println("enter mã khách hàng");
        String makhachhang=sc.nextLine();
        XemHoaDon(makhachhang);
    }
    public void MenuUser(){
        int lc;
        do {
            System.out.println("1. Xem Hóa Đơn");
            System.out.println("2. Thoát");
            System.out.println("enter lc");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    XemHoaDonKhachHang();
                    break;
            }
        }while (lc!=2);
    }
}
