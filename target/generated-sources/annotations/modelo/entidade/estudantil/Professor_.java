package modelo.entidade.estudantil;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Professor.class)
public abstract class Professor_ extends modelo.entidade.estudantil.Pessoa_ {

	public static volatile SingularAttribute<Professor, Disciplina> disciplina;
	public static volatile SingularAttribute<Professor, Long> id;

	public static final String DISCIPLINA = "disciplina";
	public static final String ID = "id";

}

