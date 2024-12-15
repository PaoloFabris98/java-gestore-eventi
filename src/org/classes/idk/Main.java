package org.classes.idk;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Evento> events = new ArrayList<>();
        Boolean a = false;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Vuoi creare un nuovo evento? Y/N");
            String temp = input.nextLine();

            a = Funct.eventCreatorPremission(temp);
            System.out.println(a);
            if (a) {
                System.out.println("Quanti eventi vuoi creare?");
                int temp1 = input.nextInt();
                try {
                    for (int i = 0; i < temp1; i++) {
                        System.out.println("Inserisci il nome dell'evento:");
                        String nome = input.nextLine();
                        if (nome.isEmpty()) {
                            nome = input.nextLine();
                        }
                        System.out.println("Inserisci il giorno dell'evento:");
                        int giorno = input.nextInt();
                        System.out.println("Inserisci il mese dell'evento:");
                        int mese = input.nextInt();
                        System.out.println("Inserisci l'anno dell'evento:");
                        int anno = input.nextInt();
                        System.out.println("Inserisci i posti totali dell'evento dell'evento:");
                        int posti = input.nextInt();
                        events.add(new Evento(nome, giorno, mese, anno, posti));
                    }
                    System.out.println("\n");
                    for (int i = 0; i < temp1; i++) {
                        System.out.println("Titolo dell'evento numero: " + (i + 1) + ".");
                        System.out.println("L'evento si terrà in data: " + events.get(i).getDate() + ".");
                        System.out.println("I posti totali per l'evento sono: " + events.get(i).getPostiTotali() + ".");
                        System.out.println(
                                "I posti prenotati per l'evento sono: " + events.get(i).getPostiPrenotati() + ".");
                        System.out.println(
                                "I posti disponibili per l'evento sono: " + events.get(i).getPostiDisponibili() + ".");
                        System.out.println("\n");
                    }
                    break;
                } catch (Exception e) {
                    input.close();
                    throw new IllegalArgumentException("Puoi inserire solo numeri");
                }

            } else {
                break;
            }

        } while (a == true);
        input.close();
    }
}
