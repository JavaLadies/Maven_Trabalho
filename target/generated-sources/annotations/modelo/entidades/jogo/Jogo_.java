package modelo.entidades.jogo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.entidade.estudantil.Disciplina;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Jogo.class)
public abstract class Jogo_ {

	public static volatile ListAttribute<Jogo, Mundo> mundos;
	public static volatile SingularAttribute<Jogo, Disciplina> disciplina;
	public static volatile SingularAttribute<Jogo, Long> id;
	public static volatile SingularAttribute<Jogo, Float> media;

	public static final String MUNDOS = "mundos";
	public static final String DISCIPLINA = "disciplina";
	public static final String ID = "id";
	public static final String MEDIA = "media";

}

