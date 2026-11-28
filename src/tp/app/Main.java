package tp.app;

import java.util.Scanner;

import tp.algoritmos.Ordenamientos;
import tp.datos.DatosIniciales;
import tp.modelo.Ciudad;
import tp.modelo.Expedicion;
import tp.modelo.Explorador;
import tp.modelo.Sector;

public class Main {
    public static void main(String[] args) {
        Ciudad ciudad = crearCiudad();
        Explorador[] exploradores = crearExploradores();
        Expedicion[] expediciones = new Expedicion[exploradores.length];
        Scanner teclado = new Scanner(System.in);
        Sector sector;
        int opcion = -1, opcion2 = -1, opcion3 = -1, fila, columna, tipo;

        do {
            System.out.println("\n1. Mostrar Mapa  2. Informe  3. Explorar  4. Ordenar  5. Modificar  0. Salir");
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
                    for (int i = 0; i < exploradores.length; i++) {
                        expediciones[i] = explorar(ciudad, exploradores[i], i);
                        if (expediciones[i].getCeldasVisitadas() != 0) {
                            System.out.println("Info de la expedicion: " + expediciones[i].toString());
                        }
                    }
                    break;
                case 4:
                    Expedicion[] expedicionesClon = expediciones;
                    if (expediciones != null) {
                        do {
                            System.out.println("\n1. Insercion  2. Merge  0. Volver atras");
                            System.out.print("Opcion: ");
                            if (!teclado.hasNextInt()) {
                                teclado.nextLine();
                                continue;
                            }
                            opcion3 = teclado.nextInt();

                            switch (opcion3) {
                                case 1:
                                    do {
                                        System.out.println("Elija el criterio para ordenar");
                                        System.out.println(
                                                "\n1. Puntaje  2. Tesoros  3. Tiempo  4. Celdas Recorridas  0. Volver");
                                        System.out.print("Opcion: ");
                                        if (!teclado.hasNextInt()) {
                                            teclado.nextLine();
                                            continue;
                                        }
                                        opcion2 = teclado.nextInt();
                                        mostrarMetodoYCriterio(opcion3, opcion2);
                                        switch (opcion2) {
                                            case 1:
                                                Ordenamientos.ordenarFuerzaBruta(expedicionesClon, 1);
                                                break;
                                            case 2:
                                                Ordenamientos.ordenarFuerzaBruta(expedicionesClon, 2);
                                                break;
                                            case 3:
                                                Ordenamientos.ordenarFuerzaBruta(expedicionesClon, 3);
                                                break;
                                            case 4:
                                                Ordenamientos.ordenarFuerzaBruta(expedicionesClon, 4);
                                                break;
                                            case 0:
                                                break;
                                            default:
                                                System.out.println("Opcion invalida");
                                                break;
                                        }
                                    } while (opcion2 != 0);
                                    break;
                                case 2:
                                    do {
                                        System.out.println("Elija el criterio para ordenar");
                                        System.out.println(
                                                "\n1. Puntaje  2. Tesoros  3. Tiempo  4. Celdas Recorridas  0. Volver");
                                        System.out.print("Opcion: ");
                                        if (!teclado.hasNextInt()) {
                                            teclado.nextLine();
                                            continue;
                                        }
                                        opcion2 = teclado.nextInt();
                                        mostrarMetodoYCriterio(opcion3, opcion2);
                                        switch (opcion2) {
                                            case 1:
                                                Ordenamientos.ordenarDivideVenceras(expediciones, 1);
                                                break;
                                            case 2:
                                                Ordenamientos.ordenarDivideVenceras(expediciones, 2);
                                                break;
                                            case 3:
                                                Ordenamientos.ordenarDivideVenceras(expediciones, 3);
                                                break;
                                            case 4:
                                                Ordenamientos.ordenarDivideVenceras(expediciones, 4);
                                                break;
                                            case 0:
                                                break;
                                            default:
                                                System.out.println("Opcion invalida");
                                                break;
                                        }
                                    } while (opcion2 != 0);
                                    continue;
                                case 0:
                                    break;
                                default:
                                    System.out.println("Opcion invalida");
                                    break;
                            }
                        } while (opcion3 != 0);
                    } else {
                        System.out.println("No existen expediciones");
                    }
                    break;
                case 5:
                    ciudad.mostrarMapa();
                    System.out.println("Indique la fila a cambiar:");
                    if (!teclado.hasNextInt()) {
                        teclado.nextLine();
                        continue;
                    }
                    fila = teclado.nextInt();

                    System.out.println("Indique la columna a cambiar:");
                    if (!teclado.hasNextInt()) {
                        teclado.nextLine();
                        continue;
                    }
                    columna = teclado.nextInt();

                    System.out.println("Indique el nuevo estado a ingresar:");
                    System.out.println("\n0. Muro  1. Libre  2. Tesoro  3. Trampa");
                    if (!teclado.hasNextInt()) {
                        teclado.nextLine();
                        continue;
                    }
                    tipo = teclado.nextInt();

                    switch (tipo) {
                        case 0:
                            sector = null;
                            break;
                        case 2:
                            sector = new Sector(tipo, 20);
                            break;
                        case 3:
                            sector = new Sector(tipo, -10);
                            break;
                        default:
                            sector = new Sector(tipo, 0);
                            break;
                    }
                    ciudad.modificar(fila, columna, sector);

                    break;
                case 0:
                    System.out.println("Fin");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 0);
        teclado.close();
    }

