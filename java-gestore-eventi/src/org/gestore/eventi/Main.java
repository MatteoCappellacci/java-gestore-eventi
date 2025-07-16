package org.gestore.eventi;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        


        /* TEST
        Evento bellino = new Evento("prova ", LocalDate.of(25,10,12), 100);

            bellino.setTitolo("bauu");
            System.out.println(bellino.getTitolo()); */



        Concerto concertoneRoma = new Concerto("Roma2025", LocalDate.of(2025, 9, 15), 1000, 0,
                LocalTime.of(11, 30), new BigDecimal(30.00));

        Concerto concertoneMilano = new Concerto("Milano2026", LocalDate.of(2026, 9, 15), 1000, 0, LocalTime.of(11, 30), new BigDecimal(30.00));
               

        Concerto concertoneBologna = new Concerto("Bologna2021", LocalDate.of(2021, 5 ,22), 1000, 0, LocalTime.of(11, 00),new BigDecimal(30.00));


                
        Scanner scanner = new Scanner(System.in);

        System.out.println("Concerti disponibili:");
        System.out.println("1. " +concertoneRoma.toString());
        System.out.println("2. " + concertoneMilano.toString());
        System.out.println("3. " + concertoneBologna.toString());



System.out.println("\nQuale concerto vuoi selezionare? (1 = concertoneRoma, 2 = concertoneMilano, 3 = concertoneBologna)" );


        int sceltaConcerto = scanner.nextInt();

        Evento concertoSelezionato;

        if (sceltaConcerto == 1) {
            concertoSelezionato = concertoneRoma;
        } else if (sceltaConcerto == 2) {
            concertoSelezionato = concertoneMilano;
        } else if (sceltaConcerto == 3) {
            concertoSelezionato = concertoneBologna;
        } else {
            System.out.println("Scelta non valida. Riprova.");
            scanner.close();
            return;
        }

        System.out.println("Quante prenotazioni vuoi effettuare per: " + concertoSelezionato.getTitolo() + " " + " ?");
        int postiPrenotati = scanner.nextInt();

        for (int i = 0; i < postiPrenotati; i++) {
            try {
                concertoSelezionato.prenota();
            } catch (IllegalStateException errore) {
                System.out.println("Errore durante la prenotazione: " + errore.getMessage());
                break;
            }
        }

        System.out.println("\nPrenotazione completata. Vuoi disdire una prenotazione? (digita 'disdici' per procedere oppure 'conferma' per terminare)");
        scanner.nextLine();
        String utenteHaScelto = scanner.nextLine().trim().toLowerCase();

        switch (utenteHaScelto) {
            case "disdici":
                System.out.println("\nQuante prenotazioni vuoi disdire per: " + concertoSelezionato.getTitolo() + " ?");
                int numeroDisdetti = scanner.nextInt();

                for (int i = 0; i < numeroDisdetti; i++) {
                    try {
                        concertoSelezionato.disdici();
                    } catch (IllegalStateException errore) {
                        System.out.println("Errore durante la disdetta: " + errore.getMessage());
                        break;
                    }
                }

                System.out.println("\nRiepilogo finale:".toUpperCase());
                System.out.println(concertoSelezionato.toString());
                break;

            case "conferma":
            default:
                System.out.println("Prenotazioni confermate. Nessuna disdetta effettuata.");
                System.out.println("\nRiepilogo finale:".toUpperCase());
                System.out.println(concertoSelezionato.toString());
                break;
        }

        scanner.close();



    }

    

    
}
