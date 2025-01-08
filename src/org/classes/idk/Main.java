package org.classes.idk;

public class Main {
    public static void main(String[] args) {
        ProgrammaEventi eventi = new ProgrammaEventi();
        ProgrammaConcerti concerti = new ProgrammaConcerti();
        Boolean a = true;
        input in = new input(3);

        while (a) {
            if (a) {
                Output.sysOut("---------------------------------");
                Output.sysOut("Digita un numero:");
                Output.sysOut("1 - Inserisci evento/i");
                Output.sysOut("2 - inserisci concerto/i");
                Output.sysOut("3 - Visualizza eventi e concerti");
                Output.sysOut("4 - Prenota");
                Output.sysOut("5 - Disdici");
                Output.sysOut("6 - Exit");
                Output.sysOut("---------------------------------");
                int temp1;
                temp1 = in.nextInt();
                if (temp1 < 0 || temp1 > 6) {
                    Output.sysOut("Devi scegliere tra una delle opzioni date.");
                }
                if (temp1 == 1) {
                    Options.creaEvento(eventi, in);
                } else if (temp1 == 2) {
                    Options.creaConcerto(concerti, in);
                } else if (temp1 == 3) {
                    Options.visualizzaEventiConcerti(eventi, concerti, in);
                } else if (temp1 == 4) {
                    Options.prenotazioni(eventi, concerti, in);
                } else if (temp1 == 5) {
                    Options.disdette(eventi, concerti, in);
                } else if (temp1 == 6) {
                    Options.getElementsNumber(eventi, concerti, in);
                } else if (temp1 == 7) {
                    Options.clearList(eventi, concerti, in);
                } else if (temp1 == 8) {
                    a = Funct.eventCreatorPremission(temp1);
                    Output.sysOut("Buona giornata!");
                } else if (temp1 <= 0 || temp1 > 6) {
                    Output.sysOut("Puoi scegliere solamente una delle opzioni date!");
                } else {
                    Output.sysOut("Ops, qualcosa è andato storto.");
                    break;
                }

            }

        }

        in.inputClose();

    }
}
