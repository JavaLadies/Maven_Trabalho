package modelo.entidade.estudantil;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Visitante.class)
public abstract class Visitante_ extends modelo.entidade.estudantil.Usuario_ {

	public static volatile SingularAttribute<Visitante, Long> id;
	public static volatile SingularAttribute<Visitante, Contato> contato;

	public static final String ID = "id";
	public static final String CONTATO = "contato";

}

