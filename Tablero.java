// modelo
import java.util.Random;

public class Tablero {
    private Celda[][] tablero; //cambie el tipo de tablero para poder dibujar bien el tablero en consola
    private boolean[][] celdasReveladas;

    public Tablero(int filas, int columnas) {
        tablero = new Celda[filas][columnas];

        this.inicializarTablero(filas, columnas);
        
    }

    // crea un tablero recorriend con for
    private void inicializarTablero(int filas, int columnas) {
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                this.tablero[i][j] = new Celda();
                this.celdasReveladas[i][j] = false;
            }
        }

        //array de letras porque los emojis no salen en consola
        String[] emojis = {"A","B","C","D","E","F","G","H"};
        String[] emojisDisponibles = new String[filas * columnas];
        int posicion = 0;

        for(int e = 0; e < emojis.length; e++) {
            emojisDisponibles[posicion++] = emojis[e];
            emojisDisponibles[posicion++] = emojis[e];
        }

        Random random = new Random();
        for (int i = emojisDisponibles.length - 1; i > 0; i --) {
            int j = random.nextInt(i + 1);
            String temporal = emojisDisponibles[i];
            emojisDisponibles[i] = emojisDisponibles[j];
            emojisDisponibles[j] = temporal;
        }

        posicion = 0;
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                tablero[i][j].setEmoji(emojisDisponibles[posicion]);
                posicion++;
            }
        }
    }

    public String obtenerEmoji(int fila, int columna) {
        if (tablero[fila][columna].isEmparejada()) { // si la celda está emparejada devuelve una X
            return "X";
        } else if (celdasReveladas[fila][columna]) { // si las celdas se revelan muestra el emoji revelado
            return tablero[fila][columna].getEmoji();
        }
        return "."; // por defecto empieza con .
    }

    // vuelve celdasReveladas true para mostrarlas
    public void revelarCelda(int fila, int columna) {
        celdasReveladas[fila][columna] = true;
    }


    // chequea que no haya ninguna fila o columna emparejada y vuelve false revelar celdas
    public void ocultarCelda(int fila, int columna) {
        if (!tablero[fila][columna].isEmparejada()) {
            celdasReveladas[fila][columna] = false;
        }
    }

    // chequea que el usuario haya encontrado un par
    public boolean verificarCeldaE(int fila, int columna) {
        return tablero[fila][columna].isEmparejada();
    }

    // recorre el tamaño de las filas y las columnas para ver si están todas encontradas, si es así vuelve true para terminar y si no retorna false.
    public boolean verificarTableroCompleto(){
        for(int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[0].length; j++) {
                if (!tablero[i][j].isEmparejada()) {
                    return false;
                }
            }
        }
        return true;
    }
}
