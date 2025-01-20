package org.classes.idk;

public class Main {
    public static void main(String[] args) {
        ProgrammaEventi eventi = new ProgrammaEventi();
        ProgrammaConcerti concerti = new ProgrammaConcerti();
        Boolean a = true;
        input in = new input(3);

        eventi.getItemsArray()
                .add(new Evento("test1", Funct.randomDay(), Funct.randomMonth(), 2027, Funct.postiRandom()));
        eventi.getItemsArray()
                .add(new Evento("test2", Funct.randomDay(), Funct.randomMonth(), 2026, Funct.postiRandom()));
        eventi.getItemsArray()
                .add(new Evento("test3", Funct.randomDay(), Funct.randomMonth(), 2029, Funct.postiRandom()));

        concerti.getItemsArray()
                .add(new Concerto("testConcerto1", Funct.randomDay(), Funct.randomMonth(), 2027, Funct.postiRandom(),
                        Funct.minutiRandom(), Funct.oreRandom(), Funct.costoRandom()));
        concerti.getItemsArray()
                .add(new Concerto("testConcerto2", Funct.randomDay(), Funct.randomMonth(), 2026, Funct.postiRandom(),
                        Funct.minutiRandom(), Funct.oreRandom(), Funct.costoRandom()));
        concerti.getItemsArray()
                .add(new Concerto("testConcerto3", Funct.randomDay(), Funct.randomMonth(), 2029, Funct.postiRandom(),
                        Funct.minutiRandom(), Funct.oreRandom(), Funct.costoRandom()));

        while (a) {
            if (a) {
                Output.sysOut("---------------------------------");
                Output.sysOut("Digita un numero:");
                Output.sysOut("1 - Inserisci evento/i");
                Output.sysOut("2 - inserisci concerto/i");
                Output.sysOut("3 - Visualizza eventi e concerti");
                Output.sysOut("4 - Prenota");
                Output.sysOut("5 - Disdici");
                Output.sysOut("6 - Numero di concerti/eventi");
                Output.sysOut("7 - Cancella eventi/concerti");
                Output.sysOut("8 - Exit");
                Output.sysOut("---------------------------------");
                int temp1;
                temp1 = in.nextInt();
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
                } else if (temp1 == 9) {
                    a = Funct.eventCreatorPremission(temp1);
                    Output.sysOut("Buona giornata!");
                } else if (temp1 <= 0 || temp1 > 8) {
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
