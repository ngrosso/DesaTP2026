package tp.algoritmos;
import tp.modelo.Expedicion;
public final class Ordenamientos {
    private Ordenamientos(){}
    public static final int PUNTAJE=1,TESOROS=2,TIEMPO=3,CELDAS=4;
    /** Compara según criterio: negativo si a va antes que b, positivo si va después.
     * Empates: id ascendente para obtener orden determinista.
     */
    public static int comparar(Expedicion a,Expedicion b,int criterio){
        // TODO: puntaje y tesoros descendentes; tiempo y celdas ascendentes.
        throw new UnsupportedOperationException("TODO comparar");
    }
    /** Ordenar in-place; elegir un algoritmo de fuerza bruta. */
    public static void ordenarFuerzaBruta(Expedicion[] datos,int criterio){
        throw new UnsupportedOperationException("TODO ordenarFuerzaBruta");
    }
    /** Ordenar in-place; elegir Heap Sort, Quick Sort o Merge Sort. */
    public static void ordenarDivideVenceras(Expedicion[] datos,int criterio){
        throw new UnsupportedOperationException("TODO ordenarDivideVenceras");
    }
}
