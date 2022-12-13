import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Check implements Serializable {
    public static Scanner sc=new Scanner(System.in);
    public static int CheckInput(){
        int n;
        while (true){
            try{
                n=Integer.parseInt(sc.nextLine());
                if(n<0){
                    System.out.println("Phải >=0");
                }else{
                    return n;
                }
            }catch (Exception e){
                System.out.println("Chỉ được nhập số");
            }
        }
    }
    public static double CheckInputDouble(){
        double n;
        while (true){
            try{
                n=Double.parseDouble(sc.nextLine());
                if(n<0){
                    System.out.println("Phải >=0");
                }else{
                    return n;
                }
            }catch (Exception e){
                System.out.println("Chỉ được nhập số");
            }
        }
    }
    public static String CheckInputGmail(){
        String n;
        while (true){
            n=sc.nextLine();
            if(n.endsWith("@gmail.com") || n.endsWith("@gmail.vn")){
                break;
            }else{
                System.out.println("enter again: ");
            }
        }
        return n;
    }
    public static long CheckInputLong(){
        long n;
        while (true){
            try{
                n=Long.parseLong(sc.nextLine());
                if(n<0){
                    System.out.println("Phải >=0");
                }else{
                    return n;
                }
            }catch (Exception e){
                System.out.println("Chỉ được nhập số");
            }
        }
    }
    public static String checkInputString(){
        String str;
        while(true){
            try{
                str = sc.nextLine();
                if(str.isEmpty())
                    System.out.println("Bạn chưa có nhập gì hết");
                else if(str.length() > 12)
                    System.out.println("Chiều dài chuỗi vượt quá 12");
                else
                    return str;
            }catch (NoSuchElementException e){
                System.out.println("Bạn chưa có nhập gì hết");
            }
        }
    }
    public static String checkDate()
    {
        String str;
        while (true){
            try
            {
                str=sc.nextLine();
                String []part = str.split("/");
                int day = Integer.parseInt(part[0]);
                int month = Integer.parseInt(part[1]);
                int year = Integer.parseInt(part[2]);
                if(day <= 0 || day > 31)
                    System.out.println("enter again");
                if(month <= 0 || month >= 13)
                    System.out.println("enter agian");
                else
                break;
            } catch (NumberFormatException | IndexOutOfBoundsException e)
            {
                System.out.println("enter again");
            }
        }
        return str;
    }
}
