package org.classes.idk;

import java.util.ArrayList;

public class ProgrammaConcerti {
    protected ArrayList<Concerto> Concerti = new ArrayList<>();

    public void setEvent(Concerto i) {
        this.Concerti.add(i);
    }

    public ArrayList<Concerto> getEventsArray() {
        return this.Concerti;
    }

    public void getEvents(int giorno, int mese, int anno) {
        ArrayList<Concerto> returnedConcert = new ArrayList<>();
        if (giorno < 0 || giorno > 31) {
            throw new IllegalArgumentException("Il giorno dev'essere compreso tra 0 e 31");
        }
        if (mese < 0 || giorno > 12) {
            throw new IllegalArgumentException("Il mese dev'essere compreso tra 0 e 12");
        }
        if (anno < 0) {
            throw new IllegalArgumentException("L'anno non può essere inferiore a 0");
        }

        int tempGiorno = giorno;
        int tempMese = mese;
        int tempAnno = anno;

        for (int i = 0; i < Concerti.size(); i++) {
            Concerto currentEvent = Concerti.get(i);
            if (currentEvent.anno == tempAnno && currentEvent.mese == tempMese && currentEvent.giorno == tempGiorno) {
                returnedConcert.add(currentEvent);
            }

        }
        if (returnedConcert.size() == 0) {
            Output.sysOut("Non ci sono eventi da visualizzare.");
        } else {
            for (int i = 0; i < returnedConcert.size(); i++) {
                Evento currentEvent = returnedConcert.get(i);
                Output.sysOut(currentEvent);
            }
        }
    }
}
