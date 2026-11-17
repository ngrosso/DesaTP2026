package TPFinal;

public class Sector {
    public static final int INICIO=0, LIBRE=1, TESORO=2, TRAMPA=3; //final significa que es una constante
    private int tipo;
    private int valor; // Recompensa positiva del tesoro o penalización positiva de la trampa.

    //Constructor
    public Sector(int tip, int val){
        this.tipo = tip;
        this.valor = val;
    }

    //Visualizadores
    public int getTipo() {
        return this.tipo;
    }

    public int getValor(){
        return this.valor;
    }

    private String getEmoji(){
        String simbolo =
                (this.getTipo() == 0) ? "🚩" :
                        (this.getTipo() == 1) ? "⬜" :
                                (this.getTipo() == 2) ? "💎" : "⚠️";
        return simbolo;
    } //Devuelve un simbolo para cada sector. Ver donde lo pueden utilizar

    public boolean esTesoro(Sector unSec){
        boolean iguales = false;

        if (this.tipo == "💎"){
            iguales = true;
        }

        return iguales;
    }

    public boolean esTrampa(Sector unSec){
        boolean iguales = false;

        if (this.tipo == "⚠️"){
            iguales = true;
        }

        return iguales;
    }
}
