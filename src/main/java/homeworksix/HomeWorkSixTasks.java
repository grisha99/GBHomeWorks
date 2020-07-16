package homeworksix;

public class HomeWorkSixTasks {

    public Animal [] animalArr;

    public void initAnimals(int count) {            // генерация животных
        animalArr = new Animal[count];
        for (int i = 0; i < animalArr.length; i++) {
            if (i % 2 == 0) {
                animalArr[i] = new Cat();
            } else {
                animalArr[i] = new Dog();
            }
        }
    }

    public void doAllRun(double distance) {             // все бегают
        for (int i = 0; i < animalArr.length; i++) {
            animalArr[i].run(distance);
        }
    }

    public void doAllJump(double distance) {            // все прыгают
        for (int i = 0; i < animalArr.length; i++) {
            animalArr[i].jump(distance);
        }
    }

    public void doAllSwim(double distance) {            // все плавают
        for (int i = 0; i < animalArr.length; i++) {
            animalArr[i].swim(distance);
        }
    }
}
