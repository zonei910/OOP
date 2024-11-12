import java.io.IOException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException{
        ListUser a = new ListUser();

        Student b = new Student();
        b.enter();
        a.addStudent(b);

        a.export();

        a.exportFile();




      
    }   
}
