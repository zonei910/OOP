
import java.util.ArrayList;
import java.util.Scanner;

public abstract class User implements IInOut{
    private String username;
    private String password;

    public User(){
        username ="";
        password ="";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
        //hàm equal dùng để so sánh 2 chuỗi với nhau
    }

    public void logout() {
        
    }

    // Getters and Setters
    public String getUsername() {
    	return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword() {
    	return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    
    @Override
    public void enter(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ten: ");
        username  = sc.nextLine();
        System.out.print("Nhap mat khau: ");
        password = sc.nextLine();
    }   

    @Override
    public void export(){
        System.out.println("Ten: " + username);
        System.out.println("Mat Khau: "+password);
    }

    public String checkPassword(){
        return password;
    }

    public abstract String getID();
    public abstract void setID(String ms);
    public abstract ArrayList<Subject> getSubjectList();
}


// Đọc file nào ghi file đó