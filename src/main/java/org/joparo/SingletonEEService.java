package org.joparo;

import javax.ejb.Singleton;

@Singleton
public class SingletonEEService {
    private int id = 0;

    public int getId() {
        return id++;
    }
}
