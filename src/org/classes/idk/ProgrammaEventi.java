package org.classes.idk;

import java.util.ArrayList;

public class ProgrammaEventi {
    protected ArrayList<Evento> Eventi = new ArrayList<>();

    public void setEvent(Evento i) {
        this.Eventi.add(i);
    }

    public ArrayList<Evento> getEventsArray() {
        return this.Eventi;
    }

    public void getEvents(int giorno, int mese, int anno) {
        ArrayList<Evento> returnedEvent = new ArrayList<>();
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

        for (int i = 0; i < Eventi.size(); i++) {
            Evento currentEvent = Eventi.get(i);
            if (currentEvent.anno == tempAnno && currentEvent.mese == tempMese && currentEvent.giorno == tempGiorno) {
                returnedEvent.add(currentEvent);
            }

        }
        if (returnedEvent.size() == 0) {
            Output.sysOut("Non ci sono eventi da visualizzare.");
        } else {
            for (int i = 0; i < returnedEvent.size(); i++) {
                Evento currentEvent = returnedEvent.get(i);
                Output.sysOut(currentEvent);
            }
        }
    }
}
