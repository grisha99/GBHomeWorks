package homeworknine;

public class Treadmill extends SportsEquipment {

    private int length;

    public Treadmill(){

        setName("Беговая дорожка");;
        length = (int)(Math.random() * 500);
    }

    public int getLength() {
        return length;
    }

    public void info() {
        System.out.println(getName() + ", длинна: " + length + " метров.");
    }
}
