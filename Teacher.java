
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Teacher extends User implements IInOut{
    // Mã giảng viên
    private String msgv;
    private int permission;
    // Danh sách môn dạy 
    private ArrayList<Subject>  subjects; 
    // Thêm danh sách môn học gấp rồi sửa 2 thằng
     

    public Teacher(){
        super();
        msgv = "";
        permission = 0;
        subjects = new ArrayList<>();
    }

    public Teacher(String mgv , int permission , ArrayList<Subject> hihi){
        this.msgv = mgv;
        permission = permission;
        subjects = hihi;
    }

    public Teacher(Teacher teacher){
        super(teacher.getUsername() , teacher.getPassword());
        this.msgv = teacher.getID();
    }

    public void addSubject(Subject a){
        subjects.add(a);
    }

    public ArrayList<Subject> getSubjectList(){
        return subjects;
    }

    public void removeSubject(String ms){
        for(int i = 0 ; i<subjects.size();i++)
            if(subjects.get(i).getID().equals(ms))
                subjects.remove(i);
    }
    public int getPer(){
        return permission;
    }

    public void setPer(int per){
        permission = per;
    }
    


    @Override
    public String getID(){
        return msgv;
    }
    @Override
    public void setID(String mgv){
        this.msgv = mgv;
    }

    public void enter(){
        Scanner sc = new Scanner(System.in);
        String x;
        int k;
        super.enter();
        System.out.print("Nhap ma so giang vien: ");
        x = sc.nextLine();
        msgv = x;
        System.out.print("Nhap so mon giang day: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i <n ; i++){
                Subject a = new Subject();
                System.out.print("Nhap ma mon hoc: ");
                x = sc.nextLine();
                a.setID(x);
                System.out.print("Nhap ten mon hoc: ");
                x = sc.nextLine();
                a.setSubjName(x);
                subjects.add(a);
        }
    }

    public void export() throws FileNotFoundException{
        super.export();
        System.out.println("Ma giang vien: "+getID());
        if(getPer() == 1){
            System.out.println("Giang vien co quyen Admin");
        }else{
            System.out.println("Giang vien khong co quyen Admin");
        }
        System.out.println("");
        for(int i = 0 ; i<getSubjectList().size();i++){
            System.out.println("Ma so mon hoc: "+getSubjectList().get(i).getID());
            System.out.println("Ten mon hoc: "+getSubjectList().get(i).getSubjName());
            System.out.println("");
        }
        System.out.println("===============================================");
    }


    public void editSubj(){
        Scanner sc = new Scanner(System.in);
        System.out.println("=====Sua thong tin mon cua giang vien=====");
        System.out.print("Nhap ma mon muon sua: ");
        String x = sc.nextLine();
        int co = 0;
        for(int i = 0 ; i<getSubjectList().size();i++){
            if(subjects.get(i).equals(x)){
                co = 1;
                System.out.println("1. Sua ten mon hoc ");
                System.out.println("2. Sua ma mon hoc");
                System.out.print("Lua chon cua ban");
                int chon = sc.nextInt();
                sc.nextLine();
                String y;
                switch(chon){
                    case 1:
                        System.out.print("Nhap ten mon hoc moi: ");
                        y = sc.nextLine();
                }
            
            }

        }


}
}