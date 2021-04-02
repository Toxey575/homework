package lesson5;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        /*1. Задать массив на n слов.
        В цикле считывать с консоли слова (scanner.nextLine()),
        и добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
        В итоге в массиве будут только уникальные слова.
        Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен
        Перед завершением программы, вывести получившийся массив в консоль*/


        String[] wArr = new String[10];

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите слово ");
            String userStr = scanner.nextLine();
            System.out.println(userStr);
            if (userStr.equals("exit"))
                break;
            for (int i = 0; i < wArr.length; i++) {
                if (wArr[i] == null) {
                    wArr[i] = userStr;
                    break;
                }
                if (wArr[i].equals(userStr)) {
                    break;
                }
            }
            System.out.println(Arrays.toString(wArr));
        }


        /*2. Найти количество вхождений одной строки в другую.
        Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза*/


        String longLine = "домдомдомдомдомдомдомдомдомдомдом";
        String word = "дом";
        int match = 0;

        for (int i = 0, count = 0; i < longLine.length(); i++) {
            if (longLine.charAt(i) == word.charAt(count)) {
                count++;
            }
            if (count == word.length()) {
                match++;
                count = 0;
            }
        }
        System.out.println("Слово " + word + " встречается в предложении " + match + " раз.");


        /*3. Написать функцию, которая проверяет, является ли строка палиндромом.
        Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по
        буквам или по словам как слева направо, так и справа налево.
        Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром*/


        longLine = "а роза упала на лапу Азора";

        String temp = longLine.replaceAll(" ", "");
        String longLineR = new String();

        for (int i = temp.length() - 1, y = 0; y < temp.length(); i--, y++) {
            longLineR += temp.charAt(i);
        }

        boolean result = temp.equalsIgnoreCase(longLineR);

        if (result) System.out.println("Строка является палиндромом");


        /* 4. Заменить все буквы в слове на строчные, первую букву на заглавную
        Например, дано hello, получаем Hello / дано HeLLO, получаем Hello*/


        word = "КАРЛ у КлАрЫ украЛ КОРалЛы";
        word = word.toLowerCase();
        word = word.substring(0, 1).toUpperCase() + word.substring(1);

        System.out.println(word);


        /*5. Вводится с клавиатуры массив слов. Определить, сколько слов начинается на определенную букву.*/


        //scanner = new Scanner(System.in);
        //String userStr = scanner.nextLine();

        wArr = new String[]{"cat", "dog", "duck", "lion", "leopard", "canon", "tank", "shower", "yeet", "dude"};

        Arrays.sort(wArr);
        System.out.println(Arrays.toString(wArr));

        int i = 0, j = 0, count = 0;

        while (i < wArr.length) {
            if (wArr[i].charAt(0) == wArr[j].charAt(0)) {
                ++count;
            } else {
                j = j + count;
                System.out.println("Буква " + wArr[j].charAt(0) + " повторяется " + count + " раз");
                count = 0;
                --i;
            }
            ++i;
        }
    }
}