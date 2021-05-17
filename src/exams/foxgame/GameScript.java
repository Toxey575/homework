package exams.foxgame;

import exams.foxgame.utils.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static exams.foxgame.utils.Settings.*;
import static exams.foxgame.utils.Status.*;

public class GameScript {
    private static int currentStage;
    private static Status status = INPROGRESS;
    private static final Scanner scanner = new Scanner(System.in);
    public static final ArrayList<HashMap<Integer, String>> gameText = new ArrayList<>();
    private static final String[] choice = {"1. Вернуться домой\n" +
            "2. Отправиться на поиски", "1. Попытаться разузнать о Бельчонке у лесных жителей\n" +
            "2. Искать Бельчонка в одиночку", "1. Расспросить Сову\n" +
            "2. Расспросить Волка", "1. Поверить Сове и отправиться вглубь леса\n" +
            "2. Сове не стоит верить -> Искать Бельчонка в одиночку", "1. Волк прав -> Вернуться домой\n" +
            "2. -> Искать Бельчонка в одиночку", "1. Нет, потрачено слишком много времени, нужно идти дальше -> Искать Бельчонка в одиночку\n" +
            "2. Нужно воспользоваться шансом и раздобыть мёд", "1. Подождать, вдруг пчёлы улетят\n" +
            "2. Нужно попытаться выкрасть мёд немедленно", "1. Поесть немного и передохнуть\n" +
            "2. Скорее отнести мёд Медвежонку", "1. Может быть он прав и Лисёнок просто паникует -> Вернуться домой\n" +
            "2. Медвежонок ничего не знает, нужно продолжить поиски -> Искать Бельчонка в одиночку\n"};




    static {
        HashMap<Integer, String> stage0 = new HashMap<>();
        stage0.put(1, "Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше и увидел там рой злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга!\n");
        stage0.put(2, "Все лесные жители были заняты своими делами и не обращали внимания на Лисёнка и его проблему. Но вдруг кто нибудь видел Бельчонка... Лисёнок не знал, что ему делать. Помогите ему.\n");
        gameText.add(stage0);

        HashMap<Integer, String> stage1 = new HashMap<>();
        stage1.put(1, "Пока Лисёнок принимал решение, лесные жители разошлись кто куда. Остались только Сова и Волк. Но у Совы бывают проблемы с памятью, а Волк может сильно разозлиться из-за расспросов. Кого выбрать?\n");
        stage1.put(2, "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать.\n");
        gameText.add(stage1);

        HashMap<Integer, String> stage2 = new HashMap<>();
        stage2.put(1, "Сова долго не хотела говорить, но в итоге сказала, что видела испуганного Бельчонка, бежавшего вглубь леса. Все лесные жители знают, что в глубине леса опасно, если Бельчонок там, ему срочно нужна помощь.\n");
        stage2.put(2, "Волк оказался вполне дружелюбным, но помочь не смог. Лишь сказал, что маленькому лисенку не стоит бродить по лесу одному. И как теперь поступить?\n");
        gameText.add(stage2);

        HashMap<Integer, String> stage3 = new HashMap<>();
        stage3.put(1, "В глубине леса Лисёнок встретил Медвежонка. Ленивый Медвежонок был готов рассказать все, что знает, если Лисёнок принесёт ему мёда.\n");
        stage3.put(2, "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать.\n");
        gameText.add(stage3);

        HashMap<Integer, String> stage4 = new HashMap<>();
        stage4.put(1, "Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше и увидел там рой злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга!\n");
        stage4.put(2, "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать.\n");
        gameText.add(stage4);

        HashMap<Integer, String> stage5 = new HashMap<>();
        stage5.put(1, "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать.\n");
        stage5.put(2, "Лисёнок быстро нашёл мёд, но вокруг летал рой злобных пчел. Лисёнок всегда боялся пчёл, но и не найти друга он тоже боялся.\n");
        gameText.add(stage5);

        HashMap<Integer, String> stage6 = new HashMap<>();
        stage6.put(1, "Лисёнок подождал немного, и пчёлы разлетелись. Лисёнок без проблем набрал мёда. Вдруг он понял, что очень голоден. Что же делать?\n");
        stage6.put(2, "Это была не лучшая идея. Пчёлы покусали Лисёнка, теперь ему самому нужна помощь.\n");
        gameText.add(stage6);

        HashMap<Integer, String> stage7 = new HashMap<>();
        stage7.put(1, "Пока Лисёнок ел, злобные пчёлы вернулись и покусали его. Лисёнку нужна помощь, он не сможет продолжить поиски.\n");
        stage7.put(2, "Довольный Медвежонок рассказал Лисёнку, что очень хорошо знает семью Белок и уверен, что Бельчонок никогда не пошёл бы в глубь леса. Он заверял Лисёнка, что Белки не попадают в неприятности, и что Совам нельзя верить, он также уговаривал Лисёнка вернуться домой.\n");
        gameText.add(stage7);

        HashMap<Integer, String> stage8 = new HashMap<>();
        stage8.put(1, "Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл на место встречи раньше и увидел там рой злобных пчел. Он поспешил предупредить об этом Лисёнка, но они разминулись. Наконец-то друзья нашли друг друга!\n");
        stage8.put(2, "Лисёнок слишком долго плутал по лесу в поисках друга и сам не заметил, как заблудился. Теперь его самого нужно искать.\n");
        gameText.add(stage8);
    }

