// modelo

public class Tablero {
    private int[][] tablero;
    private boolean[][] celdasReveladas;

    public Tablero(int filas, int columnas) {
        tablero = new int[filas][columnas];
        celdasReveladas = new int[filas][columnas];
        inicializarTablero(filas, columnas);
    }
}
