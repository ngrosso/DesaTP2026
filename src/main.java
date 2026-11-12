package TPFinal;

public class main {
    public static void main(String[] args) {
        Ciudad unaCiudad = new Ciudad("Konigsberg");

        unaCiudad.generarCiudad(unaCiudad,5,5);
        System.out.println(unaCiudad.getNombre());
        unaCiudad.establecerInicio(unaCiudad);
        recorrerMatriz(unaCiudad.getMatrizCiudad());
        System.out.println(unaCiudad.calculoDistancia(unaCiudad, 0, 4));
        System.out.println(unaCiudad.calcularContenido(unaCiudad.getMatrizCiudad(), "Tesoro"));
    }

    public static void recorrerMatriz(Sector[][] mat){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[i].length; j++){
                System.out.printf("%10s", mat[i][j].getContenido());
            }
            System.out.println();
        }
    }
}
