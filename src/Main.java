public class Main {

    public static final int FILAS = 10;
    public static final int COLUMNAS = 10;

    public static void main(String[] args) {

        int[] tamanosBarcos = {5, 4, 3, 3, 2};
        int numBarcos = tamanosBarcos.length;

        int[][] tableroBarcosJugador = Tablero.crearTableroBarcos(FILAS, COLUMNAS);
        int[][] tableroBarcosCPU = Tablero.crearTableroBarcos(FILAS, COLUMNAS);

        char[][] tableroDisparosJugador = Tablero.crearTableroDisparos(FILAS, COLUMNAS);
        char[][] tableroDisparosCPU = Tablero.crearTableroDisparos(FILAS, COLUMNAS);

        int[] impactosJugador = new int[numBarcos];
        int[] impactosCPU = new int[numBarcos];
        for (int i = 0; i < numBarcos; i++) {
            impactosJugador[i] = 0;
            impactosCPU[i] = 0;
        }

        Barcos.colocarBarcosAleatorios(tableroBarcosJugador, tamanosBarcos);
        Barcos.colocarBarcosAleatorios(tableroBarcosCPU, tamanosBarcos);

        Tablero.mostrarTableroConBarcos(tableroBarcosJugador, tableroDisparosCPU);

        Tablero.mostrarTableroDisparos(tableroDisparosJugador);zc
                }
}
