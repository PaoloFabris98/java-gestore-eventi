package org.classes.idk;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Evento> events = new ArrayList<>();
        Boolean a = true;
        Scanner input = new Scanner(System.in);

        do {
            if (a) {
                System.out.println("---------------------------------");
                System.out.println("Digita un numero:");
                System.out.println("1 - Inserisci nuovo evento/i");
                System.out.println("2 - Visualizza eventi");
                System.out.println("3 - Prenota");
                System.out.println("4 - Disdici");
                System.out.println("5 - Exit");
                System.out.println("---------------------------------");
                int temp1;
                try {
                    temp1 = input.nextInt();
                    if (temp1 < 0 || temp1 > 6) {
                        System.out.println("Devi scegliere tra una delle opzioni date.");
                    }
                    if (temp1 == 1) {
                        System.out.println("Quanti eventi vuoi inserire?");
                        input.nextLine();
                        int temp2 = input.nextInt();
                        System.out.println("");
                        for (int i = 0; i < temp2; i++) {
                            System.out.println("");
                            System.out.println("Evento numero: " + (i + 1));
                            System.out.println("---------------------------------");
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
                            System.out.println("Titolo dell'evento numero: " + (i + 1) + ".");
                            System.out.println("L'evento si terrà in data: " + events.get(i).getDate() + ".");
                            System.out.println(
                                    "I posti totali per l'evento sono: " + events.get(i).getPostiTotali() + ".");
                        }
                    } else if (temp1 == 2) {
                        System.out.println("\n");
                        for (int i = 0; i < events.size(); i++) {
                            System.out.println("Evento numero: " + (i + 1) + ".");
                            System.out.println("Titolo: " + events.get(i).getTitle() + ".");
                            System.out.println("L'evento si terrà in data: " + events.get(i).getDate() + ".");
                            System.out.println(
                                    "I posti totali per l'evento sono: " + events.get(i).getPostiTotali() + ".");
                            System.out.println(
                                    "I posti prenotati per l'evento sono: " + events.get(i).getPostiPrenotati() + ".");
                            System.out.println(
                                    "I posti disponibili per l'evento sono: " + events.get(i).getPostiDisponibili()
                                            + ".");
                            System.out.println("\n");
                        }
                    } else if (temp1 == 3) {
                        System.out.println("\n");
                        System.out.println("Per quale evento vuoi prenotarti?");
                        System.out.println("---------------------------------");
                        for (int i = 0; i < events.size(); i++) {
                            System.out.println((i + 1) + " - " + events.get(i).getTitle());
                        }
                        System.out.println("---------------------------------");
                        int c = input.nextInt();
                        input.nextInt();
                        System.out.println("Quanti posti vuoi prenotare?");
                        int d = input.nextInt();
                        events.get(c).prenota(d);
                        System.out.println("Hai prenotato: " + d + " posti.");
                        System.out.println("I posti prenotati ora sono: " + events.get(c).getPostiPrenotati());

                    } else if (temp1 == 4) {
                        System.out.println("\n");
                        System.out.println("Per quale evento vuoi disdire?");
                        System.out.println("---------------------------------");
                        for (int i = 0; i < events.size(); i++) {
                            System.out.println((i + 1) + " - " + events.get(i).getTitle());
                        }
                        System.out.println("---------------------------------");
                        int c = input.nextInt();
                        input.nextInt();
                        System.out.println("Quanti posti vuoi disdire?");
                        int d = input.nextInt();
                        events.get(c).disdici(d);
                    } else if (temp1 == 5) {
                        input.close();
                        Funct.eventCreatorPremission(temp1);
                    } else {
                        input.close();
                        break;
                    }
                } catch (Exception e) {
                    input.close();
                    throw new IllegalArgumentException(
                            "Nel campo per il nome dell'evento puoi inserire solo una stringa.\n In tutti gli altri campi, possono essere inseriti solo numeri interi, positivi.");
                }

            } else {
                break;
            }

        } while (a == true);
        input.close();
    }
}
