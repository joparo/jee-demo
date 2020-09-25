package org.joparo;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Entity(name="MyEntity")
public class MyEntity {

    static List<String> names = Arrays.asList("Adam", "Bertil", "Ceasar", "David", "Erik", "Filip");

    @Id
    String id;

    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static MyEntity build() {
        MyEntity e = new MyEntity();
        e.id = UUID.randomUUID().toString();
        Random rand = new Random();
        e.name = names.get(rand.nextInt(names.size()));
        return e;
    }
}