    public static void startGame(int currentStage) {
        int playerInput;

        System.out.println("""
                Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком.
                Это утро не было исключением. Лисёнок пришёл на их обычное место встречи, но Бельчонка там не было.
                Лисёнок ждал, ждал, но так и не смог дождаться своего друга. "Бельчонок не пропустил еще ни одной встречи,
                вдруг он попал в беду." - подумал Лисёнок. Как поступить Лисенку?
                """);
        while (status.equals(INPROGRESS))

        switch (currentStage) {
            case 0:
                System.out.println(choice[currentStage]);
                System.out.println("Введите 1 или 2.");

                playerInput = scanner.nextInt();

                if (playerInput == 1) {
                    System.out.println(gameText.get(currentStage).get(1));
                    status = WIN;
                    break;
                } else if (playerInput == 2) {
                    System.out.println(gameText.get(currentStage).get(2));
                    currentStage = 1;
                    break;
                } else {
                    System.out.println(choice[currentStage]);
                    System.out.println("Введите 1 или 2.");
                }
            case 1:
                System.out.println(choice[currentStage]);
                System.out.println("Введите 1 или 2.");

                playerInput = scanner.nextInt();

                if (playerInput == 1) {
                    System.out.println(gameText.get(currentStage).get(1));
                    currentStage = 2;
                    break;
                } else if (playerInput == 2) {
                    System.out.println(gameText.get(currentStage).get(2));
                    status = LOSE;
                    break;
                } else {
                    System.out.println(choice[currentStage]);
                    System.out.println("Введите 1 или 2.");
                }
            case 2:
                System.out.println(choice[currentStage]);
                System.out.println("Введите 1 или 2.");

                playerInput = scanner.nextInt();

                if (playerInput == 1) {
                    System.out.println(gameText.get(currentStage).get(1));
                    currentStage = 3;
                    break;
                } else if (playerInput == 2) {
                    System.out.println(gameText.get(currentStage).get(2));
                    currentStage = 4;
                    break;
                } else {
                    System.out.println(choice[currentStage]);
                    System.out.println("Введите 1 или 2.");
                }
            case 3:
                System.out.println(choice[currentStage]);
                System.out.println("Введите 1 или 2.");

                playerInput = scanner.nextInt();

                if (playerInput == 1) {
                    System.out.println(gameText.get(currentStage).get(1));
                    currentStage = 5;
                    break;
                } else if (playerInput == 2) {
                    System.out.println(gameText.get(currentStage).get(2));
                    status = LOSE;
                    break;
                } else {
                    System.out.println(choice[currentStage]);
                    System.out.println("Введите 1 или 2.");
                }
            case 4:
                System.out.println(choice[currentStage]);
                System.out.println("Введите 1 или 2.");

                playerInput = scanner.nextInt();

                if (playerInput == 1) {
                    System.out.println(gameText.get(currentStage).get(1));
                    status = WIN;
                    break;
                } else if (playerInput == 2) {
                    System.out.println(gameText.get(currentStage).get(2));
                    status = LOSE;
                    break;
                } else {
                    System.out.println(choice[currentStage]);
                    System.out.println("Введите 1 или 2.");
                }
            case 5:
                System.out.println(choice[currentStage]);
                System.out.println("Введите 1 или 2.");

                playerInput = scanner.nextInt();

                if (playerInput == 1) {
                    System.out.println(gameText.get(currentStage).get(1));
                    status = LOSE;
                    break;
                } else if (playerInput == 2) {
                    System.out.println(gameText.get(currentStage).get(2));
                    currentStage = 6;
                    break;
                } else {
                    System.out.println(choice[currentStage]);
                    System.out.println("Введите 1 или 2.");
                }
            case 6:
                System.out.println(choice[currentStage]);
                System.out.println("Введите 1 или 2.");

                playerInput = scanner.nextInt();

                if (playerInput == 1) {
                    System.out.println(gameText.get(currentStage).get(1));
                    currentStage = 7;
                    break;
                } else if (playerInput == 2) {
                    System.out.println(gameText.get(currentStage).get(2));
                    status= LOSE;
                    break;
                } else {
                    System.out.println(choice[currentStage]);
                    System.out.println("Введите 1 или 2.");
                }
            case 7:
                System.out.println(choice[currentStage]);
                System.out.println("Введите 1 или 2.");

                playerInput = scanner.nextInt();

                if (playerInput == 1) {
                    System.out.println(gameText.get(currentStage).get(1));
                    status = LOSE;
                    break;
                } else if (playerInput == 2) {
                    System.out.println(gameText.get(currentStage).get(2));
                    currentStage = 8;
                    break;
                } else {
                    System.out.println(choice[currentStage]);
                    System.out.println("Введите 1 или 2.");
                }
            case 8:
                System.out.println(choice[currentStage]);
                System.out.println("Введите 1 или 2.");

                playerInput = scanner.nextInt();

                if (playerInput == 1) {
                    System.out.println(gameText.get(currentStage).get(1));
                    status = WIN;
                    break;
                } else if (playerInput == 2) {
                    System.out.println(gameText.get(currentStage).get(2));
                    status = LOSE;
                    break;
                } else {
                    System.out.println(choice[currentStage]);
                    System.out.println("Введите 1 или 2.");
                }
        }
        System.out.println(status.getMessage());
    }

    public static int getCurrentStage() {
        return currentStage;
    }

    public static Status getStatus() {
        return status;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static ArrayList<HashMap<Integer, String>> getGameText() {
        return gameText;
    }

    public static String[] getChoice() {
        return choice;
    }
}
