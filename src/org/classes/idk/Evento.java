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
            System.out.println("Ora: " + timeStamp);
            System.out.println("Data Evento: " + temp);
            throw new IllegalArgumentException("La data attuale è dopo la data dell'evento");
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
        System.out.println("La data dev'essere formattata in giorno/mese/anno.");
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

    public void setPostiPrenotati(int i) {
        if (i > this.postiTotali) {
            System.out.println("Non si possono prenotare più posti di quelli disponibili.");
        } else {
            this.postiPrenotati = i;
        }
    }

    public void prenota() {
        int temp = this.postiPrenotati++;
        String timeStamp = Funct.timeNow();
        String tempDate = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);
        if (temp > this.postiPrenotati) {
            System.out.println("Non ci sono posti disponibili per una prenotazione");
        } else {
            if (Integer.parseInt(timeStamp) > Integer.parseInt(tempDate)) {
                this.postiPrenotati += 1;
            }
        }
    }

    public void disdici() {
        String timeStamp = Funct.timeNow();
        String tempDate = anno + Funct.numberFormatted(mese) + Funct.numberFormatted(giorno);

        if (Integer.parseInt(timeStamp) < Integer.parseInt(tempDate)) {
            this.postiPrenotati -= 1;
        } else {
            System.out.println("L'evento è passato non è possibile disdire.");
        }

    }
}
