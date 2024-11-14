import java.util.Scanner;


public class Question extends Subject implements IInOut{
    private String question;
    private String option_1;
    private String option_2;
    private String option_3;
    private String option_4;
    private char answer;

    public Question(){
        question ="";
        option_1 = "";
        option_2 = "";
        option_3 = "";
        option_4 = "";
        answer = ' ';
    }
 
    public Question (String question, String option_1, String option_2, String option_3, String option_4 , char answer){
        this.question = question;
        this.option_1 = option_1;
        this.option_2 = option_2;
        this.option_3 = option_3;
        this.option_4 = option_4;
        this.answer = answer;
    } 

    public void enter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap noi dung cau hoi: ");
        question = sc.nextLine();
        System.out.print("Nhap lua chon A: ");
        option_1 = sc.nextLine();
        System.out.print("Nhap lua chon B: ");
        option_2 = sc.nextLine();
        System.out.print("Nhap lua chon C: ");
        option_3 = sc.nextLine();
        System.out.print("Nhap lua chon D: ");
        option_4 = sc.nextLine();
        System.out.print("Nhap cau tra loi cho cau hoi: ");
        answer = sc.nextLine().charAt(0);
    }


    public void export(){
        System.out.println(question);
        System.out.println("A. " + option_1);
        System.out.println("B. " + option_2);
        System.out.println("C. " + option_3);
        System.out.println("D. " + option_4);
    }   

    public String getQuestion(){
        return question;
    }

    public String getOption_1(){
        return option_1;
    }

    public String getOption_2(){
        return option_2;
    }

    public String getOption_3(){
        return option_3;
    }

    public String getOption_4(){
        return option_4;
    }

    public char getAnswer(){
        return answer;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setOption_1(String a){
        this.option_1 = a;
    }

    public void setOption_2(String a){
        this.option_2 = a;
    }

    public void setOption_3(String a){
        this.option_3 = a;
    }

    public void setOption_4(String a){
        this.option_4 = a;
    }

    public void setAnswer(char a){
        this.answer = a;
    }



}