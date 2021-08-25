package modelo.entidades.jogo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Fase.class)
public abstract class Fase_ {

	public static volatile ListAttribute<Fase, Atividade> atividades;
	public static volatile SingularAttribute<Fase, Mundo> mundo;
	public static volatile SingularAttribute<Fase, String> nome;
	public static volatile ListAttribute<Fase, Teoria> teorias;
	public static volatile SingularAttribute<Fase, Long> id;
	public static volatile SingularAttribute<Fase, Float> nota;
	public static volatile SingularAttribute<Fase, Situacao> status;

	public static final String ATIVIDADES = "atividades";
	public static final String MUNDO = "mundo";
	public static final String NOME = "nome";
	public static final String TEORIAS = "teorias";
	public static final String ID = "id";
	public static final String NOTA = "nota";
	public static final String STATUS = "status";

}

