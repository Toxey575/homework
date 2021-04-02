package lesson5;

import java.util.Arrays;
import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
// 1. Задать массив на n слов.
// В цикле считывать с консоли слова (scanner.nextLine()),
// и добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
// В итоге в массиве будут только уникальные слова.
// Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен
// Перед завершением программы, вывести получившийся массив в консоль

        /*Scanner scanner = new Scanner(System.in);
        while (true) {
            String userStr = scanner.nextLine();
            for (String arg : args) {


            }
        }*/








// 2. Найти количество вхождений одной строки в другую.
// Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза





// 3. Написать функцию, которая проверяет, является ли строка палиндромом.
// Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по буквам или по словам как слева направо,
// так и справа налево.
// Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром




// 4. Заменить все буквы в слове на строчные, а первую букву на заглавную
// Например, дано hello, получаем Hello / дано HeLLO, получаем Hello






// 5. Вводится с клавиатуры массив слов. Определить, сколько слов начинается на определенную букву.

        //String[] wordsArr = new String[10];
        String[] wordsArr = {"aasdsf", "asfasf", "asfas", "assdb", "basdsf", "bsfasf", "csfas", "bssdb", "fsfas", "assdb"};
        char[] fCharArr = new char[10];

        for (int i = 0; i < 10; i++) {
            //Scanner scanner = new Scanner(System.in);
            //wordsArr[i] = scanner.nextLine();
            char[] formStr = wordsArr[i].toCharArray();
            fCharArr[i] = formStr[0];
        }

        Arrays.sort(fCharArr);
        System.out.println(Arrays.toString(fCharArr));

        int min = 0, count = 0, max = 9, i = 0;

       while (i < 10)  {
           if (fCharArr[i] <= fCharArr[min]/*fCharArr[i] < fCharArr[min]*/) {
               count++;
               i++;
               System.out.println(i);
           } else {
               System.out.println(fCharArr[min] + " - " + count + " штук");
               min = min + count;
               System.out.println("min = " + min);
               count = 0;
           }

       }











    }
}
