import java.io.*;
import java.util.ArrayList;

public class FiLe {
    public static void CloseFile(InputStream is){
        if(is!=null){
            try{
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void CloseFile(OutputStream os){
        if(os!=null){
            try{
                os.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
//    public static void write(ArrayList<KhachHang> k) {
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(Khachhang,true);
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(k);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            CloseFile(fos);
//            CloseFile(oos);
//        }
//    }
//    public static void writeArray(ChuyenBay[] cb){
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        try {
//            fos = new FileOutputStream(new File("Chuyenbay.txt"));
//            oos = new ObjectOutputStream(fos);
//            oos.writeObject(cb);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            CloseFile(fos);
//            CloseFile(oos);
//        }
//    }
//    public static ChuyenBay[] readChuyenBay() throws RuntimeException {
//        ChuyenBay[] cb=null;
//        FileInputStream fin=null;
//        ObjectInputStream Objin=null;
//        try{
//            fin=new FileInputStream(new File(Khachhang));
//            Objin=new ObjectInputStream(fin);
//            cb=(ChuyenBay[])Objin.readObject();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } finally {
//            CloseFile(fin);
//            CloseFile(Objin);
//        }
//        return cb;
//    }
//    public static ArrayList<KhachHang> read(){
//       ArrayList<KhachHang> kh=new ArrayList<>();
//       FileInputStream fin=null;
//       ObjectInputStream Objin=null;
//       try{
//           fin=new FileInputStream(Khachhang);
//           Objin=new ObjectInputStream(fin);
//           kh=(ArrayList<KhachHang>)Objin.readObject();
//       } catch (FileNotFoundException e) {
//           throw new RuntimeException(e);
//       } catch (IOException e) {
//           throw new RuntimeException(e);
//       } catch (ClassNotFoundException e) {
//           throw new RuntimeException(e);
//       } finally {
//           CloseFile(fin);
//           CloseFile(Objin);
//       }
//       return kh;
//    }
//    public static void ReadData(ArrayList<KhachHang> k){
//        System.out.println("Thong tin khach hàng: ");
//        try{
//            for(KhachHang i:k){
//                i.output();
//            }
//        }catch (Exception e){
//            System.out.println("Empty file");
//        }
//    }
//    public static void ReadDataArray(KhachHang[] k){
//        System.out.println("Thong tin khach hàng: ");
//        try{
//            for(KhachHang i:k){
//                i.output();
//            }
//        }catch (Exception e){
//            System.out.println("Empty file");
//        }
//    }
//    public static void listchuyenbay(ChuyenBay cb){
//        FileInputStream fin=null;
//        ObjectInputStream Osin=null;
//        try{
//            fin=new FileInputStream(new File("Chuyenbay.txt"));
//            Osin=new ObjectInputStream(fin);
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try{
//                if(fin!=null){
//                    CloseFile(fin);
//                }
//                if(Osin!=null){
//                    CloseFile(Osin);
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//    }
//    public static void readChuyenbay(ChuyenBay cb[]){
//        try{
//            for(ChuyenBay i:cb){
//                i.output();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//    public static void writeNhanVien(ArrayList<NhanVien> nhanvien){
//        FileOutputStream fout=null;
//        ObjectOutputStream Oin=null;
//        try{
//            fout=new FileOutputStream(new File(Nhanvien),true);
//            Oin=new ObjectOutputStream(fout);
//            Oin.writeObject(nhanvien);
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            if(fout!=null){
//                CloseFile(fout);
//            }
//            if(Oin!=null){
//                CloseFile(Oin);
//            }
//        }
//    }
//    public static ArrayList<NhanVien>  readNhanVien(){
//        ArrayList<NhanVien> n=null;
//        FileInputStream fin=null;
//        ObjectInputStream Objin=null;
//        try{
//            fin=new FileInputStream(new File(Nhanvien));
//            Objin=new ObjectInputStream(fin);
//            n=(ArrayList<NhanVien>) Objin.readObject();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } finally {
//            CloseFile(fin);
//            CloseFile(Objin);
//        }
//        return n;
//    }
    public static Object WriteFile(Object write,String filename){
        FileInputStream fin=null;
        ObjectInputStream ofin=null;
        try{
            fin=new FileInputStream(new File(filename));
            ofin=new ObjectInputStream(fin);
            write=ofin.readObject();
        }catch (Exception e){
            System.out.println("Đọc dữ liệu thất bại");
            return null;
        }finally {
            CloseFile(fin);
            CloseFile(ofin);
        }
        System.out.println("Đọc dữ liệu thành công");
        return write;
    }
    public static void ReadFile(Object read,String filename){
        FileOutputStream fout=null;
        ObjectOutputStream ofout=null;
        try{
            fout=new FileOutputStream(new File(filename));
            ofout=new ObjectOutputStream(fout);
            ofout.writeObject(read);
            System.out.println("Lưu File Thành Công");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Lưu File Không Được");
        }finally {
            CloseFile(fout);
            CloseFile(ofout);
        }
    }
}
