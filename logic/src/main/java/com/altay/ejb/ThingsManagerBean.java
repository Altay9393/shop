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

    public Thing createThing(String name, int price){
        Thing thing = new Thing();
        thing.setName(name);
        thing.setPrice(price);
        entityManager.persist(thing);

        return thing;
    }

    public List<Thing> getThings(){
       return null;
    }
}
