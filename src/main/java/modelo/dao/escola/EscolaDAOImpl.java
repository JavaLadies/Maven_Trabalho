package modelo.dao.escola;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import modelo.entidade.estudantil.Escola;

public class EscolaDAOImpl implements EscolaDAO {

	public void inserirEscola(Escola escola) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(escola);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void deletarEscola(Escola escola) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(escola);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}

	public void atualizarEscola(Escola escola) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(escola);

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}
	}
	
	public List<Escola> recuperarEscola() {

		Session sessao = null;
		List<Escola> escolas = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Escola> criteria = construtor.createQuery(Escola.class);
			Root<Escola> raizEscola = criteria.from(Escola.class);

			criteria.select(raizEscola);

			escolas = sessao.createQuery(criteria).getResultList();

			sessao.getTransaction().commit();

		} catch (Exception sqlException) {

			sqlException.printStackTrace();

			if (sessao.getTransaction() != null) {
				sessao.getTransaction().rollback();
			}

		} finally {

			if (sessao != null) {
				sessao.close();
			}
		}

		return escolas;
	}
	
	private SessionFactory conectarBanco() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Endereco.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Aluno.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Contato.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Escola.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Pessoa.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Disciplina.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Professor.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Usuario.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Turma.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Visitante.class);
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
