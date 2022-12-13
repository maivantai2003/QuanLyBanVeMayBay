import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class DanhSachKhachHang implements ChucNang, Serializable {
    public  static Scanner sc=new Scanner(System.in);
    private ArrayList<KhachHang> khachhang;
    public DanhSachKhachHang(){
        this.khachhang=new ArrayList<>();
    }
    public DanhSachKhachHang(ArrayList<KhachHang> khachhang){
        this.khachhang=khachhang;
    }
    public ArrayList<KhachHang> getKh() {
        return khachhang;
    }

    public void setKh(ArrayList<KhachHang> kh) {
        this.khachhang = kh;
    }
    public void input(){
        System.out.println("nhập vào số lượng khách hàng: ");
        int n = Check.CheckInput();
        for(int i=0;i<n;i++){
            KhachHang k=new KhachHang();
            k.input();
            k.setMakhachhang("KH"+(khachhang.size()+1));
            khachhang.add(k);
        }
    }
    public void output(){
        System.out.printf("-------------------\n");
        System.out.printf("|%-20s|\n","DANH SACH KHACH HANG");
        System.out.printf("-------------------\n");
        System.out.printf("-------------------------------------------------------------------------------------------------------\n");
        System.out.printf("|%-10s|%-18s|%-10s|%-10s|%-12s|%-12s|%-12s|%-20s|%-12s|\n","MãKH","Tên","Tuổi","GiớiTính","ĐịaChỉ","NgàySinh","CCCD","Gmail","SĐT");
        System.out.printf("--------------------------------------------------------------------------------------------------------\n");
        for(KhachHang i:khachhang){
            i.output();
            System.out.printf("------------------------------------------------------------------------------------------------------\n");
        }
    }
    @Override
    public void Search() {
        System.out.println("enter makhachhang");
        String makhachhang=sc.nextLine();
        SearchKhachHang(makhachhang);
    }
    public void SearchKhachHang(String makhachhang){
        int temp=0;
        boolean check=false;
        for(int i=0;i<khachhang.size();i++){
            if(khachhang.get(i).getMakhachhang().compareTo(makhachhang)==0){
                temp=i;
                check=true;
            }
        }
        if(!check){
            System.out.println("Không có khách hàng cần tìm kiếm");
        }else{
            System.out.println("Khách hàng cần tìm");
            khachhang.get(temp).output();
        }
    }
    public int IndexKhachHang(String makhachhang){
        for(int i=0;i<khachhang.size();i++){
            if(khachhang.get(i).getMakhachhang().compareTo(makhachhang)==0){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void Delete() {
        System.out.println("enter makhachhang");
        String makhachhang=sc.nextLine();
        DeleteKhachHang(makhachhang);
    }
    public void DeleteKhachHang(String makhachhang){
        int temp=0;
        boolean check=false;
        for(KhachHang i:khachhang){
            if(i.getMakhachhang().compareTo(makhachhang)==0){
                temp=khachhang.indexOf(i);
                check=true;
                khachhang.remove(i);
                break;
            }
        }
        if(!check){
            System.out.println("Không có khách hàng cần xóa");
        }
    }
    public void addKhachHang(KhachHang k){
        k.setMakhachhang("KH"+(khachhang.size()+1));
        khachhang.add(k);
    }
    public void ChinhSuaThongThongTin(){
        int lc;
        int index;
        System.out.println("enter mã khách hàng cần chỉnh sửa");
        String makhachhang=sc.nextLine();
        if(IndexKhachHang(makhachhang)!=-1){
            index=IndexKhachHang(makhachhang);
            do {
                option();
                lc = Check.CheckInput();
                switch (lc) {
                    case 1:
                        khachhang.get(index).setTen(sc.nextLine());
                        break;
                    case 2:
                        khachhang.get(index).setTuoi(Check.CheckInput());
                        break;
                    case 3:
                        khachhang.get(index).setDc(sc.nextLine());
                        break;
                    case 4:
                        khachhang.get(index).setCCCD(sc.nextInt());
                        break;
                    case 5:
                        khachhang.get(index).setDay(sc.nextLine());
                        break;
                }
            }while (lc!=6);
        }else{
            System.out.println("KHông Tìm Thấy Khách Hàng Cần Sửa");
        }

    }
    public void option(){
        System.out.println("1. Tên");
        System.out.println("2. Tuổi");
        System.out.println("3. Địa Chỉ");
        System.out.println("4. CCCD");
        System.out.println("5. Ngày Sinh");
        System.out.println("6. Thoát");
        System.out.println("enter lựa chọn");
    }
    public void MenuKhachHang(){
        int lc;
        do{
            System.out.println("1. Xem Khách Hàng");
            System.out.println("2. Tìm Kiếm Khách Hàng");
            System.out.println("3. Thêm Khách Hàng");
            System.out.println("4. Xóa Khách Hàng");
            System.out.println("5. Sửa Thông Tin Khách Hàng");
            System.out.println("6. Thoát");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    output();
                    break;
                case 2:
                    Search();
                    break;
                case 3:
                    input();
                    break;
                case 4:
                    Delete();
                    break;
                case 5:
                    ChinhSuaThongThongTin();
                    break;
            }
        }while (lc!=6);
    }
}
