package org.joparo;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MyEntityService {
    @Inject
    MyEntityRepository repo;

    public void insert() {
        repo.create(MyEntity.build());
    }

    /**
     * RuntimeException - will be rolled back by Container Managed Transaction
     */
    public void insertManyWithRuntimeException() {
        repo.create(MyEntity.build());
        repo.create(MyEntity.build());
        repo.create(MyEntity.build());
        throw new RuntimeException("There was an error insert the entities.");
    }

    /**
     * @throws Exception will not be rolled back by Container Managed Transaction
     */
    public void insertManyWithException() throws Exception {
        repo.create(MyEntity.build());
        repo.create(MyEntity.build());
        repo.create(MyEntity.build());
        throw new Exception("There was an exception insert the entities.");
    }
}
