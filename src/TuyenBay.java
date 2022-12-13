import java.io.Serializable;
import java.util.Scanner;

public class TuyenBay implements Serializable {
    public static Scanner sc=new Scanner(System.in);
    private String matuyenbay;
    private SanBay sanden,sandi;
    public TuyenBay(){
        sanden=new SanBay();
        sandi=new SanBay();
    }
    public TuyenBay(String matuyenbay,SanBay sandi,SanBay sanden){
        this.matuyenbay=matuyenbay;
        this.sandi=sandi;
        this.sanden=sanden;
    }
    public TuyenBay(SanBay sandi,SanBay sanden){
        this.sandi=sandi;
        this.sanden=sanden;
        this.matuyenbay=(this.sandi.getMasanbay()+"-"+this.sanden.getMasanbay()).toString();
    }
    public String getMatuyenbay() {
        return matuyenbay;
    }

    public void setMatuyenbay(String matuyenbay) {
        this.matuyenbay = matuyenbay;
    }

    public SanBay getSandi() {
        return sandi;
    }

    public void setSandi(SanBay sandi) {
        this.sandi = sandi;
    }

    public SanBay getSanden() {
        return sanden;
    }

    public void setSanden(SanBay sanden) {
        this.sanden = sanden;
    }

    public void input(){
        System.out.println("Sân bay đi: ");
        this.sandi.input();
        System.out.println("Sân bay đến: ");
        this.sanden.input();
        this.matuyenbay=this.sandi.getMasanbay()+"-"+this.sanden.getMasanbay();
    }
    public void output(){
        System.out.printf("|%-12s|%-30s|%-15s|%-30s|%-15s|\n",this.getMatuyenbay(),this.getSandi().getTensanbay(),this.getSandi().getTinhthanhpho(),this.getSanden().getTensanbay(),this.getSanden().getTinhthanhpho());
    }
}
