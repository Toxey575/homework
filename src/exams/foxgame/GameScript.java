package exams.foxgame;

import exams.foxgame.menu.Menu;
import exams.foxgame.utils.Status;

import java.util.Scanner;

import static exams.foxgame.utils.Status.INPROGRESS;

public class GameScript {
    public static Status gameStatus = INPROGRESS;
    private static final Scanner scanner = new Scanner(System.in);
    private static String currentParagraph;


    public static void goOnParagraph(Paragraph paragraph) {

        currentParagraph = paragraph.name();
        int playerInput;

        if (paragraph.getStatus() != null) {
            gameStatus = paragraph.getStatus();
        }

        while (gameStatus.equals(INPROGRESS)) {
            System.out.println(paragraph.getText());
            System.out.println(paragraph.getChoice());
            System.out.println("""
                                        
                    Выберите вариант 1 или 2!
                    Введите 3, чтобы выйти в меню.
                    """);

            playerInput = scanner.nextInt();

            if (playerInput == 1) {
                goOnParagraph(paragraph.getFirstVar());
            } else if (playerInput == 2) {
                goOnParagraph(paragraph.getSecondVar());
            } else if (playerInput == 3) {
                Menu.pauseMenu();
            } else {
                System.out.println("""
                        Выберите вариант 1 или 2!
                        Введите 3, чтобы выйти в меню.
                        """);
            }
        }
        System.out.println(gameStatus.getMessage());
        Menu.startApp();
    }

    public static String getCurrentParagraph(){
        return currentParagraph;

    }
}


