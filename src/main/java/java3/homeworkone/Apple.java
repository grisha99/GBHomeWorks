package java3.homeworkone;

public class Apple extends Fruit{

    private final static float APPLE_WEIGHT_DEFAULT = 1.0f;

    public Apple() {
        super(APPLE_WEIGHT_DEFAULT);
    }


    public Apple(float weight) {
        super(weight);
    }
}
