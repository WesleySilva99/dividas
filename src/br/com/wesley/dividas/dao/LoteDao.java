package br.com.wesley.dividas.dao;

import br.com.wesley.dividas.model.Usuario;
import br.com.wesley.dividas.model.carnaval.Lote;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LoteDao {

    private static final String PERSISTENCE_UNIT = "dividas";

    public void inserir(Lote l) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(l);
        manager.getTransaction().commit();
        manager.close();
        factory.close();

    }

    public List<Lote> getAllLote() {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        List<Lote> lista = manager.createQuery("FROM Lote l ORDER BY l.id").getResultList();
        manager.close();
        factory.close();

        return lista;

    }

    public Lote getLoteById(Integer id) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("FROM Lote l WHERE l.id = :paramId");
        query.setParameter("paramId", id);

        List<Lote> lista = query.getResultList();

        manager.close();
        factory.close();

        if (lista != null && lista.size() > 0) {
            return lista.get(0);
        } else {
            return null;
        }

    }

}
