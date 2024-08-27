import java.io.IOException;

public class ProblemMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numeroStati = 10;
        double probabilitaConnessionePocoConnesso = 0.25;
        double probabilitaConnessioneMedioConnesso = 0.5;
        double probabilitaConnessioneMoltoConnesso = 0.75;
        double probabilitaBus = 0.8;
        double probabilitaTreno = 0.5;
        double probabilitaAereo = 0.2;
        System.out.println("sdrhhtjhtryw");
        
        
        

        // Generare e scrivere problemi in PDDL
        try {
            for (int i = 0; i < 5; i++) {
                String nomeFile = "Test/molto_poco_connesso" + "_problema" + (i + 1) + ".pddl";
                Problema generatorePocoConnesso = new Problema(numeroStati, probabilitaConnessionePocoConnesso, probabilitaBus, probabilitaTreno, probabilitaAereo);
                generatorePocoConnesso.scriviPDDL(nomeFile);
            }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//        try {
//            for (int i = 0; i < 5; i++) {
//                String nomeFile = "Test/medio_connesso" + "_problema" + (i + 1) + ".pddl";
//                Problema generatoreMedioConnesso = new Problema(numeroStati, probabilitaConnessioneMedioConnesso, probabilitaBus, probabilitaTreno, probabilitaAereo);
//                generatoreMedioConnesso.scriviPDDL(nomeFile);
//            }
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        try {
//            for (int i = 0; i < 5; i++) {
//            	String nomeFile = "Test/molto_connesso" + "_problema" + (i + 1) + ".pddl";
//                Problema generatoreMoltoConnesso = new Problema(numeroStati, probabilitaConnessioneMoltoConnesso, probabilitaBus, probabilitaTreno, probabilitaAereo);
//                generatoreMoltoConnesso.scriviPDDL(nomeFile);
//            }
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
	
}
