package tp.app;

import tp.modelo.*;
import tp.datos.DatosIniciales;
import tp.algoritmos.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ciudad ciudad = crearCiudad();
        Explorador[] exploradores = crearExploradores();
        Scanner teclado = new Scanner(System.in);
        int opcion = -1;
        do {
            System.out.println("\n1. Mostrar Mapa  2. Informe  3. Explorar  4. Ordenar  0. Salir");
            System.out.print("Opción: ");
            if (!teclado.hasNextInt()) {
                teclado.nextLine();
                continue;
            }
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    ciudad.mostrarMapa();
                    break;
                case 2:
                    ciudad.informeGeneral();
                    break;
                case 3:
                    //Ejemplo de llamada, podria cambiar
                    System.out.println("Tesoros: ".explorar(ciudad, explorador, 1).getTesorosRecuperados());
                    break;
                case 4:
                    //COMPLETAR
                    break;

                case 0:
                    System.out.println("Fin");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
        while (opcion != 0);
    }

    public static Ciudad crearCiudad() {
        /* COMPLETAR */
    }

    public static Explorador[] crearExploradores() {
        //COMPLETAR
    }

    public static Expedicion explorar(Ciudad ciudad, Explorador explorador, int idExpedicion) {
        // TODO: crear boolean[][] visitadas, medir con System.nanoTime(),
        // llamar al auxiliar recursivo y construir Expedicion.
        throw new UnsupportedOperationException("TODO explorar");
    }

    /**
     * El auxiliar debe incluir casos base y cuatro llamadas recursivas.
     */
    private static int explorarDesde(Ciudad ciudad, Explorador explorador, boolean[][] visitadas, int fila, int columna, int[] contadorVisitadas) {
        // TODO: contar tesoros, registrar trampas y contar celdas visitadas.
        throw new UnsupportedOperationException("TODO explorarDesde");
    }
}


