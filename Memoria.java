// controlador

public class Memoria {
    private Jugador jugador1;
    private Jugador jugador2;
    private int turnoActual;
    private Tablero tablero;

    public Memoria(Jugador jugador1, Jugador jugador2, Tablero tablero) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
        this.turnoActual = 0;
    }

    public Jugador getJugadorActual() {
        return turnoActual == 0 ? jugador1 : jugador2;
    }

    public void cambiarTurno() {
        turnoActual = (turnoActual == 0) ? 1 : 0;
    }

    //agregué este método para poder terminar el juego
    public boolean juegoTerminado() {
        return tablero.verificarTableroCompleto();
    }

    public String mostrarResultado() {
        return jugador1.getNombre() + ": " + jugador1.getPuntaje() + "|" + jugador2.getNombre() + ": " + jugador2.getPuntaje();
    }

    //cambie el retorno de void a string para poder retornar un mensaje de emparejamiento o no
    public String realizarTurno(int f1, int c1, int f2, int c2) {
        if (f1 == f2 && c1 == c2) {
            return "misma";
        } else if (tablero.verificarCeldaE(f1, c2) || tablero.verificarCeldaE(f2, c2)) {
            return "emparejada";
        }

        tablero.revelarCelda(f1, c1);
        tablero.revelarCelda(f2, c2);

        String emoji1 = tablero.obtenerEmoji(f1, c1);
        String emoji2 = tablero.obtenerEmoji(f2, c2);

        if (emoji1.equals(emoji2)) {
            getJugadorActual().incrementarPuntaje();
            return "par";
        } else {
            return "no par";
        }
    }

}


//no utilicé jugar ya que se me hizo más facil hacerlo en main