import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User implements IInOut{
    // Danh sách các môn đã , đang học => status = 1 đã học , đang thi , status = 0 chưa học
    private ArrayList<Subject>  subjects;
    private ArrayList<Exam> exam;
    // Mã sinh viên
    private String mssv;


    public Student(){
        super();
        mssv = "";
        subjects = new ArrayList<Subject>();
        exam = new ArrayList<Exam>();
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

    public void addSubject(Subject a){
        subjects.add(a);
    }

    public void removeSubject(String ms){
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

    public void export() throws FileNotFoundException{
        super.export();
        for(int i = 0 ; i<subjects.size();i++){
            subjects.get(i).export();
        }
    }


    public void doExam() throws IOException{
        Scanner sc = new Scanner(System.in);
        int co = 0;
        int co1 = 0;
        do{
        System.out.print("Nhap code de vao thi: ");
        String ms = sc.nextLine();
        char c;
        for(int i = 0 ; i<exam.size();i++){
            if(exam.get(i).getCode().equals(ms)){
                Exam a = new Exam();
                a.henshinExam(exam.get(i));
                do{





                System.out.print("Ban co muon ket thuc bai thi khong [0/1]: ");
                    co1 = sc.nextInt();
                }while(co1 != 1);
            }
        }




        if(co == 0) System.out.println("Vui long nhap lai code");
    }while(co == 0);
    }

    public void viewExam() throws FileNotFoundException{
        ListExam a = new ListExam();
        a.enterFile();

        System.out.println("=====Cac bai thi ban co the lam=====");
        for(int i = 0 ; i<subjects.size();i++){
            for(int j=0;j<a.getListExam().size();j++){
                if(subjects.get(i).getID().equals(a.getListExam().get(j).getID()) && subjects.get(i).getStatus() == 0){
                    System.out.println("Ma mon thi: "+a.getListExam().get(j).getID());
                    System.out.println("Ten mon thi: "+a.getListExam().get(j).getSubjName());
                    System.out.println("Code mon thi: "+a.getListExam().get(j).getCode());
                    exam.add(a.getListExam().get(j));
                }
            }
        }
    }





}

