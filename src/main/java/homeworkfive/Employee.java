package homeworkfive;

public class Employee {

    public String fullName;
    public String position;
    public String email;
    public String phone;
    public double salary;
    public int age;

    public Employee(String fullName, String position,
                     String email, String phone, double salary, int age) {

        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("Данные сотрудника:");
        System.out.println("ФИО: " + this.fullName);
        System.out.println("Должность: " + this.position);
        System.out.println("Возраст: " + this.age);
        System.out.printf("Зарплата: %.2f\n", this.salary); //печатаем копейки полностью, даже если они 00
        System.out.println("EMail: " + this.email);
        System.out.println("Телефон: " + this.phone);
    }

}
