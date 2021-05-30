package exams.foxgame.menu;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class SaveFile {
    String path;
    public SaveFile(String path){
        this.path = path;
    }

    public boolean saveGame(String currentParagraph){
        try(FileWriter writer = new FileWriter(this.path, false))
        {
            writer.write(currentParagraph);
            writer.flush();
            return true;
        }
        catch(IOException ex){
    System.out.println(ex.getMessage());
        }
        return false;
    }

    public String loadGame(){

        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                        new FileInputStream(this.path), StandardCharsets.UTF_8))){
            String line = reader.readLine();
            return line;
        } catch (IOException e) {
            return null;
        }
    }
}