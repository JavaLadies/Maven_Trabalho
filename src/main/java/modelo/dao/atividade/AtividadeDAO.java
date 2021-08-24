package modelo.dao.atividade;

import java.util.List;

import modelo.entidade.estudantil.Aluno;
import modelo.entidades.jogo.Atividade;

public interface AtividadeDAO {
	
	void inserirAtividade (Atividade atividade);
	
	void deletarAtividade (Atividade atividade);
	
	void atualizarAtividade (Atividade atividade);
	
	List<Atividade> recuperarAtividades();

	List<Atividade> recuperarAtividadesAluno(Aluno aluno);
}