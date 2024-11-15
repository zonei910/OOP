import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListExam {
    ArrayList<Exam> ds;

    public ListExam(){
        ds = new ArrayList<Exam>();
    }

    public ListExam(ArrayList<Exam> ds){
        this.ds = ds;
    }

    public ArrayList<Exam> getListExam(){
        return ds;
    }

    public void setListExam(ArrayList<Exam> ds){
        this.ds = ds;
    }

    public void addExam(Exam a){
        ds.add(a);
    }

    public void removeExam(String code){
        for(int i = 0 ; i<ds.size();i++)
            if(ds.get(i).getCode().equals(code))
                ds.remove(ds.get(i));
    }

    public void findExam(String code) throws FileNotFoundException{
        for(int i = 0 ; i<ds.size();i++)
        if(ds.get(i).getCode().equals(code)){
            ds.get(i).export();
            System.out.println("");
        }
    }

    public void editExam(Exam a) throws IOException{
        int co = 0;
        do{
        System.out.println("Chon noi dung muon sua");
        System.out.println("1. Ma bai thi");
        System.out.println("2. Ma mon thi");
        System.out.println("3. So luong cau hoi");
        Scanner sc = new Scanner(System.in);
        System.out.print("Lua chon cua ban: ");
        int chon = sc.nextInt();
        sc.nextLine();
        String x;
        switch(chon){
            case 1:
            co = 1;
                System.out.print("Nhap ma bai thi moi: ");
                x = sc.nextLine(); 
                a.setCode(x);
                a.updateExam(a);
            break;
            case 2:
            co = 1;
                System.out.println("Nhap ma mon thi moi: ");
                x = sc.nextLine();
                a.setID(x);
                a.updateExam(a);
                break;
            case 3:
            co = 1;
            System.out.println("Nhap so luong cau hoi moi: ");
            int s = sc.nextInt();
            a.setTotal(s);
            a.updateExam(a);
            break;
            default:
                System.out.println("Vui long nhap lai");
                break;
        }
    }while(co == 0);
    }

    


}
