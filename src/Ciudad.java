package TPFinal;

public class Ciudad {
    private String nombre;
    private Sector celdaInicio;
    private Sector[][] matrizCiudad;

    //Constructores
    public Ciudad(String nom, Sector celIni, Sector[][] matCiu){
        this.nombre = nom;
        this.celdaInicio = celIni;
        this.matrizCiudad = matCiu;
    }

    public Ciudad(String nom){
        this.nombre = nom;
        this.celdaInicio = null;
        this.matrizCiudad = null;
    }

    //Visualizadores
    public String getNombre() {
        return this.nombre;
    }

    public Sector getCeldaInicio() {
        return this.celdaInicio;
    }

    public Sector[][] getMatrizCiudad() {
        return this.matrizCiudad;
    }

    public boolean equals(Ciudad unaCiudad){
        boolean iguales = false;

        if ((this.nombre).equals(unaCiudad.nombre)){
            iguales = true;
        }

        return iguales;
    }

    public String toString(){
        return ("Datos ciudad: nombre " + this.nombre + ", celda inicio " + this.celdaInicio + ", y matriz ciudad " +
                this.matrizCiudad);
    }

    //Modificadores
    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public void setCeldaInicio(Sector celIni) {
        this.celdaInicio = celIni;
    }

    public void setMatrizCiudad(Sector[][] matCiu) {
        this.matrizCiudad = matCiu;
    }

    //Propias del tipo
    public void generarCiudad(Ciudad city ,int f, int c){
        Sector[][] matriz = new Sector[f][c];
        city.setMatrizCiudad(matriz);
        int aux = 1;

        for (int i = 0; i < f; i++){
            for (int j = 0; j < c; j++){
                Sector cel = new Sector(aux);
                matriz[i][j] = cel.generarCeldaRandom(cel);
                aux++;
            }
        }
    }

    public void establecerInicio(Ciudad city){
        Sector[][] matriz = city.getMatrizCiudad();
        boolean inicio = false;
        int i = 0, j = 0;

        while (!inicio && i < matriz.length){
            while (!inicio && j < matriz[i].length){
                if (((matriz[i][j]).getContenido() == null) || ((matriz[i][j]).getContenido().equalsIgnoreCase("Libre"))){
                    matriz[i][j].setContenido("Inicio");
                    city.setCeldaInicio(matriz[i][j]);
                    inicio = true;
                }
                j++;
            }
            j = 0;
            i++;
        }
    }

    public int calculoDistancia(Ciudad city, int f, int c){
        Sector[][] matriz = city.getMatrizCiudad();
        int i = 0, j = 0, dist = -1;
        boolean encontrado = false;

        while (!encontrado && i <= matriz.length - 1){
            while (!encontrado && j <= matriz[i].length - 1){
                if (f == i && c == j){
                    encontrado = true;
                    dist = i + j;
                }
                j++;
            }
            j = 0;
            i++;
        }

        return dist;
    }

    public int calcularContenido(Sector[][] matriz, String cont){
        int contador = 0;

        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if (matriz[i][j].getContenido() != null && (matriz[i][j].getContenido()).equalsIgnoreCase(cont)){
                    contador++;
                }
            }
        }

        return contador;
    }// debe devolver un arreglo

    public int calcularContenidoArr(Sector[] arr, String cont){
        int contador = 0;

        for (int i = 0; i < arr.length; i++){
            if (arr[i].getContenido() != null && (arr[i].getContenido()).equalsIgnoreCase(cont)){
                contador++;
            }
        }

        return contador;
    }
}
