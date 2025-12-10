public class Tablero {

    public static int[][] crearTableroBarcos(int filas, int columnas) {
        int[][] tablero = new int[filas][columnas];
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                tablero[i][j] = -1;
        return tablero;
    }

    public static char[][] crearTableroDisparos(int filas, int columnas) {
        char[][] tablero = new char[filas][columnas];
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                tablero[i][j] = '~';
        return tablero;
    }

    public static void mostrarTableroDisparos(char[][] tableroDisparos) {
        System.out.print("  ");
        for (int c = 0; c < tableroDisparos[0].length; c++) System.out.print(c + " ");
        System.out.println();
        for (int f = 0; f < tableroDisparos.length; f++) {
            System.out.print(f + " ");
            for (int c = 0; c < tableroDisparos[0].length; c++) {
                System.out.print(tableroDisparos[f][c] + " ");
            }
            System.out.println();
        }
    }

    // Versión mejorada que muestra '*' antes de disparar
    // y los símbolos de disparos después
    public static void mostrarTableroConBarcos(int[][] tableroBarcos, char[][] tableroDisparosCPU) {
        System.out.print("  ");
        for (int c = 0; c < tableroBarcos[0].length; c++) System.out.print(c + " ");
        System.out.println();

        for (int f = 0; f < tableroBarcos.length; f++) {
            System.out.print(f + " ");
            for (int c = 0; c < tableroBarcos[0].length; c++) {
                if (tableroDisparosCPU[f][c] == '~') {
                    // Antes de disparar: '*' si hay barco, '.' si no
                    System.out.print((tableroBarcos[f][c] != -1 ? "*" : ".") + " ");
                } else {
                    // Después de disparar: mostrar lo que haya en tableroDisparosCPU
                    System.out.print(tableroDisparosCPU[f][c] + " ");
                }
            }
            System.out.println();
        }
    }

    public static boolean esCoordenadaValida(int fila, int columna, int filas, int columnas) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }
}
