package homeworknine;

public class Cat implements ActionInterface{
    private int num;
    private int maxLength;
    private double maxHeight;

    public Cat(int sportNum){
        num = sportNum;
        maxLength = (int)(Math.random() * 300);
        maxHeight = Math.round((Math.random() * 1.6) * 100.0) / 100.0;
    }

    public boolean jump(Wall wall) {
        if (wall.getHeight() <= maxHeight) {
            System.out.println("Кот " + num + ": Я прыгнул на " + wall.getHeight() + " метров");
            return true;
        } else {
            System.out.println("Кот " + num + ": Не могу прыгнуть на " + wall.getHeight() + " метров, схожу с дистанции");
            return false;
        }
    }

    public boolean run(Treadmill treadmill) {

        if (treadmill.getLength() <= maxLength) {
            System.out.println("Кот " + num + ": Я пробежал " + treadmill.getLength() + " метров");
            return true;
        } else {
            System.out.println("Кот " + num + ": Не могу пробежать " + treadmill.getLength() + " метров, схожу с дистанции");
            return false;
        }
    }
}
