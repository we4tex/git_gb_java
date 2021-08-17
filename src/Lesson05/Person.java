package Lesson05;

class Person {
    private static final int CURRENT_YEAR = 2021;
    private String surname;
    private String secondName;
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int birthYear;
    public Person(String surname,
                  String name,
                  String secondName,
                  String email,
                  String phone,
                  String position,
                  int salary,
                  int birthYear) {
        this.birthYear = birthYear;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
    }
    int getAge() {
        return CURRENT_YEAR - birthYear;
    }
    int getSalary() {
        return salary;
    }
    String getPosition() {
        return position;
    }
    String getPhone() {
        return phone;
    }
    String getEmail() {
        return email;
    }
    String getSecondName() {
        return secondName;
    }
    String getName() {
        return name;
    }
    String getSurname() {
        return surname;
    }
    String getFullInfo() {
        return this.surname + " " +
                this.name + " " +
                this.secondName + ", " +
                this.getAge() + " лет, " +
                this.position + ". E-mail: " +
                this.email + ". Телефонный номер:: " +
                this.phone + ". Зарплата: " +
                this.getSalary() + " рублей.";
    }
}