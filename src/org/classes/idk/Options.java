package org.classes.idk;

import java.util.ArrayList;

public class Options {

    public static void creaEvento(ProgrammaEventi<Evento> eventi, input in) {
        Output.sysOut("Quanti eventi vuoi creare?");
        in.newLine();
        int temp2 = in.nextInt();
        Output.sysOut("");
        for (int i = 0; i < temp2; i++) {
            Evento currentEvent = eventi.getItemsArray().get(i);
            Output.sysOut("");
            Output.sysOut("Evento numero: " + (i + 1));
            Output.sysOut("---------------------------------");
            Output.sysOut("Inserisci il nome dell'evento:");
            String nome = in.newString();
            if (nome.isEmpty()) {
                nome = in.newString();
            }
            Output.sysOut("Inserisci il giorno dell'evento:");
            int giorno = in.nextInt();
            Output.sysOut("Inserisci il mese dell'evento:");
            int mese = in.nextInt();
            Output.sysOut("Inserisci l'anno dell'evento:");
            int anno = in.nextInt();
            Output.sysOut("Inserisci i posti totali dell'evento dell'evento:");

            int posti = in.nextInt();
            eventi.setEvent(new Evento(nome, giorno, mese, anno, posti));
            Output.sysOut("\n");
            Output.sysOut("Titolo dell'evento numero " + (i + 1) + ": " + currentEvent.getTitle());
            Output.sysOut("L'evento si terrà in data: " + currentEvent.getDate() + ".");
            Output.sysOut(
                    "I posti totali per l'evento sono: " + currentEvent.getPostiTotali() + ".");
        }
    }

    public static void creaConcerto(ProgrammaEventi<Concerto> concerti, input in) {
        Output.sysOut("Quanti concerti vuoi creare?");
        in.newLine();
        int temp2 = in.nextInt();
        Output.sysOut("");
        for (int i = 0; i < temp2; i++) {
            Concerto currentConcert = concerti.getItemsArray().get(i);
            Output.sysOut("");
            Output.sysOut("Concerto numero: " + (i + 1));
            Output.sysOut("---------------------------------");
            Output.sysOut("Inserisci il nome del concerto:");
            String nome = in.newString();
            if (nome.isEmpty()) {
                nome = in.newString();
            }
            Output.sysOut("Inserisci il giorno del concerto:");
            int giorno = in.nextInt();
            Output.sysOut("Inserisci il mese del concerto:");
            int mese = in.nextInt();
            Output.sysOut("Inserisci l'anno del concerto:");
            int anno = in.nextInt();
            Output.sysOut("Inserisci l'ora dell'evento:");
            int ora = in.nextInt();
            Output.sysOut("Minuti:");
            int minuti = in.nextInt();
            Output.sysOut("Inserisci il costo del biglietto (usa la virgola come separatore):");
            Double prezzo = in.nextDouble();
            Output.sysOut("Inserisci i posti totali del concerto:");
            int posti = in.nextInt();
            concerti.setEvent(new Concerto(nome, giorno, mese, anno, posti, minuti, ora, prezzo));
            Output.sysOut("\n");
            Output.sysOut("Titolo del concerto numero " + (i + 1) + ": " + currentConcert.getTitle());
            Output.sysOut("Il concerto si terrà in data: " + currentConcert.getDate() + ".");
            Output.sysOut("L'orario del concerto è: " + currentConcert.getOrario() + ".");
            Output.sysOut(
                    "I posti totali del concerto sono: " + currentConcert.getPostiTotali() + ".");
        }
    }

