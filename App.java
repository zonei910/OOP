
//App của mình
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;

public class App{
    public static void main(String[] args) throws IOException{ 
do{
    int me = 0;
    ListUser danhsachUser = new ListUser();
    danhsachUser.enterFile();
    Scanner sc = new Scanner(System.in);
    Student a = new Student();
    Teacher b  = new Teacher();
    int co;
do{     
    for(int i=0;i<50;i++) System.out.println("");
    co = 0;
    System.out.println("~~~~~Dang Nhap~~~~~");
        System.out.print("Nhap ma so: ");
        String maso = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        String matKhau = sc.nextLine();
        for(int i = 0 ; i<danhsachUser.getListUser().size();i++){
            if(maso.equals(danhsachUser.getListUser().get(i).getID()) && matKhau.equals(danhsachUser.getListUser().get(i).getPassword())){
                co = 1;
                if(danhsachUser.getListUser().get(i) instanceof Student){
                    a = new Student((Student) danhsachUser.getListUser().get(i));
                    me = i;
                }
                if(danhsachUser.getListUser().get(i) instanceof Teacher){
                    b = new Teacher((Teacher) danhsachUser.getListUser().get(i));
                    me = i;
                }
            }
        }
        if(co == 0){
            System.out.println("Khong tim thay tai khoan");
        }
        

      
    }while(co == 0);

while(true){
    //Menu của teacher
    int menuGV = 0;
    if(a.getID().equals("") && b instanceof Teacher){ 
        Teacher teacher = new Teacher();
        for(int i = 0 ; i < danhsachUser.getListUser().size();i++){
            if(danhsachUser.getListUser().get(i).getID().equals(b.getID())){
                b = (Teacher) danhsachUser.getListUser().get(i);
            }
        }
        teacher = b;
        for(int i = 1 ; i<=50;i++) System.out.println("");
        int co1 = 0;
        do{
        System.out.println("~~~~~Chao mung den voi menu cua giang vien~~~~~");
        System.out.println("1. Xem thong tin cua giang vien");
        System.out.println("2. Xem thong tin sinh vien");
        System.out.println("3. Xem danh sach mon hoc");
        System.out.println("4. Xem danh sach de thi");
        System.out.println("5. Thoat dang nhap");
        System.out.print("Lua chon cua ban: ");
        int chon = sc.nextInt();
        sc.nextLine();
        switch(chon){
            case 1:
            int co2 = 0;
        do{
            for(int i = 1 ; i<=50;i++) System.out.println("");
            System.out.println("Ban muon Xem thong tin gi");
            System.out.println("1. Xem thong tin cua ban");
            System.out.println("2. Xem thong tin cua tat ca giang vien");
            System.out.println("3. Quay lai menu chinh");
            System.out.println("4. Thoat dang nhap");
            System.out.print("Lua chon cua ban: ");
            int chon1 = sc.nextInt();
            sc.nextLine();
            switch(chon1){
                case 1:
                int co3 = 0;
                do{
                for(int i = 1 ; i<=50;i++) System.out.println("");
                    System.out.println("=====Thong tin=====");
                    teacher.export();
                    ListUser info_me = new ListUser();
                    info_me.setListUser(danhsachUser.getListUser());
                    info_me.listMe(teacher.getID());
                    System.out.println("1. Sua thong tin");
                    System.out.println("2. Them mon");
                    System.out.println("3. Xoa mon");
                    System.out.println("4. Quay lai");
                    System.out.println("5. Thoat dang nhap");
                    System.out.print("Lua chon cua ban: ");
                    int chonthongtin = sc.nextInt();
                    sc.nextLine();
                    switch(chonthongtin){
                        case 1:
                        int co4 = 0;
                        do{
                        for(int i = 1 ; i<=50;i++) System.out.println("");
                            String x;
                            System.out.println("=====Sua thong tin=====");
                            System.out.println("Chon thong tin can sua");
                            System.out.println("1. ID");
                            System.out.println("2. Ten");
                            System.out.println("3. Mat khau");
                            System.out.println("4. Quay lai");
                            System.out.println("5. Thoat dang nhap");
                            System.out.print("Lua chon cua ban: ");
                            int chonsuathongtin = sc.nextInt();
                            sc.nextLine();
                            
                            switch(chonsuathongtin){
                                case 1:
                                System.out.print("Nhap ID moi: ");
                                x = sc.nextLine();
                                teacher.setID(x);
                                info_me.listMe(teacher.getID());
                                break;
                                case 2:
                                System.out.print("Nhap ten moi: ");
                                x = sc.nextLine();
                                teacher.setUsername(x);
                                info_me.listMe(teacher.getID());
                                break;
                                case 3:
                                System.out.print("Nhap mat khau moi: ");
                                x = sc.nextLine();
                                teacher.setPassword(x);
                                info_me.listMe(teacher.getID());
                                break;
                                case 5:
                                    co1 =1;
                                    co2 = 1;
                                    co3 = 1;
                                    co4 = 1;
                                    menuGV = 1;
                                    break;
                                case 4:
                                    co1 = 0;
                                    co2 = 0;
                                    co3 = 0;
                                    menuGV = 0;
                                    co4 = 1;
                                    break;
                                default:
                                System.out.print("Ban nhap sai vui long nhap lai");
                                break;
                            }
                        }while(co4 == 0);
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
                        case 4:
                            co2 = 0;
                            menuGV = 0;
                            co1 = 0;
                            co3 = 1;
                            break;
                        case 5:
                            co2 = 1;
                            co1 = 1;
                            co3 = 1;
                            menuGV = 1;
                            break;
                        default:
                            System.out.println("Nhap sai");
                            break;
                    }

                 }while(co3 == 0); 
                    break;
                    case 2:
                        int co5 = 0;
                        do{
                        for(int i=1;i<=50;i++) System.out.println("");
                        System.out.println("=====Danh sach giang vien=====");
                        ListUser danhsachGiangVien = new ListUser();
                            danhsachGiangVien.setListUser(danhsachUser.getListUser());
                            danhsachGiangVien.listTeacher();
                            danhsachGiangVien.export();
                        if(teacher.getPer() == 1){
                            System.out.println("===Quan ly danh sach giang vien===");
                            System.out.println("1. Them moi giang vien");
                            System.out.println("2. Sua thong tin giang vien");
                            System.out.println("3. Xoa giang vien");   
                            System.out.println("4. Quay lai");
                            System.out.println("5. Thoat dang nhap"); 
                            System.out.print("Lua chon cua ban: ");
                            int chonquanlydanhsach = sc.nextInt();
                            sc.nextLine();
                                switch(chonquanlydanhsach){
                                case 1:
                                    Teacher addTeacher = new Teacher();
                                    addTeacher.enter();
                                    danhsachUser.addTeacher(addTeacher);
                                    danhsachGiangVien.setListUser(danhsachUser.getListUser());
                                    danhsachGiangVien.listTeacher();
                                    break;
                                case 2:
                                int co6 = 0;
                                do{
                                    System.out.print("Nhap ma giang vien muon sua: ");
                                    String teacherupdate = sc.nextLine();
                                    int coo = 0;
                                    for(int i=1;i<=50;i++) System.out.println("");
                                    for(int i = 0 ;i<danhsachUser.getListUser().size();i++){
                                        if(danhsachUser.getListUser().get(i).getID().equals(teacherupdate)){
                                            coo = 1;
                                            System.out.println("=====Quan ly thong tin=====");
                                            danhsachUser.getListUser().get(i).export();
                                            System.out.println("Chon thong tin can sua");
                                            System.out.println("1. ID");
                                            System.out.println("2. Ten");
                                            System.out.println("3. Mat khau");    
                                            System.out.println("4. Them mon giang day");
                                            System.out.println("5. Xoa mon giang day");    
                                            System.out.println("6. Quay lai");
                                            System.out.println("7. Thoat dang nhap");            
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
                                                danhsachGiangVien.setListUser(danhsachUser.getListUser());
                                                danhsachGiangVien.listTeacher();
                                                    }
                                                break;
                                                case 2:
                                                System.out.print("Nhap ten moi: ");
                                                String y = sc.nextLine();
                                                danhsachUser.getListUser().get(i).setUsername(y);
                                                danhsachGiangVien.setListUser(danhsachUser.getListUser());
                                                danhsachGiangVien.listTeacher();
                                                break;
                                                case 3:
                                                System.out.print("Nhap mat khau moi: ");
                                                String z = sc.nextLine();
                                                danhsachUser.getListUser().get(i).setPassword(z);
                                                danhsachGiangVien.setListUser(danhsachUser.getListUser());
                                                danhsachGiangVien.listTeacher();
                                                break;
                                                
                                                case 4:
                                                Subject subadd = new Subject();
                                                subadd.enter();
                                                danhsachUser.getListUser().get(i).addSubject(subadd);
                                                danhsachGiangVien.setListUser(danhsachUser.getListUser());
                                                danhsachGiangVien.listTeacher();
                                                break;
                                                    case 5:
                                                System.out.print("Nhap ma so mon hoc can xoa: ");
                                                String subremove = sc.nextLine();
                                                danhsachUser.getListUser().get(i).removeSubject(subremove);
                                                danhsachGiangVien.setListUser(danhsachUser.getListUser());
                                                danhsachGiangVien.listTeacher();
                                                break;    

                                                    case 6:
                                                        co5 = 0;
                                                        co6 = 1;
                                                        break;
                                                    case 7:
                                                        co1 = 1;
                                                        co2 = 1;
                                                        co3 = 1;
                                                        co5 = 1;
                                                        co6 = 1;
                                                        break;
                                                default:
                                                System.out.print("Vui long nhap lai");
                                                break;
                                        
                                            }

                                        }
                                    }
                                    if(coo == 0) {
                                        System.out.println("Khong tim thay giang vien co ID nhu ban vua nhap");
                                        co6 = 1;
                                        co5 =0;
                                    }
                                }while(co6 == 0);
                                    break;
                                    //



                                    case 3:
                                        System.out.print("Nhap ma giang vien muon xoa: ");
                                        String teacherRemove = sc.nextLine();
                                        danhsachUser.deleteUser(teacherRemove); 
                                        danhsachGiangVien.setListUser(danhsachUser.getListUser());
                                        danhsachGiangVien.listTeacher();
                                        break;
                                    
                                     case 4:
                                        co1 = 0;
                                        co2 = 0;
                                        co5 = 1;   
                                        menuGV = 0;
                                        break;
                                    case 5:
                                        co1 = 1;
                                        co2 = 1;
                                        co5 = 1;
                                        menuGV = 1;
                                        break;


                                    default:
                                        System.out.println("Nhap sai");
                                        break;
                            }
                        }
                        }while(co5 == 0);
                       break;
                case 3:
                        co2 = 1;
                        co1 = 0;
                        menuGV = 0;
                        break;
                case 4:
                        co1 = 1;
                        menuGV = 1;
                        co2 = 1;
                        break;
                default:
                        System.out.println("Vui long nhap lai");
                        break;
            }
        
            //
        }while(co2 == 0);
          break;
          

            
          


            case 5:
                co1 = 1;
                menuGV = 1;
                break;

            default:
            System.out.println("Ban nhap khong chinh xac vui long nhap lai");
            break;
    }

        
       
    danhsachUser.exportFile();
    }while(co1 == 0);
    if(menuGV == 1) break;
}
    
    //menu sinh vien
    if(b.getID().equals("") && a instanceof Student){
        Student student = new Student();
        for(int i = 0 ; i < danhsachUser.getListUser().size();i++){
            if(danhsachUser.getListUser().get(i).getID().equals(a.getID())){
                a = (Student) danhsachUser.getListUser().get(i);
            }
        }
        student = (Student) a;
        int menuSV = 0;
        do{
            for(int i=0;i<50;i++) System.out.println("");
        System.out.println("~~~~~Chao mung den voi menu sinh vien~~~~~");
        System.out.println("1. Xem thong tin cua ban");
        System.out.println("2. Vao thi");
        System.out.println("3. Dang ki mon");
        System.out.println("4. Thoat dang nhap");
        System.out.print("Lua chon cua ban: ");
        int chon = sc.nextInt();
        sc.nextLine();
            switch(chon){
                case 1:
                int co1 = 0;
                for(int i=0;i<50;i++) System.out.println("");
                do{
                    student.export();
                    System.out.println("=====Quan ly thong tin=====");
                    System.out.println("1. Doi mat khau");
                    System.out.println("2. Doi ten");
                    System.out.println("3. Xem thong tin cac mon hoc");
                    System.out.println("4. Quay lai");
                    System.out.println("5. THoat dang nhap");
                    System.out.print("Lua chon cua ban: ");
                    int chon1 = sc.nextInt();
                    sc.nextLine();
                    switch(chon1){
                        case 1:
                        System.out.print("Nhap mat khau moi: ");
                        String mkmoi = sc.nextLine();
                        student.setPassword(mkmoi);
                        danhsachUser.getListUser().get(me).setPassword(mkmoi);
                        break;

                        case 2:
                        System.out.print("Nhap ten moi: ");
                        String tenmoi = sc.nextLine();
                        student.setUsername(tenmoi);
                        danhsachUser.getListUser().get(me).setUsername(tenmoi);
                        break;

                        case 3:
                        student.showSubject();
                        break;



                        case 4:
                            co1 =1;
                            menuSV =0;
                            break;
                        case 5:
                            co1 = 1;
                            menuSV = 1;
                            break;

                        default:
                            System.out.println("Vui long nhap lai");
                            break;
                    }
                    }while(co1 == 0);
                break;


                case 4:
                    menuSV = 1;
                    break;
                default:
                    System.out.println("Vui long nhap lai");
                    break;
            }


        }while(menuSV == 0);
        danhsachUser.exportFile();
    }








    break;
}
}while(true);
}}