import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;
public class DanhSachVeMayBay implements Serializable,ChucNang,reSize {
    public static Scanner sc=new Scanner(System.in);
    private VeMayBay[] vemaybay;
    private int n;
    public DanhSachVeMayBay(){
        this.n=0;
        this.vemaybay=new VeMayBay[n];
    }
    public DanhSachVeMayBay(VeMayBay[] vemaybay,int n){
        this.n=n;
        this.vemaybay=new VeMayBay[this.n];
    }

    public VeMayBay[] getVemaybay() {
        return vemaybay;
    }

    public void setVemaybay(VeMayBay[] vemaybay) {
        this.vemaybay = vemaybay;
    }

    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public void input(DanhSachChuyenBay chuyenBay){
        int lc;
        String machuyenbay;
        System.out.println("Danh Sách Chuyến Bay hiện có");
        chuyenBay.output();
        System.out.println("---------------------------------------------------");
        while(true){
            System.out.println("1. Nhập Vé Máy Bay");
            System.out.println("2. Dừng Nhập");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    while (true){
                        System.out.println("enter mã chuyến bay cần nhập vé");
                        machuyenbay=sc.nextLine();
                        if(chuyenBay.SearchIndex(machuyenbay)!=-1){
                            break;
                        }else{
                            System.out.println("Không Có Hãng Bay hoặc Máy Bay");
                            System.out.println("Nhập lại");
                        }
                    }
                    int temp=vemaybay.length;
                    setSize(chuyenBay.getChuyenbay()[chuyenBay.SearchIndex(machuyenbay)].getGhethuonggia());
                    for(int i=temp;i<vemaybay.length;i++){
                        vemaybay[i]=new VeMayBay();
                        vemaybay[i].setMacb(machuyenbay);
                        vemaybay[i].setMave("MV"+(i+1));
                        vemaybay[i].setTrinhtrangve("Chưa Đặt");
                        vemaybay[i].setTenhangve("Thương Gia");
                        vemaybay[i].setSoghe("SG"+(i+1));
                        vemaybay[i].setGiave(chuyenBay.getChuyenbay()[chuyenBay.SearchIndex(machuyenbay)].getGiaghethuonggia());
                    }
                    temp=vemaybay.length;
                    setSize(chuyenBay.getChuyenbay()[chuyenBay.SearchIndex(machuyenbay)].getGhephothong());
                    for(int i=temp;i<vemaybay.length;i++){
                        vemaybay[i]=new VeMayBay();
                        vemaybay[i].setMacb(machuyenbay);
                        vemaybay[i].setMave("MV"+(i+1));
                        vemaybay[i].setTrinhtrangve("Chưa Đặt");
                        vemaybay[i].setTenhangve("Phổ Thông");
                        vemaybay[i].setSoghe("SG"+(i+1));
                        vemaybay[i].setGiave(chuyenBay.getChuyenbay()[chuyenBay.SearchIndex(machuyenbay)].getGiaghephothong());
                    }
                    break;
                case 2:
                    return;
            }
        }
    }
    @Override
    public void Search() {
        String mave;
        System.out.println("enter mã vé: ");
        mave=sc.nextLine();
        if(SearchIndex(mave)!=-1){
            System.out.println("Tìm thấy vé");
            vemaybay[SearchIndex(mave)].output();
        }
    }
    public int SearchIndex(String mave){
        Boolean check=false;
        int temp=0;
        for(int i=0;i<vemaybay.length;i++){
            if(vemaybay[i].getMave().compareTo(mave)==0){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void Delete() {
        System.out.println("enter ma ve may bay can xoa");
        String mave=sc.nextLine();
        DeleteVe(mave);
    }
    public void DeleteVe(String mave){
        int vt=checkVemaybay(mave);
        if(vt==-1){
            System.out.println("Không có mã vé này");
        }else{
            for(int i=vt;i<vemaybay.length;i++){
                vemaybay[i]=vemaybay[i+1];
            }
            vemaybay[vemaybay.length-1]=null;
            setSize(-1);
        }
    }
    public void setSize(int size){
        this.vemaybay= Arrays.copyOf(this.vemaybay,this.vemaybay.length+size);
        this.n+=size;
    }
    public void output(){
        System.out.printf("--------------------\n");
        System.out.printf("|%-20s|\n","DANH SACH VE");
        System.out.printf("--------------------\n");
        System.out.printf("------------------------------------------------------------------------------\n");
        System.out.printf("|%-10s|%-20s|%-20s|%-15s|%-20s|%-10s|\n","MãVé","MãChuyếnBay","TênHạngVé","GiáVé","TìnhTrạngVé","Ghế");
        System.out.printf("-------------------------------------------------------------------------------------------\n");
        for(int i=0;i<vemaybay.length;i++){
            vemaybay[i].output();
            System.out.printf("----------------------------------------------------------------------------------------\n");
        }
    }
    public int checkVemaybay(String ve){
        for(int i=0;i<vemaybay.length;i++){
            if(vemaybay[i].getTenhangve().compareTo(ve)==0 && vemaybay[i].getTrinhtrangve().compareTo("Chưa Đặt")==0){
                return i;
            }
        }
        return -1;
    }
    public int datcho(String mave){
        for(int i=0;i<vemaybay.length;i++){
            if(vemaybay[i].getMave().compareTo(mave)==0 && vemaybay[i].getTrinhtrangve().compareTo("Chưa Đặt")==0){
                return i;
            }
        }
        return -1;
    }
    public void MuaVe(DanhSachChuyenBay chuyenBay,int n){
        int lc=0;
        do {
            System.out.println("1. Vé Thương Gia");
            System.out.println("2. Vé Phổ Thông");
            System.out.println("3. enter lc");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    break;
                case 2:
                    break;
            }
        }while (lc!=0);
    }
    public void XemVeChuyenBay(){
        System.out.println("enter mã chuyến bay cần xem vé");
        String machuyenbay;
        machuyenbay=sc.nextLine();
        boolean check=false;
        System.out.printf("|%-10s|%-20s|%-20s|%-15s|%-20s|%-10s|\n","MãVé","MãChuyếnBay","TênHạngVé","GiáVé","TìnhTrạngVé","Ghế");
        for(int i=0;i<vemaybay.length;i++){
            if(vemaybay[i].getMacb().compareTo(machuyenbay)==0){
                System.out.println("Vé Của Chuyến Bay: "+machuyenbay);
                vemaybay[i].output();
                check=true;
            }
        }
        if(!check){
            System.out.println("Không có vé máy bay của chuyến bay: "+machuyenbay);
        }
    }
    public void XemVeChuyenBay(String machuyenbay){
        for(int i=0;i<vemaybay.length;i++){
            if(vemaybay[i].getMacb().compareTo(machuyenbay)==0){
                vemaybay[i].output();
            }
        }
    }
    public void XemVeDat(){
        System.out.println("enter chuyến bay cần xem vé");
        String machuyenbay=sc.nextLine();
        int lc=0;
        do {
            System.out.println("1. Xem Số Vé Hạng Phổ Thông");
            System.out.println("2. Xem Số Vé Hạng Thương Gia");
            System.out.println("3. Thoát");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    for(int i=0;i<vemaybay.length;i++){
                        if(vemaybay[i].getMacb().compareTo(machuyenbay)==0 && vemaybay[i].getTenhangve().compareTo("Phổ Thông")==0){
                            vemaybay[i].output();
                        }
                    }
                    break;
                case 2:
                    for(int i=0;i<vemaybay.length;i++){
                        if(vemaybay[i].getMacb().compareTo(machuyenbay)==0 && vemaybay[i].getTenhangve().compareTo("Thương Gia")==0){
                            vemaybay[i].output();
                        }
                    }
                    break;
            }
        }while (lc!=3);
    }
    public void MenuVeMayBay(DanhSachChuyenBay chuyenBay){
        int lc;
        do{
            chuyenBay.output();
            System.out.println("1. Xem Vé Theo Chuyến Bay");
            System.out.println("2. Tìm Kiếm vé");
            System.out.println("3. Xem Tất Vả Vé");
            System.out.println("4. Thêm Vé");
            System.out.println("5. Xem Số Vé Đã Đặt/Chưa Đặt");
            System.out.println("6. Thoát");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    XemVeChuyenBay();
                    break;
                case 2:
                    Search();
                    break;
                case 3:
                    output();
                    break;
                case 4:
                    input(chuyenBay);
                    break;
                case 5:
                    XemVeDat();
                    break;
            }
        }while (lc!=6);
    }
    public boolean checkVe(DanhSachChuyenBay chuyenBay,String cb,String hang,int soluong){
        if(hang.compareTo("Phổ Thông")==0){
            if(soluong>chuyenBay.getChuyenbay()[chuyenBay.SearchIndex(cb)].getGhephothong()){
                return false;
            }else{
                return true;
            }
        }
        if(hang.compareTo("Thương Gia")==0){
            if(soluong>chuyenBay.getChuyenbay()[chuyenBay.SearchIndex(cb)].getGhethuonggia()){
                return false;
            }else{
                return true;
            }
        }
        return true;
    }
    public int MaVe(String cb,String hang){
        for(int i=0;i<vemaybay.length;i++){
            if(vemaybay[i].getMacb().compareTo(cb)==0 && vemaybay[i].getTenhangve().compareTo(hang)==0 && vemaybay[i].getTrinhtrangve().compareTo("Chưa Đặt")==0){
                return i;
            }
        }
        return -1;
    }
    public int MaGhe(String cb,String hang,String ghe){
        for(int i=0;i<vemaybay.length;i++){
            if(vemaybay[i].getMacb().compareTo(cb)==0 && vemaybay[i].getTenhangve().compareTo(hang)==0 && vemaybay[i].getSoghe().compareTo(ghe)==0){
                return i;
            }
        }
        return -1;
    }
}