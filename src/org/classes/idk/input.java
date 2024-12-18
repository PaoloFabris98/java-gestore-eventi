package org.classes.idk;

import java.util.Scanner;

public class input {
    protected Scanner input = new Scanner(System.in);

    public void newLine() {
        input.nextLine();
    }

    public String newString() {
        return input.nextLine();
    }

    public int nextInt() {
        int i = 0;
        while (i < 3) {
            try {
                return input.nextInt();
            } catch (Exception e) {
                i++;
                System.out.println("Errore: inserisci un numero intero valido.");
                input.nextLine();
            }
        }
        throw new IllegalArgumentException("Hai Superato il numero di tentativi massimi. (3)");
    }

    public Double nextDouble() {
        int i = 0;
        while (i < 3) {
            try {
                return input.nextDouble();
            } catch (Exception e) {
                i++;
                System.out.println("Errore: inserisci un numero valido (usa la virgola come separatore).");
                input.nextLine();
            }
        }
        throw new IllegalArgumentException("Hai Superato il numero di tentativi massimi. (3)");
    }

    public void inputClose() {
        input.close();
    }

}
