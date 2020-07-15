package homeworkfive;

public class HomeWorkFiveMain {
    public static void main(String[] args) {
        HomeWorkFiveTasks hwt = new HomeWorkFiveTasks();

        hwt.initEmployee();           // инициализация массива сотрудников
        hwt.printEmployeeByAge(40);   // вывод сотрудников старше указанного возраста
    }
}
