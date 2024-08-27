
public class Connessione {
    Stato da;
    Stato a;
    String tipo;
    String oggetto;

    Connessione(Stato da, Stato a, String tipo, String oggetto) {
        this.da = da;
        this.a = a;
        this.tipo = tipo;
        this.oggetto = oggetto;
    }
}
