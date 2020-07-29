package homeworknine;

import java.util.Iterator;

public class Human implements ActionInterface {

    private int num;
    private int maxLength;
    private double maxHeight;

    public Human(int sportNum){
        num = sportNum;
        maxLength = (int)(Math.random() * 450);
        maxHeight = Math.round((Math.random() * 1.9) * 100.0) / 100.0;
    }

    public boolean jump(Wall wall) {
        if (wall.getHeight() <= maxHeight) {
            System.out.println("Человек " + num + ": Я прыгнул на " + wall.getHeight() + " метров");
            return true;
        } else {
            System.out.println("Человек " + num + ": Не могу прыгнуть на " + wall.getHeight() + " метров, схожу с дистанции");
            return false;
        }
    }

    public boolean run(Treadmill treadmill) {
        if (treadmill.getLength() <= maxLength) {
            System.out.println("Человек " + num + ": Я пробежал " + treadmill.getLength() + " метров");
            return true;
        } else {
            System.out.println("Человек " + num + ": Не могу пробежать " + treadmill.getLength() + " метров, схожу с дистанции");
            return false;
        }
    }

}
