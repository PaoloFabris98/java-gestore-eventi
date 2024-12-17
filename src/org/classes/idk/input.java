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
        return input.nextInt();
    }

    public void inputClose() {
        input.close();
    }

}
