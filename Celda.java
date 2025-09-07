// modelo

public class Celda {
    private String emoji;
    private boolean revelada;
    private boolean emparejada;

    public Celda() {
        this.emoji = "";
        this.revelada = false;
        this.emparejada = false;
    }

    public String getEmoji() {
        return emoji;
    }

    //lo mismo que agregarEmoji pero con un set y de parametro tiene el emoji y no la celda ya que estoy asignando un emoji y no una celda.
    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    // cambié la funcion de emparejar() por un set para poder manejarla mas facil y pueda asignarle true y false cuando quiera
    public void setEmparejada(boolean emparejada) {
        this.emparejada = emparejada;
    }

    public boolean isRevelada() {
        return revelada;
    }

    public boolean isEmparejada() {
        return emparejada;
    }

    // junte las funciones de revelar y ocultar en este set para poder manejarlo más facil 
    public void setRevelada(boolean revelada) {
        this.revelada = revelada; 
    }
}
