import java.util.Scanner;
public class Main {
    public static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        DanhSachMayBay mayBay=null;
        mayBay=(DanhSachMayBay) FiLe.WriteFile(mayBay,"MayBay");
        if(mayBay==null){
            mayBay=new DanhSachMayBay();
            FiLe.ReadFile(mayBay,"MayBay");
        }
        DanhSachHangBay hangBay=null;
        hangBay=(DanhSachHangBay) FiLe.WriteFile(hangBay,"HangBay");
        if(hangBay==null){
            hangBay=new DanhSachHangBay();
            FiLe.ReadFile(hangBay,"HangBay");
        }
        DanhSachTuyenBay tuyenBay=null;
        tuyenBay=(DanhSachTuyenBay) FiLe.WriteFile(tuyenBay,"Tuyenbay");
        if(tuyenBay==null){
            tuyenBay=new DanhSachTuyenBay();
            FiLe.ReadFile(tuyenBay,"Tuyenbay");
        }

        DanhSachChuyenBay chuyenBay=null;
        chuyenBay=(DanhSachChuyenBay) FiLe.WriteFile(chuyenBay,"Chuyenbay");
        if(chuyenBay==null){
            chuyenBay=new DanhSachChuyenBay();
            FiLe.ReadFile(chuyenBay,"Chuyenbay");
        }
        DanhSachNhanVien nhanVien=null;
        nhanVien=(DanhSachNhanVien) FiLe.WriteFile(nhanVien,"NhanVien");
        if(nhanVien==null){
            nhanVien=new DanhSachNhanVien();
            FiLe.ReadFile(nhanVien,"NhanVien");
        }
        DanhSachVeMayBay veMayBay=null;
        veMayBay=(DanhSachVeMayBay)FiLe.WriteFile(veMayBay,"Vemaybay");
        if(veMayBay==null){
            veMayBay=new DanhSachVeMayBay();
            FiLe.ReadFile(veMayBay,"Vemaybay");
        }
        DanhSachKhachHang khachHang=null;
        khachHang=(DanhSachKhachHang)FiLe.WriteFile(khachHang,"KhachHang");
        if(khachHang==null){
            khachHang=new DanhSachKhachHang();
            FiLe.ReadFile(khachHang,"KhachHang");
        }
        DanhSachPhieuDatCho phieuDatCho=null;
        phieuDatCho=(DanhSachPhieuDatCho)FiLe.WriteFile(phieuDatCho,"PhieuDatCho");
        if(phieuDatCho==null){
            phieuDatCho=new DanhSachPhieuDatCho();
            FiLe.ReadFile(phieuDatCho,"PhieuDatCho");
        }
        DanhSachHoaDon hoaDon=null;
        hoaDon=(DanhSachHoaDon)FiLe.WriteFile(hoaDon,"HoaDon");
        if(hoaDon==null){
            hoaDon=new DanhSachHoaDon();
            FiLe.ReadFile(hoaDon,"HoaDon");
        }
        int lc=0,lc1=0,lc2=0;
        String pass;
        System.out.println("Nếu là người dùng thì vui lòng nhập password là user");
        do {
            System.out.println("1. ĐĂNG NHẬP");
            System.out.println("2. THOÁT");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    System.out.println("enter mật khẩu: ");
                    pass=sc.nextLine();
                    if(pass.compareTo("admin")==0) {
                        do {
                            System.out.println("Xin Chào: "+nhanVien.getName(pass)+" Quản Lí ");
                            System.out.println("1. Danh Sách Nhân Viên");
                            System.out.println("2. Danh Sách Máy Bay");
                            System.out.println("3. Danh Sách Hãng Bay");
                            System.out.println("4. Danh Sách Tuyến Bay");
                            System.out.println("5. Danh Sách Chuyến Bay");
                            System.out.println("6. Danh Sách Vé Máy Bay");
                            System.out.println("7. Danh Sách Khách Hàng");
                            System.out.println("8. Thoát");
                            System.out.println("enter lc");
                            lc=Check.CheckInput();
                            switch (lc){
                                case 1:
                                    nhanVien.MenuNhanVien();
                                    FiLe.ReadFile(nhanVien,"NhanVien");
                                    break;
                                case 2:
                                    mayBay.MenuMayBay();
                                    FiLe.ReadFile(mayBay,"MayBay");
                                    break;
                                case 3:
                                    hangBay.MenuHangBay();
                                    FiLe.ReadFile(hangBay,"HangBay");
                                    break;
                                case 4:
                                    tuyenBay.MenuTuyenBay();
                                    FiLe.ReadFile(tuyenBay,"Tuyenbay");
                                    break;
                                case 5:
                                    chuyenBay.MenuChuyenBay(hangBay,mayBay,tuyenBay);
                                    FiLe.ReadFile(chuyenBay,"Chuyenbay");
                                    break;
                                case 6:
                                    veMayBay.MenuVeMayBay(chuyenBay);
                                    FiLe.ReadFile(veMayBay,"Vemaybay");
                                    break;
                                case 7:
                                    khachHang.MenuKhachHang();
                                    FiLe.ReadFile(khachHang,"KhachHang");
                                    break;
                            }
                        }while (lc!=8);
                    }else if(pass.compareTo("admin1")==0 || pass.compareTo("adimn2")==0 || pass.compareTo("admin3")==0){
                        do{
                            System.out.println("Xin Chào: "+nhanVien.getName(pass));
                            System.out.println("1. Danh Phiếu Đặt Chỗ");
                            System.out.println("2. Danh Sách Hóa Đơn");
                            System.out.println("3. thoát");
                            System.out.println("enter lc");
                            lc1=Check.CheckInput();
                            switch (lc1){
                                case 1:
                                    phieuDatCho.MenuPhieuDatCho(chuyenBay,veMayBay,khachHang);
                                    FiLe.ReadFile(phieuDatCho,"PhieuDatCho");
                                    break;
                                case 2:
                                    hoaDon.MenuHoaDon(khachHang,nhanVien,phieuDatCho);
                                    FiLe.ReadFile(hoaDon,"HoaDon");
                                    break;
                            }
                        }while (lc1!=3);

                    } else if (pass.compareTo("user")==0) {
                        do{
                            System.out.println("1. Xem Phiếu Đặt Chỗ");
                            System.out.println("2. Xem Hóa Đơn");
                            System.out.println("3. Thoát");
                            System.out.println("enter lc");
                            lc2=Check.CheckInput();
                            switch (lc2){
                                case 1:
                                    phieuDatCho.MenuUser(chuyenBay,veMayBay,khachHang);
                                    FiLe.ReadFile(phieuDatCho,"PhieuDatCho");
                                    break;
                                case 2:
                                    hoaDon.MenuUser();
                                    FiLe.ReadFile(hoaDon,"HoaDon");
                                    break;
                            }
                        }while (lc2!=3);
                    } else{
                        System.out.println("Nhập Sai Mật Khẩu");
                        System.out.println("enter again");
                    }
                    break;
            }
        }while (lc!=2);
    }
}