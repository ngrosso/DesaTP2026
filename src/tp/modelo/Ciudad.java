package tp.modelo;
public class Ciudad {
    private  Sector[][] sectores;
    public Ciudad(int filas,int columnas){
        if(filas<=0||columnas<=0)throw new IllegalArgumentException("Dimensiones inválidas");

        //TO DO: Crear la matriz de sectores y poblarla con los sectores
        //sectores=new Sector[filas][columnas];
    }
    public int getFilas()
    {
        //Completar
    }
    public int getColumnas()
    {
        //Completar

    }
    public boolean posicionValida(int fila,int columna){
       //Devuelve si el elemento en la poscion de la fila y la columna es una posicion
       // válida dentro de la matriz;

    }

    public Sector getSector(int fila,int columna){
        if(!posicionValida(fila,columna))throw new IndexOutOfBoundsException();
        return sectores[fila][columna];
    }

    public void modificar(int fila,int columna,Sector sector){
        // TO DO: validar posición y asignar nuevo tipo.
        // Recordar que null representa muro.
        
    }
    public boolean esTransitable(int fila,int columna){
        // TO DO: fuera de rango o muro devuelve false.
        
    }

    public int contarTesoros()
    {
        //TO DO contar todos los tesoros;
    }

    public int contarTrampas()
    {
        //TO DO contar todas las Trampas
    }

    public int contarTransitables()
    {
       //TO DO contar todos los lugares Transitables
    }

    public int[] tesorosPorFila(){
        //devuelve un arreglo con la cantidad de tesoros en cada fila
    }

    public int[] tesorosPorColumna(){
        //Devuelve un arreglo con la cantidad de tesoros en cada columna
    }

    public int[] trampasPorFila(){
         //Devuelve un arreglo con la cantidad de trampas por fila
    }

    public int[] trampasPorColumna(){
         //Devuelve un arreglo con la cantidad de trampas por columna
    }

    /** En caso de empate devolver el índice menor; si no hay tesoros, devolver 0. */
    public int filaConMasTesoros(){
        //Devuelve el indice de la fila con mas tesoros
    }

    public int columnaConMasTesoros(){
        //Devuelve el índice de la columna con mas tesoros
    }
    

    public void  mostrarMapa(){
        //Imprime por pantalla la matriz de la ciudad
        //Ver que métodos ya existentes pueden utilizar y completar lo que falte.
        //Por si lo necesitan: un emoji para los muros: "⬛" 

    }

    public Ciudad clonar(){
        //Retorna una ciudad que es una copia de la ciudad actual.
    }

    public void informeGeneral(){}
}
