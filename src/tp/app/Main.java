package tp.app;

import java.util.Scanner;

import tp.modelo.Ciudad;
import tp.modelo.Expedicion;
import tp.modelo.Explorador;
import tp.modelo.Sector;

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
                    // Ejemplo de llamada, podria cambiar
                    Expedicion expedicion = explorar(ciudad, exploradores, 1);
                    System.out.println("Info de la expedicion: " + expedicion.toString());
                    break;
                case 4:
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Fin");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    public static Ciudad crearCiudad() {
        int filas = (int) (Math.random() * 20) + 2;
        int columnas = (int) (Math.random() * 20) + 2;
        Ciudad ciudad = new Ciudad(5, 5);
        // COMPLETAR
        return ciudad;
    }

    public static Explorador[] crearExploradores() {
        Explorador[] exploradores = new Explorador[1];

        exploradores[0] = new Explorador(1, "Indiana", 0, 0);
        // exploradores[1] = new Explorador(2, "Lara", 15, 2);
        // exploradores[2] = new Explorador(3, "Nathan", 25, 2);
        // exploradores[3] = new Explorador(4, "Elena", 5, 22);
        // exploradores[4] = new Explorador(5, "Alex", 15, 42);

        return exploradores;

    }

    public static Expedicion explorar(Ciudad ciudad, Explorador[] exploradores, int idExpedicion) {
        // TODO: crear boolean[][] visitadas, medir con System.nanoTime(),
        // llamar al auxiliar recursivo y construir Expedicion.
        Expedicion[] expediciones = new Expedicion[exploradores.length];
        int pos = 0;
        if (ciudad == null || exploradores == null) {
            throw new IllegalArgumentException("Ciudad y explorador no pueden ser nulos");
        }

        boolean[][] visitadas = new boolean[ciudad.getFilas()][ciudad.getColumnas()];
        int[] contadorVisitadas = new int[1];

        long inicio = System.nanoTime();
        for (Explorador explorador : exploradores) {
            System.out.println("Explorador pos=(" + explorador.getFila() + "," + explorador.getColumna() +
                    ") | Ciudad=(" + ciudad.getFilas() + "x" + ciudad.getColumnas() + ") | " +
                    "valida=" + ciudad.posicionValida(explorador.getFila(), explorador.getColumna()) +
                    " | transitable=" + ciudad.esTransitable(explorador.getFila(), explorador.getColumna()));
            int tesoros = explorarDesde(
                    ciudad,
                    explorador,
                    visitadas,
                    explorador.getFila(),
                    explorador.getColumna(),
                    contadorVisitadas);
            long tiempoNanos = System.nanoTime() - inicio;
            expediciones[pos] = new Expedicion(
                    idExpedicion,
                    explorador.getId(),
                    tesoros,
                    contadorVisitadas[0],
                    explorador.getPuntaje(),
                    tiempoNanos);
            pos++;
        }

        return expediciones[0];
    }

    /**
     * El auxiliar debe incluir casos base y cuatro llamadas recursivas.
     */
    private static int explorarDesde(Ciudad ciudad, Explorador explorador, boolean[][] visitadas, int fila, int columna,
            int[] contadorVisitadas) {

        // TODO: contar tesoros, registrar trampas y contar celdas visitadas.
        int tesorosEncontrados = 0;
        if (!ciudad.esTransitable(fila, columna) || visitadas[fila][columna]) {
            tesorosEncontrados = 0;
        }else{
            visitadas[fila][columna] = true;
            contadorVisitadas[0]++;
            System.out.println("[Visitas] Fila: " + fila + " Columna: " + columna);
    
            
            Sector sector = ciudad.getSector(fila, columna);
            if (sector != null) {
                if (sector.esTesoro()) {
                    tesorosEncontrados = 1;
                    explorador.registrarTesoro(sector.getValor());
                } else if (sector.esTrampa()) {
                    explorador.registrarTrampa(sector.getValor());
                }
            }
    
            tesorosEncontrados += explorarDesde(ciudad, explorador, visitadas, fila - 1, columna, contadorVisitadas); //Arriba
            tesorosEncontrados += explorarDesde(ciudad, explorador, visitadas, fila + 1, columna, contadorVisitadas); //Abajo
            tesorosEncontrados += explorarDesde(ciudad, explorador, visitadas, fila, columna - 1, contadorVisitadas); //Izquierda
            tesorosEncontrados += explorarDesde(ciudad, explorador, visitadas, fila, columna + 1, contadorVisitadas); //Derecha
    
            System.out.println("[Vuelve de] Fila: " + fila + " Columna: " + columna);
        }

        return tesorosEncontrados;
    }
}
