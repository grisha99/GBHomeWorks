package homeworkeleven;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeWorkElevenTasks {

    public static String[] words = {
            "apple", "pea", "orange", "lemon", "banana", "apricot", "cherry", "avocado",
            "broccoli", "carrot", "cherry", "garlic", "grape", "leak",
            "melon", "leak", "kiwi", "lemon", "mango", "cherry", "mushroom",
            "nut", "lemon", "olive", "pea"};

    private static String [][] testPersonArr = {
            {"Иванов",  "00000000"},
            {"Петров",  "11111111"},
            {"Петров",  "22222222"},
            {"Костин",  "00000000"},
            {"Костин",  "77777777"},
            {"Сидоров", "33333333"}
    };

    /**
     * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
     * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
     * Посчитать сколько раз встречается каждое слово.
     */

    public static void startFirstTask(){
        System.out.println("Исходный массив: ");
        System.out.println(Arrays.toString(words));
        System.out.println("Уникальный массив: ");
        System.out.println(ArrayUtils.getUniqueList(words).toString());
        System.out.println("Частота слов исходного массива: ");
        ArrayUtils.printRepeatWords(words);
    }

    /**
     * Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
     * В этот телефонный справочник с помощью метода add() можно добавлять записи.
     * С помощью метода get() искать номер телефона по фамилии.
     * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
     * тогда при запросе такой фамилии должны выводиться все телефоны.
     */
    public static void startSecondTask() {
        PhoneBook phoneBook = new PhoneBook();

        for (int i = 0; i < testPersonArr.length; i++) {
            if (phoneBook.add(testPersonArr[i][0],testPersonArr[i][1])) {
                System.out.println("Контакт добавлен.");
            } else {
                System.out.println("Контакт с таким номеров уже существует");
            }
        }

        ArrayList<String> phoneArr = phoneBook.get("петров");

        if (phoneArr.size() > 0) {
            System.out.println("Список телефонов: " + phoneArr.toString());
        } else {
            System.out.println("Такого контакта нет!");
        }
    }


}
