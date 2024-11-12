import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements IInOut{
    // Danh sách các môn đã , đang học => status = 1 đã học , đang thi , status = 0 chưa học
    private ArrayList<Subject>  subjects;
    // Mã sinh viên
    private String mssv;


    public Student(){
        super();
        mssv = "";
        subjects = new ArrayList<Subject>();
    }

    public Student(String username, String password, String mssv , ArrayList<Subject> subjects) {
        super(username, password);
        this.mssv = mssv;
        this.subjects = subjects;
    }

    public Student(Student student){
       super(student.getUsername() , student.getPassword());
        this.mssv = student.getID();
        subjects = student.getSubjectList();
    }

    @Override
    public String getID(){
        return mssv;
    }
    @Override
    public void setID(String mssv){
        this.mssv = mssv;
    }

    public void addSubjectToStudent(Subject a){
        subjects.add(a);
    }

    public void removeSubjectOfStudent(String ms){
        for(int i = 0 ;i<subjects.size();i++)
            if(subjects.get(i).getID().equals(ms))
                subjects.remove(i);
    }

    public ArrayList<Subject> getSubjectList(){
        return subjects;
    }

    public Subject getSubjectOfStudent(String ms){
        for(int i=0;i<subjects.size();i++)
            if(subjects.get(i).getID().equals(ms))
                return subjects.get(i);

        return null;
    }
    

    public float getGPA(){
        float s = 0;
        for(int i = 0 ; i < subjects.size(); i++)
            s = s + subjects.get(i).getPoint();
            return s/subjects.size();
    }



  
    
    public void enter(){
        Scanner sc = new Scanner(System.in);
        String x;
        int k;
        super.enter();
        System.out.print("Nhap ma so sinh vien: ");
        x = sc.nextLine();
        mssv = x;

        System.out.print("Nhap so luong mon sinh vien muon dang ki: ");
        int n = sc.nextInt();
        sc.nextLine();
        subjects = new ArrayList<>();
        for(int i = 0 ; i<n;i++){
            Subject a = new Subject();

            System.out.print("Nhap ten mon hoc: ");
            x = sc.nextLine();
            a.setSubjName(x);
            System.out.print("Nhap ma mon hoc: ");
            x = sc.nextLine();
            a.setID(x);
            System.out.print("Nhap trang thai cua sinh vien voi mon hoc: ");
            k = sc.nextInt();
            sc.nextLine();
            a.setStatus(k);
            if(k == 0) a.setPoint(0);
            else{
                System.out.print("Nhap diem sinh vien doi voi mon hoc: ");
                k = sc.nextInt();
                sc.nextLine();
                a.setPoint(k);
            }
            subjects.add(a);
        }

    }

    public void export(){
        super.export();
        for(int i = 0 ; i<subjects.size();i++){
            subjects.get(i).export();
        }
    }


}

