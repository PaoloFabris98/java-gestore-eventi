package org.classes.idk;

import java.util.ArrayList;

public class ProgrammaEventi implements generics<Evento> {
    protected ArrayList<Evento> elements = new ArrayList<Evento>();
    protected ArrayList<Evento> returnedEvent = new ArrayList<Evento>();

    public void setEvent(Evento i) {
        this.elements.add(i);
    }

    public ArrayList<Evento> getItemsArray() {
        return this.elements;
    }

    public ArrayList<Evento> getEvent(int giorno, int mese, int anno) {
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
            Evento currentEvent = elements.get(i);
            if (currentEvent.anno == tempAnno && currentEvent.mese == tempMese && currentEvent.giorno == tempGiorno) {
                this.returnedEvent.add(currentEvent);
            }

        }
        if (returnedEvent.size() == 0) {
            Output.sysOut("Non ci sono eventi da visualizzare.");
            return this.returnedEvent;
        }

        return this.returnedEvent;

    }

    public int getElementsNumber() {
        return this.elements.size();
    }

    public void cleanReturnedArray() {
        this.returnedEvent.clear();
    }

    public void cleanArray() {
        this.elements.clear();
    }

    public void cleanArrayItem(int option) {
        if (option >= 0 && option < this.elements.size()) {
            this.elements.remove(option);
            Output.sysOut("Evento cancellato.");
        } else {
            System.out.println("L'indice: " + option + " non è valido o non esiste.");
        }

    }

    public void formattedElements() {
        for (int i = 0; i < this.elements.size(); i++) {
            Evento currentElement = this.elements.get(i);
            Output.sysOut(currentElement.getDate() + " - " + currentElement.getTitle());
        }
    }

    public void specificFormattedElements(int giorno, int mese, int anno) {
        for (int i = 0; i < this.elements.size(); i++) {
            Evento currentElement = this.elements.get(i);
            if (currentElement.giorno == Integer.parseInt(Funct.numberFormatted(giorno))
                    && currentElement.mese == Integer.parseInt(Funct.numberFormatted(mese))
                    && currentElement.anno == anno) {
                Output.sysOut(currentElement.getDate() + " - " + currentElement.getTitle());
            }
        }
    }
}
