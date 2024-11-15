
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exam extends Subject {
    private ArrayList<Student> student;
    private ArrayList<Question> question;
    private int total;
    private String code;

    public Exam(){
        student = new ArrayList<Student>();
        question = new ArrayList<Question>();
        total = 0;
        code = "";
    }

    public void addStudent(Student a){
        student.add(a);
    }
  
    public void create() throws IOException , FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma mon can thi: ");
        String ms = sc.nextLine();
        setID(ms);

        ListUser a = new ListUser();
        a.enterFile();
        
        for(int i = 0 ; i<a.getListUser().size();i++){
            for(int j = 0 ; j<a.getListUser().get(i).getSubjectList().size();j++){
                    if(a.getListUser().get(i).getSubjectList().get(j).getID().equals(getID()) && a.getListUser().get(i).getSubjectList().get(j).getStatus() == 0){
                        Student b = new Student();
                        b = (Student) a.getListUser().get(i);
                        student.add(b);
                    }
            }
        }
        ListQuestion b = new ListQuestion();
        b.enterFile();

        for(int i = 0 ; i<b.getListQuestion().size();i++){
            if(b.getListQuestion().get(i).getID().equals(getID())){
                question.add(b.getListQuestion().get(i));
        }
    }
        System.out.print("Nhap ma bai thi: ");
        code = sc.nextLine();
        System.out.print("Nhap so luong cau hoi can tao: ");
        total = sc.nextInt();

        }



        public ArrayList<Student> getListStudent(){
            return student;
        }

        public ArrayList<Question> getListQuestions(){
            return question;
        }

        public int getTotal(){
            return total;
        }

        public String getCode(){
            return code;
        }

        public void setListStudent(ArrayList<Student> a){
            student = a;
        }

        public void setListQuestion(ArrayList<Question> a){
            question = a;
        }

        public void setTotal(int a){
            total = a;
        }

        public void setCode(String a){
            code = a;
        }

        public void export() throws FileNotFoundException {
            System.out.println("Ma mon thi: " + getID());
            System.out.print("Ten mon thi: ");
            ListSubject a = new ListSubject();
            a.enterFile();
            for(int i = 0 ;i<a.getListSubject().size();i++){
                if(getID().equals(a.getListSubject().get(i).getID()))
                    System.out.println(a.getListSubject().get(i).getSubjName());
            }

            System.out.println("Ma bai thi: "+code);
            System.out.println("~~~Danh sach sinh vien thi~~~");
            for(int i = 0 ; i<getListStudent().size();i++){
                System.out.println(getListStudent().get(i).getID() + "," + getListStudent().get(i).getUsername());
            }
            System.out.println("~~~Danh sach cau hoi~~~");
            for(int i = 0 ; i<total;i++){
                getListQuestions().get(i).export();
                System.out.println("");
            }
        }




}