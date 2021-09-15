package modelo.dao.aluno;
import java.util.List;

import modelo.entidade.estudantil.Aluno;
import modelo.entidade.estudantil.Disciplina;

public interface AlunoDAO {
	
	void inserirAluno(Aluno aluno);

	void deletarAluno(Aluno aluno);

	void atualizarAluno(Aluno aluno);
	
	Aluno recuperarAluno(Aluno aluno);

	List<Aluno> recuperarAlunos();
	
	List<Aluno> recuperarAlunoDisciplinas (Disciplina disciplina);
}