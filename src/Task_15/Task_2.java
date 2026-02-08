package Task_15;

//Задача 2:
//Создать класс, который будет хранить в себе коллекцию с названиями животных.
//Реализовать методы удаления и добавления животных по следующим правилам:
//добавляется всегда в начало коллекции, а удаляется всегда из конца. Показать работу
//объекта этого класса в main методе другого класса.

import java.util.ArrayDeque;
import java.util.Scanner;

public class Task_2 {

    public static class Animals {

        ArrayDeque<String> deque = new ArrayDeque<>();

        public void animalsAdd(String input) {
           deque.addFirst(input);
        }

        public void animalRemove() {
            System.out.println("Текущий порядок " + deque);
           deque.removeLast();
            System.out.println("Порядок после удаления " + deque);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);;
        Task_2.Animals animals = new Task_2.Animals();
        boolean isComplete = false;
        while (!isComplete) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Введите название животного");
                String input = scanner.nextLine();
                animals.animalsAdd(input);
            }
            isComplete = true;
        }
        animals.animalRemove();
    }
}


