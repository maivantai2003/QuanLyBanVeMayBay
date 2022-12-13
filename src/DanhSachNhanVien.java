import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachNhanVien implements ChucNang, Serializable {
    public static Scanner sc=new Scanner(System.in);
    private ArrayList<NhanVien> nhanvien;
    public DanhSachNhanVien(){
        this.nhanvien=new ArrayList<>();
        //String ten, int tuoi, String gioitinh, String dc, String day, String masonhanvien,double luong,String password
        nhanvien.add(new NhanVienQuanLi("Văn Tài",19,"nam","Bến Tre","1/1/2022","NV1",10000d,"admin"));
        nhanvien.add(new NhanVienBanVe("Lệ San",19,"nữ","TP HCM","1/1/2022","NV2",8000d,"admin1"));
        nhanvien.add(new NhanVienBanVe("Uyển Quân",19,"nũ","Bình Định","1/1/2022","NV3",8000d,"admin2"));
        nhanvien.add(new NhanVienBanVe("Thiên Phúc",19,"nam","Bến Tre","1/1/2022","NV4",8000d,"admin3"));
    }
    public void input(){
        System.out.println("enter so luong nhan vien: ");
        int n;
        n=Check.CheckInput();
        for(int i=0;i<n;i++){
            NhanVien v=Create();
            nhanvien.add(v);
        }
    }
    public NhanVien Create(){
        int lc;
        NhanVien nv=null;
        System.out.println("1. nhân viên bán vé");
        System.out.println("2. nhân viên quản lí");
        System.out.println("enter option: ");
        do{
            lc=Check.CheckInput();
            if(lc>3 || lc<0){
                System.out.println("enter again");
            }
        }while (lc>3 || lc<0);
        switch (lc){
            case 1:
                nv=new NhanVienBanVe();
                break;
            case 2:
                nv=new NhanVienQuanLi();
                break;
        }
        nv.setMasonhanvien("NV"+(nhanvien.size()+1));
        nv.input();
        return nv;
    }
    public void output(){
        System.out.printf("-------------------\n");
        System.out.printf("|%-20s|\n","DANH SACH NHAN VIEN");
        System.out.printf("-------------------\n");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("|%-10s|%-20s|%-5s|%-20s|%-10s|%-10s|%-15s|%-20s|\n","MãNV","Tên","Tuổi","GiớiTính","ĐịaChỉ","NgaySinh","Lương","Password");
        System.out.printf("-----------------------------------------------------------------------------------------------------------------------\n");
        for(NhanVien i:nhanvien){
            i.output();
            System.out.printf("-----------------------------------------------------------------------------------------------------------------------\n");
        }
    }
    public void Add(NhanVien v){
        nhanvien.add(v);
        //File.writeNhanVien(nv);
    }
    public void DeleteNhanVien(String manhanvien){
        boolean check=false;
        for(NhanVien i:nhanvien){
            if(i.getMasonhanvien().compareTo(manhanvien)==0){
                nhanvien.remove(i);
                check=true;
                break;
            }
        }
        if(check==false){
            System.out.println("không có nhân viên nào");
        }
    }
    public void XuatNhanVienTheoLoai(){
        int lc;
        do{
            System.out.println("1. Nhân Viên Bán Vé");
            System.out.println("2. Nhân Viên Quản Lí");
            System.out.println("3. Tất Cả");
            System.out.println("4. Thoát");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    System.out.printf("-----------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("|%-10s|%-20s|%-5s|%-20s|%-10s|%-10s|%-15s|%-20s|\n","MãNV","Tên","Tuổi","GiớiTính","ĐịaChỉ","NgaySinh","Lương","Password");
                    System.out.printf("-----------------------------------------------------------------------------------------------------------------------\n");
                    for(NhanVien i:nhanvien){
                        if(i instanceof NhanVienBanVe){
                            i.output();
                        }
                    }
                    break;
                case 2:
                    System.out.printf("-----------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("|%-10s|%-20s|%-5s|%-20s|%-10s|%-10s|%-15s|%-20s|\n","MãNV","Tên","Tuổi","GiớiTính","ĐịaChỉ","NgaySinh","Lương","Password");
                    System.out.printf("-----------------------------------------------------------------------------------------------------------------------\n");
                    for(NhanVien i:nhanvien){
                        if(i instanceof NhanVienQuanLi){
                            i.output();
                        }
                    }
                    break;
                case 3:
                    System.out.printf("-----------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("|%-10s|%-20s|%-5s|%-20s|%-10s|%-10s|%-15s|%-20s|\n","MãNV","Tên","Tuổi","GiớiTính","ĐịaChỉ","NgaySinh","Lương","Password");
                    System.out.printf("-----------------------------------------------------------------------------------------------------------------------\n");
                    for(NhanVien i:nhanvien){
                        i.output();
                    }
            }
        }while(lc!=4);
    }
    @Override
    public void Delete() {
        String manhanvien;
        System.out.println("enter manhanvien delete");
        manhanvien=sc.nextLine();
        DeleteNhanVien(manhanvien);
    }
    public int SearchIndexNhanVien(String manhanvien){
        for(NhanVien i:nhanvien){
            if(i.getMasonhanvien().compareTo(manhanvien)==0){
                return nhanvien.indexOf(i);
            }
        }
        return -1;
    }

    @Override
    public void Search() {
        String manhanvien;
        System.out.println("Nhập mã số nhân viên cần tìm : ");
        manhanvien=sc.nextLine();
        if(SearchIndexNhanVien(manhanvien)!=-1){
            System.out.printf("-----------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("|%-10s|%-20s|%-5s|%-20s|%-10s|%-10s|%-15s|%-20s|\n","MãNV","Tên","Tuổi","GiớiTính","ĐịaChỉ","NgaySinh","Lương","Password");
            System.out.printf("-----------------------------------------------------------------------------------------------------------------------\n");
            nhanvien.get(SearchIndexNhanVien(manhanvien)).output();
        }
    }
    public void edit(){
        int lc=0;
        System.out.println("enter mã nhân viên cần sửa");
        String manhanvien=sc.nextLine();
        if(SearchIndexNhanVien(manhanvien)!=-1){
            do{
                System.out.println("1. Sửa Tên Nhân Viên");
                System.out.println("2. Sửa Mức Lương");
                System.out.println("3. Thoát");
                System.out.println("enter lc");
                lc=Check.CheckInput();
                switch (lc){
                    case 1:
                        nhanvien.get(SearchIndexNhanVien(manhanvien)).setTen(sc.nextLine());
                        break;
                    case 2:
                        nhanvien.get(SearchIndexNhanVien(manhanvien)).setLuong(Check.CheckInputDouble());
                        break;
                }
            }while (lc!=3);
        }else{
            System.out.println("Không có mã nhân viên cần chỉnh sửa");
        }
    }
    public void MenuNhanVien(){
        int lc=0;
        do{
            System.out.println("1. Xem Nhân Viên");
            System.out.println("2. Thêm Nhân Viên Viên");
            System.out.println("3. Tìm Kiếm Nhân Viên");
            System.out.println("4. Xóa Nhân Viên");
            System.out.println("5. Sửa Thông Tin Nhân Viên");
            System.out.println("6. Thoát");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    XuatNhanVienTheoLoai();
                    break;
                case 2:
                    input();
                    break;
                case 3:
                    Search();
                    break;
                case 4:
                    Delete();
                    break;
                case 5:
                    edit();
                    break;
            }
        }while (lc!=6);
    }
    public String getName(String pass){
        for(NhanVien i:nhanvien){
            if(i.getPassword().compareTo(pass)==0 && (i instanceof NhanVienQuanLi)){
                return "("+i.getMasonhanvien()+")"+i.getTen();
            }
            if(i.getPassword().compareTo(pass)==0 && (i instanceof NhanVienBanVe)){
                return "("+i.getMasonhanvien()+")"+i.getTen();
            }

        }
        return "Không Có";
    }
}
