package Lesson06;

/**
 * Урок 6. Продвинутое ООП
 * 1. Создать классы Собака и Кот с наследованием от класса Животное.
 * 2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
 * Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
 * 3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
 * плавание: кот не умеет плавать, собака 10 м.).
 * 4. * Добавить подсчет созданных котов, собак и животных.
 */

public class HomeWorkApp {

    public static void main(String[] args) {

        String tempWinEvent = " у него получилось.";
        String tempLossEvent = " у него не получилось.";
        String eventName;
        String eventResult;

        Cat cat1 = new Cat("Васька", 200, 0);
        Dog dog1 = new Dog("Чарли", 500, 10);

        Animals[] animals = {cat1, dog1};

        float runLength = 250;
        float swimLength = 8;

        for (Animals animal : animals) {
            String nameString = animal.getType() + " " + animal.getName() + " может ";

            eventName = "пробежать на " + animal.getMaxRun() + " м. Пытается пробежать на ";
            eventResult = animal.run(runLength) ? tempWinEvent : tempLossEvent;
            result(nameString, eventName, runLength, eventResult);

            int swimResult = animal.swim(swimLength);
            eventName = "проплыть на " + animal.getMaxSwim() + " м. Попытка проплыть на ";
            eventResult = (swimResult == Animals.SWIM_OK) ? tempWinEvent : tempLossEvent;

            if (swimResult == Animals.SWIM_NONE)
                eventResult = " это не получилось, т.к. не умеет плавать.";
            result(nameString, eventName, swimLength, eventResult);
        }

        System.out.print("\nВсего животных: " + Animals.countAnimal  + ". Из них:" +
                "\nКотиков: " + Cat.countCat + "\nПёсиков: " + Dog.countDog);
    }

    private static void result(String nameAnimal, String event, float eventLength, String resultEvent) {
        System.out.println(nameAnimal + event + eventLength + " м. и" + resultEvent);
    }

}
