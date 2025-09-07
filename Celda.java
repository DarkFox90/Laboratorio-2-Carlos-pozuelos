// modelo

public class Celda {
    private String emoji;
    private boolean revelada;
    private boolean emparejada;

    public Celda(String emoji) {
        this.emoji = emoji;
        this.revelada = false;
        this.emparejada = false;
    }
}
