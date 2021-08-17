package Lesson05;

public class HomeWorkApp {

    /**
     * Урок 5. Введение в ООП.
     * 1. Создать класс "Сотрудник" с полями: ФИО, возраст, должность, email, телефон, зарплата.
     * 2. Конструктор класса должен заполнять эти поля при создании объекта.
     * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
     * 4. Создать массив из 5 сотрудников.
     * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
     */

    public static void main(String[] args) {

        Person mainEmployee = new Person("Иванов", "Иван",
                "Иванович", "1@ya.ru", "8(999)999-99-99",
                "Директор", 100000, 1970);

        Person [] office = {
                mainEmployee,
                new Person("Петров", "Петр", "Петрович",
                        "2@ya.ru", "8(111)111-11-11", "Заместитель директора",
                        50000, 1990),
                new Person("Сидоров", "Сидор", "Сидорович",
                        "3@ya.ru", "8(222)222-22-22", "Программист",
                        50000, 1987),
                new Person("Николаев", "Николай", "Николаевич",
                        "4@ya.ru", "8(333)333-33-33", "Программист",
                        50000, 1975),
                new Person("Митяев", "Митяй", "Митяевич",
                        "N/A", "8(444)444-44-44", "Программист",
                        45000, 1996)
        };

        getAllPersonsInOffice(office);
        System.out.println("\nВывод списка сотрудников кто старше 40 лет:");
        getOldPerson(office, 40);

    }

    private static void getOldPerson(Person[] office, int year) {
        for (int i = 0; i < office.length; i++)
            if (office[i].getAge() > year) {
                System.out.println((("> " ) + office[i].getFullInfo()));
            }
    }

    private static void getAllPersonsInOffice(Person[] office) {
        System.out.println("Все сотрудники: ");
        for (int i = 0; i < office.length; i++)
            System.out.println((">") + " " + office[i].getFullInfo());
    }
}