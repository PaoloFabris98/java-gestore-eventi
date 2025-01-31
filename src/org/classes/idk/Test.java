package org.classes.idk;

import java.util.ArrayList;

public class Test {
    protected ArrayList<Concerto> elements = new ArrayList<Concerto>();
    protected ArrayList<Concerto> returnedEvent = new ArrayList<Concerto>();

    public void setEvent(Concerto i) {
        this.elements.add(i);
    }

    public ArrayList<Concerto> getItemsArray() {
        return this.elements;
    }

    public ArrayList<Concerto> getEvents(int giorno, int mese, int anno) {
        cleanReturnedArray();
        if (giorno < 1 || giorno > 31) {
            throw new IllegalArgumentException("Il giorno dev'essere compreso tra 1 e 31");
        }
        if (mese < 1 || giorno > 12) {
            throw new IllegalArgumentException("Il mese dev'essere compreso tra 1 e 12");
        }
        if (anno < 1) {
            throw new IllegalArgumentException("L'anno non può essere inferiore a 1");
        }

        int tempGiorno = giorno;
        int tempMese = mese;
        int tempAnno = anno;

        for (int i = 0; i < elements.size(); i++) {
            Concerto currentEvent = elements.get(i);
            if (currentEvent.anno == tempAnno && currentEvent.mese == tempMese && currentEvent.giorno == tempGiorno) {
                this.returnedEvent.add(currentEvent);
            }

        }
        if (returnedEvent.size() == 0) {
            Output.sysOut("Non ci sono elementi da visualizzare.");
            return this.returnedEvent;
        }

        return this.returnedEvent;

    }

    public int getElementsNumber() {
        return this.elements.size();
    }

    public void cleanReturnedArray() {
        returnedEvent.clear();
    }

    public void formattedElements() {
        for (int i = 0; i < this.elements.size(); i++) {
            Evento currentElement = this.elements.get(i);
            Output.sysOut(currentElement.getDate() + " - " + currentElement.getTitle());
        }
    }
}
