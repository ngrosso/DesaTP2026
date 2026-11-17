package tp.datos;
import java.util.Random;
import tp.modelo.*;
public final class DatosIniciales {
    private DatosIniciales(){}
    /** Datos deterministas; -1 representa muro. */
        public static Ciudad crearCiudad(){
             final int FILAS = 30;
        final int COLUMNAS = 50;

        Ciudad ciudad = new Ciudad(FILAS, COLUMNAS);

        for (int f = 0; f < FILAS; f++) {
            for (int c = 0; c < COLUMNAS; c++) {

                int tipo;

                // Muros horizontales que separan tres zonas
                boolean muroHorizontal =
                        (f == 10 || f == 20);

                // Muros verticales con pasajes
                boolean muroVertical =
                        (c == 9 || c == 19 ||
                        c == 29 || c == 39)
                        && f % 10 != 5;

                // Obstáculos adicionales distribuidos
                // de manera determinística
                boolean obstaculo =
                        (f * 7 + c * 11) % 23 == 0
                        && f % 10 != 5
                        && c != 2 && c != 12
                        && c != 22 && c != 32
                        && c != 42;

                if (muroHorizontal ||
                    muroVertical || obstaculo) {

                    tipo = -1; // Muro

                } else if (
                        (f == 5  && c == 2) ||
                        (f == 15 && c == 2) ||
                        (f == 25 && c == 2)) {

                    tipo = 0; // Punto inicial

                } else if ((f * 17 + c * 13) % 37 == 0) {

                    tipo = 2; // Tesoro

                } else if ((f * 19 + c * 7) % 29 == 0) {

                    tipo = 3; // Trampa

                } else {

                    tipo = 1; // Camino libre
                }

                ciudad.modificar(
                    f, c,
                    tipo == -1 ? null :
                        new Sector(
                            tipo,
                            tipo == 2 ? 10 :
                            tipo == 3 ? 4 : 0
                        )
                );
            }
        }

        return ciudad;
    }
    
    public static Explorador[] crearExploradores() {

    Explorador[] exploradores = new Explorador[5];

    exploradores[0] = new Explorador(1, "Indiana", 5, 2);
    exploradores[1] = new Explorador(2, "Lara", 15, 2);
    exploradores[2] = new Explorador(3, "Nathan", 25, 2);
    exploradores[3] = new Explorador(4, "Elena", 5, 22);
    exploradores[4] = new Explorador(5, "Alex", 15, 42);

    return exploradores;
    }


    public static Expedicion[] crearExpediciones(int cantidad,long semilla){
        if(cantidad<0)throw new IllegalArgumentException();
        Random r=new Random(semilla);Expedicion[] datos=new Expedicion[cantidad];
        for(int i=0;i<cantidad;i++)datos[i]=new Expedicion(i+1,1,r.nextInt(50),r.nextInt(200)+1,r.nextInt(500)-100,r.nextInt(1000000)+1);
        return datos;
    }
}
