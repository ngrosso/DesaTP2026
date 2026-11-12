package TPFinal;

public class Expedicion {
    private int identificador;
    private Explorador explorador;
    private int tesorosRecuperados;
    private int[] celdasVisitadas;
    private int puntaje;
    private double tiempoEjecucion;

    //Constructor
    public Expedicion(int id, Explorador explo, int tesRec, int[] celVisit, int pun, double timeEje){
        this.identificador = id;
        this.explorador = explo;
        this.tesorosRecuperados = tesRec;
        this.celdasVisitadas = celVisit;
        this.puntaje = pun;
        this.tiempoEjecucion = timeEje;
    }

    public Expedicion(int id){
        this.identificador = id;
        this.explorador = null;
        this.tesorosRecuperados = 0;
        this.celdasVisitadas = null;
        this.puntaje = 0;
        this.tiempoEjecucion = 0;
    }

    //Visualizadores
    public int getIdentificador() {
        return this.identificador;
    }

    public Explorador getExplorador() {
        return this.explorador;
    }

    public int getTesorosRecuperados() {
        return this.tesorosRecuperados;
    }

    public int[] getCeldasVisitadas() {
        return this.celdasVisitadas;
    }

    public int getPuntaje() {
        return this.puntaje;
    }

    public double getTiempoEjecucion() {
        return this.tiempoEjecucion;
    }

    public boolean equals(Expedicion unaExpedicion){
        boolean iguales = false;

        if (this.identificador == unaExpedicion.identificador){
            iguales = true;
        }

        return iguales;
    }

    public String toString(){
        return ("Datos Expedicion: Id " + this.identificador + ", explorador " + this.explorador + ", tesoros recuperados" +
                " " + this.tesorosRecuperados + ", celdas visitadas " + this.celdasVisitadas + ", puntaje " + this.puntaje +
                ", y tiempo de ejecucion " + this.tiempoEjecucion);
    }

    //Modificadores
    public void setIdentificador(int id) {
        this.identificador = id;
    }

    public void setExplorador(Explorador explo) {
        this.explorador = explo;
    }

    public void setTesorosRecuperados(int tesRec) {
        this.tesorosRecuperados = tesRec;
    }

    public void setCeldasVisitadas(int[] celVisit) {
        this.celdasVisitadas = celVisit;
    }

    public void setPuntaje(int punt) {
        this.puntaje = punt;
    }

    public void setTiempoEjecucion(double timeEje) {
        this.tiempoEjecucion = timeEje;
    }
}
