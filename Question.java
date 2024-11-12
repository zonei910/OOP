import java.util.Scanner;

public class Question {

    private String question;
    private String option_a;
    private String option_b;
    private String option_c;
    private String option_d;
    private char answer; // ( a -b -c -d )

    public Question(){}

    public String getQuestion(){
        return question;
    }
    public void setQuestion(String a){
        question=a;
    }
    public void setA(String a){
        option_a=a;
    }
    public String getA(){
        return option_a;
    }
    public void setB(String a){
        option_b=a;
    }
    public String getB(){
        return option_b;
    }
    public void setC(String a){
        option_c=a;
    }
    public String getC(){
        return option_c;
    }
    public void setD(String a){
        option_d=a;
    }
    public String getD(){
        return option_d;
    }
    public char getAnswer(){
        return answer;
    }
    public void setAnswer(char a){
        answer=a;
    }

    public void input(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap noi dung cau hoi: ");
        question=sc.nextLine();
        System.out.print("Nhap noi dung dap an a: ");
        option_a=sc.nextLine();
        System.out.print("Nhap noi dung dap an b: ");
        option_b=sc.nextLine();
        System.out.print("Nhap noi dung dap an c: ");
        option_c=sc.nextLine();
        System.out.print("Nhap noi dung dap an d: ");
        option_d=sc.nextLine();
        System.out.print("Nhap dap an dung(a-b-c-d): ");
        answer=sc.next().charAt(0);
    }

    public void output(){
        System.out.println("Question: "+question);
        System.out.println("A. "+option_a);
        System.out.println("B. "+option_b);
        System.out.println("C. "+option_c);
        System.out.println("D. "+option_d);
        System.out.println("Answer: "+answer+'\n');
    }
}
