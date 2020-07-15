package homeworkfive;

public class HomeWorkFiveTasks {

    private Employee [] people = new Employee[5];

    public void initEmployee() {

        people[0] = new Employee("Антон Антонович", "Бухгалтер", "mail1@ad.ru",
                "89991234567", 45000.50, 45);
        people[1] = new Employee("Сергей Сергеевич", "Директор", "mail2@ad.ru",
                "89991111111", 230000.51, 32);
        people[2] = new Employee("Дмитрий Дмитриевич", "Курьер", "mail3@ad.ru",
                "89992222222", 23000.50, 21);
        people[3] = new Employee("Андрей Андреевич", "Охранник", "mail4@ad.ru",
                "89993333333", 24000, 53);
        people[4] = new Employee("Иван Иванович", "Инженер", "mail5@ad.ru",
                "89994444444", 35000.50, 41);
    }

    public void printEmployeeByAge(int age) {
        for (int i = 0; i < people.length; i++) {
            if (people[i].age > age) {
                people[i].info();
                System.out.println("----------------");
            }

        }
    }
}
