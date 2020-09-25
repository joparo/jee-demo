package org.joparo;

import javax.inject.Inject;

public class MyEntityCDIService {
    @Inject
    MyEntityRepository repo;

    public void insertManyWithError() {
        repo.create(MyEntity.build());
        repo.create(MyEntity.build());
        repo.create(MyEntity.build());
        throw new RuntimeException("There was an error insert the entities.");
    }
}
