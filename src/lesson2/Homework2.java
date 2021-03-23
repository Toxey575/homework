package lesson2;

import java.util.Scanner;

public class Homework2 {
    public static void main(String[] args) {

            // Задача на if
            System.out.println("Задача 1");
            int count = 3;
            System.out.println("Число правильных ответов: " + count);

            if (count >= 90) {
                System.out.println("Отлично");
            } else if (count >= 60) {
                System.out.println("Хорошо");
            } else if (count >= 40) {
                System.out.println("Удовлетворительно");
            } else  {
                System.out.println("Попробуйте в следующий раз");
            }

            // Задача на switch
            System.out.println("Задача 2");
            Scanner scanner = new Scanner(System.in);
            int first, second, op;
            System.out.println("Введите первый операнд");
            first = scanner.nextInt();
            System.out.println("Введите второй операнд");
            second = scanner.nextInt();
            System.out.println("Введите 3 это +, 5 это -, 7 это *, 9 это /: ");
            op = scanner.nextInt();

            switch (op) {
                case 3 -> System.out.println(first + second);
                case 5 -> System.out.println(first - second);
                case 7 -> System.out.println(first * second);
                case 9 -> System.out.println(first / second);
            }

            // Задача на цикл while
            System.out.println("Задача 3");
            int plateD = 100, plateC = 0;
            float aos = 24;

            while (aos > 0 && plateD > 0) {
                aos -= 0.5;
                --plateD;
                ++plateC;
            }
            System.out.println("Осталось средства: " + aos + ", " + "Помыто тарелок: " + plateC + ", " + "Осталось тарелок: " + plateD);


            // Программа загадывает число в диапазоне [1;9]
            System.out.println("Задача 4");
            int compNum = 1 + (int) (Math.random() * 8), playerNum;
            System.out.println("Загаданное число: " + compNum);

            while (true) {
                System.out.println("Введите число: ");
                playerNum = scanner.nextInt();
                if (compNum > playerNum) {
                    System.out.println("Загаданное число больше");
                }
                if (compNum < playerNum) {
                    System.out.println("Загаданное число меньше");
                }
                if (compNum == playerNum) {
                    System.out.println("Вы угадали!");
                    break;
                }
                if (playerNum == 0) {
                    System.out.println("До свидания");
                    break;
                }
            }

            // Задача на Math.random() и if
            System.out.println("Задача 5");
            int randNum = 10 + (int) (Math.random() * 490);
            System.out.println("Случайное число: " + randNum);

            if (randNum <= 200 && randNum >= 25) {
                System.out.println("Число " + randNum + " содержится в интервале");
            } else {
                System.out.println("Число " + randNum + " не содержится в интервале");
            }

            // Пользователь!!! загадывает число в диапазоне от [1 до 100]
            System.out.println("Задача 6");
            int targetNum, compGuess, min = 1, max = 99,xxx, compQ, resultNum = 0, playerTip;
            // переменные

            System.out.println("Введите число: ");
            targetNum = scanner.nextInt();
            // ввод искомого числа

            while (targetNum != resultNum) {
                xxx = (max - min) + 1;
                System.out.println("Загаданное число: " + targetNum);

                compGuess = min + (int) (Math.random() * xxx);
                // генерация числа компьютера

                System.out.println("Комп думает, что это число " + compGuess);
                System.out.println("Диапазон поиска: " + min + "-" + max);

                compQ = 2 + (int) (Math.random() * 2);
                // генерация цифры для выбора вопроса компа
                if (max - min <= 5) compQ = 1;

                switch (compQ) {
                    case 1:
                        System.out.println("Число равно " + compGuess + "?");
                        playerTip = scanner.nextInt();
                        if (playerTip == 0) {
                            resultNum = compGuess;
                        }
                        if (playerTip == 1) {
                            break;
                        }
                        break;
                    case 2:
                        System.out.println("Число больше " + compGuess + "?");
                        playerTip = scanner.nextInt();
                        if (playerTip == 0) {
                            min = compGuess + 1;
                        }
                        if (playerTip == 1) {
                            max = compGuess;
                        }
                        break;
                    case 3:
                        System.out.println("Число меньше " + compGuess + "?");
                        playerTip = scanner.nextInt();
                        if (playerTip == 0) {
                            max = compGuess - 1;
                        }
                        if (playerTip == 1) {
                            min = compGuess;
                        }
                        break;
                }
            }
            System.out.println("УРА!");























    }
}
