package homeworksix;

public class Animal {

    protected String name;                  // имя животного
    protected double maxRunDistance;        // максимальная дистанция бега в метрах
    protected double maxSwimDistance;       // максимальная дистанция плаванья в метрах
    protected double maxJumpHeight;         // максимальная высота прыжков в метрах

    public Animal() {
        maxJumpHeight = (double) Math.round((Math.random() * 2) * 100) / 100;
        maxRunDistance = (double) Math.round((Math.random() * 500) * 100) / 100;
        maxSwimDistance = (double) Math.round((Math.random() * 60) * 100) / 100;
    }


    protected void run(double distance) {
        if (distance < maxRunDistance) {
            System.out.println("Я " + name + " пробежала " + distance + " метров");
        } else {
            System.out.println("Я " + name + " не могу пробежать " + distance + " метров, могу максимум " + maxRunDistance + " метров");
        }
    }

    protected void jump(double height) {
        if (height < maxJumpHeight) {
            System.out.println("Я " + name + " прыгнула на " + height + " метров");
        } else {
            System.out.println("Я " + name + " не могу прыгнуть на " + height + " метров, могу максимум на " + maxJumpHeight + " метров");
        }
    }

    protected void swim(double distance) {
        if (distance < maxSwimDistance) {
            System.out.println("Я " + name + " проплыла на " + distance + " метров");
        } else {
            System.out.println("Я " + name + " не могу плавать на " + distance + " метров, могу максимум на " + maxSwimDistance + " метров");
        }
    }
}
