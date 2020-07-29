package homeworknine;

public abstract class SportsEquipment {

    private String name = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void info();    // инфо о спортивном снаряде
}
