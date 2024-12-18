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
                    out.sysOut("\n");
                    int temp2;
                    out.sysOut("Per cosa vuoi disdirti?");
                    out.sysOut("---------------------------------");
                    out.sysOut("0 - Eventi");
                    out.sysOut("1 - Concerti");
                    out.sysOut("---------------------------------");
                    try {
                        temp2 = in.nextInt();
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Puoi inserire solo numeri.");
                    }
                    if (temp2 == 0) {
                        if (eventsConcert.size() == 0) {
                            out.sysOut("Non ci sono eventi per cui disdirsi");
                        } else {
                            out.sysOut("Per quale evento vuoi disdire?");
                            out.sysOut("---------------------------------");
                            for (int i = 0; i < events.size(); i++) {
                                out.sysOut((i) + " - " + events.get(i).getTitle());
                            }
                            out.sysOut("---------------------------------");
                            int c = in.nextInt();
                            in.newLine();
                            out.sysOut("Quanti posti vuoi disdire?");
                            int d = in.nextInt();
                            events.get(c).disdici(d);
                        }
                    } else if (temp2 == 1) {
                        if (eventsConcert.size() == 0) {
                            out.sysOut("Non ci sono concerti per cui prenotarsi");
                        } else {
                            out.sysOut("Per quale concerto vuoi prenotarti?");
                            out.sysOut("---------------------------------");
                            for (int i = 0; i < eventsConcert.size(); i++) {
                                out.sysOut((i) + " - " + eventsConcert.get(i).getTitle());
                            }
                            out.sysOut("---------------------------------");
                            int c = in.nextInt();
                            in.newLine();
                            out.sysOut("Quanti posti vuoi prenotare?");
                            int d = in.nextInt();
                            eventsConcert.get(c).disdici(d);
                        }
                    }
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
