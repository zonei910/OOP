import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class ListQuestion implements IFILE{
    private ArrayList<Question> ds;

    public ListQuestion(){
        ds = new ArrayList<Question>();
    }

    public ListQuestion(ArrayList<Question> a){
        ds = a;
    }

    public void setListQuestion(ArrayList<Question> a){
        ds = a;
    }


    public ArrayList<Question> getListQuestion(){
        return ds;
    }

    public void addQuestion(Question q){
        ds.add(q);
    }
    
    public void removeQuestion(String a){
        for(int i = 0 ; i<ds.size();i++)
            if(ds.get(i).getID().equals(a))
                ds.remove(i);
    }


    public void findQuestion(String a){
        for(int i = 0 ; i<ds.size();i++)
        if(ds.get(i).getID().equals(a))
            ds.get(i).export();
    }


    public void enterFile() throws FileNotFoundException , IOException{
        File file = new File("dsQuestion.txt");
        Scanner sc = new Scanner(file);
        Question a = new Question();
        int co1 = 0 , co2 = 0 , co3 = 0 , co4 = 0 , co5 = 0 , co6 = 0 , co7 = 0 , co8 = 0; 
        while(sc.hasNext()){
            String line = sc.nextLine();
            if(co1 == 0){
                String [] arr = line.split(",");
                if(arr.length == 2 ){
                a.setID(arr[0]);
                a.setSubjName(arr[1]);
                co1 = 1;
                }
                continue;
            }

            
            if(co2 == 0){
                a.setIDQues(line);
                co2 = 1;
                continue;
            }
            if(co3 == 0){
                a.setQuestion(line);
                co3 = 1;
                continue;
            }

            if(co4 == 0){
                a.setOption_1(line);
                co4 = 1;
                continue;
            }
            if(co5 == 0){
                a.setOption_2(line);
                co5 = 1;
                continue;
            }
            if(co6 == 0){
                a.setOption_3(line);
                co6 = 1;
                continue;
            }
            if(co7 == 0){
                a.setOption_4(line);
                co7 = 1;
                continue;
            }

            if(co8 == 0){
                a.setAnswer(line.charAt(0));
                co8 = 1;
                ds.add(a); 
                a = new Question();
                continue;
            }
            co1 = 0 ; co2 = 0 ; co3 = 0 ; co4 = 0 ; co5 = 0 ; co6 = 0 ; co7 = 0 ; co8 = 0; 
        }
    }

   
    

            public void exportFile() throws IOException{
                File file = new File("dsQuestion.txt");
                FileWriter fw = new FileWriter(file);
                for(int i = 0 ;i<ds.size();i++){
                    fw.write(ds.get(i).getID()+","+ds.get(i).getSubjName()+"\n");
                    fw.write(ds.get(i).getIDQues()+"\n");
                    fw.write(ds.get(i).getQuestion()+"\n");
                    fw.write(ds.get(i).getOption_1()+"\n");
                    fw.write(ds.get(i).getOption_2()+"\n");
                    fw.write(ds.get(i).getOption_3()+"\n");
                    fw.write(ds.get(i).getOption_4()+"\n");
                    fw.write(ds.get(i).getAnswer()+"\n");
                    fw.write("\n");
                }
                fw.close();
            }


            public void export(){
                for(int i = 0 ; i < ds.size();i++){
                       ds.get(i).export();
                       System.out.println("");
                    }
            }



}
