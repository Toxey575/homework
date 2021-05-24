package exams.foxgame.menu;

import exams.foxgame.GameScript;
import exams.foxgame.utils.Status;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static exams.foxgame.GameScript.*;
import static exams.foxgame.utils.Settings.*;

public class Game {

    public Game() {}

    public void newGame() {
        GameScript.startGame(START_STAGE);
    }

    public void resumeGame() {
        GameScript.startGame(getCurrentStage());
    }




    public void saveGame() {
        String currentStage =  Integer.toString(getCurrentStage());
        try(FileOutputStream fileOutput = new FileOutputStream("save.txt")) {
            byte[] buffer = currentStage.getBytes();

            fileOutput.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Игра сохранена!");


    }

    public void loadGame() {

        int currentStage = 0;

        try(FileInputStream fileInput = new FileInputStream("save.txt")) {
            int i;
            while ((i = fileInput.read()) != -1){

                currentStage = Character.getNumericValue((char) i);

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        GameScript.startGame(currentStage);

    }
}
