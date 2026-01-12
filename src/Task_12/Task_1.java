package Task_12;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Задача 1:
//Вывести в консоль из строки которую пользователь вводит с клавиатуры все
//аббревиатуры. Аббревиатурой будем считать слово от 2 до 6 символов, состоящее
//только из прописных букв, без чисел
public class Task_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (!input.trim().isEmpty()) {
                Pattern p = Pattern.compile("\\b[A-ZА-ЯЁ]{2,6}\\b");
                Matcher m = p.matcher(input);
                boolean isFound = false;
                while (m.find()) {
                    System.out.println("Найденная аббревиатура: " + m.group());
                    isFound = true;
                }
                if (!isFound) {
                    System.out.println("Аббревиатур нет");
                }
                break;
            } else {
                System.out.println("Введена пустая строка");
            }
        }
    }
}

