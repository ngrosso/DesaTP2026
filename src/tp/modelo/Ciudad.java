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
                        if (inicio) {
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
        boolean existe = false;
        if (sectores != null && fila >= 0 && fila < sectores.length) {
            if (columna >= 0 && columna < sectores[fila].length) {
                existe = true;
            }
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
        if (posicionValida(fila, columna)) {
            sectores[fila][columna] = sector;
        }
    }

    public boolean esTransitable(int fila, int columna) {
        boolean paso = false;

        if (posicionValida(fila, columna) && sectores[fila][columna] != null) {
            paso = true;
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
        int[] contPorCol = new int[0];

        if (sectores != null && sectores.length > 0 && sectores[0].length > 0) {
            int cantCols = sectores[0].length;
            contPorCol = new int[cantCols];

            for (int col = 0; col < cantCols; col++) {
                int contTesoros = 0;

                for (int fila = 0; fila < sectores.length; fila++) {
                    if (sectores[fila][col] != null && sectores[fila][col].esTesoro()) {
                        contTesoros++;
                    }
                }

                contPorCol[col] = contTesoros;
            }
        }

        return contPorCol;
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
        int[] retorno;
        if (sectores == null || sectores.length == 0 || sectores[0].length == 0) {
            retorno = new int[0];
        } else {
            int cantCols = sectores[0].length;
            int[] contPorCol = new int[cantCols];

            for (int col = 0; col < cantCols; col++) {
                int contTrampas = 0;

                for (int fila = 0; fila < sectores.length; fila++) {
                    if (sectores[fila][col] != null && sectores[fila][col].esTrampa()) {
                        contTrampas++;
                    }
                }

                contPorCol[col] = contTrampas;
            }
            retorno = contPorCol;
        }
        return retorno;
    }

    /**
     * En caso de empate devolver el índice menor; si no hay tesoros, devolver 0.
     */
    public int filaConMasTesoros() {
        int cont = 0, contM = 0, ind = 0;

        for (int i = 0; i < sectores.length; i++) {
            for (int j = 0; j < sectores[i].length; j++) {
                if (sectores[i][j] != null && sectores[i][j].esTesoro()) {
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
        int maxTesoros = 0;
        int indColMax = 0;

        if (sectores != null && sectores.length > 0 && sectores[0].length > 0) {
            for (int col = 0; col < sectores[0].length; col++) {
                int contTesoros = 0;

                for (int fila = 0; fila < sectores.length; fila++) {
                    if (sectores[fila][col] != null && sectores[fila][col].esTesoro()) {
                        contTesoros++;
                    }
                }

                if (contTesoros > maxTesoros) {
                    maxTesoros = contTesoros;
                    indColMax = col;
                }
            }
        }

        return indColMax;
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
                    if (sectores[i][j].getTipo() == 3) {
                        System.out.print(sectores[i][j].getEmoji());
                    } else {
                        System.out.print(sectores[i][j].getEmoji());
                    }
                }
            }
            System.out.println();
        }
    }

    public Ciudad clonar() {
        // Retorna una ciudad que es una copia de la ciudad actual.
        Ciudad ciudadClon = new Ciudad(sectores.length, sectores[0].length);

        for (int i = 0; i < ciudadClon.getFilas(); i++) {
            for (int j = 0; j < ciudadClon.getColumnas(); j++) {
                ciudadClon.modificar(i, j, this.getSector(i, j));
            }

        }
        return ciudadClon;
    }

    public void informeGeneral() {
        System.out.println("La cantidad de tesoros en la ciudad es de " + contarTesoros());
        System.out.println("La cantidad de trampas en la ciudad es de " + contarTrampas());
        System.out.println("La cantidad de celdas transitables en la ciudad es de " + contarTransitables());
        System.out.print("Tesoros por Fila: ");
        mostrarArregloConteo(tesorosPorFila());
        System.out.print("Tesoros por Columna: ");
        mostrarArregloConteo(tesorosPorColumna());
        System.out.print("Trampas por Fila: ");
        mostrarArregloConteo(trampasPorFila());
        System.out.print("Trampas por Columna: ");
        mostrarArregloConteo(trampasPorColumna());
        System.out.println("La fila con mas tesoros es: " + filaConMasTesoros());
        System.out.println("La columna con mas tesoros es: " + columnaConMasTesoros());
    }

    public static void mostrarArregloConteo(int[] arregloValores) {
        if (arregloValores == null || arregloValores.length == 0) {
            System.out.println(" (sin datos)");
        } else {
            System.out.print("[");
            for (int i = 0; i < arregloValores.length; i++) {
                if (i == arregloValores.length - 1)
                    System.out.print(arregloValores[i]);
                else
                    System.out.print(arregloValores[i] + ",");
            }
            System.out.println("]");
        }
    }
}
