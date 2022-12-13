import java.io.Serializable;

public class PhieuDatCho implements Serializable {
    private String madatcho;
    private String soghe;
    private String makhachhang;
    private String machuyenbay;
    private String ngay;
    private String mave;
    private double gia;
    public PhieuDatCho(){}
    public PhieuDatCho(String madatcho,String soghe,String makhachhang,String machuyenbay,String ngay,String mave,double gia){
        this.madatcho=madatcho;
        this.soghe=soghe;
        this.makhachhang=makhachhang;
        this.machuyenbay=machuyenbay;
        this.ngay=ngay;
        this.mave=mave;
        this.gia=gia;
    }

    public String getMadatcho() {
        return madatcho;
    }

    public void setMadatcho(String madatcho) {
        this.madatcho = madatcho;
    }

    public String getSoghe() {
        return soghe;
    }

    public void setSoghe(String soghe) {
        this.soghe = soghe;
    }

    public String getMakhachhang() {
        return makhachhang;
    }

    public void setMakhachhang(String makhachhang) {
        this.makhachhang = makhachhang;
    }

    public String getMachuyenbay() {
        return machuyenbay;
    }

    public void setMachuyenbay(String machuyenbay) {
        this.machuyenbay = machuyenbay;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void output(){
        System.out.printf("|%-20s|%-15s|%-15s|%-20s|%-15s|%-15s|%-20f|\n",madatcho,makhachhang,machuyenbay,ngay,mave,soghe,gia);
    }
}
