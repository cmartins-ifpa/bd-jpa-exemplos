package dao.fachada;

import java.util.List;

import entidades.Pessoa;

public class TestaPessoaDAO {
	public static void main(String[] args) {
		Pessoa p = new Pessoa();
		p.setNome("ANA ANTONIA");
		DAOFacade<Pessoa> dao = new DAOFacade<Pessoa>(Pessoa.class);

		// recupera a última linha para incrementar o ID
		long cont = dao.lastId();
		p.setId(cont + 1);
		dao.insert(p);
		long id = p.getId();
		System.out.println("Incluiu o " + p.getNome() + " ID=" + id);

		List<Pessoa> all = dao.findAll();
		for (Pessoa pessoa : all) {
			System.out.println(pessoa.getNome());
		}
		// alterando o ID registrado no inicio
		p = (Pessoa) dao.findById(id);
		p.setNome("RAFAEL SANTOS");
		dao.update(p);
		// deleta um registro com ID=7 (considando que existe o ID)
		p = (Pessoa) dao.findById(7L);
		System.out.println("Apagando o ID = " + p.getId() + " - " + p.getNome());
		dao.delete(p);

		// lista novas linhas
		System.out.println("*******  LISTA APOS UPDATE e DELETE *******");
		all = dao.findAll();
		for (Pessoa pessoa : all) {
			System.out.println(pessoa.getNome());
		}

		dao.getEntityManager().close();
	}
}
