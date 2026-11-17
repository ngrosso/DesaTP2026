package tp.modelo;
public class Explorador {
    //Completar atributos
    private final int id;
    private final String nombre;
    private int fila,columna,tesorosRecolectados,trampasEncontradas,puntaje;

    public Explorador(int id,String nombre,int fila,int columna){
        this.id=id;this.nombre=nombre;this.fila=fila;this.columna=columna;
    }

    public int getId(){return id;}
    public String getNombre(){return nombre;}
    public int getFila(){return fila;}
    public int getColumna(){return columna;}
    public int getTesorosRecolectados(){return tesorosRecolectados;}
    public int getTrampasEncontradas(){return trampasEncontradas;}
    public int getPuntaje(){return puntaje;}

    public void cambiarPosicion(int fila,int columna)
    {
        this.fila=fila;
        this.columna=columna;
    }
    public void registrarTesoro(int recompensa){
        // TODO: incrementar contador y puntaje.
        throw new UnsupportedOperationException("TODO registrarTesoro");
    }
    public void registrarTrampa(int penalizacion){
        // TODO: incrementar contador y descontar puntaje.
        throw new UnsupportedOperationException("TODO registrarTrampa");
    }
    public void reiniciarResultados(){
        // TODO: poner contadores y puntaje en cero.
        throw new UnsupportedOperationException("TODO reiniciarResultados");
    }
}
