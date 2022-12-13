import java.io.Serializable;
import java.util.Scanner;

public class SanBay implements Serializable {
    public static Scanner sc=new Scanner(System.in);
    private String masanbay;
    private String tensanbay;
    private String tinhthanhpho;
    public SanBay(){

    }
    public SanBay(String masanbay,String tensanbay,String tinhthanhpho){
        this.masanbay=masanbay;
        this.tensanbay=tensanbay;
        this.tinhthanhpho=tinhthanhpho;
    }
    public String getMasanbay() {
        return masanbay;
    }

    public void setMasanbay(String masanbay) {
        this.masanbay = masanbay;
    }

    public String getTensanbay() {
        return tensanbay;
    }

    public void setTensanbay(String tensanbay) {
        this.tensanbay = tensanbay;
    }

    public String getTinhthanhpho() {
        return tinhthanhpho;
    }
    public void setTinhthanhpho(String tinhthanhpho) {
        this.tinhthanhpho = tinhthanhpho;
    }

    public void input(){
        System.out.println("enter masanbay: ");
        this.masanbay=sc.nextLine();
        System.out.println("enter tensanbay: ");
        this.tensanbay=sc.nextLine();
        System.out.println("enter tỉnh thành phố");
        this.tinhthanhpho=sc.nextLine();
    }
    public void output(){
        System.out.println("MASANBAY: "+this.masanbay);
        System.out.println("TENSANBAY: "+this.tensanbay);
        System.out.println("TINHTHANHPHO: "+this.tinhthanhpho);
    }
}
