import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class DanhSachHangBay implements ChucNang, Serializable {
    public static Scanner sc=new Scanner(System.in);
    private ArrayList<HangBay> hangbay;
    public DanhSachHangBay(){
        this.hangbay=new ArrayList<>();
        hangbay.add(new HangBay("QH","Bamboo Airways"));
        hangbay.add(new HangBay("BL","Pacific Airlines "));
        hangbay.add(new HangBay("VJ","Vietjet Air"));
        hangbay.add(new HangBay("VN","Vietnam Airlines"));
        hangbay.add(new HangBay("VU","Vietravel Airlines "));
    }

    public ArrayList<HangBay> getHangbay() {
        return hangbay;
    }

    public void setHangbay(ArrayList<HangBay> hangbay) {
        this.hangbay = hangbay;
    }
    public void input(){
        int lc;
        while (true){
            System.out.println("1. Nhập Hãng Bay");
            System.out.println("2. Dừng Nhập");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    System.out.println("Hãng Bay: "+(this.hangbay.size()+1));
                    HangBay hb=new HangBay();
                    hb.input();
                    addHangBay(hb);
                    break;
                case 2:
                    return;
            }
        }
    }
    public void ouptut(){
        System.out.printf("-------------------\n");
        System.out.printf("|%-20s|\n","DANH SACH HANG BAY");
        System.out.printf("-------------------\n");
        System.out.printf("--------------------------------------\n");
        for(HangBay i:hangbay){
            i.output();
            System.out.printf("--------------------------------------\n");
        }
    }
    public int SearchIndex(String mahangbay){
        for(int i=0;i<hangbay.size();i++){
            if(hangbay.get(i).getMahangbay().compareTo(mahangbay)==0){
                return i;
            }
        }
        return -1;
    }
    public void addHangBay(HangBay hb){
        hangbay.add(hb);
    }
    @Override
    public void Search() {
        System.out.println("enter ma hang bay: ");
        String mahangbay=sc.nextLine();
        if(SearchIndex(mahangbay)!=-1){
            System.out.println("Tìm Thấy hàng bay");
            hangbay.get(SearchIndex(mahangbay)).output();
        }else{
            System.out.println("Không tìm thấy máy bay");
        }
    }
    @Override
    public void Delete() {
        System.out.println("enter hãng bay");
        String mahangbay=sc.nextLine();
        if(SearchIndex(mahangbay)!=-1){
            hangbay.remove(SearchIndex(mahangbay));
        }else{
            System.out.println("Không có hãng bay");
        }
    }
    public void DeleteHangBay(String mahangbay){
        Boolean check=false;
        for(HangBay i:hangbay){
            if(i.getMahangbay().compareTo(mahangbay)==0){
                check=true;
                hangbay.remove(i);
                break;
            }
        }
        if(!check){
            System.out.println("Không tồn tại hãng bay");
        }
    }
    public void MenuHangBay(){
        int lc;
        do{
            System.out.println("1. Xem các hãng bay");
            System.out.println("2. Tìm kiếm hãng Bay");
            System.out.println("3. Thêm hãng bay");
            System.out.println("4. Xóa hãng bay");
            System.out.println("5. Thoát");
            System.out.println("enter lc");
            lc=Check.CheckInput();
            switch (lc){
                case 1:
                    ouptut();
                    break;
                case 2:
                    Search();
                case 3:
                    input();
                    break;
                case 4:
                    Delete();
                    break;
            }
        }while(lc!=5);
    }
}
