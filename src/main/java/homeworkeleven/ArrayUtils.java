package homeworkeleven;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class ArrayUtils {

    public static ArrayList<String> getUniqueList(String [] arr) {
        Set<String> uniqSet = new HashSet<>(Arrays.asList(arr));
        return new ArrayList<>(uniqSet);
    }

    private static HashMap<String, Integer> getRepeatWordsCountMap(String [] arr) {
        HashMap<String, Integer> result = new HashMap<>(); // карта <слово (ключ), кол-во этого слова в массиве(значение)>
        Integer val;
        for (String element: arr) {
            if (result.containsKey(element)) { // если слово есть, увеличиваем его кол-во
                val = result.get(element);
                val++;
                result.put(element, val);
            } else {                           // если слова нет, добавляем его с кол-вом 1
                result.put(element, 1);
            }
        }
        return result;
    }

    public static void printRepeatWords(String [] arr) {

        HashMap<String, Integer> wordsCountMap = getRepeatWordsCountMap(arr);
        for (Map.Entry<String, Integer> element: wordsCountMap.entrySet()) {
            System.out.println("Слово \"" + element.getKey() + "\" встречается " + element.getValue() + " раз.");
        }
    }
}
