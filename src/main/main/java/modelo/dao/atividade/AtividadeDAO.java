package modelo.dao.atividade;

import java.util.List;

import modelo.entidades.jogo.Atividade;
import modelo.entidades.jogo.Fase;

public interface AtividadeDAO {
	
	void inserirAtividade (Atividade atividade);
	
	void deletarAtividade (Atividade atividade);
	
	void atualizarAtividade (Atividade atividade);
	
	List<Atividade> recuperarAtividades();

	List<Atividade> recuperarAtividadesFase(Fase fase);
}