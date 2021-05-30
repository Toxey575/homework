package exams.foxgame.menu;


import exams.foxgame.Game;
import exams.foxgame.GameScript;
import exams.foxgame.utils.Status;
import java.util.Scanner;

import static exams.foxgame.utils.Status.*;


public class Menu {

    private static Game game = new Game();
    private static Command newGame = new NewGameCommand(game);
    private static Command saveGame = new SaveGameCommand(game);
    private static Command loadGame = new LoadGameCommand(game);
    private static Scanner scanner = new Scanner(System.in);

    public Menu() {

    }

    public static void startApp() {

        GameScript.gameStatus = INPROGRESS;

        while (GameScript.gameStatus.equals(INPROGRESS)) {

            System.out.println("""
                    Добро пожаловать в увлекательное приключение!
                    Выберите один из пунктов:
                            1: Начать игру
                            2: Загрузить игру
                            4: Выход
                    """);

            int menuPlayerInput = scanner.nextInt();

            switch (menuPlayerInput) {
                case 1:
                    game.newGame();
                    break;
                case 2:
                    game.loadGame();
                    break;
                case 4:
                    GameScript.gameStatus = END;
                    System.out.println(GameScript.gameStatus.getMessage());
                    System.exit(1);
                    break;

                default:
                    System.out.println("Пункт меню не выбран!Пожалуйста,выберите команду: ");
                    break;

            }

        }


    }

    public static void pauseMenu() {

        while (GameScript.gameStatus.equals(INPROGRESS)) {

            System.out.println("""
                    Добро пожаловать в увлекательное приключение!
                    Выберите один из пунктов:
                            1: Продолжить игру
                            2: Сохранить игру
                            3: Загрузить игру
                            4: Выход
                    """);

            int menuPlayerInput = scanner.nextInt();

            switch (menuPlayerInput) {
                case 1:
                    game.resumeGame();
                    break;
                case 2:
                    game.saveGame();
                    break;
                case 3:
                    game.loadGame();
                    break;
                case 4:
                    GameScript.gameStatus = END;
                    System.out.println(GameScript.gameStatus.getMessage());
                    System.exit(1);
                    break;

                default:
                    System.out.println("Пункт меню не выбран!Пожалуйста,выберите команду: ");
            }

        }
    }
}
