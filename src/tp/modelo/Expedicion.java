package tp.modelo;

public class Expedicion {
    private final int id, exploradorId, tesorosRecuperados, celdasVisitadas, puntaje;
    private final long tiempoNanos;

    public Expedicion(int id, int exploradorId, int tesorosRecuperados, int celdasVisitadas, int puntaje,
            long tiempoNanos) {
        this.id = id;
        this.exploradorId = exploradorId;
        this.tesorosRecuperados = tesorosRecuperados;
        this.celdasVisitadas = celdasVisitadas;
        this.puntaje = puntaje;
        this.tiempoNanos = tiempoNanos;
    }

    public int getId() {
        return id;
    }

    public int getExploradorId() {
        return exploradorId;
    }

    public int getTesorosRecuperados() {
        return tesorosRecuperados;
    }

    public int getCeldasVisitadas() {
        return celdasVisitadas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public long getTiempoNanos() {
        return tiempoNanos;
    }
}
