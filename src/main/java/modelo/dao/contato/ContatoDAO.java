package modelo.dao.contato;

import java.util.List;

import modelo.entidade.estudantil.Contato;

public interface ContatoDAO {

	void inserirContato(Contato contato);

	void deletarContato(Contato contato);

	void atualizarContato (Contato contato);
	
	Contato recuperarContato(Contato contato);

	List<Contato> recuperarContatos();


}