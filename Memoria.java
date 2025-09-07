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
        this.turnoActual = 1;
    }
}
