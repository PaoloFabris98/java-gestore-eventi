package org.classes.idk;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Evento> events = new ArrayList<>();
        Boolean a = true;
        input in = new input();
        Output out = new Output();

        Concerto test = new Concerto("null", 10, 10, 2030, 500, 10, 20, 20.69);
        out.sysOut(test.getDate());
        out.sysOut(test.getOrario());
        out.sysOut(test.getPrezzo());

        while (a) {
            if (a) {
                out.sysOut("---------------------------------");
                out.sysOut("Digita un numero:");
                out.sysOut("1 - Inserisci evento/i");
                out.sysOut("2 - Visualizza evento/i");
                out.sysOut("3 - Prenota");
                out.sysOut("4 - Disdici");
                out.sysOut("5 - Exit");
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
                    out.sysOut("Quanti eventi vuoi inserire?");
                    in.newLine();
                    int temp2 = in.nextInt();
                    out.sysOut("");
                    for (int i = 0; i < temp2; i++) {
                        out.sysOut("");
                        out.sysOut("Evento numero: " + (i + 1));
                        out.sysOut("---------------------------------");
                        out.sysOut("Inserisci il nome dell'evento:");
                        String nome = in.newString();
                        if (nome.isEmpty()) {
                            nome = in.newString();
                        }
                        out.sysOut("Inserisci il giorno dell'evento:");
                        int giorno = in.nextInt();
                        out.sysOut("Inserisci il mese dell'evento:");
                        int mese = in.nextInt();
                        out.sysOut("Inserisci l'anno dell'evento:");
                        int anno = in.nextInt();
                        out.sysOut("Inserisci i posti totali dell'evento dell'evento:");
                        int posti = in.nextInt();
                        events.add(new Evento(nome, giorno, mese, anno, posti));
                        out.sysOut("Titolo dell'evento numero: " + (i + 1) + ".");
                        out.sysOut("L'evento si terrà in data: " + events.get(i).getDate() + ".");
                        out.sysOut(
                                "I posti totali per l'evento sono: " + events.get(i).getPostiTotali() + ".");
                    }
                } else if (temp1 == 2) {
                    out.sysOut("\n");
                    for (int i = 0; i < events.size(); i++) {
                        out.sysOut("Evento numero: " + (i + 1) + ".");
                        out.sysOut("Titolo: " + events.get(i).getTitle() + ".");
                        out.sysOut("L'evento si terrà in data: " + events.get(i).getDate() + ".");
                        out.sysOut(
                                "I posti totali per l'evento sono: " + events.get(i).getPostiTotali() + ".");
                        out.sysOut(
                                "I posti prenotati per l'evento sono: " + events.get(i).getPostiPrenotati() + ".");
                        out.sysOut(
                                "I posti disponibili per l'evento sono: " + events.get(i).getPostiDisponibili()
                                        + ".");
                        out.sysOut("\n");
                    }
                } else if (temp1 == 3) {
                    out.sysOut("\n");
                    out.sysOut("Per quale evento vuoi prenotarti?");
                    out.sysOut("---------------------------------");
                    for (int i = 0; i < events.size(); i++) {
                        out.sysOut((i) + " - " + events.get(i).getTitle());
                    }
                    out.sysOut("---------------------------------");
                    int c = in.nextInt();
                    in.newLine();
                    out.sysOut("Quanti posti vuoi prenotare?");
                    int d = in.nextInt();

                    events.get(c).prenota(d);
                    out.sysOut("Hai prenotato: " + d + " posti.");
                    out.sysOut("I posti prenotati ora sono: " + events.get(c).getPostiPrenotati());

                } else if (temp1 == 4) {
                    out.sysOut("\n");
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
                } else if (temp1 == 5) {
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
