package ru.geekbrains.homework;

import java.util.Arrays;

public class ArrayUtils {

    /*
    Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
    идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку, иначе в методе
    необходимо выбросить RuntimeException. Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].

3. Написать метод, который проверяет состав массива из чисел 1 и 4.
 Если в нем нет хоть одной четверки или единицы, то метод вернет false;
 Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    * */

    public int[] splitArray(int[] array) {
        if (array == null) {
            throw new NullPointerException("Array is empty");
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                return Arrays.copyOfRange(array, i + 1, array.length);
            }
        }
        throw new RuntimeException("4 not found");
    }

    public boolean check14Array(int[] array) {
        boolean has1 = false;
        boolean has4 = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                has1 = true;
            }
            if (array[i] == 4) {
                has4 = true;
            }
            if (array[i] != 1 && array[i] != 4) {
                return false;
            }
        }
        return has1 && has4;
    }


}
