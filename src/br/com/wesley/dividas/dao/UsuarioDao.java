package br.com.wesley.dividas.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.wesley.dividas.model.Renda;
import br.com.wesley.dividas.model.Usuario;

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

	public List<Usuario> getAllUser(){

		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		List<Usuario> lista = manager.createQuery("FROM Usuario ORDER BY login").getResultList();
		manager.close();
		factory.close();

		return lista;

	}

    public Usuario logar(Usuario u){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("FROM Usuario WHERE login = :paramLogin and senha = :paramSenha");
        query.setParameter("paramLogin", u.getLogin());
        query.setParameter("paramSenha", u.getSenha());

        List<Usuario> lista = query.getResultList();

        manager.close();
        factory.close();

        if (lista.isEmpty()){
            return null;
        }else {
            return lista.get(0);
        }

    }

	public boolean verificaLoginExistente(String login){

		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("FROM Usuario WHERE login = :paramLogin");
		query.setParameter("paramLogin", login);

		List<Usuario> lista = query.getResultList();

		manager.close();
		factory.close();

		if (lista.size() > 0){
			return false;
		}else {
			return true;
		}

	}
	public boolean verificaEmailExistente(String email){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("FROM Usuario WHERE email = :paramEmail");
        query.setParameter("paramEmail", email);

        List<Usuario> lista = query.getResultList();

        manager.close();
        factory.close();

        if (lista.size() > 0){
            return false;
        }else {
            return true;
        }

    }

    public List<Renda> listaRedas(Usuario u){

        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        EntityManager manager = factory.createEntityManager();
        Query query = manager.createQuery("select u.rendas FROM Usuario u WHERE login = :paramLogin");
        query.setParameter("paramLogin", u.getLogin());

        List<Renda> lista = query.getResultList();

        manager.close();
        factory.close();

        return lista;

    }

}