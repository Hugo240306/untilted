public class Barcos {

    public static void colocarBarcosAleatorios(int[][] tableroBarcos, int[] tamanosBarcos) {
        for (int id = 0; id < tamanosBarcos.length; id++) {
            int tam = tamanosBarcos[id];
            boolean colocado = false;
            int intentos = 0;

            while (!colocado && intentos < 1000) {
                int fila = (int) (Math.random() * tableroBarcos.length);
                int col = (int) (Math.random() * tableroBarcos[0].length);
                boolean horizontal = Math.random() < 0.5;

                if (sePuedeColocarBarco(tableroBarcos, fila, col, tam, horizontal)) {
                    colocarBarco(tableroBarcos, fila, col, tam, horizontal, id);
                    colocado = true;
                }
                intentos++;
            }

            if (!colocado) {
                outer:
                for (int f = 0; f < tableroBarcos.length; f++) {
                    for (int c = 0; c < tableroBarcos[0].length; c++) {
                        if (sePuedeColocarBarco(tableroBarcos, f, c, tam, true)) {
                            colocarBarco(tableroBarcos, f, c, tam, true, id);
                            colocado = true;
                            break outer;
                        } else if (sePuedeColocarBarco(tableroBarcos, f, c, tam, false)) {
                            colocarBarco(tableroBarcos, f, c, tam, false, id);
                            colocado = true;
                            break outer;
                        }
                    }
                }
            }

            if (!colocado) {
                System.err.println("Warning: no se pudo colocar barco id=" + id);
            }
        }
    }

    public static boolean sePuedeColocarBarco(int[][] tablero, int fila, int columna, int tamano, boolean horizontal) {
        int filas = tablero.length;
        int columnas = tablero[0].length;

        if (fila < 0 || columna < 0) return false;

        if (horizontal) {
            if (columna + tamano > columnas) return false;
            for (int c = columna; c < columna + tamano; c++) {
                if (tablero[fila][c] != -1) return false;
            }
        } else {
            if (fila + tamano > filas) return false;
            for (int r = fila; r < fila + tamano; r++) {
                if (tablero[r][columna] != -1) return false;
            }
        }
        return true;
    }

    public static void colocarBarco(int[][] tablero, int fila, int columna, int tamano, boolean horizontal, int idBarco) {
        if (horizontal) {
            for (int c = columna; c < columna + tamano; c++) tablero[fila][c] = idBarco;
        } else {
            for (int r = fila; r < fila + tamano; r++) tablero[r][columna] = idBarco;
        }
    }

    public static boolean todosHundidos(int[] impactos, int[] tamanosBarcos) {
        if (impactos == null || tamanosBarcos == null) return false;
        if (impactos.length != tamanosBarcos.length) return false;
        for (int i = 0; i < impactos.length; i++) {
            if (impactos[i] < tamanosBarcos[i]) return false;
        }
        return true;
    }
}
