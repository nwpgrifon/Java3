package lesson6;

import java.util.ArrayList;
import java.util.Collections;

/*
Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
идущих после последней четверки. Входной массив должен содержать хотя бы одну четверку,
иначе в методе необходимо выбросить RuntimeException.
Написать набор тестов для этого метода (по 3-4 варианта входных данных). Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
*/
/*
3. Написать метод, который проверяет состав массива из чисел 1 и 4.
Если в нем нет хоть одной четверки или единицы, то метод вернет false;
Написать набор тестов для этого метода (по 3-4 варианта входных данных).
*/

public class Main {

    public ArrayList<Integer> foo(int[] arr) {


        ArrayList<Integer> tempArrayList = new ArrayList();

        for (int a : arr) {
            tempArrayList.add(a);
        }
        if (!tempArrayList.contains(4)) {
            throw new RuntimeException("there is no fours");
        }
        Collections.reverse(tempArrayList);
        ArrayList<Integer> exitArrayList = new ArrayList();
        for (Integer a : tempArrayList) {
            if (!a.equals(4)) {
                exitArrayList.add(a);
            } else break;
        }
        Collections.reverse(exitArrayList);
        return exitArrayList;
    }

    public static boolean bar(int[] arr) {
        ArrayList<Integer> tempArrayList = new ArrayList();
        for (int a : arr) {
            tempArrayList.add(a);
        }
        if (!tempArrayList.contains(4) && !tempArrayList.contains(1)) {
            return false;
        } else return true;

    }

//        private static final Logger logger = LogManager.getLogger(Main.class);

    }

