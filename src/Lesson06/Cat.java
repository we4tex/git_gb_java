package Lesson06;

class Cat extends Animals {

    public static int countCat = 0;
    private static final String thisTypeAnimal = "Котик";

    Cat(String name, float maxRun, float maxSwim) {
        super(thisTypeAnimal, name, maxRun, maxSwim);
        ++countCat;
    }

    @Override
    protected int swim(float distance) {
        return Animals.SWIM_NONE;
    }

}