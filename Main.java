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
 
import java.util.Scanner;
public class Main {

    private static final Scanner sc = new Scanner(System.in);
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
                    tablero.ocultarCelda(f1, c1);
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

    //validaciones extras que agregué por haber hecho las otras en otras clases.

    //funcion que valida que el usuario ingrese un numero entero
    private static int validarEntero(String prompt, int min, int max) {
        boolean valido = false;
        int valor = min;

        do { 
            System.out.println(prompt);
            String linea = sc.nextLine();
            try {
                int v = Integer.parseInt(linea.trim()); //intenta convertir el string a numero
                if (v < min || v > max) { //valida que esté dentro del rango
                    System.out.println("valor fuera de rango");
                } else {
                    valor = v;
                    valido = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("ingrese un numero entero válido");
            }
        } while (!valido);
        return valor;
    }

    private static String validarNombre(String prompt) {
        boolean valido = false;
        String s = "";

        do { 
            System.out.println(prompt);
            s = sc.nextLine().trim();
            if(s.length() == 0) { //chequea que no esté vacio el campo 
                System.out.println("no puede dejar el campo vacío");
            } else {
                valido = true;
            }
        } while (!valido);

        return s;
    }

    private static boolean validarContinuacion(String prompt) {
        boolean valido = false;
        String s = "";

        do { 
            System.out.println(prompt); // pregunta al usuario si desea continuar
            s = sc.nextLine().trim().toLowerCase();
            if (s.equals("s") || s.equals("n")) { //chequea que caso pasa
                valido = true;
            } else {
                System.out.println("tiene que responder con s o n"); //si responde con algo que no es s o n da error
            }
            return s.equals("s");
        } while (!valido);
    }

    private static void mostrarTablero(Tablero t) {
        System.out.print("  ");
        for (int j = 0; j < 4; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < 4; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < 4; j++) {
                System.out.print(t.obtenerEmoji(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void ganador(Jugador j1, Jugador j2) {
        int p1 = j1.getPuntaje();
        int p2 = j2.getPuntaje();

        if (p1 > p2) {
            System.out.println("jugador: " + j1.getNombre() + " gana la partida");
        } else if (p2 > p1) {
            System.out.println("jugador: " + j2.getNombre() + " gana la partida");
        } else {
            System.out.println("empate");
        }
    }
}
   

