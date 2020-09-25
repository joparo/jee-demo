package org.joparo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class MyEntityRepository {
    @PersistenceContext
    EntityManager em;

    public List<MyEntity> findAll() {
        Query q = em.createQuery("SELECT t FROM MyEntity t");
        return q.getResultList();
    }

    public void create(MyEntity incoming) {
        em.persist(incoming);
    }

    public void update(String id, MyEntity incoming) {
        MyEntity entity = em.find(MyEntity.class, id);
        entity.setName(incoming.getName());
        em.merge(entity);
    }

    public void remove(String id) {
        MyEntity entity = em.find(MyEntity.class, id);
        em.remove(entity);
    }
}
