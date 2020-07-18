package homeworkseven;

public class HomeWorkSevenTasks {

    private Cat [] catHeap;                     // куча голодных котов
    private Plate plate = new Plate();
//    Plate plate = new Plate(40);              // если нужно конкретное кол-во еды в миске

    public HomeWorkSevenTasks(int catCount) {
        initCatHeap(catCount);
    }

    private void initCatHeap(int catCount) {
        catHeap = new Cat[catCount];
        for (int i = 0; i < catHeap.length; i++) {
            catHeap[i] = new Cat("Барсик_" + (i + 1));
        }
    }

    public void startCatDinner() {
        System.out.println("++++++++ОБЕД+++++++++");
        plate.info();
        for (Cat curCat : catHeap) {
            if (curCat.getAppetite() > plate.getPlateCapacity()) {
                System.out.print("Миска для " + curCat.getName() + " слишком маленькая. ");
                System.out.println("Нужна миска минимум на " + curCat.getAppetite() + " еды.");
                continue;
            }
            while (!curCat.getSatiety()) {          // пока кот не наелся
                while ((!curCat.eat(plate))){       // если не может есть, добавим еды
                    plate.addFood();
                }
                plate.info();
            }
        }
    }
}