    public static Ciudad crearCiudad() {
        Ciudad ciudad = DatosIniciales.crearCiudad();
        return ciudad;
    }

    public static Explorador[] crearExploradores() {
        Explorador[] exploradores = DatosIniciales.crearExploradores();
        return exploradores;

    }

    public static Expedicion explorar(Ciudad ciudad, Explorador explorador, int idExpedicion) {

        if (ciudad == null || explorador == null) {
            throw new IllegalArgumentException("Ciudad y explorador no pueden ser nulos");
        }
        explorador.reiniciarResultados();
        int[] contadorVisitadas = new int[1];
        long inicio = System.nanoTime();
        boolean[][] visitadas = new boolean[ciudad.getFilas()][ciudad.getColumnas()];

        System.out.println("Explorador pos=(" + explorador.getFila() + "," + explorador.getColumna() +
                ") | Ciudad=(" + ciudad.getFilas() + "x" + ciudad.getColumnas() + ") | " +
                "valida=" + ciudad.posicionValida(explorador.getFila(), explorador.getColumna()) +
                " | transitable=" + ciudad.esTransitable(explorador.getFila(), explorador.getColumna()));

        int tesoros = explorarDesde(ciudad, explorador, visitadas, explorador.getFila(),
                explorador.getColumna(), contadorVisitadas);

        long tiempoNanos = System.nanoTime() - inicio;

        Expedicion expedicion = new Expedicion(idExpedicion, explorador.getId(), tesoros, contadorVisitadas[0],
                explorador.getPuntaje(), tiempoNanos);

        return expedicion;
    }

    /**
     * El auxiliar debe incluir casos base y cuatro llamadas recursivas.
     */
    private static int explorarDesde(Ciudad ciudad, Explorador explorador, boolean[][] visitadas, int fila, int columna,
            int[] contadorVisitadas) {

        int tesorosEncontrados = 0;
        if (!ciudad.esTransitable(fila, columna) || visitadas[fila][columna]) {
            tesorosEncontrados = 0;
        } else {
            visitadas[fila][columna] = true;
            contadorVisitadas[0]++;
            // System.out.println("[Visitas] Fila: " + fila + " Columna: " + columna);

            Sector sector = ciudad.getSector(fila, columna);
            if (sector != null) {
                if (sector.esTesoro()) {
                    tesorosEncontrados = 1;
                    explorador.registrarTesoro(sector.getValor());
                } else if (sector.esTrampa()) {
                    explorador.registrarTrampa(sector.getValor());
                }
            }

            tesorosEncontrados += explorarDesde(ciudad, explorador, visitadas, fila - 1, columna, contadorVisitadas); // Arriba
            tesorosEncontrados += explorarDesde(ciudad, explorador, visitadas, fila + 1, columna, contadorVisitadas); // Abajo
            tesorosEncontrados += explorarDesde(ciudad, explorador, visitadas, fila, columna - 1, contadorVisitadas); // Izquierda
            tesorosEncontrados += explorarDesde(ciudad, explorador, visitadas, fila, columna + 1, contadorVisitadas); // Derecha

            // System.out.println("[Vuelve de] Fila: " + fila + " Columna: " + columna);
        }

        return tesorosEncontrados;
    }

    public static void mostrarMetodoYCriterio(int metodo, int criterio) {
        boolean volver = false;
        String metodoStr = "", criterioStr = "";
        switch (metodo) {
            case 1:
                metodoStr = "Insersion";
                break;
            case 2:
                metodoStr = "Merge sort";
            default:
                break;
        }
        switch (criterio) {
            case 1:
                criterioStr = "Puntaje";
                break;
            case 2:
                criterioStr = "Tesoros";
                break;
            case 3:
                criterioStr = "Tiempo";
                break;
            case 4:
                criterioStr = "Celdas Recorridas";
                break;
            default:
                volver = true;
                break;
        }
        if (!volver)
            System.out.println("Metodo: " + metodoStr + " | Criterio: " + criterioStr);
    }
}
