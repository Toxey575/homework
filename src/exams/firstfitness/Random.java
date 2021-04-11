package exams.firstfitness;

import java.time.LocalDate;

public class Random {

    public static String genClientName() {
        String[] authorsN = {"Игорь", "Наталья", "Федор", "Александр", "Анатолий", "Татьяна", "Олег", "Дарья", "Николай", "Роман",};
        return authorsN[(int) (Math.random() * 10)];
    }

    public static String genClientSurname() {
        String[] authorsS = {"Хороший", "Плохой", "Бедненький", "Больной", "Богатый", "Синий", "Берёзка", "Белочка", "Суслик", "Телек"};
        return authorsS[(int) (Math.random() * 10)];
    }

    public static LocalDate genDateOfBirth() {
        String strDate = null;

        int yGen = 1960 + (int) (Math.random() * 50);
        int mGen = 1 + (int) (Math.random() * 11);
        int dGen = 1 + (int) (Math.random() * 27);

        if (mGen < 10 && dGen < 10) strDate = yGen + "-" + "0" + mGen + "-" + "0" + dGen;
        else if (mGen >= 10 && dGen < 10) strDate = yGen + "-" + mGen + "-" + "0" + dGen;
        else if (mGen < 10 && dGen >= 10) strDate = yGen + "-" + "0" + mGen + "-" + dGen;
        else strDate = yGen + "-" + mGen + "-" + dGen;

        return LocalDate.parse(strDate);

    }



}
