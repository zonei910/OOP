

import java.util.*;
import java.time.*;



public class TakeTest {
    private CreateTest test;
    private int total;
    private int n;
    private ArrayList<Question> selected;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    TakeTest(){};
    
    public TakeTest(CreateTest test) {
        this.test = test;
        this.total = test.getTotal();
        this.n = test.getN();
        this.selected = new ArrayList<>();
    }
    
    
    
    
    public CreateTest getTest() {
        return test;
    }

    public void setTest(CreateTest test) {
        this.test = test;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
    
    public ArrayList<Question> getSelectedQuestions() {
        return selected;
    }

    public void setSelectedQuestions(ArrayList<Question> selectedQuestions) {
        this.selected = selectedQuestions;
    }

    
    public void startTest() {
        Scanner sc = new Scanner(System.in);
        
        selectQuestions();
        
        System.out.println("Bai kiem tra bat dau! Ban co 30 phut de lam bai.");
        System.out.println("Tong so cau hoi trong bai thi: " + total);
        System.out.println("Thoi gian lam bai: 30 phut.");
        
        startTime = LocalDateTime.now();
        endTime = startTime.plusMinutes(30);
        
        int correctAnswers = 0;
        
        for (int i = 0; i < total; i++) {
            Question question = selected.get(i);
            System.out.println((i + 1) + ". " + question.getContent());
            System.out.print("Nhap dap an: ");
            String answer = sc.nextLine();
            if (answer.equals(question.getAnswer())) {
                correctAnswers++;
            }
        }
        
        if (LocalDateTime.now().isAfter(endTime)) {
            System.out.println("Thoi gian lam bai da het!");
        }

        System.out.println("\nKet qua lam bai:");
        System.out.println("So cau dung: " + correctAnswers + "/" + total);
        System.out.println("Diem: " + (correctAnswers * 10 / total));
    }
    
    private void selectQuestions() {
        Random rand = new Random();
        ListQuestion allQuestions = test.getDs();
        Set<Integer> selectedIndexes = new HashSet<>();
        
        while (selected.size() < total) {
            int randomIndex = rand.nextInt(n);
            if (!selectedIndexes.contains(randomIndex)) {
                selected.add(allQuestions.getQuestion(randomIndex));
                selectedIndexes.add(randomIndex);
            }
        }
    }
    
    public void printTimeRemaining() {
        long minutesLeft = Duration.between(LocalDateTime.now(), endTime).toMinutes();
        if (minutesLeft > 0) {
            System.out.println("Thoi gian con lai: " + minutesLeft + " phut");
        } else {
            System.out.println("Thoi gian da het!");
        }
    }
    
    public static void main(String[] args) {
        ListExam listExam = new ListExam();
        listExam.input();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma bai thi: ");
        String testCode = sc.nextLine();
        
        CreateTest test = listExam.FindExam(testCode);
        
        if (test != null) {
            TakeTest takeTest = new TakeTest(test);
            takeTest.startTest();
        } else {
            System.out.println("Ma bai thi khong ton tai!");
        }
    }
    
    
}