    public static void visualizzaEventiConcerti(ProgrammaEventi<Evento> eventi, ProgrammaEventi<Concerto> concerti,
            input in) {
        Output.sysOut("\n");
        int temp2;
        Output.sysOut("Cosa vuoi visualizzare?");
        Output.sysOut("---------------------------------");
        Output.sysOut("0 - Evento");
        Output.sysOut("1 - Concerto");
        Output.sysOut("2 - Lista Eventi");
        Output.sysOut("3 - Lista Concerti");
        Output.sysOut("---------------------------------");

        temp2 = in.nextInt();

        if (temp2 == 0) {
            Output.sysOut("\n");
            if (eventi.getItemsArray().size() == 0) {
                Output.sysOut("Non ci sono eventi da visualizzare.");
            } else {
                for (int i = 0; i < eventi.getItemsArray().size(); i++) {
                    Evento currentEvents = eventi.getItemsArray().get(i);
                    Output.sysOut("Evento numero: " + (i + 1) + ".");
                    Output.sysOut("Titolo: " + currentEvents.getTitle() + ".");
                    Output.sysOut("L'evento si terrà in data: " + currentEvents.getDate() + ".");
                    Output.sysOut(
                            "I posti totali per l'evento sono: " + currentEvents.getPostiTotali() + ".");
                    Output.sysOut(
                            "I posti prenotati per l'evento sono: " + currentEvents.getPostiPrenotati()
                                    + ".");
                    Output.sysOut(
                            "I posti disponibili per l'evento sono: " + currentEvents.getPostiDisponibili()
                                    + ".");
                    Output.sysOut("\n");
                }
            }
        } else if (temp2 == 1) {
            Output.sysOut("\n");
            if (concerti.getItemsArray().size() == 0) {
                Output.sysOut("Non ci sono concerti da visualizzare.");
            } else {
                for (int i = 0; i < concerti.getItemsArray().size(); i++) {
                    Concerto currentConcert = concerti.getItemsArray().get(i);
                    Output.sysOut("Concerto numero: " + (i + 1) + ".");
                    Output.sysOut("Titolo: " + currentConcert.getTitle() + ".");
                    Output.sysOut("Il concerto si terrà in data: " + currentConcert.getDate() + " alle: "
                            + currentConcert.getOrario() + ".");
                    Output.sysOut(
                            "Il prezzo del concerto è: " + currentConcert.getPrezzoFormattato()
                                    + ".");

                    Output.sysOut(
                            "I posti totali per il concerto sono: " + currentConcert.getPostiTotali()
                                    + ".");
                    Output.sysOut(
                            "I posti prenotati per il concerto sono: "
                                    + currentConcert.getPostiPrenotati() + ".");
                    Output.sysOut(
                            "I posti disponibili per il concerto sono: "
                                    + currentConcert.getPostiDisponibili()
                                    + ".");
                    Output.sysOut("\n");
                }
            }
        } else if (temp2 == 2) {
            if (eventi.getItemsArray().size() == 0) {
                Output.sysOut("Non ci sono eventi da visualizzare");
            } else {
                eventi.formattedElements();
                eventi.cleanReturnedArray();
            }
        } else if (temp2 == 3) {
            if (eventi.getItemsArray().size() == 0) {
                Output.sysOut("Non ci sono eventi da visualizzare");
            } else {
                concerti.formattedElements();
                concerti.cleanReturnedArray();
            }

        } else {
            Output.sysOut("Devi inserire una selezione valida.");
        }
    }

    public static void prenotazioni(ProgrammaEventi<Evento> eventi, ProgrammaEventi<Concerto> concerti, input in) {
        Output.sysOut("\n");
        int temp2;
        Output.sysOut("Per cosa vuoi prenotarti?");
        Output.sysOut("---------------------------------");
        Output.sysOut("0 - Eventi");
        Output.sysOut("1 - Concerti");
        Output.sysOut("---------------------------------");
        temp2 = in.nextInt();
        if (temp2 == 0) {
            if (eventi.getItemsArray().size() == 0) {
                Output.sysOut("Non ci sono eventi per cui prenotarsi");
            } else {
                Output.sysOut("Per quale evento vuoi prenotarti?");
                Output.sysOut("---------------------------------");
                for (int i = 0; i < eventi.getItemsArray().size(); i++) {
                    Evento currentEvents = eventi.getItemsArray().get(i);
                    Output.sysOut((i) + " - " + currentEvents.getTitle());
                }
                Output.sysOut("---------------------------------");
                int c = in.nextInt();
                in.newLine();
                Output.sysOut("Quanti posti vuoi prenotare?");
                int d = in.nextInt();
                eventi.getItemsArray().get(c).prenota(d);
            }
        } else if (temp2 == 1) {
            if (concerti.getItemsArray().size() == 0) {
                Output.sysOut("Non ci sono concerti per cui prenotarsi");
            } else {
                Output.sysOut("Per quale concerto vuoi prenotarti?");
                Output.sysOut("---------------------------------");
                for (int i = 0; i < concerti.getItemsArray().size(); i++) {
                    Concerto currentConcert = concerti.getItemsArray().get(i);
                    Output.sysOut((i) + " - " + currentConcert.getTitle());
                }
                Output.sysOut("---------------------------------");
                int c = in.nextInt();
                in.newLine();
                Output.sysOut("Quanti posti vuoi prenotare?");
                int d = in.nextInt();
                concerti.getItemsArray().get(c).prenota(d);
            }
        } else {
            Output.sysOut("Devi inserire una selezione valida.");
        }
    }

