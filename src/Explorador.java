package TPFinal;

public class Explorador {
    private int identificador;
    private String nombre;
    private Sector posicionActual;
    private int tesorosRecoletados;
    private int trampasEncontradas;
    private int puntajeAcumulado;

    //Constructores
    public Explorador(int id, String nom, Sector posAc, int tesRec, int trampEnc, int punAcum){
        this.identificador = id;
        this.nombre = nom;
        this.posicionActual = posAc;
        this.tesorosRecoletados = tesRec;
        this.trampasEncontradas = trampEnc;
        this.puntajeAcumulado = punAcum;
    }

    public Explorador(int id){
        this.identificador = id;
        this.nombre = "";
        this.posicionActual = null;
        this.tesorosRecoletados = 0;
        this.trampasEncontradas = 0;
        this.puntajeAcumulado = 0;
    }

    //Observadores
    public int getIdentificador(){
        return this.identificador;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Sector getPosicionActual() {
        return this.posicionActual;
    }

    public int getTesorosRecoletados() {
        return this.tesorosRecoletados;
    }

    public int getTrampasEncontradas() {
        return this.trampasEncontradas;
    }

    public int getPuntajeAcumulado() {
        return this.puntajeAcumulado;
    }

    public boolean equals(Explorador unExplorador){
        boolean iguales = false;

        if (this.identificador == unExplorador.identificador){
            iguales = true;
        }

        return iguales;
    }

    public String toString(Sector unSector){
        return ("Datos del explotador: Id " + this.identificador + ", nombre "+ '"' + this.nombre + '"' +
                ", tesoros recolectados " + this.tesorosRecoletados + ", trampas encontradas " + this.trampasEncontradas
                + ", posicion actual(" + unSector.toString() + "), y puntaje acumulado " + this.puntajeAcumulado);
    }

    //Modificadores

    public void setIdentificador(int id) {
        this.identificador = id;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public void setPosicionActual(Sector posAc) {
        this.posicionActual = posAc;
    }

    public void setTesorosRecoletados(int tesRec) {
        this.tesorosRecoletados = tesRec;
    }

    public void setTrampasEncontradas(int trampEnc) {
        this.trampasEncontradas = trampEnc;
    }

    public void setPuntajeAcumulado(int puntAcum) {
        this.puntajeAcumulado = puntAcum;
    }

    //Propios del tipo
    public void moverExplorador(Sector[][] mat, Sector ini, Explorador explo){
        explo.setPosicionActual(ini);
        boolean mover = false;
        int i = 0, j = 0;

        while (!mover && i < mat.length){
            while (!mover && j < mat[i].length){
                if (j == 0 || j == mat[i].length - 1){
                    if (i == 0 || i == mat.length - 1){

                    } else {

                    }
                } else {
                    if (i == 0 || i == mat.length - 1){

                    } else {

                    }
                }
                j++;
            }
            j = 0;
            i++;
        }
    } // Recursividad con recursividad (Que el llamado principal no termine y inicie un nuevo llamado recursivo)
}
