

import java.util.Scanner;
import java.util.ArrayList;


public class ListQuestion {
    private ArrayList<Question> ds;
    
    public ListQuestion(){
        ds = new ArrayList<>();
    }
    
    public void Add(Question a){
        ds.add(a);
    }
    
    public void Delete(Question a){
        ds.remove(a);
    }
    
    public void Edit(Question a){
        for(int i = 0 ; i<ds.size();i++){
            if(ds.get(i).getQuestion().equals(a.getQuestion())){
                Scanner sc = new Scanner(System.in);
                System.out.println("Nhap noi dung muon sua");
                System.out.println("1. Noi dung cau hoi");
                System.out.println("2. Dap an cau 1");
                System.out.println("3. Dap an cau 2");
                System.out.println("4. Dap an cau 3");
                System.out.println("5. Dap an cau 4");
                System.out.print("Lua chon cua ban: ");
                int chon = sc.nextInt();
                sc.nextLine();
                String moi;
                switch(chon){
                    case 1:
                        System.out.print("Nhap noi dung moi: ");
                        moi = sc.nextLine();
                        ds.get(i).setQuestion(moi);
                        break;
                    case 2:
                        System.out.print("Nhap dap an moi: ");
                        moi = sc.nextLine();
                        ds.get(i).setB(moi);(moi);
                        break;
                    case 3:
                        System.out.print("Nhap dap an moi: ");
                        moi = sc.nextLine();
                        ds.get(i).setB(moi);
                        break;
                    case 4:
                        System.out.print("Nhap dap an moi: ");
                        moi = sc.nextLine();
                        ds.get(i).setC(moi);
                        break;
                    case 5:
                        System.out.print("Nhap dap an moi: ");
                        moi = sc.nextLine();
                        ds.get(i).setD(moi);
                        break;
                }
            }
        }
    }

    public void input(){
        Scanner sc=new Scanner(System.in);
        int t=1;
        do{
            Question q=new Question();
            q.input();
            Add(q);
            System.out.print("Enter 0 to stop: ");
            t=sc.nextInt();
        }
        while(t!=0);
    }
    
    public void output(){
        System.out.println("List question: "+'\n');
        for (Question q:ds){
            q.output();
        }
    }

    public ArrayList<Question> getListQuestion(){
        return ds;
    }

    public void setListQuestion(ArrayList<Question> a){
        ds = a;
    }

}