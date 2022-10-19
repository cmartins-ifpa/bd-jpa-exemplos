package dao.exemplo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entidades.Pessoa;

public interface DAO<T> {
	default public EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("jpa-exemplos");
		EntityManager entityManager = factory.createEntityManager();
		return entityManager;
	}

	T findById(long id);
	List<T> findAll();
	void insert(T t);
	void update(T t);
	void delete(T t);
}
