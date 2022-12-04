/*
Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.
 */

import java.util.Collections;
import java.util.LinkedList;

public class theFirstTaskSem4 {
    public static void main(String[] args) {
        LinkedList<Integer> originalList = new LinkedList<>();
        originalList.add(0);
        originalList.add(2);
        originalList.add(3);
        originalList.add(6);
        originalList.add(7);
        originalList.add(10);
        originalList.add(1459675);
        System.out.println(originalList);
        Collections.reverse(originalList);
        System.out.println(originalList);
    }
}
