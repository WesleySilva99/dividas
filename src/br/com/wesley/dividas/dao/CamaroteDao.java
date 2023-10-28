package br.com.wesley.dividas.dao;

import br.com.wesley.dividas.model.Usuario;
import br.com.wesley.dividas.model.carnaval.Camarote;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CamaroteDao {

    private static final String PERSISTENCE_UNIT = "dividas";

    public void inserir(Camarote c) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(c);
        manager.getTransaction().commit();
        manager.close();
        factory.close();

    }

    public void saveCamarote(Camarote c) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(c);
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

    public List<Camarote> getAllCamarotes() {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        List<Camarote> lista = manager.createQuery("FROM Camarote c ORDER BY c.valor").getResultList();
        manager.close();
        factory.close();

        return lista;

    }

    public Camarote getById(Integer id) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("FROM Camarote c WHERE c.id = :id");
        query.setParameter("id", id);

        List<Camarote> lista = query.getResultList();

        manager.close();
        factory.close();

        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }

    }

    public void delete(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        Camarote camarote = manager.find(Camarote.class, id);
        manager.getTransaction().begin();
        manager.remove(camarote);
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

}
