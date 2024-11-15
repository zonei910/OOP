import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ListUser implements IFILE{
    private ArrayList<User> list;

    public ListUser(){
        list = new ArrayList<>();
    }
    public ListUser(ArrayList<User> list){
        this.list = list;
    }

    public void addStudent(Student a){
        list.add(a);
    }
    public void addStudent(){
        Student a = new Student();
        a.enter();
        list.add(a);
    }


    public void addTeacher(Teacher a){
        list.add(a);
    }

    public void addTeacher(){
        Teacher a = new Teacher();
        a.enter();
        list.add(a);
    }

    public ArrayList<User> getListUser(){
        return list;
    }

    public void setListUser(ArrayList<User> list){
        this.list = list;
    }

    public void editUser(String ms){
        Scanner sc = new Scanner(System.in);
        int co = 0;
        for(int i = 0 ;i<list.size();i++){
            if(list.get(i).equals(ms)){
                co = 1;
                if(list.get(i) instanceof Student){
                    Student a = (Student)list.get(i);
                    System.out.println("=====Sua thong tin sinh vien=====");
                    System.out.println("1 .ID");
                    System.out.println("2. Ten");
                    System.out.println("3. Mat khau");
                    System.out.println("4. Sua thong tin mon");
                    System.err.print("Lua chon cua ban: ");
                    int chon1 = sc.nextInt();
                    
                    
                }




            }
        }
        if(co == 0){
            System.out.println("Khong tim thay ID tuong ung");
        }
    }

    public void listStudent() throws FileNotFoundException{
        int co = 0;
        for(int i=0;i<list.size();i++){
            if(list.get(i) instanceof Student){
                list.get(i).export();
                co = 1;
                System.out.println("");
            }
        }
        if(co == 0) System.out.println("List dont have any Student");
    }

    public void listTeacher() throws FileNotFoundException , IOException{
        File file = new File("dsUser.txt");
        FileWriter fw = new FileWriter(file);
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i) instanceof Teacher){
                Teacher a = (Teacher)list.get(i);
                fw.write(list.get(i).getID() + ","+list.get(i).getUsername() +","+list.get(i).getPassword()+","+a.getPer() + "\n");
                for(int j = 0 ; j <list.get(i).getSubjectList().size();j++){
                    fw.write(list.get(i).getSubjectList().get(j).getID() + ","+ list.get(i).getSubjectList().get(j).getSubjName() + "\n");
                }
                fw.write("\n");
            }
            
        }
        fw.close();
    }


    public void listMe(String ms)throws IOException{
        File file = new File("dsUser.txt");
        FileWriter fw = new FileWriter(file);
        for(int i = 0 ; i < list.size() ; i++){
            if(list.get(i) instanceof Teacher && list.get(i).getID().equals(ms)){
                Teacher a = (Teacher)list.get(i);
                fw.write(list.get(i).getID() + ","+list.get(i).getUsername() +","+list.get(i).getPassword()+","+a.getPer() + "\n");
                for(int j = 0 ; j <list.get(i).getSubjectList().size();j++){
                    fw.write(list.get(i).getSubjectList().get(j).getID() + ","+ list.get(i).getSubjectList().get(j).getSubjName() + "\n");
                }
                fw.write("\n");
            }     
        }
        fw.close();
    }

    public void deleteUser(String ms){
        int co = 0;
        for(int i = 0 ;i<list.size() ; i++){
            if(list.get(i).getID().equals(ms)){
                co = 1;
                list.remove(i);
            }
        }
        if(co == 0) System.out.println("Khong the tim thay giang vien can xoa");
        else System.out.println("Giang vien da bi xoa");
    }

    // public void findUser(String ms){
    //     int co = 0 ;
    //     for(int i = 0 ;i<list.size();i++){
    //         if(list.get(i).getID().equals(ms)){
    //             co = 1;
    //             list.get(i).export();
    //             System.out.println("");
    //         }
    //     }
    //     if(co == 1) System.out.println("Cannot find any ID you wanna find");

    // }


     
    public void enter(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose who you want to add");
        System.out.println("1. Student");
        System.out.println("2. Teacher");
        System.out.print("Your choice: ");
        int chon = sc.nextInt();

        switch (chon) {
            case 1:
                Student a = new Student();
                a.enter();
                list.add(a);
                break;
            case 2:
                Teacher b = new Teacher();
                b.enter();
                list.add(b);
                break;
            default:
                break;
        }

    }

    public void export(){
        for(int i=0;i<list.size();i++){
            if(list.get(i) instanceof Student){
                System.out.println(list.get(i).getID() + ","+list.get(i).getUsername() +","+list.get(i).getPassword());
                for(int j = 0 ; j <list.get(i).getSubjectList().size();j++){
                    System.out.println(list.get(i).getSubjectList().get(j).getID() + ","+ list.get(i).getSubjectList().get(j).getSubjName() +","+ list.get(i).getSubjectList().get(j).getStatus() + "," +list.get(i).getSubjectList().get(j).getPoint()  );
                }
            }
        if(list.get(i) instanceof Teacher){
            Teacher a = new Teacher();
            a = (Teacher) list.get(i);
            System.out.println(a.getID() + ","+a.getUsername() +","+a.getPassword()+","+a.getPer());
            for(int j = 0 ; j <list.get(i).getSubjectList().size();j++){
                System.out.println(list.get(i).getSubjectList().get(j).getID() + ","+ list.get(i).getSubjectList().get(j).getSubjName());
            }
        }
        System.out.println("");
    }
    }
    public void exportFile() throws IOException{
        File file = new File("dsUser.txt");
        FileWriter fw = new FileWriter(file);
        for(int i = 0 ; i<list.size();i++){
            if(list.get(i) instanceof Student){
                fw.write("SinhVien"+","+list.get(i).getID()+","+list.get(i).getUsername()+","+list.get(i).getPassword()+"\n");
                for(int j = 0 ; j <list.get(i).getSubjectList().size();j++){
                    fw.write(list.get(i).getSubjectList().get(j).getID() + "," + list.get(i).getSubjectList().get(j).getSubjName()+","+ (int)list.get(i).getSubjectList().get(j).getStatus() +","+ (float)list.get(i).getSubjectList().get(j).getPoint()  +  '\n');
                }
            }
            if(list.get(i) instanceof Teacher){
                Teacher a = new Teacher();
                a = (Teacher) list.get(i);
                fw.write("GiangVien"+","+a.getID()+","+a.getUsername()+","+a.getPassword()+","+a.getPer() +"\n");
                for(int j = 0 ; j <list.get(i).getSubjectList().size();j++){
                    fw.write(a.getSubjectList().get(j).getID() + "," + a.getSubjectList().get(j).getSubjName() +"\n");
                }
            }   
            fw.write("\n");
        }
        fw.close();
    }
    
    public void enterFile() throws FileNotFoundException{
        File file = new File("dsUser.txt");
        Scanner sc = new Scanner(file);
        Student b = null;
        Teacher d = null;
        while(sc.hasNext()){
            String line = sc.nextLine();
            String [] argv = line.split(",");
            if(argv[0].equals("")){
                continue;
            }
            if(argv[0].equals("SinhVien") || argv[0].equals("GiangVien")){
                if(argv[0].equals("SinhVien")){
                b = new Student();
                b.setID(argv[1]);
                b.setUsername(argv[2]);
                b.setPassword(argv[3]);  
                list.add(b);
                }
                if(argv[0].equals("GiangVien")){
                    d = new Teacher();
                    d.setID(argv[1]);
                    d.setUsername(argv[2]);
                    d.setPassword(argv[3]);
                    d.setPer(Integer.parseInt(argv[4]));
                    list.add(d);
                }
            }else{
                if(argv.length == 4){
                Subject c = new Subject();
                c.setID(argv[0]);
                c.setSubjName(argv[1]);
                float score = Float.parseFloat(argv[3]);
                int status = Integer.parseInt(argv[2]);
                c.setPoint(score);
                c.setStatus(status);
                b.addSubject(c);
                }
                if(argv.length == 2){
                    Subject c = new Subject();
                    c.setID(argv[0]);
                    c.setSubjName(argv[1]);
                    d.addSubject(c);
                }
            }
        }
    }


}
