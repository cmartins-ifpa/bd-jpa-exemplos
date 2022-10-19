package exemplo1.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import exemplo1.entidades.Cliente;

public class TesteConexaoJPA {

	public static void main(String[] args) {
		EntityManager entityMgr = Persistence
        		.createEntityManagerFactory("jpa-exemplos")
        		.createEntityManager();
		System.out.println("Ok Conexao ----- JPA");
		
		Query query = entityMgr.createQuery("select c from Cliente c", Cliente.class);
		List<Cliente> clientes = query.getResultList();
		System.out.println("Qtde de clientes - "+ clientes.size());
		for (Cliente c1 : clientes) {
			System.out.println(c1.getNome() + " 		     ID=" + c1.getId());
		}
	}
} // fim classe
