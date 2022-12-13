import java.io.Serializable;
import java.util.Scanner;

public class HangBay implements Serializable {
    public static Scanner sc=new Scanner(System.in);
    private String mahangbay;
    private String tenhangbay;
    public HangBay(){}
    public HangBay(String mahangbay,String tenhangbay){
        this.mahangbay=mahangbay;
        this.tenhangbay=tenhangbay;
    }
    public void input(){
        System.out.println("Nhập mã hãng bay: ");
        this.mahangbay=sc.nextLine();
        System.out.println("Nhập tên hãng bay: " );
        this.tenhangbay=sc.nextLine();
    }
    public void output(){
//        System.out.println("MAHANGBAY: "+this.mahangbay);
//        System.out.println("TENHANGBAY: "+this.tenhangbay);
        System.out.printf("|%-10s|%-25s|\n",this.mahangbay,this.tenhangbay);
    }
    public String getMahangbay() {
        return mahangbay;
    }

    public void setMahangbay(String mahangbay) {
        this.mahangbay = mahangbay;
    }

    public String getTenhangbay() {
        return tenhangbay;
    }

    public void setTenhangbay(String tenhangbay) {
        this.tenhangbay = tenhangbay;
    }
}
