/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author LENOVO
 */

import java.util.ArrayList;
import java.util.Scanner;


public class ListResult {

    private ArrayList<Result> r;

    public ListResult() {
        this.r = new ArrayList<>();
    }

    public ArrayList<Result> getR() {
        return r;
    }

    public void setR(ArrayList<Result> r) {
        this.r = r;
    }

    public void addResult(Result result) {
        r.add(result);
    }

    public void removeResult(String mssv) {
        r.removeIf(result -> result.getMssv().equals(mssv));
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        Result result = new Result();
        result.input();
        addResult(result);
    }

    public void output() {
        if (r.isEmpty()) {
            System.out.println("Danh sách kết quả trống.");
            return;
        }
        for (Result result : r) {
            result.output();
            System.out.println("--------------------");
        }
    }

}
