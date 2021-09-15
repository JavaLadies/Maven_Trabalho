package modelo.dao.escola;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.estudantil.Escola;
import modelo.factory.conexao.ConexaoFactory;

public class EscolaDAOImpl implements EscolaDAO {

	private ConexaoFactory fabrica;

	public EscolaDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirEscola(Escola escola) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
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

			sessao = fabrica.getConexao().openSession();
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

			sessao = fabrica.getConexao().openSession();
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
	
	public Escola recuperarEscola(Escola escola) {

		Session sessao = null;
		Escola escolaRecuperado = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Escola> criteria = construtor.createQuery(Escola.class);
			Root<Escola> raizEscola = criteria.from(Escola.class);

			criteria.select(raizEscola);
			
			ParameterExpression<Long> idEscola= construtor.parameter(Long.class);
			criteria.where(construtor.equal(raizEscola.get("id"), idEscola));

			escolaRecuperado = sessao.createQuery(criteria).setParameter(idEscola, escola.getId()).getSingleResult();

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

		return escolaRecuperado;
	}
	
	public List<Escola> recuperarEscolas() {

		Session sessao = null;
		List<Escola> escolas = null;

		try {

			sessao = fabrica.getConexao().openSession();
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
}
