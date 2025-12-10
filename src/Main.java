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

        boolean finPartida = false;
        boolean turnoJugador = true;

        while (!finPartida) {

            if (turnoJugador) {
                System.out.println("--- TURNO DEL JUGADOR ---");

                Tablero.mostrarTableroConBarcos(tableroBarcosJugador, tableroDisparosCPU);
                Tablero.mostrarTableroDisparos(tableroDisparosJugador);

                int fila = -1, columna = -1;
                boolean valido = false;

                while (!valido) {
                    System.out.print("Introduce coordenada (ej. A5): ");
                    String coord = sc.nextLine().trim().toUpperCase();

                    fila = Utilidades.convertirFila(coord);
                    columna = Utilidades.convertirColumna(coord);

                    if (!Tablero.esCoordenadaValida(fila, columna, FILAS, COLUMNAS)) {
                        System.out.println("Coordenada fuera del tablero.");
                    } else if (Disparos.yaDisparado(tableroDisparosJugador, fila, columna)) {
                        System.out.println("Ya has disparado allí.");
                    } else {
                        valido = true;
                    }
                }

                boolean hundido = Disparos.procesarDisparo(
                        fila,
                        columna,
                        tableroBarcosCPU,
                        tableroDisparosJugador,
                        impactosCPU,
                        tamanosBarcos
                );

                if (hundido) System.out.println("¡Has hundido un barco!");

                if (Barcos.todosHundidos(impactosCPU, tamanosBarcos)) {
                    System.out.println("¡HAS GANADO! Hundiste todos los barcos enemigos.");
                    finPartida = true;
                }

            } else {
                System.out.println("--- TURNO DE LA CPU ---");

                int filaCPU, columnaCPU;

                while (true) {
                    filaCPU = Utilidades.numeroAleatorio(0, FILAS - 1);
                    columnaCPU = Utilidades.numeroAleatorio(0, COLUMNAS - 1);

                    if (!Disparos.yaDisparado(tableroDisparosCPU, filaCPU, columnaCPU)) break;
                }

                System.out.println("La CPU dispara a (" + filaCPU + ", " + columnaCPU + ")");

                boolean hundidoJugador = Disparos.procesarDisparo(
                        filaCPU,
                        columnaCPU,
                        tableroBarcosJugador,
                        tableroDisparosCPU,
                        impactosJugador,
                        tamanosBarcos
                );

                if (hundidoJugador) System.out.println("La CPU ha hundido uno de tus barcos...");

                if (Barcos.todosHundidos(impactosJugador, tamanosBarcos)) {
                    System.out.println("Has perdido. Todos tus barcos han sido hundidos.");
                    finPartida = true;
                }
            }

            turnoJugador = !turnoJugador;
        }

        sc.close();
    }
}
