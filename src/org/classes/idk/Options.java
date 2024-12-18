package org.classes.idk;

import java.util.ArrayList;

public class Options {

    public static void creaEvento(ArrayList<Evento> events, input in) {
        Output out = new Output();
        out.sysOut("Quanti eventi vuoi creare?");
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
            out.sysOut("\n");
            out.sysOut("Titolo dell'evento numero " + (i + 1) + ": " + events.get(i).getTitle());
            out.sysOut("L'evento si terrà in data: " + events.get(i).getDate() + ".");
            out.sysOut(
                    "I posti totali per l'evento sono: " + events.get(i).getPostiTotali() + ".");
        }
    }

    public static void creaConcerto(ArrayList<Concerto> eventsConcert, input in) {
        Output out = new Output();
        out.sysOut("Quanti concerti vuoi creare?");
        in.newLine();
        int temp2 = in.nextInt();
        out.sysOut("");
        for (int i = 0; i < temp2; i++) {
            out.sysOut("");
            out.sysOut("Concerto numero: " + (i + 1));
            out.sysOut("---------------------------------");
            out.sysOut("Inserisci il nome del concerto:");
            String nome = in.newString();
            if (nome.isEmpty()) {
                nome = in.newString();
            }
            out.sysOut("Inserisci il giorno del concerto:");
            int giorno = in.nextInt();
            out.sysOut("Inserisci il mese del concerto:");
            int mese = in.nextInt();
            out.sysOut("Inserisci l'anno del concerto:");
            int anno = in.nextInt();
            out.sysOut("Inserisci l'ora dell'evento:");
            int ora = in.nextInt();
            out.sysOut("Minuti:");
            int minuti = in.nextInt();
            out.sysOut("Inserisci il costo del biglietto (usa la virgola come separatore):");
            Double prezzo = in.nextDouble();
            out.sysOut("Inserisci i posti totali del concerto:");
            int posti = in.nextInt();
            eventsConcert.add(new Concerto(nome, giorno, mese, anno, posti, minuti, ora, prezzo));
            out.sysOut("\n");
            out.sysOut("Titolo del concerto numero " + (i + 1) + ": " + eventsConcert.get(i).getTitle());
            out.sysOut("Il concerto si terrà in data: " + eventsConcert.get(i).getDate() + ".");
            out.sysOut(
                    "I posti totali del concerto sono: " + eventsConcert.get(i).getPostiTotali() + ".");
        }
    }

    public static void visualizzaEventiConcerti(ArrayList<Evento> events, ArrayList<Concerto> eventsConcert, input in) {
        Output out = new Output();
        out.sysOut("\n");
        int temp2;
        out.sysOut("Cosa vuoi visualizzare?");
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
            out.sysOut("\n");
            if (events.size() == 0) {
                out.sysOut("Non ci sono eventi da visualizzare.");
            } else {
                for (int i = 0; i < events.size(); i++) {
                    out.sysOut("Evento numero: " + (i + 1) + ".");
                    out.sysOut("Titolo: " + events.get(i).getTitle() + ".");
                    out.sysOut("L'evento si terrà in data: " + events.get(i).getDate() + ".");
                    out.sysOut(
                            "I posti totali per l'evento sono: " + events.get(i).getPostiTotali() + ".");
                    out.sysOut(
                            "I posti prenotati per l'evento sono: " + events.get(i).getPostiPrenotati()
                                    + ".");
                    out.sysOut(
                            "I posti disponibili per l'evento sono: " + events.get(i).getPostiDisponibili()
                                    + ".");
                    out.sysOut("\n");
                }
            }
        } else if (temp2 == 1) {
            out.sysOut("\n");
            if (eventsConcert.size() == 0) {
                out.sysOut("Non ci sono concerti da visualizzare.");
            } else {
                for (int i = 0; i < eventsConcert.size(); i++) {
                    out.sysOut("Evento numero: " + (i + 1) + ".");
                    out.sysOut("Titolo: " + eventsConcert.get(i).getTitle() + ".");
                    out.sysOut("L'evento si terrà in data: " + eventsConcert.get(i).getDate() + ".");
                    out.sysOut(
                            "I posti totali per l'evento sono: " + eventsConcert.get(i).getPostiTotali()
                                    + ".");
                    out.sysOut(
                            "I posti prenotati per l'evento sono: "
                                    + eventsConcert.get(i).getPostiPrenotati() + ".");
                    out.sysOut(
                            "I posti disponibili per l'evento sono: "
                                    + eventsConcert.get(i).getPostiDisponibili()
                                    + ".");
                    out.sysOut("\n");
                }
            }
        } else {
            out.sysOut("Non hai selezionato un numero corretto.");
        }
    }

    public static void prenotazioni(ArrayList<Evento> events, ArrayList<Concerto> eventsConcert, input in) {
        Output out = new Output();
        out.sysOut("\n");
        int temp2;
        out.sysOut("Per cosa vuoi prenotarti?");
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
            if (events.size() == 0) {
                out.sysOut("Non ci sono eventi per cui prenotarsi");
            } else {
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
                eventsConcert.get(c).prenota(d);
            }
        } else {
            out.sysOut("Non hai selezionato un numero corretto.");
        }
    }
}
