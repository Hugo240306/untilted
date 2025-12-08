public class Barcos {

    public static void colocarBarcosAleatorios(int[][] tableroBarcos, int[] tamanosBarcos) {
        for (int id = 0; id < tamanosBarcos.length; id++) {
            int tam = tamanosBarcos[id];
            boolean colocado = false;

            int fila = (int) (Math.random() * tableroBarcos.length);
            int col = (int) (Math.random() * tableroBarcos[0].length);
            boolean horizontal = Math.random() < 0.5;

            if (sePuedeColocarBarco(tableroBarcos, fila, col, tam, horizontal)) {
                colocarBarco(tableroBarcos, fila, col, tam, horizontal, id);
                colocado = true;
            }
        }
    }

    public static boolean sePuedeColocarBarco(int[][] tablero, int fila, int columna, int tamano, boolean horizontal) {
        if (horizontal) {
            if (columna + tamano > tablero[0].length) return false;
            for (int c = columna; c < columna + tamano; c++) {
                if (tablero[fila][c] != -1) return false;
            }
        } else {
            if (fila + tamano > tablero.length) return false;
            for (int f = fila; f < fila + tamano; f++) {
                if (tablero[f][columna] != -1) return false;
            }
        }
        return true;
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
