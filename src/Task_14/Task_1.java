package Task_14;

//Задача 1:
//В задании приложен файл Ромео и Джульетта на английском, вычитать его в приложении.
//Проанализировать и записать в другой файл самое длинное слово.

import java.io.*;

public class Task_1 {

    public static void main(String[] args) {
        File folder = new File("C:\\Users\\osman\\Documents\\java" );
        File file = new File(folder, "RomeoAndJuliet.txt");
        try {
            folder.mkdir();
            if (file.createNewFile()) {
                System.out.println("Файл: " + file.getName() + " " + "успешно создан");
            } else {
                System.out.println("Файл уже существовал");
            }
        } catch (IOException e) {
            throw new RuntimeException("Не удалось создать файл" + e.getMessage());
        }
        System.out.println(file.exists());
        String text = "Romeo and Juliet is a tragedy written by William Shakespeare about the romance between two young Italians from feuding families.";
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte [] buffer = text.getBytes();
            fileOutputStream.write(buffer , 0, buffer.length);
            System.out.println("Текст успешно записан в файл " + file.getName());
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи текста " + e.getMessage());
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte [] fileBytes = new byte[(int) file.length()];
            fileInputStream.read(fileBytes);
            String longestWord = "";
            StringBuilder currentWord = new StringBuilder();
            for (byte b : fileBytes) {
                char c = (char) b;
                if (Character.isLetter(c)) {
                    currentWord.append(c);
                } else {
                    if (currentWord.length() > longestWord.length()) {
                        longestWord = currentWord.toString();
                    }
                    currentWord.setLength(0);
                }
            }
            if (currentWord.length() > longestWord.length()) {
                longestWord = currentWord.toString();
            }
            try {
                File file1 = new File(folder, "RomeoAndJulietLongestWord.txt");
                FileOutputStream fileOutputStream = new FileOutputStream(file1);
                byte [] buffer = longestWord.getBytes();
                fileOutputStream.write(buffer , 0, buffer.length);
                System.out.println("Самое длинное слово записано в файл " + file1.getName());
            } catch (IOException e) {
                throw new RuntimeException("Ошибка записи текста " + e.getMessage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
