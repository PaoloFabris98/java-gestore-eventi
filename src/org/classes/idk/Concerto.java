package org.classes.idk;

public class Concerto extends Evento {
    protected int minuti;
    protected int ore;
    protected String orario;
    protected Double prezzo = 0.0;
    protected String prezzoFormattato;

    public Concerto(String titolo, int giorno, int mese, int anno, int postiTotali, int minuti, int ore,
            Double prezzo) {
        if (titolo == null || titolo.isEmpty()) {
            throw new IllegalArgumentException("Il titolo non può essere vuoto.");
        }
        if (giorno <= 0 || giorno > 31 || mese <= 0 || mese > 12 || anno <= 0) {
            throw new IllegalArgumentException("Data non valida.");
        }
        if (postiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }
        if (prezzo < 0.0) {
            throw new IllegalArgumentException("Il prezzo non può essere inferiore a 0.");
        }
        if (minuti < 0 || minuti > 59) {
            throw new IllegalArgumentException("I minuti devono essere compresi tra 0 e 59.");
        }
        if (ore < 0 || ore > 23) {
            throw new IllegalArgumentException("Le ore devono essere comprese tra 0 e 23.");
        }

        super(titolo, giorno, mese, anno, postiTotali);

        String eventTime = Funct.numberFormatted(ore) + Funct.numberFormatted(minuti);

        long tempHourNow = Long.parseLong(Funct.timeNow() + Funct.minuteHourNow());
        long tempEventTime = Long
                .parseLong(this.anno + Funct.numberFormatted(this.mese) + Funct.numberFormatted(this.giorno)
                        + eventTime);

        if (tempHourNow > tempEventTime) {
            throw new IllegalArgumentException("L'orario dell'evento è già passato.");
        }

        String temp = ore + ":" + minuti;
        this.minuti = minuti;
        this.ore = ore;
        this.orario = temp;
        this.prezzo = prezzo;
        this.prezzoFormattato = prezzo + " Euro";
    }

    public String getOrario() {
        return this.orario;
    }

    public Double getPrezzo() {
        return this.prezzo;
    }

    public String getPrezzoFormattato() {
        return this.prezzoFormattato;
    }

    public void setOrario(int minuti, int ore) {
        if (minuti < 0 || minuti > 59) {
            throw new IllegalArgumentException("I minuti devono essere compresi tra 0 e 59.");
        }
        if (ore < 0 || ore > 23) {
            throw new IllegalArgumentException("Le ore devono essere comprese tra 0 e 23.");
        }
        String eventTime = Funct.numberFormatted(ore) + Funct.numberFormatted(minuti);
        long tempHourNow = Long.parseLong(Funct.timeNow() + Funct.minuteHourNow());
        long tempEventTime = Long
                .parseLong(this.anno + Funct.numberFormatted(this.mese) + Funct.numberFormatted(this.giorno)
                        + eventTime);
        if (tempHourNow > tempEventTime) {
            throw new IllegalArgumentException("L'orario dell'evento è già passato.");
        }
        String temp = Funct.numberFormatted(ore) + ":" + Funct.numberFormatted(minuti);
        this.orario = temp;
    }

    public void setPrezzo(Double prezzo) {
        if (prezzo < 0) {
            throw new IllegalArgumentException("Il prezzo non può essere inferiore a 0.");
        }
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return this.getDate() + " " + getOrario() + " " + this.getTitle() + " " + getPrezzo() + " euro.";
    }

}
