package tp.algoritmos;

import tp.modelo.Expedicion;

public final class Ordenamientos {
    private Ordenamientos() {
    }

    public static final int PUNTAJE = 1, TESOROS = 2, TIEMPO = 3, CELDAS = 4;

    /**
     * Compara según criterio: negativo si a va antes que b, positivo si va después.
     * Empates: id ascendente para obtener orden determinista.
     */
    public static int comparar(Expedicion expedicionA, Expedicion expedicionB, int criterio) {
        int aux = 0;

        switch (criterio) {
            case PUNTAJE:
                if (expedicionA.getPuntaje() > expedicionB.getPuntaje()) {
                    aux = -1;
                } else if (expedicionA.getPuntaje() < expedicionB.getPuntaje()) {
                    aux = 1;
                } else {
                    if (expedicionA.getId() < expedicionB.getId()) {
                        aux = -1;
                    } else if (expedicionA.getId() > expedicionB.getId()) {
                        aux = 1;
                    }
                }
                break;

            case TESOROS:
                if (expedicionA.getTesorosRecuperados() > expedicionB.getTesorosRecuperados()) {
                    aux = -1;
                } else if (expedicionA.getTesorosRecuperados() < expedicionB.getTesorosRecuperados()) {
                    aux = 1;
                } else {
                    if (expedicionA.getId() < expedicionB.getId()) {
                        aux = -1;
                    } else if (expedicionA.getId() > expedicionB.getId()) {
                        aux = 1;
                    }
                }
                break;

            case TIEMPO:
                if (expedicionA.getTiempoNanos() < expedicionB.getTiempoNanos()) {
                    aux = -1;
                } else if (expedicionA.getTiempoNanos() > expedicionB.getTiempoNanos()) {
                    aux = 1;
                } else {
                    if (expedicionA.getId() < expedicionB.getId()) {
                        aux = -1;
                    } else if (expedicionA.getId() > expedicionB.getId()) {
                        aux = 1;
                    }
                }
                break;

            case CELDAS:
                if (expedicionA.getCeldasVisitadas() < expedicionB.getCeldasVisitadas()) {
                    aux = -1;
                } else if (expedicionA.getCeldasVisitadas() > expedicionB.getCeldasVisitadas()) {
                    aux = 1;
                } else {
                    if (expedicionA.getId() < expedicionB.getId()) {
                        aux = -1;
                    } else if (expedicionA.getId() > expedicionB.getId()) {
                        aux = 1;
                    }
                }
                break;

            default:
                System.out.println("Criterio invalido");
                break;
        }

        return aux;
    }

    /** Ordenar in-place; elegir un algoritmo de fuerza bruta. */
    public static void ordenarFuerzaBruta(Expedicion[] arrExpedicion, int criterio) {
        if (arrExpedicion != null) {

            System.out.println("Antes de ordenar");
            mostrarArreglo(arrExpedicion);

            if (arrExpedicion.length > 1) {
                for (int i = 1; i < arrExpedicion.length; i++) {
                    Expedicion expedicion = arrExpedicion[i];
                    int j = i - 1;

                    while (j >= 0 && comparar(expedicion, arrExpedicion[j], criterio) < 0) {
                        arrExpedicion[j + 1] = arrExpedicion[j];
                        j = j - 1;
                    }
                    arrExpedicion[j + 1] = expedicion;
                }
            }

            System.out.println("Despues de ordenar");
            mostrarArreglo(arrExpedicion);
        }
    }

    /** Ordenar in-place; elegir Heap Sort, Quick Sort o Merge Sort. */
    public static void ordenarDivideVenceras(Expedicion[] arrExpedicion, int criterio) {
        if (arrExpedicion != null) {
            System.out.println("Antes de ordenar");
            mostrarArreglo(arrExpedicion);

            if (arrExpedicion.length > 1) {
                mergeSort(arrExpedicion, 0, arrExpedicion.length - 1, criterio);
            }

            System.out.println("Despues de ordenar");
            mostrarArreglo(arrExpedicion);

        }
    }

    public static void mergeSort(Expedicion[] arrExpedicion, int izq, int der, int criterio) {
        if (izq < der) {
            int mid = (izq + der) / 2;
            mergeSort(arrExpedicion, izq, mid, criterio);
            mergeSort(arrExpedicion, mid + 1, der, criterio);
            merge(arrExpedicion, izq, mid, der, criterio);
        }
    }

    public static void merge(Expedicion[] arrExpedicion, int izq, int mid, int der, int criterio) {
        int eIzq = mid - izq + 1;
        int eDer = der - mid;

        Expedicion[] L = new Expedicion[eIzq];
        Expedicion[] R = new Expedicion[eDer];

        for (int i = 0; i < eIzq; i++) {
            L[i] = arrExpedicion[izq + i];
        }
        for (int j = 0; j < eDer; j++) {
            R[j] = arrExpedicion[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = izq;

        while (i < eIzq && j < eDer) {
            if (comparar(L[i], R[j], criterio) <= 0) {
                arrExpedicion[k] = L[i];
                i++;
            } else {
                arrExpedicion[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < eIzq) {
            arrExpedicion[k] = L[i];
            i++;
            k++;
        }

        while (j < eDer) {
            arrExpedicion[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mostrarArreglo(Expedicion[] arrExpedicion) {
        for (int i = 0; i < arrExpedicion.length; i++) {
            System.out.println(arrExpedicion[i].toString());
        }
    }
}