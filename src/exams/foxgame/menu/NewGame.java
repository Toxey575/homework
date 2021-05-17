package exams.foxgame.menu;

import exams.foxgame.GameScript;

import static exams.foxgame.utils.Settings.*;

public class NewGame implements Command{

    private GameScript gameScript;

    public NewGame(GameScript gameScript) {
        this.gameScript = gameScript;
    }

    @Override
    public void execute() {

    }
}
