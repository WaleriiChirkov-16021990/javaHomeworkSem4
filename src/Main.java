/*
Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.
 */

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public void first(Deque<Object> object){
        System.out.println("Первый элемент очереди: " + object.getFirst());
    }

    private void enqueue(Deque<Object> object){
        object.addLast(object.pollFirst());

    }
    private void dequeue(Deque<Object> object){
        System.out.println("Удаляем первый элемент очереди: " + object.removeFirst());
    }
    public static void main(String[] args) {
        Deque<Object> home = new LinkedList<>();
        Main main = new Main();
        home.push(5);
        home.push("R");
        home.push("S");
        home.push("u");
        home.push("p");
        home.push("e");
        home.push("r");
        System.out.printf("Текущая очередь: %s\n", home);
        main.enqueue(home);
        System.out.printf("Очередь после перемещения первого элемента: %s \n", home);
        main.dequeue(home);
        System.out.printf("Очередь после удаления первого элемента: %s \n", home);
        main.first(home);
        System.out.printf("Очередь после возвращения 1 элеменита без его удаления: %s \n", home);
    }
}