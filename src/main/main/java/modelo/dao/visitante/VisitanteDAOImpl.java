package modelo.dao.visitante;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.estudantil.Contato;
import modelo.entidade.estudantil.Visitante;
import modelo.factory.conexao.ConexaoFactory;

public class VisitanteDAOImpl implements VisitanteDAO {

	private ConexaoFactory fabrica;

	public VisitanteDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirVisitante(Visitante visitante) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(visitante);

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

	public void deletarVisitante(Visitante visitante) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(visitante);

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

	public void atualizarVisitante(Visitante visitante) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(visitante);

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
	
	public List<Visitante> recuperarVisitantes() {

		Session sessao = null;
		List<Visitante> visitantes = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Visitante> criteria = construtor.createQuery(Visitante.class);
			Root<Visitante> raizVisitante = criteria.from(Visitante.class);

			criteria.select(raizVisitante);

			visitantes = sessao.createQuery(criteria).getResultList();

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

		return visitantes;
	}

	public List<Visitante> recuperarVisitantesContato(Contato contato) {

		Session sessao = null;
		List<Visitante> visitantes = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Visitante> criteria = construtor.createQuery(Visitante.class);
			Root<Visitante> raizVisitante = criteria.from(Visitante.class);

			Join<Visitante, Contato> juncaoContato = raizVisitante.join("contato");

			ParameterExpression<Long> idContato = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoContato.get("id"), idContato));

			visitantes = sessao.createQuery(criteria).setParameter(idContato, contato.getId()).getResultList();

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

		return visitantes;
	}
}