import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner t = new Scanner(System.in);
        int opzione;
        File miofile=new File("elaborazione csv/src/Cortinovis.csv");
        memoria Memoria=new memoria(miofile);


        do {
            System.out.println("scegli  opzione:");
            System.out.println("1-file caricato in memoria");
            System.out.println("0-esci");
            opzione = t.nextInt();
            t.nextLine();
            switch (opzione) {
                case 1:
                    Memoria.carica(miofile);

                    break;
                case 0:


                    System.out.println("grazie per aver usate il servizio cortinovis, alla prossima!");
                    break;
                default:
                    System.out.println("metti una tra le opzioni richieste");

            }
        } while (opzione != 0);
    }
}
