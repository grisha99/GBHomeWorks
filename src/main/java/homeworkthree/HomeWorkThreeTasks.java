package homeworkthree;

import java.util.Scanner;

public class HomeWorkThreeTasks {

    public void quessNumber() {
        int maxTryCount = 3;
        int currentTry;
        boolean gameContinue = true;

        int answer;
        int userAnswer;

        Scanner scn = new Scanner(System.in);
        do {
            answer = (int) (Math.random() * 10); // случайное число от 0 - 9 (включительно)
            currentTry = 1;
            System.out.println("Угадайте число от 0 до 9.");
            System.out.println("У Вас " + maxTryCount + " попытки.");
            while (maxTryCount >= currentTry) {
                System.out.println("Попытка №" + currentTry);
                System.out.print("Введите число: ");
                userAnswer = scn.nextInt();
                if (userAnswer == answer) {
                    System.out.println("Поздравляю, Вы угадали!");
                    break;
                } else if (userAnswer < answer) {
                    System.out.println("Ваше число меньше загаданного.");
                    currentTry++;
                } else {
                    System.out.println("Ваше число больше загаданного.");
                    currentTry++;
                }
            }
            if (currentTry > maxTryCount) {
                System.out.println("Попытки закончились, вы проиграли.");
            }
            int intContinue;
            do {                // бесконечный цикл, пока не будет указано точное значение 0 или 1
                System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
                intContinue = scn.nextInt();
            }while ((intContinue < 0) || (intContinue > 1));
            gameContinue = intContinue != 0;

        } while (gameContinue);
        System.out.println("Игра окончена!");
        scn.close();
    }

    public void quessWord() {
        String[] words = {
                "apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape",
                "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};


        char secretMask = '#';      //символ маски
        int maskLength = 15;        //размер маски для не правильного слова
        String secretWord;          // частично угаданное слова с верными буквами
        String userAnswer;
        int wordID = (int) (Math.random() * words.length); //номер слова в массиве от 0 до конечного эл-та
        Scanner scn = new Scanner(System.in);

        System.out.println("Игра угадайте слово.");


        do {
            System.out.print("Введите слово: ");
            userAnswer = scn.next().toLowerCase();
            if (userAnswer.equals(words[wordID])) {  // слово угадано, выход из цикла
                break;
            }
            secretWord = "";
            for (int i = 0; i < userAnswer.length() && i < words[wordID].length(); i++) { //поиск совпадения букв
                if (userAnswer.charAt(i) == words[wordID].charAt(i)) {
                    secretWord = secretWord + userAnswer.charAt(i);
                } else {
                    secretWord = secretWord + secretMask;
                }
            }
            for (int i = secretWord.length(); i < maskLength; i++) {    //дополняем маску слова до максимальной длинны
                secretWord = secretWord + secretMask;
            }

            System.out.println("Вы не угадали, совпавшие буквы: " + secretWord);
        } while (true);

        System.out.println("Поздравляю, Вы выиграли.");
        scn.close();
    }

}
