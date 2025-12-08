import java.util.Scanner;

public class Main {

    public static final int FILAS = 10;
    public static final int COLUMNAS = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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

        System.out.println("Tablero del jugador:");
        Tablero.mostrarTableroConBarcos(tableroBarcosJugador, tableroDisparosCPU);

        System.out.println("Tablero de disparos del jugador:");
        Tablero.mostrarTableroDisparos(tableroDisparosJugador);


        boolean coordenadaValida = false;
        int fila = -1, columna = -1;

        while (!coordenadaValida) {
            System.out.print("Introduce coordenada (ej. A5): ");
            String coord = sc.nextLine().trim().toUpperCase();

            fila = Utilidades.convertirFila(coord);
            columna = Utilidades.convertirColumna(coord);

            if (!Tablero.esCoordenadaValida(fila, columna, FILAS, COLUMNAS)) {
                System.out.println("No existe esa coordenada");
            } else if (Disparos.yaDisparado(tableroDisparosJugador, fila, columna)) {
                System.out.println("Ya disparaste ahi");
            } else {
                coordenadaValida = true;
            }
        }

        boolean hundido = Disparos.procesarDisparo(fila, columna, tableroBarcosCPU, tableroDisparosJugador, impactosCPU, tamanosBarcos);

        if (hundido) {
            System.out.println("Hundiste un barco");
        } else {
            System.out.println("Disparo listo .");
        }

        sc.close();
    }
}
