package org.classes.idk;

public class Evento {
    protected String titolo;
    protected int giorno;
    protected int mese;
    protected int anno;
    protected String data;
    protected int postiTotali;
    protected int postiPrenotati;

    public Evento(String titolo, int giorno, int mese, int anno, int postiTotali) throws IllegalArgumentException {
        if (titolo == null || titolo.isEmpty()) {
            throw new IllegalArgumentException("Il titolo non può essere vuoto.");
        }
        if (giorno <= 0 || giorno > 31 || mese <= 0 || mese > 12 || anno <= 0) {
            throw new IllegalArgumentException("Data non valida.");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }

        String temp = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);
        if (Funct.dayPassed(temp)) {
            throw new IllegalArgumentException("La data attuale è dopo la data dell'evento");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Non possono esserci posti inferiori o uguali a zero.");
        }
        this.titolo = titolo;
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
        this.postiTotali = postiTotali;
        this.data = Funct.numberFormatted(giorno) + "/" + Funct.numberFormatted(mese) + "/" + anno;
        this.postiPrenotati = 0;

    }

    Output out = new Output();

    public String getTitle() {
        return this.titolo;
    }

    public void setTitle(String i) {
        this.titolo = i;
    }

    public String getDate() {
        return this.data;
    }

    public void setDate(int giorno, int mese, int anno) {

        String temp = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);
        if (Funct.dayPassed(temp)) {
            Output.sysOut("Data Evento: " + temp);
            throw new IllegalArgumentException("La data attuale è dopo la data dell'evento");
        }
        if (giorno <= 0 || giorno > 31 || mese <= 0 || mese > 12 || anno <= 0) {
            throw new IllegalArgumentException("Data non valida.");
        }
        this.giorno = giorno;
        this.mese = mese;
        this.anno = anno;
        this.data = giorno + "/" + mese + "/" + anno;

    }

    public int getPostiTotali() {
        return this.postiTotali;
    }

    public int getPostiPrenotati() {
        return this.postiPrenotati;
    }

    public int getPostiDisponibili() {
        return (getPostiTotali() - getPostiPrenotati());
    }
    /*
     * public void setPostiPrenotati(int i) {
     * if (i > this.postiTotali) {
     * System.out.
     * println("Non si possono prenotare più posti di quelli disponibili.");
     * } else {
     * this.postiPrenotati += i;
     * }
     * }
     */

    public void prenota(int time) {
        try {

            int temp = (this.postiPrenotati + time);
            String timeStamp = Funct.timeNow();
            String tempDate = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);
            if (temp > getPostiTotali()) {
                Output.sysOut("Non puoi prenotare cosi tanti posti, i posti disponibili sono:"
                        + getPostiDisponibili());
            } else {
                if (Integer.parseInt(timeStamp) < Integer.parseInt(tempDate)) {
                    for (int i = 0; i < time; i++) {
                        this.postiPrenotati = getPostiPrenotati() + 1;
                    }
                    Output.sysOut("Hai prenotato: " + time + " posti.");
                    Output.sysOut("I posti attualmente prenotati sono: " + getPostiPrenotati());
                } else {
                    Output.sysOut("L'evento è già passato, non puoi prenotare.");
                }
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Per prenotare dei posti, puoi inserire solamente numeri interi.");
        }
    }

    public void disdici(int time) throws IllegalArgumentException {
        try {

            String timeStamp = Funct.timeNow();
            String tempDate = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);

            if (Integer.parseInt(timeStamp) < Integer.parseInt(tempDate)) {
                if ((getPostiPrenotati() - time) < 0) {
                    Output.sysOut("Non puoi disdire cosi tante prenotazioni");
                    Output.sysOut("I posti attualmente prenotati sono: " + getPostiPrenotati());
                } else {
                    for (int i = 0; i < time; i++) {
                        this.postiPrenotati = getPostiPrenotati() - 1;
                    }
                    Output.sysOut("Hai disdetto: " + time + " posti.");
                    Output.sysOut("I posti attualmente prenotati sono: " + getPostiPrenotati());
                }
            } else if (Integer.parseInt(timeStamp) > Integer.parseInt(tempDate)) {
                Output.sysOut("L'evento è passato non è possibile disdire.");
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Per disdire dei posti, puoi inserire solamente numeri interi.");
        }

    }

    @Override
    public String toString() {
        return this.getDate() + " " + this.getTitle();
    }
}
