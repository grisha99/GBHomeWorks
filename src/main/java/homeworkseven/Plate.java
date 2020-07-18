package homeworkseven;

public class Plate {
    private int plateCapacity = 40;     // максимальное кол-во еды в миске
    private int food;

    public Plate() {            // конструктор с рандомным кол-вом еды в миске
        food = 1 + (int) (Math.random() * plateCapacity);
    }

    public Plate(int food) {    // конструктор с явным указанием кол-вом еды в миске
        if (food > plateCapacity) {     // в миску нельзя положить еды больше, чем она вмещает
            this.food = plateCapacity;
        } else {
            this.food = food;
        }
    }

    public void decraseFood(int count) {
        if (food - count < 0) {         // не может быть отрицательного значения еды
            food = 0;
        } else {
            food -= count;
        }
    }

    public void info () {
        System.out.println("В миске " + food + " еды из " + plateCapacity);
    }

    public void addFood() {
        if (food == plateCapacity) {
            System.out.println("В миску больше не положить!");
            return;
        }
        int tmpFood = 1 + (int) (Math.random() * (plateCapacity - food));
        food += tmpFood;
        System.out.println("Добавили " + tmpFood + " еды в миску, теперь ее " + food);
    }

    public int getFood() {
        return food;
    }

    public int getPlateCapacity() {
        return plateCapacity;
    }
}
