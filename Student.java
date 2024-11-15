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
    private float GPA;

    public Student(){
        super();
        mssv = "";
        subjects = new ArrayList<Subject>();
        exam = new ArrayList<Exam>();
        GPA = 0;
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
        GPA = student.getGPA();
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
        int n = 0;
        for(int i = 0 ; i < subjects.size(); i++){
            if(subjects.get(i).getStatus() == 1){
                s = s + subjects.get(i).getPoint();
                n++;
            }
        }
        return (float) s/n;
    }

    public void setGPA(float a){
        GPA = a;
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
        System.out.println("Ma sinh vien: "+mssv);
        for(int i = 0 ; i<subjects.size();i++){
            subjects.get(i).export();
        }
        System.out.println("GPA cua sinh vien: "+getGPA());
    }

    public void showSubject(){
        for(int i = 0 ; i<subjects.size();i++){
            System.out.println("Ten mon hoc: "+subjects.get(i).getSubjName());
            System.out.println("Ma mon hoc: "+subjects.get(i).getID());
            System.out.print("Trang thai cua sinh vien: ");
            if(subjects.get(i).getStatus() == 1) {
                System.out.println("Da hoc");
                System.out.println("Diem so: "+subjects.get(i).getPoint());
            }
            else{ 
            System.out.println("Chua hoc");
                System.out.println("Diem so: "+subjects.get(i).getPoint());
            }
            System.out.println("");
        }
    }

    public void doExam() throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = 0;
        int co = 0;
        int co1 = 1;
        do{
        System.out.print("Nhap code bai thi: ");
        String ms = sc.nextLine();
            for(int i=0;i<exam.size();i++)
                if(exam.get(i).getCode().equals(ms))
                {
                    n = i;
                    co = 1;
                }
                if(co == 0) System.out.println("Khong tim thay bai thi tuong ung");
        }while(co == 0);
        do{
            float diem = 0;
            exam.get(n).setStatus(0);
           for(int i = 0 ; i<exam.get(n).getListQuestion().size();i++){
                System.out.println("Cau hoi: "+exam.get(n).getListQuestion().get(i).getQuestion());
                System.out.println("A. "+exam.get(n).getListQuestion().get(i).getOption_1());
                System.out.println("B. "+exam.get(n).getListQuestion().get(i).getOption_2());
                System.out.println("C. "+exam.get(n).getListQuestion().get(i).getOption_3());
                System.out.println("D. "+exam.get(n).getListQuestion().get(i).getOption_4());
                System.out.print("Lua chon cua ban: ");
                char c = sc.next().charAt(0);
                if(Character.toUpperCase(c) == Character.toUpperCase(exam.get(n).getListQuestion().get(i).getAnswer())){
                    for(int j=0;j<subjects.size();j++){
                        if(subjects.get(j).getID().equals(exam.get(n).getListQuestion().get(i).getID())){
                            subjects.get(j).setStatus(1);
                            subjects.get(j).setPoint(++diem);
                        }
                    }
                }
            }   
            System.out.print("Ban co muon lam lai bai thi hay khong [1/0]: ");
            co1 = sc.nextInt();
        }while(co1 == 1);
    }

    public void viewExam() throws IOException{
        Scanner sc = new Scanner(System.in);
        ListExam a = new ListExam();
        a.enterFile();

        System.out.println("=====Cac bai thi ban co the lam=====");
        for(int i = 0 ; i<subjects.size();i++){
            for(int j=0;j<a.getListExam().size();j++){
                if(subjects.get(i).getID().equals(a.getListExam().get(j).getID()) && subjects.get(i).getStatus() == 0){
                    System.out.println("Ma mon thi: "+a.getListExam().get(j).getID());
                    System.out.println("Ten mon thi: "+a.getListExam().get(j).getSubjName());
                    System.out.println("Code mon thi: "+a.getListExam().get(j).getCode());
                    a.getListExam().get(j).henshinExam(a.getListExam().get(j));
                    exam.add(a.getListExam().get(j));
                }
            }
        }
        System.out.print("Ban co muon lam bai thi khong? [1/0]: ");
        int x = sc.nextInt();
        System.out.println("");
        if(x == 1){
            doExam();
        }
    }


 


}

