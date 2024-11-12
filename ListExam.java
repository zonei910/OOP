import java.util.Scanner;
import java.util.ArrayList;


public class ListExam {
    public ArrayList<CreateTest> Exam;
    
    ListExam(){
        Exam=new ArrayList<>();
    }
    
    public void Add(CreateTest a){
        Exam.add(a);
    }
    
    public void DeleteExam(CreateTest a){
        Exam.remove(a);
    }
    
    public void input(){
        Scanner sc=new Scanner(System.in);
        int t=1;
        do{
            CreateTest e = new CreateTest();
            e.input();
            Add(e);
            System.out.print("Nhap 1 de tiep tuc nhap them de thi: ");
            t=sc.nextInt();
        }
        while(t==1);
    }
    
    public void output(){
        System.out.println("List Exam: "+'\n');
        for (CreateTest e:Exam){
            e.output();
        }
    }
    
    
    public int FindIndexExam (String ma){
        for (int i = 0; i < Exam.size(); i++) {
            if (Exam.get(i).getCode().equals(ma)) {
                return i;
            }
        }
        return -1;
    }
    
    // Ko tham só - Nhập mã đề thi xong tìm rồi quăng nguyên bài ra
    public CreateTest FindExam (){
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap ma de thi: ");
        String ma=sc.nextLine();
        for (CreateTest e:Exam)
            if (e.getCode().equals(ma))
                return e;
        System.out.println("Ma de thi khong ton tai!");
        return null;
    }
    
    // CÓ tham số - Tìm nguyên cái bài kiểm tra theo mã xong quăng ra
    public CreateTest FindExam (String ma){
        for (CreateTest e:Exam){
            if (e.getCode().equals(ma))
                return e;
        }
        System.out.println("Ma de thi khong ton tai!");
        return null;
    }
    
    public static void main(String[]args){
        ListExam e=new ListExam();
        e.input();
        e.output();
    }
}
