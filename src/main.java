package TPFinal;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Ciudad unaCiudad = new Ciudad("Konigsberg");
        int fila, columna, elecccion;

        unaCiudad.generarCiudad(unaCiudad,5,5);
        System.out.println(unaCiudad.getNombre());
        unaCiudad.establecerInicio(unaCiudad);
        unaCiudad.recorrerCiudad(unaCiudad.getMatrizCiudad());
        System.out.println();

        System.out.println("Quiere cambiar alguna celda? (Si:1 - No:0)");
        if ((elecccion = leer.nextInt()) == 1){
            System.out.println("Ingrese la fila:");
            fila = leer.nextInt();
            if (fila > -1 && fila < unaCiudad.getMatrizCiudad().length){
                System.out.println("Ingrese la columna:");
                columna = leer.nextInt();
                if (-1 < columna && columna < unaCiudad.getMatrizCiudad()[fila].length){
                    System.out.println("Elija un contenido para reemplazar el de la celda:" +
                            "(Tesoro: 1, Trampa: 2, Libre: 3, null: 0)");
                    switch ((leer.nextInt())){
                        case 1:
                            unaCiudad.cambioCelda(unaCiudad.getMatrizCiudad(), fila, columna, "Tesoro");
                            System.out.println("Siendo la nueva ciudad:");
                            unaCiudad.recorrerCiudad(unaCiudad.getMatrizCiudad());
                            break;
                        case 2:
                            unaCiudad.cambioCelda(unaCiudad.getMatrizCiudad(), fila, columna, "Trampa");
                            System.out.println("Siendo la nueva ciudad:");
                            unaCiudad.recorrerCiudad(unaCiudad.getMatrizCiudad());
                            break;
                        case 3:
                            unaCiudad.cambioCelda(unaCiudad.getMatrizCiudad(), fila, columna, "Libre");
                            System.out.println("Siendo la nueva ciudad:");
                            unaCiudad.recorrerCiudad(unaCiudad.getMatrizCiudad());
                            break;
                        case 0:
                            unaCiudad.cambioCelda(unaCiudad.getMatrizCiudad(), fila, columna, null);
                            System.out.println("Siendo la nueva ciudad:");
                            unaCiudad.recorrerCiudad(unaCiudad.getMatrizCiudad());
                            break;
                        default:
                            System.out.println("Contenido elegido inexistente");
                            break;
                    }
                } else {
                    System.out.println("El numero ingresado sobrepasa la longitud del arreglo");
                }
            } else {
                System.out.println("El numero ingresado sobrepasa la longitud de la matriz");
            }
        } else {
            if (elecccion != 0){
                System.out.println("Numero equivocado");
            }
        }
        System.out.println();

        System.out.println("La cantidad de tesoros en toda la ciudad es de " +
                (unaCiudad.calcularContenido(unaCiudad.getMatrizCiudad(), "Tesoro")));
        System.out.println();

        unaCiudad.informeGeneral(unaCiudad.getMatrizCiudad());
        System.out.println();

        unaCiudad.filaYColumnaMayorTesoro(unaCiudad.getMatrizCiudad());
    }
}
