package tp.algoritmos;
import tp.modelo.Expedicion;
public final class Ordenamientos {
    private Ordenamientos(){}
    public static final int PUNTAJE=1,TESOROS=2,TIEMPO=3,CELDAS=4;

    /** Compara según criterio: negativo si a va antes que b, positivo si va después.
     * Empates: id ascendente para obtener orden determinista.
     */
    public static int comparar(Expedicion a,Expedicion b,int criterio){//Esta metodo es opcional
        // TODO: puntaje y tesoros descendentes; tiempo y celdas ascendentes.
        int aux = 0;

        switch (criterio){
            case PUNTAJE:
                if (a.getPuntaje() == b.getPuntaje()){
                    if (a.getId() < b.getId()){
                        aux = 1;
                    } else {
                        aux = -1;
                    }
                } else {
                    if (a.getPuntaje() < b.getPuntaje()){
                        aux = 1;
                    } else {
                        aux = -1;
                    }
                }
                break;

            case TESOROS:
                if (a.getTesorosRecuperados() == b.getTesorosRecuperados()){
                    if (a.getId() < b.getId()){
                        aux = 1;
                    } else {
                        aux = -1;
                    }
                } else {
                    if (a.getTesorosRecuperados() < b.getTesorosRecuperados()){
                        aux = 1;
                    } else {
                        aux = -1;
                    }
                }
                break;

            case TIEMPO:
                if (a.getTiempoNanos() == b.getTiempoNanos()){
                    if (a.getId() < b.getId()){
                        aux = 1;
                    } else {
                        aux = -1;
                    }
                } else {
                    if (a.getTiempoNanos() < b.getTiempoNanos()){
                        aux = 1;
                    } else {
                        aux = -1;
                    }
                }
                break;

            case CELDAS:
                if (a.getCeldasVisitadas() == b.getCeldasVisitadas()){
                    if (a.getId() < b.getId()){
                        aux = 1;
                    } else {
                        aux = -1;
                    }
                } else {
                    if (a.getCeldasVisitadas() < b.getCeldasVisitadas()){
                        aux = 1;
                    } else {
                        aux = -1;
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
    public static void ordenarFuerzaBruta(Expedicion[] datos,int criterio){ //Inserccion
        Expedicion indice;
        int j;

        System.out.println("Antes de ordenar");
        mostrarArreglo(datos);
        for (int i = 1; i < datos.length; i++){
            indice = datos[i];
            j = i - 1;
            while (j >= 0 && comparar(indice, datos[j], criterio) != 0){
                datos[j + 1] = datos[j];
                j = j - 1;
            }
            datos[j + 1] = indice;
        }
        System.out.println("Despues de ordenar");
        mostrarArreglo(datos);
    }

    /** Ordenar in-place; elegir Heap Sort, Quick Sort o Merge Sort. */
    public static void ordenarDivideVenceras(Expedicion[] datos,int criterio){ //Merge
        int[] arr = new int[datos.length];

        switch (criterio){
            case PUNTAJE:
                for (int i = 0; i < datos.length; i++){
                    arr[i] = datos[i].getPuntaje();
                }

                break;

            case TESOROS:
                for (int i = 0; i < datos.length; i++){
                    arr[i] = datos[i].getTesorosRecuperados();
                }

                break;

            case TIEMPO:
                for (int i = 0; i < datos.length; i++){
                    //arr[i] = datos[i].getTiempoNanos();
                }

                break;

            case CELDAS:
                for (int i = 0; i < datos.length; i++){
                    arr[i] = datos[i].getCeldasVisitadas();
                }

                break;

            default:
                System.out.println("Criterio invalido");
                break;
        }

        mergeSort(arr, 0, arr.length);
    }

    /*public static void insertion(int[] arr, Expedicion[] arrE) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }*/

    public static void mergeSort(int[] A, int izq, int der) {
        if (izq < der) {
            int mid = (izq + der) / 2;
            mergeSort(A, izq , mid);
            mergeSort(A, mid + 1, der);
            merge(A, izq, mid, der);
        }
    }

    public static void merge(int[] A, int izq, int mid, int der) {

        int nIzq = mid - izq + 1;
        int nDer = der - mid;

        int[] L = new int[nIzq];
        int[] R = new int[nDer];

        for (int i = 0; i < nIzq; i++) {
            L[i] = A[izq + i];
        }
        for (int j = 0; j < nDer; j++) {
            R[j] = A[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = izq;

        while (i < nIzq && j < nDer) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < nIzq) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < nDer) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public static void mostrarArreglo(Expedicion[] arr){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
