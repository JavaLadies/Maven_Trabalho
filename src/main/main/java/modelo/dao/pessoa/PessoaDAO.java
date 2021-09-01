package modelo.dao.pessoa;

import java.util.List;

import modelo.entidade.estudantil.Pessoa;

public interface PessoaDAO {

	void inserirPessoa(Pessoa pessoa);

	void deletarPessoa(Pessoa pessoa);

	void atualizarPessoa(Pessoa pessoa);

	List<Pessoa> recuperarPessoas();
}