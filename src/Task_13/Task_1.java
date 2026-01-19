package Task_13;


// Задача 1:
//Создать класс, в котором будет статический метод. Этот метод принимает на вход три
//параметра: login, password, confirmPassword. Все поля имеют тип данных String. Длина
//login должна быть меньше 20 символов и не должен содержать пробелы. Если login не
//соответствует этим требованиям, необходимо выбросить WrongLoginException. Длина
//password должна быть меньше 20 символов, не должен содержать пробелом и должен
//содержать хотя бы одну цифру. Также password и confirmPassword должны быть равны.
//Если password не соответствует этим требованиям, необходимо выбросить
//WrongPasswordException. WrongPasswordException и WrongLoginException -
//пользовательские классы исключения с двумя конструкторами – один по умолчанию,
//второй принимает сообщение исключения и передает его в конструктор класса Exception.
//Метод возвращает true, если значения верны, false в противном случае

import java.util.Scanner;

public class Task_1 {

    public static class WrongLoginException extends Exception {

        public WrongLoginException () {
        }

        public WrongLoginException (String message) {
            super(message);
        }

    }

    public static class WrongPasswordException extends Exception {

        public WrongPasswordException () {

        }

        public WrongPasswordException (String message) {
            super(message);
        }
    }

    public static boolean formValidation (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {

        if (login.length() >= 20) {
            throw new WrongLoginException("Ошибка! Длина логина не должна превышать 19 символов");
        }
        if (login.isEmpty()) {
            throw new WrongLoginException("Ошибка! логин не должен быть пустым");
        }
        if (login.contains(" ")) {
            throw new WrongLoginException("Ошибка! логин не должен содержать пробелов");
        }
        if (password.length() >= 20) {
            throw new WrongPasswordException("Ошибка! Длина пароля не должна превышать 19 символов");
        }
        if (password.isEmpty()) {
            throw new WrongPasswordException("Ошибка! пароль не должен быть пустым");
        }
        if (password.contains(" ")) {
            throw new WrongLoginException("Ошибка! пароль не должен содержать пробелов");
        }
        if (!password.matches(".*\\d.*")) {
            throw new WrongLoginException("Ошибка! пароль должен содержать хотя бы одну цифру");
        }
        if (!confirmPassword.equals(password)) {
            throw new WrongLoginException("Ошибка! пароли не совпадают");
        }
        return true;
    }

    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин");
        String login = scanner.nextLine();

        System.out.println("Введите пароль");
        String password = scanner.nextLine();

        System.out.println("Подтвердите пароль");
        String confirmPassword = scanner.nextLine();

        try {
            boolean result = formValidation(login, password, confirmPassword);
            if (result) {
                System.out.println("Регистрация прошла успешно");
            }
        } catch (WrongPasswordException | WrongLoginException e) {
            System.out.println("Ошибка регистрации: " + e.getMessage());
        }
    }
}
