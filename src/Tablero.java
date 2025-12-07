public class Tablero {

    public static int[][] crearTableroBarcos(int filas, int columnas) {
        int[][] tablero = new int[filas][columnas];
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                tablero[i][j] = -1; // inicializamos a -1
        return tablero;
    }

    public static char[][] crearTableroDisparos(int filas, int columnas) {
        char[][] tablero = new char[filas][columnas];
        for (int i = 0; i < filas; i++)
            for (int j = 0; j < columnas; j++)
                tablero[i][j] = '~'; // inicializamos a '~'
        return tablero;
    }

    public static void mostrarTableroDisparos(char[][] tableroDisparos) {

    }

    public static void mostrarTableroConBarcos(int[][] tableroBarcos, char[][] tableroDisparosCPU) {

    }

    public static boolean esCoordenadaValida(int fila, int columna, int filas, int columnas) {
        return fila >= 0 && fila < filas && columna >= 0 && columna < columnas;
    }
}
