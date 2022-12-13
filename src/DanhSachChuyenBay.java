import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachChuyenBay implements ChucNang,reSize, Serializable {
    public static Scanner sc = new Scanner(System.in);
    private ChuyenBay[] chuyenbay;
    private int n = 0;
//String hangbay,String machuyenbay,String matuyebay,String mamaybay,String thoigian,String ngaydi,String di,String den,int ghephothong,int ghethuonggia,double giaghephothong,double giaghethuonggia
    public DanhSachChuyenBay() {
        this.n = 3;
        chuyenbay=new ChuyenBay[n];
        chuyenbay[0]=new ChuyenBay("Bamboo Airways","QH1","SGN-HAN","MB1","12:00","8/12/2022","Hồ Chí Minh","Hà Nội",50,20,1000d,5000d);
        chuyenbay[1]=new ChuyenBay("Vietnam Airlines","VN2","HAN-SGN","MB2","19:00","9/12/2022","Hà Nội","Hồ Chí Minh",30,10,1000d,8000d);
        chuyenbay[2]=new ChuyenBay("Vietjet Air","VJ3","UIH-VCA","MB3","23:00","10/12/2022","Bình Định","Cần Thơ",50,20,1000d,5000d);
    }

    public DanhSachChuyenBay(ChuyenBay[] chuyenbay, int n) {
        this.chuyenbay = new ChuyenBay[this.n];
    }

    public ChuyenBay[] getChuyenbay() {
        return chuyenbay;
    }

    public void setChuyenbay(ChuyenBay[] chuyenbay) {
        this.chuyenbay = chuyenbay;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void input(DanhSachHangBay hangBay,DanhSachMayBay mayBay,DanhSachTuyenBay tuyenBay) {
        int lc;
        String mahangbay,mamaybay,matuyenbay;
        System.out.println("Danh Sách hãng bay hiện có");
        hangBay.ouptut();
        System.out.println("Danh Sách máy bay hiện có");
        mayBay.output();
        System.out.println("Danh Sách tuyến bay hiện có");
        tuyenBay.output();
        System.out.println("---------------------------------------------------");
            while(true){
                System.out.println("1. Nhập Chuyến Bay");
                System.out.println("2. Dừng Nhập");
                lc=Check.CheckInput();
                switch (lc){
                    case 1:
                        ChuyenBay cb=new ChuyenBay();
                        while (true){
                            System.out.println("enter mahangbay");
                            mahangbay=sc.nextLine();
                            System.out.println("enter maybay");
                            mamaybay=sc.nextLine();
                            System.out.println("enter matuyenbay");
                            matuyenbay=sc.nextLine();
                            if(hangBay.SearchIndex(mahangbay)!=-1 && mayBay.SeachIndex(mamaybay)!=-1 && tuyenBay.SearchIndex(matuyenbay)!=-1){
                                //set tên hãng bay
                                cb.setHangbay(hangBay.getHangbay().get(hangBay.SearchIndex(mahangbay)).getTenhangbay());
                                //set mã chuyến bay
                                cb.setMachuyenbay(mahangbay+""+(chuyenbay.length+1));
                                //set mã máy bay
                                cb.setMamaybay(mamaybay);
                                //set tuyen bay
                                cb.setMatuyebay(matuyenbay);
                                cb.setDi(tuyenBay.getTuyenbay()[tuyenBay.SearchIndex(matuyenbay)].getSandi().getTinhthanhpho());
                                cb.setDen(tuyenBay.getTuyenbay()[tuyenBay.SearchIndex(matuyenbay)].getSanden().getTinhthanhpho());
                                break;
                            }else{
                                System.out.println("Không Có Hãng Bay hoặc Máy Bay");
                                System.out.println("Nhập lại");
                            }
                        }
                        cb.input();
                        cb.setGhephothong(mayBay.getMaybay()[mayBay.SeachIndex(mamaybay)].getGhephothong());
                        cb.setGhethuonggia(mayBay.getMaybay()[mayBay.SeachIndex(mamaybay)].getGhethuonggia());
                        setSize(1);
                        chuyenbay[chuyenbay.length-1]=cb;
                        break;
                    case 2:
                        return;
                }
            }
    }

    @Override
    public void setSize(int size) {
        this.chuyenbay = Arrays.copyOf(this.chuyenbay, this.chuyenbay.length + size);
        this.n += size;
    }

    public void output() {
        System.out.printf("----------------------\n");
        System.out.printf("|%-20s|\n","DANH SACH CHUYEN BAY");
        System.out.printf("----------------------\n");
        System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("|%-22s|%-15s|%-13s|%-13s|%-13s|%-13s|%-13s|%-13s|%-15s|%-15s|%-15s|%-15s|\n","HãngBay","TuyếnBay","MãChuyếnBay","MãMáyBay","NgàyĐi","ThờiGianĐi","NơiĐi"," NơiĐến","GhếPhổThông","GhếThươngGia","GiáVéPT","GiáVéTG");
        System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        for (ChuyenBay i : chuyenbay) {
            i.output();
            System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
        }
    }
    public void addchuyenbay(ChuyenBay cb) {
        this.chuyenbay = Arrays.copyOf(this.chuyenbay, this.chuyenbay.length + 1);
        this.chuyenbay[n] = cb;
        setN(n + 1);
    }
    public void Delete() {
        System.out.println("enter mã chuyến bay cần xóa");
        String machuyenbay=sc.nextLine();
        if(SearchIndex(machuyenbay)!=-1){
            for(int i=SearchIndex(machuyenbay);i<chuyenbay.length-1;i++){
                chuyenbay[i]=chuyenbay[i+1];
            }
            chuyenbay[chuyenbay.length-1]=null;
            setSize(-1);
        }else{
            System.out.println("Không có chuyến bay");
        }
    }
    public void Search() {
        System.out.println("nhập mã chuyến bay cần tìm");
        String machuyenbay;
        machuyenbay = sc.nextLine();
        if(SearchIndex(machuyenbay)!=-1) {
            System.out.println("Tìm thấy chuyến bay");
            chuyenbay[SearchIndex(machuyenbay)].output();
        }else{
            System.out.println("Chuyến Bay không có");
        }
    }
    public int SearchIndex(String machuyenbay) {
        for (int i = 0; i < chuyenbay.length-1; i++) {
            if (chuyenbay[i].getMachuyenbay().compareTo(machuyenbay) == 0) {
                return i;
            }
        }
        return -1;
    }
    public void editChuyenBay(){
        int lc=0;
        System.out.println("enter mã chuyến bay cần sửa");
        String machuyenbay=sc.nextLine();
        if(SearchIndex(machuyenbay)!=-1){
            do {
                System.out.println("1. Sửa Giá Vé Thương Gia");
                System.out.println("2. Sửa Giá Vé Phổ Thông");
                System.out.println("3. Thoát");
                System.out.println("enter lc");
                lc=Check.CheckInput();
                switch (lc){
                    case 1:
                        System.out.println("Nhập giá vé thương gia: ");
                        chuyenbay[SearchIndex(machuyenbay)].setGiaghethuonggia(Check.CheckInputDouble());
                        break;
                    case 2:
                        System.out.println("Nhập giá vé phổ thông: ");
                        chuyenbay[SearchIndex(machuyenbay)].setGiaghephothong(Check.CheckInputDouble());
                        break;
                }
            }while (lc!=3);
        }
    }
    public void MenuChuyenBay(DanhSachHangBay hangBay,DanhSachMayBay mayBay,DanhSachTuyenBay tuyenBay){
        int lc;
        while (true){
            System.out.println("1. Xem Chuyến Bay");
            System.out.println("2. Tìm Kiếm Chuyến Bay");
            System.out.println("3. Thêm Chuyến Bay");
            System.out.println("4. Xóa Chuyến Bay");
            System.out.println("5. Sửa Thông Tin Chuyến Bay");
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
                    input(hangBay,mayBay,tuyenBay);
                    break;
                case 4:
                    Delete();
                    break;
                case 5:
                    editChuyenBay();
                    break;
                case 6:
                    return;
            }
        }
    }
}