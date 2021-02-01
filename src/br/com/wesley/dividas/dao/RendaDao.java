package br.com.wesley.dividas.dao;

import br.com.wesley.dividas.model.Renda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RendaDao {

    private static final String PERSISTENCE_UNIT = "dividas";

    public void inserir(Renda r) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(r);
        manager.getTransaction().commit();
        manager.close();
        factory.close();

    }



}
