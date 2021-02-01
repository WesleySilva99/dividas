package br.com.wesley.dividas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.wesley.dividas.model.Divida;
import br.com.wesley.dividas.model.Renda;
import br.com.wesley.dividas.model.Usuario;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class UsuarioDao {

    private static final String PERSISTENCE_UNIT = "dividas";

    public void inserir(Usuario u) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(u);
        manager.getTransaction().commit();
        manager.close();
        factory.close();

    }

    public List<Usuario> getAllUser() {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        List<Usuario> lista = manager.createQuery("FROM Usuario ORDER BY login").getResultList();
        manager.close();
        factory.close();

        return lista;

    }

    public Usuario logar(Usuario u) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("FROM Usuario WHERE login = :paramLogin and senha = :paramSenha");
        query.setParameter("paramLogin", u.getLogin());
        query.setParameter("paramSenha", u.getSenha());

        List<Usuario> lista = query.getResultList();

        manager.close();
        factory.close();

        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }

    }

    public boolean verificaLoginExistente(String login) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("FROM Usuario WHERE login = :paramLogin");
        query.setParameter("paramLogin", login);

        List<Usuario> lista = query.getResultList();

        manager.close();
        factory.close();

        if (lista.size() > 0) {
            return false;
        } else {
            return true;
        }

    }

    public boolean verificaEmailExistente(String email) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("FROM Usuario WHERE email = :paramEmail");
        query.setParameter("paramEmail", email);

        List<Usuario> lista = query.getResultList();

        manager.close();
        factory.close();

        if (lista.size() > 0) {
            return false;
        } else {
            return true;
        }

    }

    public List<Renda> listaRedas(Usuario u) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("select u.rendas FROM Usuario u WHERE login = :paramLogin");
        query.setParameter("paramLogin", u.getLogin());

        List<Renda> lista = query.getResultList();

        manager.close();
        factory.close();

        return lista;

    }

    public List<Divida> listaDividas(Usuario u) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("select u.dividas FROM Usuario u WHERE login = :paramLogin");
        query.setParameter("paramLogin", u.getLogin());

        List<Divida> lista = query.getResultList();

        if (lista == null) {
            lista = new ArrayList<>();
        }

        manager.close();
        factory.close();

        return lista;

    }

    public void cadastrarDivida(Usuario u) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.merge(u);
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }

    public List<Divida> listaDividasDoMes(Usuario u) {

        Date primeiroDia = new Date(System.currentTimeMillis());
        primeiroDia.setDate(01);

        Date ultimoDia = new Date(System.currentTimeMillis());
        ultimoDia.setDate(ultimoDia.getMonth() == 02 ? 28 : 30);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("SELECT u.dividas FROM Usuario u, Divida d " +
                "WHERE u.login = :paramLogin and d.data between :primeiroDia and :ultimoDia");
        query.setParameter("paramLogin", u.getLogin());
        query.setParameter("primeiroDia", primeiroDia);
        query.setParameter("ultimoDia", ultimoDia);

        List<Divida> lista = query.getResultList();

        manager.close();
        factory.close();

        return lista;

    }

}