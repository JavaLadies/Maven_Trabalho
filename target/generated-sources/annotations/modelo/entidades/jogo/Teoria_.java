package modelo.entidades.jogo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Teoria.class)
public abstract class Teoria_ {

	public static volatile SingularAttribute<Teoria, String> texto;
	public static volatile SingularAttribute<Teoria, Fase> fase;
	public static volatile SingularAttribute<Teoria, Long> id;

	public static final String TEXTO = "texto";
	public static final String FASE = "fase";
	public static final String ID = "id";

}

