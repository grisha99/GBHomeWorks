package homeworknine;

public class Robot implements ActionInterface{
    private int num;
    private int maxLength;
    private double maxHeight;

    public Robot(int sportNum){
        num = sportNum;
        maxLength = (int)(Math.random() * 500);
        maxHeight = Math.round((Math.random() * 2) * 100.0) / 100.0;
    }

    public boolean jump(Wall wall) {
        if (wall.getHeight() <= maxHeight) {
            System.out.println("Робот " + num + ": Я прыгнул на " + wall.getHeight() + " метров");
            return true;
        } else {
            System.out.println("Робот " + num + ": Не могу прыгнуть на " + wall.getHeight() + " метров, схожу с дистанции");
            return false;
        }
    }

    public boolean run(Treadmill treadmill) {

        if (treadmill.getLength() <= maxLength) {
            System.out.println("Робот " + num + ": Я пробежал " + treadmill.getLength() + " метров");
            return true;
        } else {
            System.out.println("Робот " + num + ": Не могу пробежать " + treadmill.getLength() + " метров, схожу с дистанции");
            return false;
        }
    }
}
