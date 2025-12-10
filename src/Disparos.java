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
        }

        impactosBarco[idBarco]++;

        if (impactosBarco[idBarco] < tamanosBarco[idBarco]) {
            tableroDisparos[fila][columna] = 'T';
            return false;
        }

        for (int f = 0; f < tableroBarcos.length; f++) {
            for (int c = 0; c < tableroBarcos[0].length; c++) {
                if (tableroBarcos[f][c] == idBarco) {
                    tableroDisparos[f][c] = 'H';
                }
            }
        }

        return true;
    }
}
