package org.joparo;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExplodingBean {
    @PostConstruct
    public void boom() {
        throw new RuntimeException("BOOOOM!");
    }
}
