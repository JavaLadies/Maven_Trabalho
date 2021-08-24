package modelo.dao.visitante;

import java.util.List;

import modelo.entidade.estudantil.Contato;
import modelo.entidade.estudantil.Visitante;

public interface VisitanteDAO {
	
	void inserirVisitante (Visitante visitante);
	
	void deletarVisitante (Visitante visitante);
	
	void atualizarVisitante (Visitante visitante);
	
	List<Visitante> recuperarVisiantes();
	
	List<Visitante> recuperarVisitanteContato(Contato contato);
}