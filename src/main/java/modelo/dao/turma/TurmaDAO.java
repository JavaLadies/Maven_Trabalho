package modelo.dao.turma;

import java.util.List;

import modelo.entidade.estudantil.Escola;
import modelo.entidade.estudantil.Turma;

public interface TurmaDAO {
	
	void inserirTurma (Turma turma);
	
	void deletarTurma (Turma turma);
	
	void atualizarTurma (Turma turma);
	
	Turma recuperarTurma (Turma turma);
	
	List<Turma> recuperarTurmas();

	List<Turma> recuperarTurmasEscola(Escola escola);
}