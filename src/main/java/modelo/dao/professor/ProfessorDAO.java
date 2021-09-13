package modelo.dao.professor;

import java.util.List;

import modelo.entidade.estudantil.Disciplina;
import modelo.entidade.estudantil.Professor;

public interface ProfessorDAO {
	
	void inserirProfessor(Professor professor);

	void deletarProfessor(Professor professor);

	void atualizarProfessor(Professor professor);

	List<Professor> recuperarProfessor();

	Professor recuperarProfessorDisciplina (Disciplina disciplina);
	
}
