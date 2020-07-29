package homeworknine;

public class Wall extends SportsEquipment {

    private double height;

    public Wall(){
        setName("Стена");
        height = Math.round((Math.random() * 2) * 100.0) / 100.0;
    }

    public double getHeight() {
        return height;
    }

    public void info() {
        System.out.println(getName() + ", высота: " + height + " метров.");
    }
}
