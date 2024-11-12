
import java.util.Scanner;
import java.util.ArrayList;

public class CreateTest extends Subject{
    private ListQuestion ds; // so cau hoi trong list > total
    private int total;// tong so cau trong de thi
    private String code;



    public CreateTest() {
        super();
        this.ds = new ListQuestion();  
        this.total = 0;
        code = "";
    }

    public String getCode(){
        return code;
    }

    public void setCode(String a){
        code = a;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    
    public void input(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter exam code: ");
        this.code = sc.nextLine();
        System.out.print("Nhap ten mon hoc muon tao de thi");
        String x = sc.nextLine();
        setSubjName(x);
        System.out.print("Enter total questions: ");
        this.total = sc.nextInt();
        sc.nextLine();
        ds.input();  
    }
    
    public void output() {
        System.out.println("Exam code: " + code);
        System.out.println("Subject name: " + getSubjName());
        System.out.println("Total questions: " + total);

        ds.output();
    }
    
    // xoa cau hoi - lam choi thoi chu khong su dung :)
    public void deleteQuestionByContent(String content) {
        ds.deleteByContent(content);
    }
     
    public void editQuestion() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap content de edit: ");
        String oldQuestionContent = sc.nextLine();

        int index = ds.findQuestion(oldQuestionContent);
        if (index == -1) {
            System.out.println("Not found!");
            return;
        }
        ds.deleteByContent(oldQuestionContent);

        // Nhap cau hoi moi
        System.out.println("Nhapp cau hoi moi: ");
        Question newQuestion = new Question();
        newQuestion.input(); 
        ds.Add(newQuestion); 
        System.out.println("ok!");
    }  
}
