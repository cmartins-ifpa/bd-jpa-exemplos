package dao.exemplo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entidades.Pessoa;

public class TestesPessoaDAO {

	public static void main(String[] args) {
		DAO dao = new PessoaDAO();
		EntityManager em = dao.getEntityManager();

		incluiVariasPessoas(em);
		// altera(em);
		em.close();
	}

	private static void incluiVariasPessoas(EntityManager em) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Pessoa p = new Pessoa(91, "JOAO MENDES", "BELÉM", "PA");
		em.persist(p);
		p = new Pessoa(92, "MARIA CARVALHO", "BELÉM", "PA");
		em.persist(p);
		p = new Pessoa(93, "PEDRO SILVA", "CAMETÁ", "PA");
		em.persist(p);
		p = new Pessoa(94, "LUIZ CARLOS", "SANTARÉM", "PA");
		em.persist(p);
		p = new Pessoa(95, "JOSÉ SANTOS", "SANTARÉM", "PA");
		em.persist(p);
		p = new Pessoa(96, "MÁRIO PONTES", "BELÉM", "PA");

		em.persist(p);
		transaction.commit();
	}

}
