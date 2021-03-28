package lesson1;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {



//OUTPUT 1
        Replace replace = new Replace();
        ArrayList<String> arr = new ArrayList<>();
        arr.add("j");
        arr.add("a");
        arr.add("v");
        arr.add("a");
        arr.add("3");
        System.out.println(replace.switchIndex(arr, 0, 3));

//OUTPUT 2

        int[] a = {1, 2, 3, 4, 5, 67};
        System.out.println(replace.arrayToArrayList(a));


//OUTPUT 3

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Apple apple5 = new Apple();
        Apple apple6 = new Apple();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Orange orange4 = new Orange();
        Orange orange5 = new Orange();
        Orange orange6 = new Orange();

        Box<Apple> box1 = new Box<>();
        Box<Apple> box3 = new Box<>();

        Box<Orange> box2 = new Box<>();

        box1.addFruit(apple1);
        box1.addFruit(apple2);
        box1.addFruit(apple3);
        box1.addFruit(apple4);
        box1.addFruit(apple5);
        box1.addFruit(apple6);

        box2.addFruit(orange1);
        box2.addFruit(orange2);
        box2.addFruit(orange3);
        box2.addFruit(orange4);
        box2.addFruit(orange5);
        box2.addFruit(orange6);

        box3.addFruit(apple6);
        box3.addFruit(apple5);

        box3.addFromAnotherBox(box1);

        System.out.println(box3.compare(box2));


        System.out.println(box1.getArrayList());
        System.out.println(box2.getArrayList());
        System.out.println(box3.getArrayList());

    }
}
