import java.util.Scanner;

public class Utilidades {

    private static final Scanner SC = new Scanner(System.in);

    /**
     * Devuelve un número entero aleatorio entre min y max (ambos incluidos).
     */
    public static int numeroAleatorio(int min, int max) {
        if (min > max) return -1;
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    /**
     * Convierte una coordenada tipo "A5" en fila.
     * Suponemos que la parte numérica es la fila.
     * Consideramos que EXISTE LA FILA 0.
     * Ejemplo: "A5" -> 5
     *
     * Si la coordenada no es válida, debe devolver -1.
     */
    public static int convertirFila(String coord) {
        if (coord == null || coord.length() < 2) return -1;

        String numero = coord.substring(1);

        try {
            return Integer.parseInt(numero);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int convertirColumna(String coord) {
        if (coord == null || coord.length() < 2) return -1;

        char letra = Character.toUpperCase(coord.charAt(0));

        if (letra < 'A' || letra > 'Z') return -1; // letra inválida

        return letra - 'A'; // A -> 0, B -> 1, etc.
    }

    public static String leerLinea() {
        return SC.nextLine();
                    }
}
