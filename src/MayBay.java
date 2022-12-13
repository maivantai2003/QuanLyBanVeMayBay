import java.io.Serializable;
import java.util.Scanner;

public class MayBay implements Serializable {
    public static Scanner sc=new Scanner(System.in);
    private String mamaybay;
    private String tenmaybay;
    private int ghephothong;
    private int ghethuonggia;
    private int tongsoghe;
    public MayBay(){}
    public MayBay(String mamaybay,String tenmaybay,int ghephothong,int ghethuonggia){
        this.mamaybay=mamaybay;
        this.tenmaybay=tenmaybay;
        this.ghephothong=ghephothong;
        this.ghethuonggia=ghethuonggia;
        this.tongsoghe=this.ghephothong+this.ghethuonggia;
    }

    public String getMamaybay() {
        return mamaybay;
    }

    public void setMamaybay(String mamaybay) {
        this.mamaybay = mamaybay;
    }

    public String getTenmaybay() {
        return tenmaybay;
    }

    public void setTenmaybay(String tenmaybay) {
        this.tenmaybay = tenmaybay;
    }

    public int getGhephothong() {
        return ghephothong;
    }

    public void setGhephothong(int ghephothong) {
        this.ghephothong = ghephothong;
    }

    public int getGhethuonggia() {
        return ghethuonggia;
    }

    public void setGhethuonggia(int ghethuonggia) {
        this.ghethuonggia = ghethuonggia;
    }
    public void input(){
        System.out.println("Nhập tên máy bay: ");
        this.tenmaybay=sc.nextLine();
        System.out.println("Nhập số ghế phổ thông: ");
        this.ghephothong=Check.CheckInput();
        System.out.println("Nhập số ghế thương gia: ");
        this.ghethuonggia=Check.CheckInput();
        this.tongsoghe=getTongSoGhe();

    }
    public void output(){
//        System.out.println("MAMAYBAY: "+this.mamaybay);
//        System.out.println("TENMAYBAY: "+this.tenmaybay);
//        System.out.println("GHEPHOTHONG: "+this.ghephothong);
//        System.out.println("GHETHUONGGIA: "+this.ghethuonggia);
//        System.out.println("TONGSOGHE: "+this.tongsoghe);
        System.out.printf("|%-10s|%-18s|%-14d|%-14d|%-14d|\n",this.mamaybay,this.tenmaybay,this.getGhephothong(),this.getGhethuonggia(),this.getTongSoGhe());
    }
    public int getTongSoGhe(){
        return this.ghephothong+this.ghethuonggia;
    }
}
