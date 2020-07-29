package homeworknine;

public class OlympicGames {

    private static ActionInterface[] athleteArr;
    private static SportsEquipment[] equipmentArr;

    public OlympicGames(int athleteCount, int equipmentCount) {

        athleteArr = new ActionInterface[athleteCount];
        equipmentArr = new SportsEquipment[equipmentCount];

        for (int i = 0; i < athleteArr.length; i++) {
            if (i % 3 == 0) {
                athleteArr[i] = new Robot(i + 1);
            } else if (i % 2 == 0) {
                athleteArr[i] = new Human(i + 1);
            } else {
                athleteArr[i] = new Cat(i + 1);
            }
        }

        for (int i = 0; i < equipmentArr.length; i++) {
            if (i % 2 == 0) {
                equipmentArr[i] = new Wall();
            } else {
                equipmentArr[i] = new Treadmill();
            }
        }

    }

    public void startGame(){
        for (int i = 0; i < athleteArr.length; i++) {
            System.out.println("------Следующий спортсмен------");
            for (int j = 0; j < equipmentArr.length; j++) {
                equipmentArr[j].info();
                if (!athleteArr[i].doAction(equipmentArr[j])) { // если препядствие не преодолимо, далее не продолжаем
                    break;
                }
            }

        }
    }
}
