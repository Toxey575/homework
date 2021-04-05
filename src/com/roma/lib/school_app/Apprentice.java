package com.roma.lib.school_app;

import static com.roma.lib.school_app.Randoms.*;

public class Apprentice implements CanLearn {

    private final String name = nameGen();
    private final int age = kidAge();
    private String subject = subjectGen();
    public int intellect = 0;

    public static Apprentice getApprentice() {
        return new Apprentice();
    }


    public void tryToLearn () {
        int x = (int) (Math.random() * 100);
        if (x >= 30) {
            this.intellect += 1;
            System.out.println(this.name + " стал умнее.");
        } else {
            System.out.println("Не получилось =(");
        }
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSubject() {
        return subject;
    }

    public int getIntellect() {
        return intellect;
    }
    // ---------------------------------------------------

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Ученик. Имя: " + name +
                ", Возрат: " + age +
                ", Предмет: " + subject +
                ", Интелект: " + intellect;
    }
}
