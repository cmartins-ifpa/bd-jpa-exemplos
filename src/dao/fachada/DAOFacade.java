package dao.fachada;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DAOFacade<T> {
	private Class<T> entityClass;
	private EntityManager em;

	public DAOFacade(Class<T> entityClass) {
		this.entityClass = entityClass;
		EntityManagerFactory factory = Persistence.
				createEntityManagerFactory("jpa-exemplos");
		EntityManager entityManager = factory.createEntityManager();
		this.em = entityManager;
	}

	public EntityManager getEntityManager() {
		return this.em;
	}

	public void insert(T entity) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		getEntityManager().persist(entity);
		transaction.commit();
	}

	public void update(T entity) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		getEntityManager().merge(entity);
		transaction.commit();
	}

	public void delete(T entity) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		getEntityManager().remove(getEntityManager().merge(entity));
		transaction.commit();
	}

	public T findById(Object id) {
		return getEntityManager().find(entityClass, id);
	}

	/**
	 * Recupera todos os objetos (linhas) da entidade
	 * @return List <Entidade>
	 */
	public List<T> findAll() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}

	/**
	 * Retorna uma lista de entidades com uma faixa de valores  
	 */
	public List<T> findRange(int[] range) {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		q.setMaxResults(range[1] - range[0]);
		q.setFirstResult(range[0]);
		return q.getResultList();
	}

	/**
	 * Recupera a quantidade de linhas da entity
	 * @return int (número de linhas)
	 */
	public int count() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		cq.select(getEntityManager().getCriteriaBuilder().count(rt));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		return ((Long) q.getSingleResult()).intValue();
	}

	/**
	 * lastId() recupera o último ID
	 * @return long (id) 
	 */
	public long lastId() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
		// pega o último ID
		cq.select(getEntityManager().getCriteriaBuilder().max(rt.get("id")));
		javax.persistence.Query q = getEntityManager().createQuery(cq);
		return ((Long) q.getSingleResult()).longValue();
	}

	public List<String> findByDataGroup() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}

}