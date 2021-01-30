package HW_1;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void swap (int[] arr, int el1, int el2) {
        if (el1 >=0 && el1 < arr.length && el2 >= 0 && el2 < arr.length) {
            int temp = arr[el1];
            arr[el1] = arr[el2];
            arr[el2] = temp;
        }
    }
    public static <T> ArrayList<T> change (T[] arr) {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(arr));
        return list;
    }

    public static void main (String[] args) {

        // #1
        int[] testarr = new int[] {1, 2, 3, 4, 5};
        swap(testarr, 2, 4);

        // #2
        String[] stringArr = new String[] {"Январь", "Февраль", "Март", "Апрель"};
        Integer[] integerArr = new Integer[] {12, 13, 14};
        ArrayList<Integer> integers = change(integerArr);
        ArrayList<String> strings = change(stringArr);

        // #3
        Box<Apple> boxOfApple = new Box<>();
        for (int i = 0; i < 5; i++) {
            boxOfApple.addFruitInBox(new Apple());
        }
        Box<Orange> boxOfOrange = new Box<>();
        for (int i = 0; i < 9; i++) {
            boxOfOrange.addFruitInBox(new Orange());
        }



    }

}
