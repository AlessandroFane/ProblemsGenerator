import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Problema {
    private List<Stato> stati;
    private List<Connessione> connessioni;
    private Random random;

    Problema(int numeroStati, double probabilitaConnessione, double probabilitaBus, double probabilitaTreno, double probabilitaAereo) {
        stati = new ArrayList<>();
        connessioni = new ArrayList<>();
        random = new Random();

        // Creare gli stati
        for (int i = 0; i < numeroStati; i++) {
            stati.add(new Stato("S" + i));
        }

        // Creare le connessioni
        String[] tipi = {"road", "railway", "flight"};
        String[] oggetti = {"bus", "train", "plane"};
        double[] probabilita = {probabilitaBus, probabilitaTreno, probabilitaAereo};

        for (int i = 0; i < numeroStati; i++) {
            for (int j = i + 1; j < numeroStati; j++) {
                for (int k = 0; k < tipi.length; k++) {
                    if (random.nextDouble() < probabilitaConnessione && random.nextDouble() < probabilita[k]) {
                        connessioni.add(new Connessione(stati.get(i), stati.get(j), tipi[k], oggetti[k] + (random.nextInt(3) + 1)));
                    }
                }
            }
        }
    }


    public void scriviPDDL(String nomeFile) throws IOException {
        try (FileWriter writer = new FileWriter(nomeFile)) {
            writer.write("(define (problem " + nomeFile + ") (:domain navigation)\n");
            writer.write("(:objects\n");

            // Scrivere gli stati
            for (Stato stato : stati) {
                writer.write("    " + stato.nome + " - location\n");
            }

            // Scrivere gli oggetti
            writer.write("    bus1 bus2 bus3 - bus\n");
            writer.write("    treno1 treno2 treno3 - train\n");
            writer.write("    aereo1 aereo2 aereo3 - plane\n");
            writer.write(")\n");

            // Scrivere le inizializzazioni
            writer.write("(:init\n");
            for (Connessione connessione : connessioni) {
                writer.write("    (" + connessione.tipo + " " + connessione.da.nome + " " + connessione.a.nome + " " + connessione.oggetto + ")\n");
            }
            writer.write("    (at " + stati.get(0).nome + ")\n");
            writer.write(")\n");

            // Scrivere l'obiettivo
            writer.write("(:goal (and\n");
            writer.write("    (at " + stati.get(stati.size() - 1).nome + ")\n");
            writer.write("))\n");
            writer.write(")\n");
        }
    }
}

