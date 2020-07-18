package homeworkseven;

public class Cat {
    private final String name;
    private final int appetite;    // аппетит
    private boolean satiety;       // Сытость, true - кот сытый; false = кот голодный

    public Cat(String name) {
        this.name = name;
        appetite = 1 + (int) (Math.random() * 50);  // масимальный аппетит 50
        satiety = false;           // изначально кот голодный
    }

    public boolean eat(Plate plate) {
        if (satiety) {
            System.out.println("Кот " + name + " не голодный.");
            return true;
        } else if (plate.getFood() < appetite){     // в тарелка мало еды
            System.out.println("Кот " + name + " слишком голодный, не хватет " + (appetite - plate.getFood()) + " еды.");
            return false;
            } else {
                plate.decraseFood(appetite);
                satiety = true;
                System.out.println("Кот " + name + " наелся! Съел " + appetite + " еды.");
                return true;
            }
    }

    public boolean getSatiety() {
        return satiety;
    }

    public int getAppetite () {
        return appetite;
    }

    public String getName() {
        return name;
    }

}
