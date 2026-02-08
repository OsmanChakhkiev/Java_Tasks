package Task_15;

// Задача 3:
//Создать класс Student, содержащий следующие характеристики – имя, группа, курс,
//оценки по предметам. Создать коллекцию, содержащую объекты класса Student.
//Написать метод, который удаляет студентов со средним баллом <3. Если средний
//балл>=3, студент переводится на следующий курс. Дополнительно написать метод
//printStudents(List<Student> students, int course), который получает список студентов и
//номер курса. А также печатает на консоль имена тех студентов из списка, которые
//обучаются на данном курсе.


import java.util.ArrayList;
import java.util.List;

public class Task_3 {

    public static class Student {

        public String name;
        public String group;
        public int course;

        public int biology;
        public int maths;
        public int physics;
        public int chemistry;
        public int worldHistory;

        public double averageMark;


        public Student(String name, String group, int course, int biology, int maths, int physics, int chemistry, int worldHistory) {
            this.name = name;
            this.group = group;
            this.course = course;

            this.biology = biology;
            this.maths = maths;
            this.physics = physics;
            this.chemistry = chemistry;
            this.worldHistory = worldHistory;

            this.averageMark = java.util.stream.DoubleStream.of(biology, maths, physics, chemistry, worldHistory)
                    .average()
                    .orElse(0.0);
        }

        @Override
        public String toString() {
            return "Студент: " + name + ", Курс: " + course + ", Средний балл: " + averageMark;
        }

    }


    public static void processStudents (List<Student> students) {
        students.removeIf(student -> student.averageMark <= 3);
        for (Student student : students) {
            student.course++;
        }
    }

    public static void printStudents(List<Student> students, int course) {
        for (Student student : students) {
            System.out.println("Имя студента: " + student.name + " " + "Курс: " + course);
        }

        System.out.println("Список студентов выбранного курса " + course);
        boolean isComplete = false;
        for (Student student : students) {
            if (student.course == course) {
                System.out.println(student.name);
                isComplete = true;
            }
        }

        if(!isComplete) {
            System.out.println("Курс пустой");
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Dmitry", "5", 1, 4, 4, 5, 3, 4);
        Student student2 = new Student("Olga", "4", 1, 3, 5, 5,4, 2);
        Student student3 = new Student("Alex", "3", 2, 5, 2,3, 4, 5);
        Student student4 = new Student("Peter", "1", 3, 2, 3,3,2, 3);
        Student student5 = new Student("Lara", "2", 1, 3, 2, 2, 2, 2);
        ArrayList<Student> objects = new ArrayList<>();
        objects.add(student1);
        objects.add(student2);
        objects.add(student3);
        objects.add(student4);
        objects.add(student5);

        System.out.println("Список всех студентов " + objects);

        processStudents(objects);

        System.out.println("Список студентов со средним баллом больше либо равно 3 " + objects);

        printStudents(objects, 2);
        }
    }




