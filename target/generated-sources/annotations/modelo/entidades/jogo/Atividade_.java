package modelo.entidades.jogo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Atividade.class)
public abstract class Atividade_ {

	public static volatile SingularAttribute<Atividade, Fase> fase;
	public static volatile SingularAttribute<Atividade, String> enunciado;
	public static volatile ListAttribute<Atividade, Opcao> opcoes;
	public static volatile SingularAttribute<Atividade, String> nome;
	public static volatile SingularAttribute<Atividade, Long> id;
	public static volatile SingularAttribute<Atividade, Situacao> status;

	public static final String FASE = "fase";
	public static final String ENUNCIADO = "enunciado";
	public static final String OPCOES = "opcoes";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

