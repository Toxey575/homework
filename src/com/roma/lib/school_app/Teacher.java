package com.roma.lib.school_app;

import static com.roma.lib.school_app.Randoms.*;

public class Teacher /*implements CanTeach*/ {

    private final String name = nameGen();
    private final int age = adultAge();
    private final String subject = subjectGen();

    public static Teacher getTeacher() {
        return new Teacher();
    }


    public void startLesson(Apprentice[] apprentices) {
        for (int i = 0; i < apprentices.length; i++) {
            if (this.subject.equals(apprentices[i].getSubject()) || apprentices[i] != null) {
                System.out.println("Учитель " + this.subject + " " + this.name + " пытается научить " + apprentices[i].getName());
                apprentices[i].tryToLearn();
            }
        }
    }


    @Override
    public String toString() {
        return "Учитель. Имя: " + name +
                ", Возрат: " + age +
                ", Предмет: " + subject;
    }
}
