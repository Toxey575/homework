package exams.foxgame.menu;

import java.io.FileInputStream;
import java.io.IOException;

public class LoadGame implements Command{

    @Override
    public void execute() {
        try(FileInputStream fileInput = new FileInputStream("save.txt")) {
            int i = -1;
            while ((i = fileInput.read()) != -1){

            System.out.println((char) i);

            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
