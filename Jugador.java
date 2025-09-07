// modelo
import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private ArrayList<String> celdasDescubiertas; //cambie el tipo del array para poder hacer la comparación entre celdas descubiertas
    private int puntaje;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.celdasDescubiertas = new ArrayList<>();
        this.puntaje = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getCeldasDescubiertas() {
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

    //vuelve a string fila y columna para añadirlas al array
    public void agregarPares(int fila, int columna) {
        String clave = fila + "," + columna;
        celdasDescubiertas.add(clave);
    }

    //añadí este método para verificar si las celdas ya estan en la lista de celdas descubiertas y devuelve true si el jugador ya eligio la selda en ese turno para evitar repeticion
    public boolean yaSeleccionada(int fila, int columna) {
        String clave = fila + "," + columna;
        return celdasDescubiertas.contains(clave);
    }

    //añadí este método para poder limpiar la seleccion de casillas cada turno nuevo
    public void limpiarSeleccionCasilla() {
        celdasDescubiertas.clear();
    }
}