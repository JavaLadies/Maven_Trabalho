package modelo.entidades.jogo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Mundo.class)
public abstract class Mundo_ {

	public static volatile SingularAttribute<Mundo, String> nome;
	public static volatile SingularAttribute<Mundo, Long> id;
	public static volatile SingularAttribute<Mundo, Float> media;
	public static volatile SingularAttribute<Mundo, Jogo> jogo;
	public static volatile ListAttribute<Mundo, Fase> fases;
	public static volatile SingularAttribute<Mundo, Situacao> status;

	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String MEDIA = "media";
	public static final String JOGO = "jogo";
	public static final String FASES = "fases";
	public static final String STATUS = "status";

}

