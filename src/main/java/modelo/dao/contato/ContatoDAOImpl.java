package modelo.dao.contato;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import modelo.entidade.estudantil.Contato;
import modelo.entidade.estudantil.Pessoa;

public class ContatoDAOImpl implements ContatoDAO {

	public void inserirContato(Contato contato) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(contato);

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

	public void deletarContato(Contato contato) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(contato);

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

	public void atualizarContato(Contato contato) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(contato);

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

//	public List<Contato> recuperarContatos() {
//
//		Session sessao = null;
//		List<Contato> contatos = null;
//
//		try {
//
//			sessao = conectarBanco().openSession();
//			sessao.beginTransaction();
//
//			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
//
//			CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
//			Root<Contato> raizContato = criteria.from(Contato.class);
//
//			criteria.select(raizContato);
//
//			contatos = sessao.createQuery(criteria).getResultList();
//
//			sessao.getTransaction().commit();
//
//		} catch (Exception sqlException) {
//
//			sqlException.printStackTrace();
//
//			if (sessao.getTransaction() != null) {
//				sessao.getTransaction().rollback();
//			}
//
//		} finally {
//
//			if (sessao != null) {
//				sessao.close();
//			}
//		}
//
//		return contatos;
//	}

//	public Contato recuperarContatoCliente(Cliente cliente) {
//
//		Session sessao = null;
//		Contato contato = null;
//
//		try {
//
//			sessao = conectarBanco().openSession();
//			sessao.beginTransaction();
//
//			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
//
//			CriteriaQuery<Contato> criteria = construtor.createQuery(Contato.class);
//			Root<Contato> raizContato = criteria.from(Contato.class);
//
//			Join<Contato, Cliente> juncaoCliente = raizContato.join(Contato_.cliente);
//
//			ParameterExpression<String> cpfCliente = construtor.parameter(String.class);
//			criteria.where(construtor.equal(juncaoCliente.get(Cliente_.CPF), cpfCliente));
//
//			contato = sessao.createQuery(criteria).setParameter(cpfCliente, cliente.getCpf()).getSingleResult();
//
//			sessao.getTransaction().commit();
//
//		} catch (Exception sqlException) {
//
//			sqlException.printStackTrace();
//
//			if (sessao.getTransaction() != null) {
//				sessao.getTransaction().rollback();
//			}
//
//		} finally {
//
//			if (sessao != null) {
//				sessao.close();
//			}
//		}
//
//		return contato;
//	}

	private SessionFactory conectarBanco() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Contato.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Pessoa.class);
//		configuracao.addAnnotatedClass(.modelo.entidade.endereco.Endereco.class);
//		configuracao.addAnnotatedClass(.modelo.entidade.pedido.Pedido.class);

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();

		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
	}

public List<Contato> recuperarContatos() {
	// TODO Auto-generated method stub
	return null;
}

public Contato recuperarContatoPessoa(Pessoa pessoa) {
	// TODO Auto-generated method stub
	return null;
}
}