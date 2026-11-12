package TPFinal;

public class Sector {
    private int identificador;
    private String contenido;
    private int distancia;

    //Constructor
    public Sector(int id, String cont, int dist){
        this.identificador = id;
        this.contenido = cont;
        this.distancia = dist;
    }

    public Sector(int id){
        this.identificador = id;
        this.contenido = null;
        this.distancia = 0;
    }

    //Visualizadores
    public int getIdentificador() {
        return this.identificador;
    }

    public String getContenido() {
        return this.contenido;
    }

    public int getDistancia(){
        return this.distancia;
    }

    public boolean equals(Sector unSector){
        boolean iguales = false;

        if (this.identificador == unSector.identificador) {
            iguales = true;
        }

        return iguales;
    }

    public String toString(){
        return ("datosCelda: Id (" + this.identificador + "), contenido(" + this.contenido + "), y distacia del " +
                "inicio (" + this.distancia + ")");
    }

    //Modificadores
    public void setIdentificador(int id) {
        this.identificador = id;
    }

    public void setContenido(String cont) {
        this.contenido = cont;
    }

    public void setDistancia(int dist){
        this.distancia = dist;
    }

    //Propios del tipo
    public Sector generarCeldaRandom(Sector cel){
        int aux = (int)(Math.random() * (8 - 1 + 1)) + 1;

        switch (aux){
            case 1:
                cel.setContenido("Tesoro");
                break;
            case 2:
                cel.setContenido("Trampa");
                break;
            case 3, 4, 5, 6:
                cel.setContenido("Libre");
                break;
            default:
        }

        return cel;
    }
}
