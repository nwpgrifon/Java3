package lesson1;
/*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;



 */


import java.util.ArrayList;

public class Replace implements SwitchArrayIndex <ArrayList<String>, Integer>, ArrayToArrayList<int[], ArrayList<Integer>> {

    @Override
    public ArrayList<String> switchIndex(ArrayList<String> strings, Integer index1, Integer index2) {
        String a = strings.get(index1);
        strings.set(index1, strings.get(index2));
        strings.set(index2, a);
        return strings;
    }

    @Override
    public ArrayList<Integer> arrayToArrayList(int[] ints) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int e: ints) {
            arr.add(e);
        }
        return arr;
    }
}
