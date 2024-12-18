package org.classes.idk;

public class Concerto extends Evento {
    protected int minuti;
    protected int ore;
    protected String orrario;
    protected Double prezzo = 0.0;

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
        String hourStamp = Funct.minuteHourNow();
        String temp1 = Funct.numberFormatted(ore) + "" + Funct.numberFormatted(minuti);
        if (Integer.parseInt(hourStamp) >= Integer.parseInt(temp1)) {
            throw new IllegalArgumentException("L'orario dell'evento è già passato.");
        }

        super(titolo, giorno, mese, anno, postiTotali);

        String temp = ore + ":" + minuti;
        this.minuti = minuti;
        this.ore = ore;
        this.orrario = temp;
        this.prezzo = prezzo;
    }

    public String getOrario() {
        return this.orrario;
    }

    public Double getPrezzo() {
        return this.prezzo;
    }

    public void setOrario(int minuti, int ore) {
        if (minuti < 0 || minuti > 59) {
            throw new IllegalArgumentException("I minuti devono essere compresi tra 0 e 59.");
        }
        if (ore < 0 || ore > 23) {
            throw new IllegalArgumentException("Le ore devono essere comprese tra 0 e 23.");
        }
        String temp = Funct.numberFormatted(ore) + ":" + Funct.numberFormatted(minuti);
        this.orrario = temp;
    }

    public void setPrezzo(Double prezzo) {
        if (prezzo < 0) {
            throw new IllegalArgumentException("Il prezzo non può essere inferiore a 0.");
        }
        this.prezzo = prezzo;
    }

    @Override
    public String toString() {
        return this.getDate() + " " + getOrario() + " " + this.getTitle() + " " + getPrezzo() + "euro.";
    }

}
