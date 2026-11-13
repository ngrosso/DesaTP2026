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

    public void informeGeneral(Sector[][] matriz){
        int tramps = calcularContenido(matriz, "Trampa"), tesoros = calcularContenido(matriz, "Tesoro"),
                cLibres = calcularContenido(matriz, "Libre");

        System.out.println("La cantidad de trampas en la ciudad es " + tramps);
        System.out.println("La cantidad de tesoros en la ciudad es " + tesoros);
        System.out.println("La cantidad de celdas libres en la ciudad es " + cLibres);
        System.out.println("La cantidad de paredes en la ciudad es " + ((matriz.length * matriz.length) -
                (tesoros + tramps + cLibres + 1)));
    }

    public void cambioCelda(Sector[][] matriz, int i, int j, String contNuevo){
        System.out.println();
        System.out.println("El contenido de la celda numero " + matriz[i][j].getIdentificador() + ", pasa de " +
                matriz[i][j].getContenido() + " a " + contNuevo);
        matriz[i][j].setContenido(contNuevo);
    }

    public void recorrerCiudad(Sector[][] mat){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                System.out.printf("%10s", mat[i][j].getContenido());
            }
            System.out.println();
        }
    }

    public void filaYColumnaMayorTesoro(Sector[][] mat){
        int min1 = 0, min2 = 0, max1 = 0, max2 = 0, indF = -1, indC = -1;

        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                if ((mat[i][j].getContenido()) != null && (mat[i][j].getContenido()).equalsIgnoreCase("Tesoro")){
                    max1++;
                }
                if ((mat[j][i].getContenido()) != null && (mat[j][i].getContenido()).equalsIgnoreCase("Tesoro")){
                    max2++;
                }
                if (max2 > min2){
                    min2 = max2;
                    indC = j;
                }
            }
            if (max1 > min1){
                min1 = max1;
                indF = i;
            }
            max1 = 0;
            max2 = 0;
        }

        System.out.println("La fila con mayor cantidad de tesoros es la " + indF + " con " + min1 + " tesoros");
        System.out.println("La columna con mayor cantidad de tesoros es la " + indC + " con " + min2 + " tesoros");
    }
}
