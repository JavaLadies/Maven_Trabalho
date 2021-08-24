package modelo.dao.disciplina;

import java.util.List;

import modelo.entidade.estudantil.Disciplina;
import modelo.entidade.estudantil.Professor;
import modelo.entidade.estudantil.Turma;

public interface DisciplinaDAO {

	void inserirDisciplina(Disciplina disciplina);
	
	void deletarDisciplina(Disciplina disciplina);
	
	void atualizarDisciplina(Disciplina disciplina);
	
	List<Disciplina> recuperarDisciplinas();
	
	List<Disciplina> recuperarDisciplinaTurma(Turma turma);
	
	List<Disciplina> recuperarDisciplinaProfessor(Professor professor);
} 