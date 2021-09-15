package modelo.dao.escola;

import java.util.List;

import modelo.entidade.estudantil.Escola;

public interface EscolaDAO {

	void inserirEscola(Escola escola);

	void deletarEscola(Escola escola);

	void atualizarEscola(Escola escola);
	
	Escola recuperarEscola(Escola escola);

	List<Escola> recuperarEscolas();
}