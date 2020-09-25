package org.joparo;

public class DependentScopedCDIService {
    private int id = 0;

    public int getId() {
        return id++;
    }
}
