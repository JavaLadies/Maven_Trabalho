package modelo.dao.professor;

import java.util.List;

import modelo.entidade.estudantil.Professor;
import modelo.entidade.estudantil.Turma;

public interface ProfessorDAO {
	
	void inserirProfessor(Professor professor);

	void deletarProfessor(Professor professor);

	void atualizarProfessor(Professor professor);

	List<Professor> recuperarProfessor();
	
	List<Professor> recuperarProfessorTurmas (Turma turma);

}
