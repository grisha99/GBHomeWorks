package homeworkone;

public class HomeWorkOneTasks {

    byte minValue = 5;
    short myCount = 15;
    int midValue = 24;
    long maxValue = 475656456;

    float totalIncome = 33434.534f;
    double myBet = 43432.82;

    char firstLitera = 'A';

    boolean isTrue = true;

    String myName = "Аноним";

    public int calcNumber(int a, int b, int c, int d){
        return a * (b + (c / d));
    }

    public boolean calcSumInRange(int a, int b){
        return ((a + b) >= 10) && ((a + b) <= 20);
    }

    public void printNegitveOrPositive(long a) {
        String answer;
        if (a < 0) {
            answer = "Число отрицательное";
        } else
            answer = "Число положительтное";
        System.out.println("Результат: " + answer);
    }

    public boolean isNegative(long a){
        return a < 0;
    }

    public void printMyName(String myName){
        System.out.println("Привет, " + myName + "!");
    }

    public void checkYear(int myYear){
        if ((myYear % 400) == 0) {
            System.out.println("Год високосный");
        } else if ((myYear % 100) == 0) {
            System.out.println("Год НЕ високосный");
        } else if ((myYear % 4) == 0){
            System.out.println("Год високосный");
        } else
            System.out.println("Год НЕ високосный");
    }
}
