package modelo.entidade.estudantil;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Escola.class)
public abstract class Escola_ extends modelo.entidade.estudantil.Usuario_ {

	public static volatile ListAttribute<Escola, Turma> turmas;
	public static volatile SingularAttribute<Escola, String> nome;
	public static volatile SingularAttribute<Escola, Long> id;
	public static volatile SingularAttribute<Escola, Contato> contato;

	public static final String TURMAS = "turmas";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String CONTATO = "contato";

}

