package TPFinal;

public class Expedicion {
    private final int id, exploradorId, tesorosRecuperados, celdasVisitadas, puntaje;
    private final long tiempoNanos;

    //Constructor
    public Expedicion(int id, int exploId, int tesRec, int celVisit, int pun, long timeN){
        this.id = id;
        this.exploradorId = exploId;
        this.tesorosRecuperados = tesRec;
        this.celdasVisitadas = celVisit;
        this.puntaje = pun;
        this.tiempoNanos = timeN;
    }

    //Visualizadores
    public int getId() {
        return this.id;
    }

    public int getExploradorId() {
        return this.exploradorId;
    }

    public int getTesorosRecuperados() {
        return this.tesorosRecuperados;
    }

    public int getCeldasVisitadas() {
        return this.celdasVisitadas;
    }

    public int getPuntaje() {
        return this.puntaje;
    }

    public long getTiempoEjecucion() {
        return this.tiempoEjecucion;
    }
}
