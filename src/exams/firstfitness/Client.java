package exams.firstfitness;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.SortedMap;

public class Client {
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;

    public Client(String name, String surname, LocalDate dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Клиент: " +
                "Имя: " + name +
                ", Фамилия: " + surname +
                ", Дата рождения: " + dateOfBirth;
    }
}
