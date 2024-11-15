import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
        // int co = 1;
        // for(int i=0;i<ds.size();i++)
        //     if(ds.get(i).getCode().equals(a.getCode())){
        //         co = 0;
        //         System.out.println("Vui long tao bai thi voi ma code khac");
        //     }

        // if(co == 1)
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

    
    public void export() throws FileNotFoundException{
        for(int i = 0 ; i<ds.size();i++){
            ds.get(i).export();
        }
    }


    public void enterFile() throws FileNotFoundException{
        File file = new File("dsExam.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
            String line = sc.nextLine();
            String arr [] = line.split(",");
            Exam a = new Exam();
            a.setID(arr[0]);
            a.setSubjName(arr[1]);
            a.setCode(arr[2]);
            a.setTotal(Integer.parseInt(arr[3]));
            ds.add(a);
        }
    }

    public void exportFile() throws IOException{
        File file = new File("dsExam.txt");
        FileWriter fw = new FileWriter(file);
        ListSubject a = new ListSubject();
        a.enterFile();
        for(int i = 0 ; i <ds.size();i++){
            fw.write(ds.get(i).getID()+",");
            for(int j = 0 ; j<a.getListSubject().size();j++){
                if(ds.get(i).getID().equals(a.getListSubject().get(j).getID()))
                fw.write(a.getListSubject().get(j).getSubjName()+","+ds.get(i).getCode()+","+ds.get(i).getTotal()+"\n");
            }
        }
        fw.close();
    }



}
