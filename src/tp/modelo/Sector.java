package tp.modelo;
/** null en la matriz significa muro; un Sector nunca es muro. */
public class Sector {
    public static final int INICIO=0, LIBRE=1, TESORO=2, TRAMPA=3; //final significa que es una constante
    private int tipo;
    private int valor; // Recompensa positiva del tesoro o penalización positiva de la trampa.
    
    public Sector(int tipo,int valor) {
        //TO DO: Completar
    }

    public int getTipo(){
        //TO DO: Completar
    }
    public int getValor(){
        //TO DO: Completar
    }

    private String getEmoji(){
        //Devuelve un simbolo para cada sector. Ver donde lo pueden utilizar

        String simbolo = 
                 (this.getTipo() == 0) ? "🚩" :
                 (this.getTipo() == 1) ? "⬜" :
                 (this.getTipo() == 2) ? "💎" : "⚠️";
        return simbolo;
    }
    public boolean esTesoro(){
        //TO DO: Completar
    }
    public boolean esTrampa(){
            //TO DO: Completar
    }
}
