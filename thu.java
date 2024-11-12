import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;



public class thu {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("dsStudent.txt");
        Scanner sc = new Scanner(file);
        ListUser a = new ListUser();
        Student b = null;
        while(sc.hasNext()){
            String line = sc.nextLine();
            String [] argv = line.split(",");
            if(argv[0].equals("")){
                System.out.println("Yes");
                continue;
            }
            if(argv[0].equals("SinhVien")){
                b = new Student();
                b.setID(argv[1]);
                b.setUsername(argv[2]);
                b.setPassword(argv[3]);  
                a.getListUser().add(b);
            }else{
                Subject c = new Subject();
                c.setID(argv[0]);
                c.setSubjName(argv[1]);
                float score = Float.parseFloat(argv[3]);
                System.out.println(score);
               
                int status = Integer.parseInt(argv[2]);
                System.out.println(status);
                c.setPoint(score);
                c.setStatus(status);
                b.addSubjectToStudent(c);
            }
        }

    for(int j = 0 ; j<a.getListUser().size();j++)
            a.getListUser().get(j).export();


    }    
}

