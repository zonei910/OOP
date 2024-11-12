import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
public class ListSubject {
    private ArrayList<Subject> ds;

    public ListSubject() throws FileNotFoundException{
        ds = new ArrayList<Subject>();
        File file = new File("dsSubject.txt");
        Scanner sc = new Scanner(file);
        while(sc.hasNext()){
           String line = sc.nextLine();
           String argv [] = line.split(",");
            Subject a = new Subject();
            a.setID(argv[0]);
            a.setSubjName(argv[1]);
            ds.add(a);
        }
    }

    public void addListSubject(){
        Scanner sc = new Scanner(System.in);
        String x;
        Subject a = new Subject();
        System.out.print("Nhap ma so mon hoc: ");
        x = sc.nextLine();
        a.setID(x);
        System.out.print("Nhap ten mon hoc: ");
        x = sc.nextLine();
        a.setSubjName(x);
        ds.add(a);
    }


    public void deleteSubject(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma so mon hoc can xoa: ");
        String x = sc.nextLine();
        for(int i = 0 ; i<ds.size();i++)
            if(ds.get(i).getID().equals(x))
                ds.remove(i);
    }

    public void editListSubject(){
        Scanner sc = new Scanner(System.in);
    }
    
    public ArrayList<Subject> getListSubject(){
        return ds;
    }

    public void export(){
        for(int i = 0 ; i < ds.size();i++){
            System.out.println(ds.get(i).getID() + "," + ds.get(i).getSubjName());
        }
    }

    public void exportFile() throws IOException{
        File file = new File("dsSubject.txt");
        FileWriter fw = new FileWriter(file);
        for(int i = 0 ; i < ds.size();i++){
            fw.write(ds.get(i).getID() + "," + ds.get(i).getSubjName()+'\n');
    }
        fw.close();
}
}