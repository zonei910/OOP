import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
public class ListSubject implements IFILE{
    private ArrayList<Subject> ds;

    public ListSubject() {
        ds = new ArrayList<>();
        }
    

    public ArrayList<Subject> getListSubject(){
        return ds;
    }

    public void setListSubject(ArrayList<Subject> a){
        ds = a;
    }

    public void addSubject() throws IOException{
        Subject a = new Subject();
        a.enter();
        ds.add(a);
        exportFile();
    }

    public void removeSubject(String ms) throws IOException{
        for (int i = 0; i < ds.size(); i++) {
            if(ds.get(i).getID().equals(ms))
                ds.remove(i);
        }
        exportFile();
    }

    public void editSubject(String ms) throws IOException{
        Scanner sc = new Scanner(System.in);
        int co =0;
        for (int i = 0; i < ds.size(); i++){
            if(ds.get(i).getID().equals(ms)){
                co = 1;
                System.out.println("Chon cai de sua");
                System.out.println("1. Ten mon hoc");
                System.out.println("2. Ma mon hoc");
                System.out.print("Lua chon cua ban: ");
                int n = sc.nextInt();
                String x;
                sc.nextLine();
                switch(n){
                    case 1:
                    System.out.print("Nhap ten mon hoc moi: ");
                    x = sc.nextLine();
                    ds.get(i).setSubjName(x);
                    break;
                    case 2:
                    System.out.print("Nhap ma mon hoc moi: ");
                    x = sc.nextLine();
                    ds.get(i).setID(x);
                    break;
                    default:
                    System.out.println("Nhap sai");
                    break;
                }
            }
        }
        exportFile();
    }

    public void export(){
        for (int i = 0; i < ds.size(); i++){
            ds.get(i).export();
            System.out.println("");
        }
    }

    public void enterFile() throws FileNotFoundException , IOException{
        File file = new File("dsSubject.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String argv [] = line.split(",");
            Subject a = new Subject();
            a.setID(argv[0]);
            a.setSubjName(argv[1]);
            ds.add(a);
        }
    }

    public void exportFile() throws IOException{
        File file = new File("dsSubject.txt");
        FileWriter fw = new FileWriter(file);
        for (int i = 0; i < ds.size(); i++){
            fw.write(ds.get(i).getID()+","+ds.get(i).getSubjName()+"\n");
        }
        fw.close();
    }
}