package exams.foxgame;


import exams.foxgame.menu.SaveFile;

public class Game {

    public Game() {
    }

    public void newGame() {
        GameScript.goOnParagraph(Paragraph.valueOf("PARAGRAPH0"));
    }

    public void saveGame() {
        SaveFile saveFile = new SaveFile("save.txt");
        saveFile.saveGame(GameScript.getCurrentParagraph());
    }

    public void loadGame() {
        SaveFile saveFile = new SaveFile("save.txt");
        String loadParagraph = saveFile.loadGame();
        if(loadParagraph != null)
            GameScript.goOnParagraph(Paragraph.valueOf(loadParagraph));
        else
            GameScript.goOnParagraph(Paragraph.valueOf("PARAGRAPH0"));

    }
    public void resumeGame() {
        GameScript.goOnParagraph(Paragraph.valueOf(GameScript.getCurrentParagraph()));
    }
}





