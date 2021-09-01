package modelo.dao.fase;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidades.jogo.Fase;
import modelo.entidades.jogo.Mundo;
import modelo.factory.conexao.ConexaoFactory;

public class FaseDAOImpl implements FaseDAO {

	private ConexaoFactory fabrica;

	public FaseDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirFase(Fase fase) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(fase);

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

	public void deletarFase(Fase fase) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(fase);

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

	public void atualizarFase(Fase fase) {


		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(fase);

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
	
	public List<Fase> recuperarFases() {

		Session sessao = null;
		List<Fase> fases = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Fase> criteria = construtor.createQuery(Fase.class);
			Root<Fase> raizFase = criteria.from(Fase.class);

			criteria.select(raizFase);

			fases = sessao.createQuery(criteria).getResultList();

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

		return fases;
	}
	
	public List<Fase> recuperarFasesMundo(Mundo mundo) {

		Session sessao = null;
		List<Fase> fases = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Fase> criteria = construtor.createQuery(Fase.class);
			Root<Fase> raizFase = criteria.from(Fase.class);

			Join<Fase, Mundo> juncaoMundo = raizFase.join("mundo");

			ParameterExpression<Long> idMundo = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoMundo.get("id"), idMundo));

			fases = sessao.createQuery(criteria).setParameter(idMundo, mundo.getId()).getResultList();

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

		return fases;
	}
}