// Sinh vien se co list subject nen yen tam nhe

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Subject implements IInOut{
    private String mssubj;
    private String subjname;
    private float point;
    private int status;
  
    public Subject(){
        mssubj = "";
        subjname ="";
        point = 0F;
        status = 0;
    }

    public Subject(String mssubj , String subjname , float point , int status){
        this.mssubj = mssubj;
        this.subjname = subjname;
        this.point = point;
        this.status = status;
    }


    public Subject(Subject  subject){
        this.mssubj = subject.getID();
        this.subjname = subject.getSubjName();
        
    }

    public String getID(){
        return mssubj;
    }
    public void setID(String id){
        mssubj = id;
    }

    public String getSubjName(){
        return subjname;
    }
    public void setSubjName(String name){
        subjname = name;
    }

    public float getPoint(){
        return point;
    }
    public void setPoint(float point){
        this.point = point;
    }

    public float getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status = status; 
    }


    public void enter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten mon hoc: ");
        subjname = sc.nextLine();
        System.out.print("Nhap ma mon hoc: ");
        mssubj = sc.nextLine();
    }

    public void export() throws FileNotFoundException{
        System.out.println("Ten mon hoc: " + subjname);
        System.out.println("Ma mon hoc: "+mssubj);
        }

  

}
