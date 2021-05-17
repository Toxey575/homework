package exams.foxgame.menu;

import exams.foxgame.GameScript;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveGame implements Command{

    private  GameScript gameScript;
    private String currentStage;

    public SaveGame(GameScript gameScript, String currentStage) {
        this.gameScript = gameScript;
        this.currentStage = currentStage;
    }

    public SaveGame(String currentStage) {
        this.currentStage = currentStage;
    }

    @Override
    public void execute() {
        try(FileOutputStream fileOutput = new FileOutputStream("save.txt")) {
            byte[] buffer = currentStage.getBytes();

            fileOutput.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Игра сохранена!");
    }
}
