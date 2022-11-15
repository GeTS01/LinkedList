import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedMethods<Student> linkedList = new LinkedMethods<>();

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Выберите действие \n" +
                    "1) Показать колличество студентов\n" +
                    "2) Проверить содержит ли список студентов(true - не содержит)\n" +
                    "3) Проверить есть ли такое студент\n" +
                    "4) Итератор\n" +
                    "5) Переделать лист в Массив\n" +
                    "6) \n" +
                    "7) Добавить студента\n" +
                    "8) Удалить студента\n" +
                    "9) Проверить есть ли такой список\n" +
                    "10) Добавить список студентов\n" +
                    "11) Довавить список студентов по индексу\n" +
                    "12) Удаление списка\n" +
                    "13) Очистить список студентов\n" +
                    "14) Получить студента\n" +
                    "15) Заменить студента\n" +
                    "16) Добавить студента по указанному индексу\n" +
                    "17) Получить индекс студента с начало списка\n" +
                    "18) Помучить индекс студента с конца списка");

            System.out.println("");
            int number = scanner.nextInt();
            if (number == 1) {
                System.out.println(linkedList.size());
            } else if (number == 2) {
                System.out.println(linkedList.isEmpty());
            } else if (number == 3) {
                containsStudent();
            } else if (number == 1231231) {
                System.out.println(linkedList.iterator().hasNext());
                System.out.println(linkedList.iterator().next());
            } else if (number == 5) {
                System.out.println(Arrays.toString(linkedList.toArray()));
            } else if (number == 6) {
                System.out.println(linkedList.getLast());
            } else if (number == 7) {
                addStudent();
            } else if (number == 8) {
                removeStudent();
            } else if (number == 9) {
                containsAllStudent();
            } else if (number == 10) {
                addAllStudent();
            } else if (number == 11) {
                addAllIndexStudent();
            } else if (number == 12) {
                removeRetainAllStudent();
            } else if (number == 13) {
                linkedList.clear();
            } else if (number == 14) {
                getStudent();
            } else if (number == 15) {
                setStudent();
            } else if (number == 16) {
                addIndexStudent();
            } else {
                System.out.println("Такого варианта нет");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            menu();
        }
    }

    public static void containsStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя студента");
        String name = scanner.nextLine();
        System.out.println("Введите возраст студента");
        int age = scanner.nextInt();
        Student student = new Student(name, age);
        linkedList.add(student);
        System.out.println(linkedList.contains(student));
    }

    public static void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя студента");
        String name = scanner.nextLine();
        System.out.println("Введите возраст студента");
        int age = scanner.nextInt();
        Student student = new Student(name, age);
        System.out.println("Выбериет добавление: " +
                "1) linked\n" +
                "2) deque");
        int number = scanner.nextInt();
        if (number == 1) {
            System.out.println(linkedList.add(student));
        }else if(number == 2){
            linkedList.addFirst(student);
        }else {
            System.out.println("Такого варианта нет");
        }
    }

    public static void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student("1", 1);
        System.out.println("Выберите тип удаление \n" +
                "1) Как объект\n" +
                "2) По индексу");
        int number = scanner.nextInt();
        if (number == 1) {
            linkedList.remove(student);
        } else if (number == 2) {
            System.out.println("Выберите индекс студента для удаления");
            int number1 = scanner.nextInt();
            linkedList.remove(number1);
        } else {
            System.out.println("Такого варианта нет");
        }
    }

    public static void setStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите элемент который хотите заменить");
        int number = scanner.nextInt();
        Student student = new Student("5", 20);
        System.out.println(linkedList.set(number, student));
    }

    public static void getStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите элемент который хотите заменить");
        int number = scanner.nextInt();
        System.out.println(linkedList.get(number));
    }

    public static void addAllStudent() {
        Student st1 = new Student("Георгий", 21);
        Student st2 = new Student("Иван", 22);
        LinkedList<Student> Link = new LinkedList<>();
        Link.add(st1);
        Link.add(st2);
        System.out.println(linkedList.addAll(Link));
    }

    public static void containsAllStudent() {
        Student st1 = new Student("1", 1);
        Student st2 = new Student("2", 2);
        LinkedList<Student> Link = new LinkedList<>();
        Link.add(st1);
        Link.add(st2);
        linkedList.addAll(Link);
        System.out.println(linkedList.containsAll(Link));
    }

    public static void removeRetainAllStudent() {
        Scanner scanner = new Scanner(System.in);
        Student st1 = new Student("1", 1);
        Student st2 = new Student("2", 2);
        LinkedList<Student> Link = new LinkedList<>();
        Link.add(st1);
        Link.add(st2);
        linkedList.addAll(Link);
        System.out.println("Выберите удаление списка:\n" +
                "1) Удаление студантов переданного списка\n" +
                "2) Удаление всех студентов, кроме переданного списка ");
        int number = scanner.nextInt();
        if (number == 1)
            System.out.println(linkedList.removeAll(Link));
        else if (number == 2)
            System.out.println(linkedList.retainAll(Link));
        else
            System.out.println("Такого варианта нет");
    }

    public static void addIndexStudent() {
        Scanner scanner1 = new Scanner(System.in);
        Student student = new Student("urgb", 56);
        int number1 = scanner1.nextInt();
        linkedList.add(number1, student);
    }

    public static void addAllIndexStudent() {
        Scanner scanner1 = new Scanner(System.in);
        Student student1 = new Student("11", 11);
        LinkedList<Student> link1 = new LinkedList<>();
        link1.add(student1);
        Student student2 = new Student("22", 22);
        LinkedList<Student> link2 = new LinkedList<>();
        link2.add(student2);
        System.out.println(" Выберите индекс в который хотите добавить студентов");
        int number1 = scanner1.nextInt();
        int number2 = scanner1.nextInt();
        linkedList.addAll(number1, link1);
        linkedList.addAll(number2, link2);

    }
}
