package exams.firstfitness;

import java.time.LocalDate;
import java.util.Arrays;

import static exams.firstfitness.Random.*;

public class Pass {
    private final LocalDate registrationDate;
    private final LocalDate expirationDate;
    private final String name;
    private final String surname;
    private final LocalDate dateOfBirth;
    private final PassType passType;

    public Pass() {
        Client client = new Client(genClientName(), genClientSurname(), genDateOfBirth());
        this.registrationDate = LocalDate.now();
        this.expirationDate = registrationDate.plusYears(1);
        this.name = client.getName();
        this.surname = client.getSurname();
        this.dateOfBirth = client.getDateOfBirth();
        int i = (int) (Math.random() * 3);
        this.passType = PassType.values()[i];
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
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

    public PassType getPassType() {
        return passType;
    }

    @Override
    public String toString() {
        return "АБОНЕМЕНТ. " +
                "Дата регистрации: " + registrationDate + ", " +
                "дата окончания: " + expirationDate + ", " + "\n" +
                "имя: " + name + ", " +
                "фамилия: " + surname + ", " +
                "дата рождения: " + dateOfBirth  + ", " + "\n" +
                "тип абонемнта: " + passType + "\n" +
                "--------------------------------------------------------------------";
    }
}
