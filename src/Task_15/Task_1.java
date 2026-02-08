package Task_15;

//Задача 1:
//Пользователь вводит набор чисел в виде одной строки с клавиатуры. Например: "1, 2, 3,
//4, 4, 5". Избавиться от повторяющихся элементов в строке. Вывести результат на экран.
//При решении использовать коллекции.


import java.util.ArrayList;
import java.util.HashSet;

public class Task_1 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("4");
        list.add("5");
        HashSet<String> hashSet = new HashSet<>(list);
        System.out.println(hashSet);
    }
}
