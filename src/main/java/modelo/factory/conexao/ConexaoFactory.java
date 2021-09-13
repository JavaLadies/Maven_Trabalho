package modelo.factory.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexaoFactory {

	public SessionFactory getConexao() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Endereco.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Aluno.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Contato.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Escola.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Disciplina.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Professor.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Usuario.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Turma.class);
		configuracao.addAnnotatedClass(modelo.entidades.jogo.Jogo.class);
		configuracao.addAnnotatedClass(modelo.entidades.jogo.Mundo.class);
		configuracao.addAnnotatedClass(modelo.entidades.jogo.Fase.class);
		configuracao.addAnnotatedClass(modelo.entidades.jogo.Teoria.class);
		configuracao.addAnnotatedClass(modelo.entidades.jogo.Atividade.class);
		configuracao.addAnnotatedClass(modelo.entidades.jogo.Opcao.class);
		configuracao.addAnnotatedClass(modelo.entidades.jogo.Situacao.class);
				
		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();

		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
	}	
}
