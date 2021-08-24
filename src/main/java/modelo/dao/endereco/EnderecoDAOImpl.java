package modelo.dao.endereco;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import modelo.entidade.estudantil.Endereco;
import modelo.entidade.estudantil.Escola;

public class EnderecoDAOImpl implements EnderecoDAO {

	public void inserirEndereco(Endereco endereco) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.save(endereco);

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

	public void deletarEndereco(Endereco endereco) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.delete(endereco);

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

	public void atualizarEndereco(Endereco endereco) {

		Session sessao = null;

		try {

			sessao = conectarBanco().openSession();
			sessao.beginTransaction();

			sessao.update(endereco);

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

//	public List<Endereco> recuperarEnderecos() {
//
//		Session sessao = null;
//		List<Endereco> enderecos = null;
//
//		try {
//
//			sessao = conectarBanco().openSession();
//			sessao.beginTransaction();
//
//			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
//
//			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
//			Root<Endereco> raizEndereco = criteria.from(Endereco.class);
//
//			criteria.select(raizEndereco);
//
//			enderecos = sessao.createQuery(criteria).getResultList();
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
//		return enderecos;
//
//	}
//
//	public List<Endereco> recuperarEnderecosCliente(Cliente cliente) {
//
//		Session sessao = null;
//		List<Endereco> enderecos = null;
//
//		try {
//
//			sessao = conectarBanco().openSession();
//			sessao.beginTransaction();
//
//			CriteriaBuilder construtor = sessao.getCriteriaBuilder();
//
//			CriteriaQuery<Endereco> criteria = construtor.createQuery(Endereco.class);
//			Root<Endereco> raizEndereco = criteria.from(Endereco.class);
//
//			Join<Endereco, Cliente> juncaoCliente = raizEndereco.join(Endereco_.clientes);
//
//			ParameterExpression<String> cpfCliente = construtor.parameter(String.class);
//			criteria.where(construtor.equal(juncaoCliente.get(Cliente_.CPF), cpfCliente));
//
//			enderecos = sessao.createQuery(criteria).setParameter(cpfCliente, cliente.getCpf()).getResultList();
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
//		return enderecos;
//	}

	private SessionFactory conectarBanco() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Endereco.class);
		configuracao.addAnnotatedClass(modelo.entidade.estudantil.Escola.class);
//		configuracao.addAnnotatedClass(modelo.entidade.endereco.Endereco.class);
//		configuracao.addAnnotatedClass(modelo.entidade.pedido.Pedido.class);

		configuracao.configure("hibernate.cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();

		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;
	}

public List<Endereco> recuperarEnderecos() {
	// TODO Auto-generated method stub
	return null;
}

public List<Endereco> recuperarEnderecoEscola(Escola escola) {
	// TODO Auto-generated method stub
	return null;
}
}