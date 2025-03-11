package org.example;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO extends BusinessObject {

    private static int nextId = 1;

    public CEO(int id, String name) {
        id = nextId++;
        System.out.println("Ny CEO skapad med id: " + getId());

    }

    public CEO() {
        id=nextId++;
        System.out.println("Ny CEO skapad med id: " + getId());

    }

    @Override
    public String toString() {
        return "CEO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
