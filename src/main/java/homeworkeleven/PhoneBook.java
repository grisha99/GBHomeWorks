package homeworkeleven;

import java.util.*;

public class PhoneBook {

    private HashSet<Person> contacts;

    public PhoneBook() {
        contacts = new HashSet<>();
     }

    public boolean add(String secondName, String phoneNumber) {
        Person person = new Person(secondName, phoneNumber);
        return contacts.add(person); // добавит контакт, если контакта с таким номером нет
    }

    public ArrayList<String> get(String secondName) {
        ArrayList<String> resultList = new ArrayList<>();
        for (Person person: contacts) {
            if (person.getSecondName().toLowerCase().equals(secondName.toLowerCase())) {
                resultList.add(person.getPhoneNumber());
            }
        }
        return resultList;
    }
}
