import java.util.Random;

public class Barcos {

    public static void colocarBarcosAleatorios(int[][] tableroBarcos, int[] tamanosBarcos) {

        Random rnd = new Random();
        for (int id = 0; id < tamanosBarcos.length; id++) {
            int tam = tamanosBarcos[id];

            boolean colocado = false;

            int fila = rnd.nextInt(tableroBarcos.length);
            int col = rnd.nextInt(tableroBarcos[0].length);
            boolean horizontal = rnd.nextBoolean();

            if (sePuedeColocarBarco(tableroBarcos, fila, col, tam, horizontal)) {
                colocarBarco(tableroBarcos, fila, col, tam, horizontal, id);
                colocado = true;
            }

               }
        }

    public static boolean sePuedeColocarBarco(int[][] tablero, int fila, int columna, int tamano, boolean horizontal) {
        if (horizontal) {
            return columna + tamano <= tablero[0].length;
        } else {
            return fila + tamano <= tablero.length;
            }
    }

    public static void colocarBarco(int[][] tablero, int fila, int columna, int tamano, boolean horizontal, int idBarco) {
        if (horizontal) {
            for (int c = columna; c < columna + tamano; c++) {
                tablero[fila][c] = idBarco;
            }
        } else {
            for (int f = fila; f < fila + tamano; f++) {
                tablero[f][columna] = idBarco;
            }
                }
    }

    public static boolean todosHundidos(int[] impactos, int[] tamanosBarcos) {
        return false;
        }
}
