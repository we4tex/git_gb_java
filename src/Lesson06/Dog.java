package Lesson06;

class Dog extends Animals {

    public static int countDog = 0;
    private static final String thisTypeAnimal = "Пёсик";

    Dog(String name, float maxRun, float maxSwim) {
        super(thisTypeAnimal, name, maxRun, maxSwim);
        ++countDog;
    }

}
