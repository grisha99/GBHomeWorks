package homeworkeight.additionaltasks;

/**
 *
 * Постройте частотный словарь букв русского (или английского) алфавита.
 * Опустим проблему выбора и анализа корпуса языка, достаточно будет взять текст небольшой длины).
 *
 */

public class FreqDictionary {


    public static void infoText(String text) {

        if (text.length() < 1) {
            System.out.println("Строка пустая");
            return;
        }

        int firstCharNum = 'а';         // номер первой буквы алфавита
        int lastCharNum = 'я';          //номер последней буквы алфавита
        int charCount = lastCharNum - firstCharNum + 1; // общее кол-во букв
        int [] freqArr = new int[charCount];        // массив для подсчета всех букв

        text = text.toLowerCase();
        int relativeCharNum;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) >= 'а' && text.charAt(i) <= 'я') {       // если буква в пределах русского алфавита
                relativeCharNum = (int) text.charAt(i) - firstCharNum;  // считаем относительное положение буквы для массива
                freqArr[relativeCharNum] += 1;      // увеличивае ее кол-во в массиве
            }
        }

        for (int i = 0; i < freqArr.length; i++) {
            if (freqArr[i] > 0) {
                System.out.println("Букава: " + (char) (firstCharNum + i) + " встречается " + freqArr[i] + " раз");
            }
        }

    }
}
