package org.classes.idk;

public class Main {
    public static void main(String[] args) {
        Evento test = new Evento("test", 11, 12, 2025, 500);
        System.out.println("Nome evento: " + test.getTitle());
        System.out.println("Data Evento: " + test.getDate());
        System.out.println("Posti Totali: " + test.getPostiTotali());

        test.setDate(3, 5, 2025);

        System.out.println("Nome evento: " + test.getTitle());
        System.out.println("Data Evento: " + test.getDate());
        System.out.println("Posti Totali: " + test.getPostiTotali());
    }
}
