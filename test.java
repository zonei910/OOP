import java.io.IOException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException{
      ListExam a = new ListExam();
      
      a.enterFile();

      for(int i = 0 ; i<a.getListExam().size();i++){
        a.getListExam().get(i).henshinExam( a.getListExam().get(i));
      }

      for(int i = 0 ;i<a.getListExam().size();i++){
        a.getListExam().get(i).export();
      }


      Exam b = new Exam();
      b.create();
      a.addExam(b);

      a.removeExam("100");


      a.exportFile();

    }   
}
