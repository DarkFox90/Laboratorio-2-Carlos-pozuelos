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

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Integer> getCeldasDescubiertas() {
        return celdasDescubiertas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void incrementarPuntaje() {
        this.puntaje++;
    }

    public void agregarPares(int fila, int columna) {
        celdasDescubiertas.add(fila);
        celdasDescubiertas.add(columna);
    }
}