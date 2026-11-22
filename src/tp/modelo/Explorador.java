package tp.modelo;

public class Explorador {
    private final int id;
    private final String nombre;
    private int fila, columna, tesorosRecoletados, trampasEncontradas, puntaje;

    // Constructores
    public Explorador(int id, String nom, int f, int c) {
        this.id = id;
        this.nombre = nom;
        this.fila = f;
        this.columna = c;
        this.tesorosRecoletados = 0;
        this.trampasEncontradas = 0;
        this.puntaje = 0;
    }

    // Observadores
    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getFila() {
        return this.fila;
    }

    public int getColumna() {
        return columna;
    }

    public int getTesorosRecoletados() {
        return this.tesorosRecoletados;
    }

    public int getTrampasEncontradas() {
        return this.trampasEncontradas;
    }

    public int getPuntaje() {
        return this.puntaje;
    }

    // Propias del tipo

    public void cambiarPosicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public void registrarTesoro(int recompensa) {
        this.tesorosRecoletados += 1;
        this.puntaje += recompensa;
    }

    public void registrarTrampa(int penalizacion) {
        this.trampasEncontradas += 1;
        this.puntaje -= penalizacion;
    }

    public void reiniciarResultados() {
        this.tesorosRecoletados = 0;
        this.trampasEncontradas = 0;
        this.puntaje = 0;
    }
}
