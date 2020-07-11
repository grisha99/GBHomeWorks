package homeworkfive;

public class HomeWorkFiveMain {
    public static void main(String[] args) {
        HomeWorkFiveTasks hwt = new HomeWorkFiveTasks();

        hwt.initPeople();           // инициализация массива сотрудников
        hwt.printPeopleByAge(40);   // вывод сотрудников старше указанного возраста
    }
}
