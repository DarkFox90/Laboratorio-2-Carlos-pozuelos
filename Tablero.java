// modelo

public class Tablero {
    private Celda[][] tablero; //cambie el tipo de tablero para poder dibujar bien el tablero en consola
    private boolean[][] celdasReveladas;

    public Tablero(int filas, int columnas) {
        tablero = new Celda[filas][columnas];

        this.inicializarTablero(filas, columnas);
        
    }

    private void inicializarTablero(int filas, int columnas) {
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                this.tablero[i][j] = new Celda();
            }
        }
    }


}
