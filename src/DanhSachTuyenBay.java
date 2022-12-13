import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachTuyenBay implements ChucNang,reSize, Serializable {
    public static Scanner sc=new Scanner(System.in);
    private TuyenBay[] tuyenbay;
    private int n;
    public DanhSachTuyenBay(){
        this.n=5;
        tuyenbay=new TuyenBay[n];
        tuyenbay[0]=new TuyenBay(new SanBay("HAN","Sân bay Quốc tế Nội Bài","Hà Nội"),new SanBay("SGN","Sân bay Quốc tế Tân Sơn Nhất","Hồ Chí Minh"));
        tuyenbay[1]=new TuyenBay(new SanBay("HUI","Sân bay Quốc tế Phú Bài","Huế"),new SanBay("SGN","Sân bay Quốc tế Tân Sơn Nhất","Hồ Chí Minh"));
        tuyenbay[2]=new TuyenBay(new SanBay("SGN","Sân bay Quốc tế Tân Sơn Nhất","Hồ Chí Minh"),new SanBay("HAN","Sân bay Quốc tế Nội Bài","Hà Nội"));
        tuyenbay[3]=new TuyenBay(new SanBay("VDO","Sân bay Quốc tế Vân Đồn","Quảng Ninh"),new SanBay("SGN","Sân bay Quốc tế Tân Sơn Nhất","Hồ Chí Minh"));
        tuyenbay[4]=new TuyenBay(new SanBay("UIH","Sân bay Quốc tế Phù Cát","Bình Định"),new SanBay("VCA","Sân bay Quốc tế Cần Thơ","Cần Thơ"));
    }
    public DanhSachTuyenBay(TuyenBay[] tuyenbay,int n){
        this.tuyenbay=tuyenbay;
        this.n=n;
    }

    public TuyenBay[] getTuyenbay() {
        return tuyenbay;
    }

    public void setTuyenbay(TuyenBay[] tuyenbay) {
        this.tuyenbay = tuyenbay;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public void input(){
        int lc;
        while (true){
            System.out.println("1. Nhập Tuyến Bay");
            System.out.println("2. Dừng Nhập");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    System.out.println("Tuyến Bay: "+(this.tuyenbay.length+1));
                    TuyenBay tb=new TuyenBay();
                    tb.input();
                    addTuyenBay(tb);
                    break;
                case 2:
                    return;
            }
        }
    }
    public void output(){
        System.out.printf("--------------------\n");
        System.out.printf("|%-20s|\n","DANH SACH TUYEN BAY");
        System.out.printf("--------------------\n");
        System.out.printf("------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("|%-12s|%-30s|%-15s|%-30s|%-15s|\n","MãTuyếnBay","SânBayĐi","TỉnhThànhPhố","SânBayĐến","TỉnhThànhPhố");
        System.out.printf("------------------------------------------------------------------------------------------------------------\n");
        for(int i=0;i<tuyenbay.length;i++){
            tuyenbay[i].output();
            System.out.printf("------------------------------------------------------------------------------------------------------------\n");
        }
    }

    @Override
    public void setSize(int size) {
        this.tuyenbay= Arrays.copyOf(this.tuyenbay,this.tuyenbay.length+size);
        this.n+=size;
    }

    public void addTuyenBay(TuyenBay tb){
        setSize(1);
        tuyenbay[this.tuyenbay.length-1]=tb;
    }
    public int SearchIndex(String matuyenbay){
        for(int i=0;i<tuyenbay.length;i++){
            if(tuyenbay[i].getMatuyenbay().compareTo(matuyenbay)==0){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void Delete() {
        System.out.println("enter mã tuyến bay cần xóa");
        String matuyenbay=sc.nextLine();
        if(SearchIndex(matuyenbay)!=-1){
            for(int i=SearchIndex(matuyenbay);i<tuyenbay.length-1;i++){
                tuyenbay[i]=tuyenbay[i+1];
            }
            tuyenbay[tuyenbay.length-1]=null;
            setSize(-1);
        }
    }
    @Override
    public void Search() {
        System.out.println("enter mã tuyến bay cần tìm kiếm: ");
        String matuyenbay=sc.nextLine();
        if(SearchIndex(matuyenbay)!=-1){
            System.out.println("Tìm thấy máy bay");
            tuyenbay[SearchIndex(matuyenbay)].output();
        }else{
            System.out.println("Không tìm thấy chuyến bay");
        }
    }
    public void edit(){
        int lc=0;
    }
    public void MenuTuyenBay(){
        int lc=0;
        do{
            System.out.println("1. Xem Danh Sách Tuyến Bay");
            System.out.println("2. Tìm Kiếm Tuyến Bay");
            System.out.println("3. Thêm Tuyến Bay");
            System.out.println("4. Xóa Tuyến Bay");
            System.out.println("5. Thoát");
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
            }
        }while (lc!=5);
    }
}
