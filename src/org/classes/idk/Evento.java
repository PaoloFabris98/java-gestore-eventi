package org.classes.idk;

public class Evento {
    protected String titolo;
    protected int giorno;
    protected int mese;
    protected int anno;
    protected String data;
    protected int postiTotali;
    protected int postiPrenotati;

    public Evento(String titolo, int giorno, int mese, int anno, int postiTotali) {
        if (titolo == null || titolo.isEmpty()) {
            throw new IllegalArgumentException("Il titolo non può essere vuoto.");
        }
        if (giorno <= 0 || giorno > 31 || mese <= 0 || mese > 12 || anno <= 0) {
            throw new IllegalArgumentException("Data non valida.");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }

        String timeStamp = Funct.timeNow();
        String temp = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);
        if (Integer.parseInt(timeStamp) > Integer.parseInt(temp)) {
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
        this.data = giorno + "/" + mese + "/" + anno;
        this.postiPrenotati = 0;

    }

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
        String timeStamp = Funct.timeNow();
        String temp = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);
        if (Integer.parseInt(timeStamp) > Integer.parseInt(temp)) {
            System.out.println("Ora: " + timeStamp);
            System.out.println("Data Evento: " + temp);
            throw new IllegalArgumentException("La data attuale è dopo la data dell'evento");
        }
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
        int temp = (this.postiPrenotati + time);
        String timeStamp = Funct.timeNow();
        String tempDate = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);
        if (temp > getPostiTotali()) {
            System.out.println("Non ci sono posti disponibili per una prenotazione");
        } else {
            System.out.println(this.getPostiPrenotati());
            if (Integer.parseInt(timeStamp) < Integer.parseInt(tempDate)) {
                for (int i = 0; i < time; i++) {
                    this.postiPrenotati = getPostiPrenotati() + 1;
                }
                System.out.println(this.getPostiPrenotati());
            } else {
                System.out.println("L'evento è già passato, non puoi prenotare.");
            }
        }
    }

    public void disdici(int time) {
        String timeStamp = Funct.timeNow();
        String tempDate = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);

        if (Integer.parseInt(timeStamp) < Integer.parseInt(tempDate)) {
            for (int i = 0; i < time; i++) {
                if ((getPostiPrenotati() - time) < 0) {
                    System.out.println("Non puoi disdire cosi tante prenotazioni");
                    System.out.println("I posti attualmente prenotati sono: " + getPostiPrenotati());
                } else {
                    this.postiPrenotati = getPostiPrenotati() - 1;
                    System.out.println("I posti attualmente prenotati sono: " + getPostiPrenotati());
                }
            }
        } else if (Integer.parseInt(timeStamp) > Integer.parseInt(tempDate)) {
            System.out.println("L'evento è passato non è possibile disdire.");
        }

    }

    @Override
    public String toString() {
        return this.getDate() + " " + this.getTitle();
    }
}
