package modelo.entidade.estudantil;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Turma.class)
public abstract class Turma_ {

	public static volatile ListAttribute<Turma, Disciplina> disciplinas;
	public static volatile SingularAttribute<Turma, Escola> escola;
	public static volatile ListAttribute<Turma, Aluno> alunos;
	public static volatile SingularAttribute<Turma, String> nome;
	public static volatile SingularAttribute<Turma, Long> id;

	public static final String DISCIPLINAS = "disciplinas";
	public static final String ESCOLA = "escola";
	public static final String ALUNOS = "alunos";
	public static final String NOME = "nome";
	public static final String ID = "id";

}

