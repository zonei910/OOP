import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


//Chức vụ , Mã số , Tên tài khoản , Mật khẩu
public class ListAccount{
    private ArrayList<User> accounts;
    private int status;   
    public ListAccount() throws FileNotFoundException{
        status = 0;
        accounts = new ArrayList<User>();
        File file = new File("danhsachtaikhoan.txt");
        Scanner sc = new Scanner(file);   
        while(sc.hasNext()){
            String line = sc.nextLine();
            String [] arr = line.split(",");
            if(arr[0].equals("SinhVien")){
                User a = new Student();
                    a.setID(arr[1]);
                    a.setUsername(arr[2]);
                    a.setPassword(arr[3]);
                   accounts.add(a);
            }
            if(arr[0].equals("GiangVien")){
                User a = new Teacher();
                a.setID(arr[1]);
                a.setUsername(arr[2]);
                a.setPassword(arr[3]);
                accounts.add(a);
             }
    }
}

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public User getUser(int i){
        return accounts.get(i);
    }

    public ArrayList<User> getAccountList() {
        return accounts;
    }

    public void removeAccount(String ms){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getID().equals(ms)){
                accounts.remove(i);
    }
            }
    }

    public void findAccount(String ms){
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getID().equals(ms)){
                 accounts.get(i).exportTaiKhoan();
            }
    }
            }

    public void editAccount(String ms){
        int co = 0;
        Scanner sc = new Scanner((System.in));
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i).getID().equals(ms)){
                co = 1;
                System.out.println("Ban muon sua gi");
                System.out.println("1. Username");
                System.out.println("2. Password");
                System.out.println("3. Ma so");
                System.out.print("Lua chon cua ban: ");
                int chon = sc.nextInt();
                sc.nextLine();
                String moi;
                switch(chon){
                    case 1:
                        System.out.print("Nhap ten moi: ");
                        moi = sc.nextLine();
                        accounts.get(i).setUsername(moi);
                        break;
                    case 2:
                        System.out.print("Nhap mat khau moi: ");
                        moi = sc.nextLine();
                        accounts.get(i).setPassword(moi);
                        break;
                    case 3:
                        System.out.print("Nhap ma so moi: ");
                        moi = sc.nextLine();
                        accounts.get(i).setID(moi);
                        break;
                    default:
                        System.out.println("Ban khong muon sua gi ca");
                        break;
                }
            }
        }
        if(co == 0) System.out.println("Khong tim thay sinh vien ban muon tim");

}

    public void addAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap doi tuong ban muon them vao");
        System.out.println("1. Sinh vien");
        System.out.println("2. Giang vien");
        System.out.print("Lua chon cua ban: ");
        int chon = sc.nextInt();
        sc.nextLine();
        User a;
        switch (chon) {
            case 1:
                a = new Student();
                a.enterTaiKhoan();
                accounts.add(a);
                break;
            case 2:
                a = new Teacher();
                a.enterTaiKhoan();
                accounts.add(a);
                break;
            default:
                System.out.println("Ban nhap sai vui long nhap lai");
                break;
        }
    }

    public void export(){
        for(int i = 0 ; i <accounts.size() ; i++){
            accounts.get(i).exportTaiKhoan();
        }
    }

    public void exportFile() throws IOException{
        File file = new File("danhsachtaikhoan.txt");
        FileWriter fileW = new FileWriter(file);
        for(int i = 0; i < accounts.size(); i++){
            if(accounts.get(i) instanceof Student){
                fileW.write("SinhVien,"+accounts.get(i).getID()+","+accounts.get(i).getUsername()+","+accounts.get(i).getPassword()+"\n");
            }
            if(accounts.get(i) instanceof Teacher){
                fileW.write("GiangVien,"+accounts.get(i).getID()+","+accounts.get(i).getUsername()+","+accounts.get(i).getPassword()+"\n");
            }
        }
        fileW.close();
    }



}