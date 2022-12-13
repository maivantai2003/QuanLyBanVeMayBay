import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachMayBay implements ChucNang,reSize, Serializable {
    public static Scanner sc=new Scanner(System.in);
    private MayBay[] maybay;
    private int n;
    public DanhSachMayBay(){
        this.n=5;
        this.maybay=new MayBay[n];
        maybay[0]=new MayBay("MB1","BOING 777",50,20);
        maybay[1]=new MayBay("MB2","AIRBUS 370",20,10);
        maybay[2]=new MayBay("MB3","BOING 787",30,10);
        maybay[3]=new MayBay("MB4","AIRBUS 370",40,15);
        maybay[4]=new MayBay("MB5","AIRBUS 330",20,10);
    }
    public DanhSachMayBay(MayBay[] maybay,int n){
        this.n=n;
        this.maybay=new MayBay[this.n];
    }

    public MayBay[] getMaybay() {
        return maybay;
    }

    public void setMaybay(MayBay[] maybay) {
        this.maybay = maybay;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    public void setSize(int size){
        this.maybay= Arrays.copyOf(this.maybay,this.maybay.length+size);
        this.n+=size;
    }
   public void input(){
        int lc;
        while (true){
            System.out.println("1. Nhập Máy Bay");
            System.out.println("2. Dừng Nhập");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    System.out.println("Máy Bay: "+(this.maybay.length+1));
                    MayBay mb=new MayBay();
                    mb.setMamaybay("MB"+(this.maybay.length+1));
                    mb.input();
                    addMayBay(mb);
                    break;
                case 2:
                    return;
            }
        }
   }
   public void output(){
       System.out.printf("-------------------\n");
       System.out.printf("|%-20s|\n","DANH SACH MAY BAY");
       System.out.printf("-------------------\n");
       System.out.printf("----------------------------------------------------------------------------\n");
       System.out.printf("|%-10s|%-18s|%-14s|%-14s|%-14s|\n","MãMáyBay","TênMáyBay","GhếPhổThông","GhếThươngGia","TổngSốGhế");
       System.out.printf("----------------------------------------------------------------------------\n");
       for(int i=0;i<maybay.length;i++){
           maybay[i].output();
           System.out.printf("-----------------------------------------------------------------------------\n");
       }
   }

    @Override
    public void Search() {
        System.out.println("enter mã máy bay");
        String mamaybay=sc.nextLine();
        if(SeachIndex(mamaybay)!=-1){
            System.out.println("Tìm Thấy Chuyến Bay");
            maybay[SeachIndex(mamaybay)].output();
        }else{
            System.out.println("Máy bay không tồn tại");
        }
    }
    public int SeachIndex(String mamaybay){
        for(int i=0;i<maybay.length;i++){
            if(maybay[i].getMamaybay().compareTo(mamaybay)==0){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void Delete() {
        System.out.println("enter mã máy bay cần xóa");
        String mamaybay=sc.nextLine();
        if(SeachIndex(mamaybay)!=-1){
            for(int i=SeachIndex(mamaybay);i<maybay.length-1;i++){
                maybay[i]=maybay[i+1];
            }
            maybay[maybay.length-1]=null;
            setSize(-1);
        }
    }
    public void addMayBay(MayBay mb){
        setSize(1);
        maybay[maybay.length-1]=mb;
    }
    public void editMayBay(){
        int lc;
        do{
            output();
            System.out.println("Nhập máy bay cần sửa"); // còn thiếu
            String mamaybay=sc.nextLine();
            System.out.println("1. Sửa tên máy bay");
            System.out.println("2. Thay đổi số ghế phổ thông");
            System.out.println("3. Thay đổi số ghế thương gia");
            System.out.println("4. Thoát");
            System.out.println("enter lc");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    System.out.println("Nhập tên máy bay: ");
                    maybay[SeachIndex(mamaybay)].setTenmaybay(sc.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập số ghế phổ thông: ");
                    maybay[SeachIndex(mamaybay)].setGhephothong(Check.CheckInput());
                    break;
                case 3:
                    System.out.println("Nhập số ghế thương gia: ");
                    maybay[SeachIndex(mamaybay)].setGhethuonggia(Check.CheckInput());
                    break;
            }
        }while (lc!=4);
    }
    public void MenuMayBay(){
        int lc;
        do{
            System.out.println("1. Xem máy bay");
            System.out.println("2. Tìm kiếm máy bay");
            System.out.println("3. Thêm máy bay");
            System.out.println("4. Xóa máy bay");
            System.out.println("5. Sửa May Bay");
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
                    editMayBay();
                    break;
            }
        }while (lc!=6);
    }
}
