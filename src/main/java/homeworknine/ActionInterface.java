package homeworknine;

public interface ActionInterface {

    boolean jump(Wall wall);            // прыжки

    boolean run(Treadmill treadmill);   // бег

    default boolean doAction(SportsEquipment eq) { // логика действий в зависимости от спортивного снаряда
        if (eq instanceof Wall) {
            return jump(((Wall) eq));
        }
        if (eq instanceof Treadmill) {
            return run(((Treadmill) eq));
        }
        return false;
    }

}
