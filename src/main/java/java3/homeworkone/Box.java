package java3.homeworkone;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruitInBox;

    public Box() {
        fruitInBox = new ArrayList<>();
    }

    /**
     *
     * Получить фес всех фруктов в коробке
     *
     * @return  Общий вес фруктов
     */
    public float getWeight() {
        float totalWeight = 0.0f;
        if (fruitInBox != null && fruitInBox.size() > 0) {
            totalWeight = fruitInBox.get(0).getWeight() * fruitInBox.size();
        }
        return totalWeight;
    }

    /**
     *
     * Добавить фрукт в коробку
     *
     * @param fruit     новый фрукт
     */

    public void putFruitInBox(T fruit) {

        fruitInBox.add(fruit);
    }

    /**
     *
     * Удаление фрукта из коробки
     *
     * @return  фрукт
     */

    public T removeFruitFromBox() {
        if (fruitInBox.size() > 0) {
            return fruitInBox.remove(fruitInBox.size() - 1);
        }
        return null;
    }

    /**
     *
     * Перекладывает фрукты в другую коробку с таким же типом фруктов
     *
     * @param toBox     коробка в которую перекладываем фрукты
     */

    public void moveToAnotherBox(Box<T> toBox) {
        while (fruitInBox.size() > 0){
            T currentFruit = this.removeFruitFromBox();
            if (currentFruit != null) {
                toBox.putFruitInBox(currentFruit);
            }
        }
    }

    /**
     *
     * Сравнение веса фруктов в текущей коробке, с другой коробкой
     *
     * @param box   коробка фруктов для сравнения
     * @return      false если вес фруктов коробках разный. true если вес одинаков
     */

    public boolean compareBox(Box<?> box) {

        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }
}
