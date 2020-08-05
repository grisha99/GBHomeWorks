package homeworkeleven;

import java.util.Objects;

public class Person {

    private String secondName;
    private String phoneNumber;

    public Person(String secondName, String phoneNumber) {
        this.secondName = secondName;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return phoneNumber.equals(person.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }
}
