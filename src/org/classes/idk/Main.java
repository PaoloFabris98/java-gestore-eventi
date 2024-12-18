package org.classes.idk;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Evento> events = new ArrayList<>();
        ArrayList<Concerto> eventsConcert = new ArrayList<>();
        Boolean a = true;
        input in = new input();
        Output out = new Output();

        while (a) {
            if (a) {
                out.sysOut("---------------------------------");
                out.sysOut("Digita un numero:");
                out.sysOut("1 - Inserisci evento/i");
                out.sysOut("2 - inserisci concerto/i");
                out.sysOut("3 - Visualizza eventi e concerti");
                out.sysOut("4 - Prenota");
                out.sysOut("5 - Disdici");
                out.sysOut("6 - Exit");
                out.sysOut("---------------------------------");
                int temp1;
                try {
                    temp1 = in.nextInt();
                } catch (Exception e) {
                    throw new IllegalArgumentException("La selezione può contenere solo numeri dal 1 al 5.");
                }
                if (temp1 < 0 || temp1 > 6) {
                    out.sysOut("Devi scegliere tra una delle opzioni date.");
                }
                if (temp1 == 1) {
                    Options.creaEvento(events, in);
                } else if (temp1 == 2) {
                    Options.creaConcerto(eventsConcert, in);
                } else if (temp1 == 3) {
                    Options.visualizzaEventiConcerti(events, eventsConcert, in);
                } else if (temp1 == 4) {
                    Options.prenotazioni(events, eventsConcert, in);
                } else if (temp1 == 5) {
                    Options.disdette(events, eventsConcert, in);
                } else if (temp1 == 6) {
                    a = Funct.eventCreatorPremission(temp1);

                    out.sysOut("Buona giornata!");
                } else {
                    out.sysOut("Ops, qualcosa è andato storto.");
                    break;
                }

            } else {
                break;
            }

        }

        in.inputClose();

    }
}
