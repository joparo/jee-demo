package org.joparo;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ApplicationScopedCDIService {
    private int id = 0;

    public int getId() {
        return id++;
    }
}
