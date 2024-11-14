
//App của mình

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class App{
    public static void main(String[] args) throws IOException{

        ListUser danhsachUser = new ListUser();
        danhsachUser.enterFile();
        Scanner sc = new Scanner(System.in);
        Student a = new Student();
        Teacher b  = new Teacher();
        int co;
do{     
    co = 0;
    System.out.println("~~~~~Dang Nhap~~~~~");
        System.out.print("Nhap ma so: ");
        String maso = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        String matKhau = sc.nextLine();
        for(int i = 0 ; i<danhsachUser.getListUser().size();i++){
            if(maso.equals(danhsachUser.getListUser().get(i).getID()) && matKhau.equals(danhsachUser.getListUser().get(i).getPassword())){
                co = 1;
                if(danhsachUser.getListUser().get(i) instanceof Student)
                    a = new Student((Student) danhsachUser.getListUser().get(i));
                if(danhsachUser.getListUser().get(i) instanceof Teacher)
                    b = new Teacher((Teacher) danhsachUser.getListUser().get(i));
            }
        }
        if(co == 0){
            System.out.println("Khong tim thay tai khoan");
        }
        

      
    }while(co == 0);

while(true){
    //Menu của teacher
    if(a.getID() == "" && b instanceof Teacher){
        Teacher teacher = new Teacher();
        for(int i = 0 ; i < danhsachUser.getListUser().size();i++){
            if(danhsachUser.getListUser().get(i).getID().equals(b.getID())){
                b = (Teacher) danhsachUser.getListUser().get(i);
            }
        }
        teacher = b;
        for(int i = 1 ; i<=50;i++) System.out.println("");
        System.out.println("~~~~~Chao mung den voi menu cua giang vien~~~~~");
        System.out.println("1. Xem thong tin cua giang vien");
        System.out.println("2. Xem thong tin sinh vien");
        System.out.println("3. Xem danh sach mon hoc");
        System.out.println("3. Tao bai thi");
        System.out.print("Lua chon cua ban: ");
        int chon = sc.nextInt();
        sc.nextLine();
        switch(chon){
            case 1:
            for(int i = 1 ; i<=50;i++) System.out.println("");
            System.out.println("Ban muon Xem thong tin gi");
            System.out.println("1. Xem thong tin cua ban");
            System.out.println("2. Xem thong tin cua tat ca giang vien");
            System.out.print("Lua chon cua ban: ");
            int chon1 = sc.nextInt();

            switch(chon1){
                case 1:
                for(int i = 1 ; i<=50;i++) System.out.println("");
                    System.out.println("=====Thong tin=====");
                    teacher.export();
                    System.out.println("1. Sua thong tin");
                    System.out.println("2. Them mon");
                    System.out.println("3. Xoa mon");
                    System.out.print("Lua chon cua ban: ");
                    int chonthongtin = sc.nextInt();
                    sc.nextLine();
                    switch(chonthongtin){
                        case 1:
                        for(int i = 1 ; i<=50;i++) System.out.println("");
                            String x;
                            System.out.println("=====Sua thong tin=====");
                            System.out.println("Chon thong tin can sua");
                            System.out.println("1. ID");
                            System.out.println("2. Ten");
                            System.out.println("3. Mat khau");
                            
                            System.out.print("Lua chon cua ban: ");
                            int chonsuathongtin = sc.nextInt();
                            sc.nextLine();
                            switch(chonsuathongtin){
                                case 1:
                                System.out.print("Nhap ID moi: ");
                                x = sc.nextLine();
                                teacher.setID(x);
                                danhsachUser.exportFile();
                                break;
                                case 2:
                                System.out.print("Nhap ten moi: ");
                                x = sc.nextLine();
                                teacher.setUsername(x);
                                danhsachUser.exportFile();
                                break;
                                case 3:
                                System.out.print("Nhap mat khau moi: ");
                                x = sc.nextLine();
                                teacher.setPassword(x);
                                danhsachUser.exportFile();
                                break;
                                default:
                                System.out.print("Ban nhap sai vui long nhap lai");
                                break;
                            }
                            break;
                        case 2:
                        for(int i = 1 ; i<=50;i++) System.out.println("");
                                Subject subadd = new Subject();
                                subadd.enter();
                                teacher.addSubject(subadd);
                                danhsachUser.exportFile();
                                break;
                        case 3:
                        for(int i = 1 ; i<=50;i++) System.out.println("");
                                System.out.print("Nhap ma so mon hoc can xoa: ");
                                String subremove = sc.nextLine();
                                teacher.removeSubject(subremove);
                                danhsachUser.exportFile();
                                break;
                        default:
                            System.out.println("Nhap sai");
                            break;
                    }
                    break;
                    case 2:
                        for(int i=1;i<=50;i++) System.out.println("");
                        System.out.println("=====Danh sach giang vien=====");
                        ListUser danhsachGiangVien = new ListUser();
                            danhsachGiangVien.enterFile();
                            danhsachGiangVien.listTeacher();
                        if(teacher.getPer() == 1){
                            System.out.println("===Quan ly danh sach giang vien===");
                            System.out.println("1. Them moi giang vien");
                            System.out.println("2. Sua thong tin giang vien");
                            System.out.println("3. Xoa giang vien");    
                            System.out.print("Lua chon cua ban: ");
                            int chonquanlydanhsach = sc.nextInt();
                            sc.nextLine();
                                switch(chonquanlydanhsach){
                                case 1:
                                    Teacher addTeacher = new Teacher();
                                    addTeacher.enter();
                                    danhsachUser.addTeacher(addTeacher);
                                    danhsachGiangVien.addTeacher(addTeacher);
                                    break;
                                case 2:
                                    System.out.print("Nhap ma giang vien muon sua: ");
                                    String teacherupdate = sc.nextLine();
                                    int coo = 0;
                                    for(int i=1;i<=50;i++) System.out.println("");
                                    for(int i = 0 ;i<danhsachUser.getListUser().size();i++){
                                        if(danhsachUser.getListUser().get(i).getID().equals(teacherupdate)){
                                            coo = 1;
                                            System.out.println("=====Sua thong tin=====");
                                            danhsachUser.getListUser().get(i).export();
                                            System.out.println("Chon thong tin can sua");
                                            System.out.println("1. ID");
                                            System.out.println("2. Ten");
                                            System.out.println("3. Mat khau");    
                                            System.out.println("4. Them mon giang day");
                                            System.out.println("5. Xoa mon giang day");                
                                            System.out.print("Lua chon cua ban: ");
                                            int chonsuathongtin = sc.nextInt();
                                            sc.nextLine();
                                            switch(chonsuathongtin){
                                                case 1:
                                                for(int j = 0 ; j < danhsachGiangVien.getListUser().size();j++)
                                                    if(danhsachGiangVien.getListUser().get(i).getID().equals(teacherupdate)){
                                                System.out.print("Nhap ID moi: ");
                                                String x = sc.nextLine();
                                                danhsachUser.getListUser().get(i).setID(x);
                                                danhsachGiangVien.getListUser().get(i).setID(x);
                                                danhsachGiangVien.exportFile();
                                                    }
                                                break;
                                                case 2:
                                                System.out.print("Nhap ten moi: ");
                                                String y = sc.nextLine();
                                                danhsachUser.getListUser().get(i).setUsername(y);
                                                danhsachUser.exportFile();
                                                break;
                                                case 3:
                                                System.out.print("Nhap mat khau moi: ");
                                                String z = sc.nextLine();
                                                danhsachUser.getListUser().get(i).setPassword(z);
                                                danhsachUser.exportFile();
                                                break;
                                                default:
                                                System.out.print("Ban nhap sai vui long nhap lai");
                                                break;
                                                case 4:
                                    
                                                Subject subadd = new Subject();
                                                subadd.enter();
                                                danhsachUser.getListUser().get(i).addSubject(subadd);
                                                break;
                                                    case 5:
                                                System.out.print("Nhap ma so mon hoc can xoa: ");
                                                String subremove = sc.nextLine();
                                                danhsachUser.getListUser().get(i).removeSubject(subremove);
                                                danhsachUser.exportFile();
                                                break;    
                                            }
                                            break;
                                        }
                                    }
                                    if(coo == 0) System.out.println("Khong tim thay giang vien co ID nhu ban vua nhap");
                                    break;
                                    case 3:
                                        System.out.print("Nhap ma giang vien muon xoa");
                                        String teacherRemove = sc.nextLine();
                                        danhsachUser.deleteUser(teacherRemove);
                                        danhsachUser.exportFile();   
                                        break;
                                                                  
                                    default:
                                        System.out.println("Nhap sai");
                                        break;
                            }
                        }
            }
            
            case 5:
                break;

            
            case 3:
                System.out.println("===Tao bai thi===");
                System.out.print("Nhap ten mon thi: ");
                








            break;

        }

        break;







    }
    continue;
}


danhsachUser.exportFile();
}}