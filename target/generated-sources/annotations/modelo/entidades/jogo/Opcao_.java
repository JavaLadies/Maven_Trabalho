package modelo.entidades.jogo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Opcao.class)
public abstract class Opcao_ {

	public static volatile SingularAttribute<Opcao, String> texto;
	public static volatile SingularAttribute<Opcao, Atividade> atividade;
	public static volatile SingularAttribute<Opcao, Boolean> isCorreta;
	public static volatile SingularAttribute<Opcao, Byte> ordem;
	public static volatile SingularAttribute<Opcao, Long> id;

	public static final String TEXTO = "texto";
	public static final String ATIVIDADE = "atividade";
	public static final String IS_CORRETA = "isCorreta";
	public static final String ORDEM = "ordem";
	public static final String ID = "id";

}

