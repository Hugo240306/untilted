public class Disparos {

    public static boolean yaDisparado(char[][] tableroDisparos, int fila, int columna) {
        return tableroDisparos[fila][columna] != '~';
    }

    public static boolean procesarDisparo(
            int fila,
            int columna,
            int[][] tableroBarcos,
            char[][] tableroDisparos,
            int[] impactosBarco,
            int[] tamanosBarco
    ) {
        int idBarco = tableroBarcos[fila][columna];
        if (idBarco == -1) {
            tableroDisparos[fila][columna] = 'A';
            return false;
        } else {
            impactosBarco[idBarco]++;
            if (impactosBarco[idBarco] < tamanosBarco[idBarco]) {
                tableroDisparos[fila][columna] = 'T';
                return false;
            } else {
                tableroDisparos[fila][columna] = 'H';
                return true;
            }
        }
    }
}