    public static void disdette(ProgrammaEventi<Evento> eventi, ProgrammaEventi<Concerto> concerti, input in) {
        Output.sysOut("\n");
        int temp2;
        Output.sysOut("Per cosa vuoi disdirti?");
        Output.sysOut("---------------------------------");
        Output.sysOut("0 - Eventi");
        Output.sysOut("1 - Concerti");
        Output.sysOut("---------------------------------");

        temp2 = in.nextInt();

        if (temp2 == 0) {
            if (eventi.getItemsArray().size() == 0) {
                Output.sysOut("Non ci sono eventi per cui disdirsi");
            } else {
                Output.sysOut("Per quale evento vuoi disdire?");
                Output.sysOut("---------------------------------");
                for (int i = 0; i < eventi.getItemsArray().size(); i++) {
                    Evento currentEvents = eventi.getItemsArray().get(i);
                    Output.sysOut((i) + " - " + currentEvents.getTitle());
                }
                Output.sysOut("---------------------------------");
                int c = in.nextInt();
                in.newLine();
                Output.sysOut("Quanti posti vuoi disdire?");
                int d = in.nextInt();
                eventi.getItemsArray().get(c).disdici(d);
            }
        } else if (temp2 == 1) {
            if (concerti.getItemsArray().size() == 0) {
                Output.sysOut("Non ci sono concerti per cui prenotarsi");
            } else {
                Output.sysOut("Per quale concerto vuoi disdirti?");
                Output.sysOut("---------------------------------");
                for (int i = 0; i < concerti.getItemsArray().size(); i++) {
                    Concerto currentConcert = concerti.getItemsArray().get(i);
                    Output.sysOut((i) + " - " + currentConcert.getTitle());
                }
                Output.sysOut("---------------------------------");
                int c = in.nextInt();
                in.newLine();
                Output.sysOut("Quanti posti vuoi disdire?");
                int d = in.nextInt();
                concerti.getItemsArray().get(c).disdici(d);
            }
        } else {
            Output.sysOut("Devi inserire una selezione valida.");
        }
    }

    public static void eventList(ProgrammaEventi<Evento> eventi, ProgrammaEventi<Concerto> concerti, input in) {
        Output.sysOut("\n");
        int temp2;

        Output.sysOut("Che lista vuoi visualizzare?");
        Output.sysOut("---------------------------------");
        Output.sysOut("0 - Eventi");
        Output.sysOut("1 - Concerti");
        Output.sysOut("---------------------------------");

        temp2 = in.nextInt();

        if (temp2 == 0) {
            Output.sysOut("\n");
            int temp3;
            Output.sysOut("Come si vuole effettuare la ricerca?");
            Output.sysOut("---------------------------------");
            Output.sysOut("0 - Visualizza Tutti");
            Output.sysOut("1 - Tramite Data");
            Output.sysOut("---------------------------------");
            temp3 = in.nextInt();
            if (temp3 == 0) {
                eventi.formattedElements();
            } else if (temp3 == 1) {
                Output.sysOut("Inserisci il giorno:");
                int tempDay = Integer.parseInt(Funct.numberFormatted(in.nextInt()));
                Output.sysOut("Inserisci il mese:");
                int tempMonth = Integer.parseInt(Funct.numberFormatted(in.nextInt()));
                Output.sysOut("Inserisci l'anno:");
                int tempYear = Integer.parseInt(Funct.numberFormatted(in.nextInt()));
                ArrayList<Evento> retuArrayListTemp = eventi.getEvents(tempDay, tempMonth, tempYear);
                Output.sysOut("Gli eventi in data: " + tempDay + "/" + tempMonth + "/" + tempYear + ". Sono:");
                for (int i = 0; i < retuArrayListTemp.size(); i++) {
                    Evento currentElement = retuArrayListTemp.get(i);
                    Output.sysOut(currentElement.getTitle());
                }
            } else {
                Output.sysOut("Devi inserire una selezione valida.");
            }
        } else if (temp2 == 1) {
            Output.sysOut("\n");
            int temp3;
            Output.sysOut("Come si vuole effettuare la ricerca?");
            Output.sysOut("---------------------------------");
            Output.sysOut("0 - Visualizza Tutti");
            Output.sysOut("1 - Tramite Data");
            Output.sysOut("---------------------------------");
            temp3 = in.nextInt();
            if (temp3 == 0) {
                concerti.formattedElements();
            } else if (temp3 == 1) {
                Output.sysOut("Inserisci il giorno:");
                int tempDay = Integer.parseInt(Funct.numberFormatted(in.nextInt()));
                Output.sysOut("Inserisci il mese:");
                int tempMonth = Integer.parseInt(Funct.numberFormatted(in.nextInt()));
                Output.sysOut("Inserisci l'anno:");
                int tempYear = Integer.parseInt(Funct.numberFormatted(in.nextInt()));
                ArrayList<Concerto> retuArrayListTemp = concerti.getEvents(tempDay, tempMonth, tempYear);
                Output.sysOut("Gli eventi in data: " + tempDay + "/" + tempMonth + "/" + tempYear + ". Sono:");
                for (int i = 0; i < retuArrayListTemp.size(); i++) {
                    Concerto currentElement = retuArrayListTemp.get(i);
                    Output.sysOut(currentElement.getTitle());
                }
            } else {
                Output.sysOut("Devi inserire una selezione valida.");
            }
        }

    }
}
