package org.joparo;

import javax.ejb.Stateless;

@Stateless
public class StatelessEEService {
    private int id = 0;

    public int getId() {
        return id++;
    }
}
