package HW6;

public class ArraysMethods {

    public static void main (String[] args) {

    }

    public int[] extract(int[] arr) {
        int[] result;
        int marker = arr.length;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 4) {
                marker = i + 1;
                counter++;
            }
        }
        if (counter == 0) {
            throw new RuntimeException("В массиве отсутствуют четверки");
        } else {
            result = new int[arr.length - marker];
            if ((arr.length - marker) != 0) {
                for (int i = 0; i < result.length; i++) {
                    result[i] = arr[marker + i];
                }
            }
        }
        return result;
    }

    public boolean checkArray(int[] arr) {
        int counterOfOne = 0;
        int counterOfFour = 0;
        int counterOfAnotherNumber = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1)
                counterOfOne++;
                else if (arr[i] == 4)
                    counterOfFour++;
                    else
                        counterOfAnotherNumber++;
        }
        return counterOfOne != 0 && counterOfFour != 0 && counterOfAnotherNumber == 0;
    }

}
