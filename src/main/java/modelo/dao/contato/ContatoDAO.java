package modelo.dao.contato;

import java.util.List;

import modelo.entidade.estudantil.Contato;
import modelo.entidade.estudantil.Pessoa;

public interface ContatoDAO {

	void inserirContato(Contato contato);

	void deletarContato(Contato contato);

	void atualizarContato (Contato contato);

	List<Contato> recuperarContatos();

	Contato recuperarContatoPessoa(Pessoa pessoa);

}