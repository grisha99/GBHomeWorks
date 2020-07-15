package homeworksix;

public class Cat extends Animal{

    public Cat() {
        super();
        name = "Кошка";
        maxSwimDistance = 0;    // кошак плавать не умеет
    }

    @Override
    protected void swim(double distance) {
        System.out.println("Я " + name + " и плавать не умею.");           // как не крути, кошак не плавает
    }

}
