// vista
/*
 * Universidad del Valle de Guatemala
 * Programacion Orientada a Objetos
 * Ejercicio 3: sistema de organización de gimnasios
 * fecha de creación: 6 de septiembre de 2025
 * ultima modificación: 8 de septiembre de 2025
 * 
 * añadí constructores en las clases que lo necesitan porque se me olvidó incluirlos en el análisis
 */

 //los metodos de main los hice en otras clases por lo que agregué otras validaciones 
 

public class Main {
    public static void main(String[] args) {
        System.out.println("===MEMORIA===");
        boolean continuar = true;

        do {
            //creacion de jugadores y valida con el metodo validarNombre que no deje vacio el campo
            String n1 = validarNombre("nombre del primer jugador: ");
            String n2 = validarNombre("nombre del segundo jugador: ");
            Jugador j1 = new Jugador(n1);
            Jugador j2 = new Jugador(n2);

            //creacion de tablero de 4x4
            Tablero tablero = new Tablero(4, 4);
            Memoria juego = new Memoria(j1, j2, tablero);

            //while loop que termina si el tablero está completo
            while (!juego.juegoTerminado()) {
                Jugador actual = juego.getJugadorActual();
                System.out.println("\n turno de: " + actual.getNombre());

                //pregunta al usuario que fila y columna quiere y valida que ingrese un numero entero
                int f1 = validarEntero("fila (primera 0-3): ", 0,3);
                int c1 = validarEntero("columna (primera 0-3): ", 0,3);
                int f2 = validarEntero("fila (segunda 0-3): ", 0,3);
                int c2 = validarEntero("columna (segunda 0-3): ", 0,3);

                String resultado = juego.realizarTurno(f1, c1, f2, c2);

                //validaciones en los distintos casos (mismo par, elige un par ya encontrado)
                if (resultado.equals("misma")) {
                    System.out.println("no puede elegir la misma celda dos veces");
                    continue;
                } else if (resultado.equals("emparejada")) {
                    System.out.println("no puede elegir celdas emparejadas");
                } else if (resultado.equals("par")) {
                    mostrarTablero(tablero);
                    System.out.println("par encontrado");
                } else if (resultado.equals("no par")) {
                    mostrarTablero(tablero);
                    System.out.println("no coincide el par, pierdes tu turno");
                    tablero.ocultarCelda(f1, c1);.
                    tablero.ocultarCelda(f2, c2);
                    juego.cambiarTurno();
                } 
            }

            System.out.println("\n juego terminado");
            System.out.println(juego.mostrarResultado());
            ganador(j1, j2);

            continuar = validarContinuacion("desea jugar otra vez (s/n)?  ");

        } while (continuar);

        System.out.println("gracias por jugar");
    }
}
   

