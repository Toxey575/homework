package exams.foxgame.menu;

public class LoadGameCommand implements Command{
    private Game game;

    public LoadGameCommand(Game game) {
        this.game = game;
    }

    @Override
    public void execute() {
        game.loadGame();
    }
}
