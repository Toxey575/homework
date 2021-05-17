package exams.foxgame.utils;

public enum Status {
    WIN("Вы победили!"), LOSE("Вы проиграли!"), INPROGRESS("Игра продолжается");

    private String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
