package org.classes.idk;

import java.util.ArrayList;

public interface generics<T> {

    void setEvent(T event);

    ArrayList<T> getItemsArray();

    int getElementsNumber();

    void cleanReturnedArray();

    void cleanArray();

    void cleanArrayItem(int option);

    void formattedElements();
}
