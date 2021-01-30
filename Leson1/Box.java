package HW_1;

import java.util.ArrayList;

public class Box <T extends Fruit> {

    private T fruit;
    private ArrayList<Fruit> listOfFruit = new ArrayList<>();
    private float weightOfBox;

    public Box() {

    }

    public void addFruitInBox (T fruit) {
        listOfFruit.add(fruit);
        weightOfBox = weightOfBox + fruit.getWeight();
    }

    public void removeFruitOutBox (T fruit) {
        listOfFruit.remove(fruit);
        weightOfBox = weightOfBox - fruit.getWeight();
    }

    public int getValueOfFruits(){
        return listOfFruit.size();
    }

    public float getWeightOfBox() {
        return weightOfBox;
    }

    public boolean compare (Box<?> another) {
        return Math.abs(this.weightOfBox - another.getWeightOfBox()) < 0.0001;
    }

    public void shift (Box<T> boxDestination) {
        for (int i = 0; i < listOfFruit.size(); i++) {
            boxDestination.addFruitInBox((T) listOfFruit.get(i));
            removeFruitOutBox((T) listOfFruit.get(i));

        }
    }

}
