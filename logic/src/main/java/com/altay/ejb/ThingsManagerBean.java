package com.altay.ejb;

import com.altay.domain.Thing;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class ThingsManagerBean {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Thing createThing(String name, int quantity){
        Thing thing = new Thing();
        thing.setName(name);
        thing.setQuantity(quantity);
        entityManager.persist(thing);

        return thing;
    }

    public List<Thing> getThings(){
       TypedQuery query = entityManager.createQuery("select c from Thing ", Thing.class);
       return query.getResultList();
    }
}
