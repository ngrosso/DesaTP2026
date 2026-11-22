package tp.modelo;

public class Ciudad {
    private Sector[][] sectores;

    // Constructores
    public Ciudad(int filas, int columnas) {
        int chance, tipo = 0;
        boolean inicio = true;
        if (filas <= 0 || columnas <= 0) {
            throw new IllegalArgumentException("Dimensiones inválidas");
        } else {
            sectores = new Sector[filas][columnas];
            for (int i = 0; i < sectores.length; i++) {
                for (int j = 0; j < sectores[i].length; j++) {
                    chance = (int) (Math.random() * 100);
                    if (chance > 20) {
                        if (chance > 60) {
                            tipo = (int) (Math.random() * 3) + 1;
                        } else {
                            tipo = 1;
                        }
                        if(inicio){
                            inicio = false;
                            tipo = 0;
                        }
                        sectores[i][j] = new Sector(tipo, 10);
                    }

                }
            }
        }

    }

    // Visualizadores
    public int getFilas() {
        return sectores.length;
    }

    public int getColumnas() {
        return sectores[0].length;
    }

    public boolean posicionValida(int fila, int columna) {
        boolean existe = true;

        if (-1 > fila || -1 > columna || fila > sectores.length || columna > sectores[fila].length) {
            existe = false;
        }

        return existe;
    }

    public Sector getSector(int fila, int columna) {
        if (!posicionValida(fila, columna)) {
            throw new IndexOutOfBoundsException();
        }
        return sectores[fila][columna];
    }

    public void modificar(int fila, int columna, Sector sector) {
        // TO DO: validar posición y asignar nuevo tipo.

        if (posicionValida(fila, columna) && sectores[fila][columna] != null) {
            sectores[fila][columna] = sector;
        }
    }

    public boolean esTransitable(int fila, int columna) {
        boolean paso = true;

        if (sectores[fila][columna] == null) {
            paso = false;
        }

        return paso;
    }

    public int contarTesoros() {
        int cont = 0;

        for (int i = 0; i < sectores.length; i++) {
            for (int j = 0; j < sectores[i].length; j++) {
                if (sectores[i][j] != null && sectores[i][j].esTesoro()) {
                    cont++;
                }
            }
        }

        return cont;
    }

    public int contarTrampas() {
        int cont = 0;

        for (int i = 0; i < sectores.length; i++) {
            for (int j = 0; j < sectores[i].length; j++) {
                if (sectores[i][j] != null && sectores[i][j].esTrampa()) {
                    cont++;
                }
            }
        }

        return cont;
    }

    public int contarTransitables() {
        int cont = 0;

        for (int i = 0; i < sectores.length; i++) {
            for (int j = 0; j < sectores[i].length; j++) {
                if (sectores[i][j] != null) {
                    cont++;
                }
            }
        }

        return cont;
    }

    public int[] tesorosPorFila() {
        int[] arr = new int[sectores.length];
        int cont = 0;

        for (int i = 0; i < sectores.length; i++) {
            for (int j = 0; j < sectores[i].length; j++) {
                if (sectores[i][j] != null && sectores[i][j].esTesoro()) {
                    cont++;
                }
            }
            arr[i] = cont;
            cont = 0;
        }

        return arr;
    }

    public int[] tesorosPorColumna() {
        int[] arr = new int[sectores[0].length];
        int cont = 0;

        for (int i = 0; i < sectores.length; i++) {
            for (int j = 0; j < sectores[i].length; j++) {
                if (sectores[j][i] != null && sectores[j][i].esTesoro()) {
                    cont++;
                }
            }
            arr[i] = cont;
            cont = 0;
        }

        return arr;
    }

    public int[] trampasPorFila() {
        int[] arr = new int[sectores.length];
        int cont = 0;

        for (int i = 0; i < sectores.length; i++) {
            for (int j = 0; j < sectores[i].length; j++) {
                if (sectores[i][j] != null && sectores[i][j].esTrampa()) {
                    cont++;
                }
            }
            arr[i] = cont;
            cont = 0;
        }

        return arr;
    }

    public int[] trampasPorColumna() {
        int[] arr = new int[sectores[0].length];
        int cont = 0;

        for (int i = 0; i < sectores.length; i++) {
            for (int j = 0; j < sectores[i].length; j++) {
                if (sectores[j][i] != null && sectores[j][i].esTrampa()) {
                    cont++;
                }
            }
            arr[i] = cont;
            cont = 0;
        }

        return arr;
    }

    /**
     * En caso de empate devolver el índice menor; si no hay tesoros, devolver 0.
     */
    public int filaConMasTesoros() {
        // Devuelve el indice de la fila con mas tesoros

        int cont = 0, contM = 0, ind = 0;

        for (int i = 0; i < sectores.length; i++) {
            for (int j = 0; j < sectores[i].length; j++) {
                if (sectores[i][j].esTesoro()) {
                    cont++;
                }
            }
            if (cont > contM) {
                contM = cont;
                ind = i;
            }
            cont = 0;
        }

        return ind;
    }

    public int columnaConMasTesoros() {
        // Devuelve el índice de la columna con mas tesoros

        int cont = 0, contM = 0, ind = 0;

        for (int i = 0; i < sectores.length; i++) {
            for (int j = 0; j < sectores[i].length; j++) {
                if (sectores[j][i] != null && sectores[j][i].esTesoro()) {
                    cont++;
                }
            }
            if (cont > contM) {
                contM = cont;
                ind = i;
            }
            cont = 0;
        }

        return ind;
    }

    public void mostrarMapa() {
        // Imprime por pantalla la matriz de la ciudad
        // Ver que métodos ya existentes pueden utilizar y completar lo que falte.
        // Por si lo necesitan: un emoji para los muros: "⬛"

        for (int i = 0; i < sectores.length; i++) {
            for (int j = 0; j < sectores[i].length; j++) {
                if (sectores[i][j] == null) {
                    System.out.print("⬛");
                } else {
                    System.out.print(sectores[i][j].getEmoji());
                }
            }
            System.out.println();
        }
    }

    public Ciudad clonar() {
        // Retorna una ciudad que es una copia de la ciudad actual.
        Ciudad ciudadClon = new Ciudad(sectores.length, sectores[0].length);

        ciudadClon.sectores = sectores;

        return ciudadClon;
    }

    public void informeGeneral() {
        System.out.println("La cantidad de tesoros en la ciudad es de " + contarTesoros());
        System.out.println("La cantidad de trampas en la ciudad es de " + contarTrampas());
        System.out.println("La cantidad de celdas transitables en la ciudad es de " + contarTransitables());
    }
}
