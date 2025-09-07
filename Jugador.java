// modelo
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<Integer> celdasDescubiertas;
    private int puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.celdasDescubiertas = new ArrayList<>();
        this.puntaje = 0;
    }

}