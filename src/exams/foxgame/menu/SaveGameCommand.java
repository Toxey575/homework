package exams.foxgame.menu;

import exams.foxgame.Game;

public class SaveGameCommand implements Command {
    private Game game;

    public SaveGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        //game.saveGame();
    }
}