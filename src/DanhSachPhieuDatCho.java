import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
public class DanhSachPhieuDatCho implements Serializable,ChucNang {
    public static Scanner sc=new Scanner(System.in);
   private ArrayList<PhieuDatCho> phieudatcho;
   public DanhSachPhieuDatCho(){
       this.phieudatcho=new ArrayList<>();
   }
    public ArrayList<PhieuDatCho> getPhieudatcho() {
        return phieudatcho;
    }

    public void setPhieudatcho(ArrayList<PhieuDatCho> phieudatcho) {
        this.phieudatcho = phieudatcho;
    }
    public void output(){
       //"|%-20s|%-15s|%-15s|%-20s|%-15s|%-15s|%-20f|\n",madatcho,makhachhang,machuyenbay,ngay,mave,soghe,gia
        System.out.printf("-------------------------\n");
        System.out.printf("|%-20s|\n","DANH SACH PHIEU DAT CHO");
        System.out.printf("-------------------------\n");
        System.out.printf("--------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("|%-20s|%-15s|%-15s|%-20s|%-15s|%-15s|%-20s|\n","MãĐặtChỗ","MãKháchHàng","MãChuyếnBay","Ngày","MãVé","SốGhế","Giá");
        System.out.printf("--------------------------------------------------------------------------------------------------------------------------------\n");
       for(PhieuDatCho i:phieudatcho){
           i.output();
           System.out.printf("--------------------------------------------------------------------------------------------------------------------------------\n");
       }
    }
    public void input(DanhSachChuyenBay chuyenBay,DanhSachVeMayBay veMayBay,DanhSachKhachHang khachHang){
       int lc;
       String machuyenbay,mave,makhachhang,ghe,hangghe = null;
        while (true){
            System.out.println("1. Nhập Phiếu đặt chỗ");
            System.out.println("2. Thoát");
            System.out.println("enter lc: ");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    PhieuDatCho phieu=new PhieuDatCho();
                    phieu.setMadatcho("DC"+(this.phieudatcho.size()+1));
                    System.out.println("enter ngày nhập phiếu đặt chỗ");
                    phieu.setNgay(Check.checkDate());
                        System.out.println("1. Đặt Chỗ Hạng Thương Gia");
                        System.out.println("2. Đặt Chỗ Hạng Phổ Thông");
                        System.out.println("enter lc");
                        lc=Check.CheckInput();
                        switch (lc){
                            case 1:
                                hangghe="Thương Gia";
                                break;
                            case 2:
                                hangghe="Phổ Thông";
                                break;
                        }
                    sc.nextLine();
                    while (true){
                        System.out.println("enter mã chuyến bay");
                        machuyenbay=sc.nextLine();
                        if(chuyenBay.SearchIndex(machuyenbay)!=-1 && veMayBay.MaVe(machuyenbay,hangghe)!=-1){
                            KhachHang kh=new KhachHang();
                            kh.input();
                            khachHang.addKhachHang(kh);
                            phieu.setMachuyenbay(machuyenbay);
                            phieu.setMave(veMayBay.getVemaybay()[veMayBay.MaVe(machuyenbay,hangghe)].getMave());
                            veMayBay.getVemaybay()[veMayBay.MaVe(machuyenbay,hangghe)].setTrinhtrangve("Đã Đặt");
                            phieu.setMakhachhang(kh.getMakhachhang());
                            break;
                        }else{
                            System.out.println("Chuyến bay hoặc Mã Vé không tồn tại");
                            System.out.println("enter again");
                        }
                    }
                    while (true){
                        veMayBay.XemVeChuyenBay(machuyenbay);
                        System.out.println("Chọn Số Ghế");
                        ghe=sc.nextLine();
                        if(veMayBay.MaGhe(machuyenbay,hangghe,ghe)!=-1){
                            ghe=veMayBay.getVemaybay()[veMayBay.MaGhe(machuyenbay,hangghe,ghe)].getSoghe();
                            phieu.setGia(veMayBay.getVemaybay()[veMayBay.MaGhe(machuyenbay,hangghe,ghe)].getGiave());
                            System.out.println("Đặt Chỗ Thành Công");
                            if(hangghe.compareTo("Thương Gia")==0){
                                chuyenBay.getChuyenbay()[chuyenBay.SearchIndex(machuyenbay)].setGhethuonggia(chuyenBay.getChuyenbay()[chuyenBay.SearchIndex(machuyenbay)].getGhethuonggia()-1);
                            }
                            if(hangghe.compareTo("Phổ Thông")==0) {
                                chuyenBay.getChuyenbay()[chuyenBay.SearchIndex(machuyenbay)].setGhephothong(chuyenBay.getChuyenbay()[chuyenBay.SearchIndex(machuyenbay)].getGhephothong()-1);
                            }
                            phieu.setSoghe(ghe);
                            veMayBay.getVemaybay()[veMayBay.MaGhe(machuyenbay,hangghe,ghe)].setSoghe("Đã Đặt");
                            break;
                        }else{
                            System.out.println("chỗ đã có người đặt hoặc thuộc vị trí hạng ghế khác");
                        }
                    }
                    addPhieuDatCho(phieu);
                    break;
                case 2:
                    return;
            }
        }
    }
    public void addPhieuDatCho(PhieuDatCho dc){
       phieudatcho.add(dc);
    }
    @Override
    public void Delete() {
        System.out.println("enter mã phiếu đặt chỗ");
        String maphieudatcho=sc.nextLine();
        if(SeachIndex(maphieudatcho)!=-1){
            phieudatcho.remove(SeachIndex(maphieudatcho));
        }else{
            System.out.println("Không tìm thấy phiếu đặt chỗ cần xóa");
        }
    }
    @Override
    public void Search() {
        System.out.println("enter mã phiếu đặt chỗ");
        String maphieudatcho=sc.nextLine();
        if(SeachIndex(maphieudatcho)!=-1){
            System.out.println("Tìm Thấy Phiếu Đặt Chỗ");
            System.out.printf("--------------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("|%-20s|%-15s|%-15s|%-20s|%-15s|%-15s|%-20s|\n","MãĐặtChỗ","MãKháchHàng","MãChuyếnBay","Ngày","MãVé","SốGhế","Giá");
            System.out.printf("--------------------------------------------------------------------------------------------------------------------------------\n");
            phieudatcho.get(SeachIndex(maphieudatcho)).output();
        }else{
            System.out.println("Không tìm thấy phiếu đặt chỗ");
        }
    }
    public int SeachIndex(String maphieudatcho){
       for(PhieuDatCho i:phieudatcho){
           if(i.getMadatcho().compareTo(maphieudatcho)==0){
               return phieudatcho.indexOf(i);
           }
       }
       return -1;
    }
    public void editPhieuDatCho(){
       int lc=0;
        System.out.println("enter mã phiếu đặt chỗ cần chỉnh sửa");
        String madatcho=sc.nextLine();
        if(SeachIndex(madatcho)!=-1){
            do {
                System.out.println("1. Sửa Mã Khách Hàng");
                System.out.println("2. Sửa Ngày Đặt Vé");
                System.out.println("3. Thoát");
                System.out.println("4. enter lc");
                lc=Check.CheckInput();
                switch (lc){
                    case 1:
                        phieudatcho.get(SeachIndex(madatcho)).setMakhachhang(sc.nextLine());
                        break;
                    case 2:
                        phieudatcho.get(SeachIndex(madatcho)).setNgay(Check.checkDate());
                        break;
                }
            }while (lc!=3);
        }else{
            System.out.println("Không Tìm Thấy Phiếu đặt chỗ cần sửa");
        }
    }
    public void ViTriGhe(String maphieudatcho){
       boolean temp=false;
       for(PhieuDatCho i:phieudatcho){
           if(i.getMadatcho().compareTo(maphieudatcho)==0){
               i.output();
               temp=true;
               break;
           }
       }
       if(!temp){
           System.out.println("Không có đặt ghế");
       }
    }
    public void MenuPhieuDatCho(DanhSachChuyenBay chuyenBay,DanhSachVeMayBay veMayBay,DanhSachKhachHang khachHang){
       int lc;
       do{
           System.out.println("1. Tìm Kiếm Phiếu Đặt Chỗ");
           System.out.println("2. Thêm Phiếu Đặt Chỗ");
           System.out.println("3. Xem Phiếu Đặt Chỗ");
           System.out.println("4. Xóa Phiếu Đặt Chỗ");
           System.out.println("5. Sửa Phiếu Đặt Chỗ");
           System.out.println("6. Thoát");
           lc=sc.nextInt();
           switch (lc){
               case 1:
                   Search();
                   break;
               case 2:
                   chuyenBay.output();
                   input(chuyenBay,veMayBay,khachHang);
                   break;
               case 3:
                   output();
                   break;
               case 4:
                   Delete();
                   break;
               case 5:
                   editPhieuDatCho();
                   break;
           }
       }while (lc!=6);
    }
    public void MenuUser(DanhSachChuyenBay chuyenBay,DanhSachVeMayBay veMayBay,DanhSachKhachHang khachHang){
       int lc=0;
       do{
           System.out.println("1. Xem Danh Sách Chuyến Bay");
           System.out.println("2. Xem vị trí ghế");
           System.out.println("3. Thoát");
           System.out.println("enter lc");
           lc=Check.CheckInput();
           switch (lc){
               case 1:
                   chuyenBay.output();
                   break;
               case 2:
                   Search();
                   break;
           }
       }while (lc!=3);
    }
}
