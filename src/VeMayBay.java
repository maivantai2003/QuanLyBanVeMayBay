import java.io.Serializable;
import java.util.Scanner;
public class VeMayBay implements Serializable {
    public static Scanner sc=new Scanner(System.in);
    private String mave;
    private String macb;
    private String soghe;
    private String trinhtrangve;
    private String tenhangve;
    private double giave;
    public VeMayBay(){

    }
    public VeMayBay(String mave,String macb,String tenhangve,String trinhtrangve,double giave){
        this.mave=mave;
        this.macb=macb;
        this.tenhangve=tenhangve;
        this.trinhtrangve=trinhtrangve;
        this.giave=giave;
    }

    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }
    public String getMacb() {
        return macb;
    }

    public void setMacb(String macb) {
        this.macb = macb;
    }

    public String getTenhangve() {
        return tenhangve;
    }

    public void setTenhangve(String tenhangve) {
        this.tenhangve = tenhangve;
    }


    public String getTrinhtrangve() {
        return trinhtrangve;
    }

    public void setTrinhtrangve(String trinhtrangve) {
        this.trinhtrangve = trinhtrangve;
    }

    public double getGiave() {
        return giave;
    }

    public String getSoghe() {
        return soghe;
    }
    public void setSoghe(String soghe) {
        this.soghe = soghe;
    }

    public void setGiave(double giave) {
        this.giave = giave;
    }
    public void output(){
        System.out.printf("|%-10s|%-20s|%-20s|%-15f|%-20s|%-10s|\n",this.mave,this.macb,this.tenhangve,this.giave,this.trinhtrangve,this.soghe);
    }

}
