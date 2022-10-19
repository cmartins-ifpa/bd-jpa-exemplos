package dao.exemplo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidades.Pessoa;

public class PessoaDAO implements DAO<Pessoa> {
	EntityManager em = getEntityManager();

	@Override
	public Pessoa findById(long id) {
		return em.find(Pessoa.class, id);
	}

	@Override
	public List<Pessoa> findAll() {
		javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(Pessoa.class));
		return getEntityManager().createQuery(cq).getResultList();
	}

	@Override
	public void insert(Pessoa t) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(t);
		transaction.commit();
	}

	@Override
	public void update(Pessoa t) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(t);
		transaction.commit();
	}

	@Override
	public void delete(Pessoa t) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Pessoa pessoa = em.find(Pessoa.class, t.getId());
		em.remove(pessoa);
		transaction.commit();
	}

}
