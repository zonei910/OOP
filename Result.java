
import java.util.Scanner;
import java.time.*;

public class Result {
    private String mssv;
    private String name;
    private float score;
    private LocalDateTime time;
    
    
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getScore() {
        return score;
    }
    
    public void setScore(float score) {
        this.score = score;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
    public void input() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nhap MSSV: ");
        mssv = scanner.nextLine();
        
        System.out.print("Nhap tên: ");
        name = scanner.nextLine();
        
        System.out.print("Nhap điểm: ");
        score = scanner.nextFloat();
        
        time = LocalDateTime.now();
    }
    
    public void output() {
        System.out.println("MSSV: " + mssv);
        System.out.println("Ten: " + name);
        System.out.println("Điem: " + score);
        System.out.println("Thoi gian hoan thanh: " + time);
    }
}
