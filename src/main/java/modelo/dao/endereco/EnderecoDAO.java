package modelo.dao.endereco;

import java.util.List;

import modelo.entidade.estudantil.Endereco;
import modelo.entidade.estudantil.Escola;

public interface EnderecoDAO {
	
	void inserirEndereco(Endereco endereco);

	void deletarEndereco(Endereco endereco);

	void atualizarEndereco(Endereco endereco);
	
	Endereco recuperarEndereco(Endereco endereco);

	List<Endereco> recuperarEnderecos();
	
	Endereco recuperarEnderecoEscola(Escola escola);
}