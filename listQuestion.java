import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;





public class listQuestion{
    private ArrayList<Question> ds;

    public listQuestion(){
        ds = new ArrayList<>();
    }

    public listQuestion(ArrayList<Question> a){
        ds = a;
    }

    public void setlistQuestion(ArrayList<Question> a){
        ds = a;
    }


    public ArrayList<Question> getQuestion(ArrayList<Question> a){
        return ds;
    }


    



}
