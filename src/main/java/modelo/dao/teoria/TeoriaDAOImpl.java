package modelo.dao.teoria;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidades.jogo.Fase;
import modelo.entidades.jogo.Teoria;
import modelo.factory.conexao.ConexaoFactory;

public class TeoriaDAOImpl implements TeoriaDAO {

	private ConexaoFactory fabrica;

	public TeoriaDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirTeoria(Teoria teoria) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(teoria);

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

	public void deletarTeoria(Teoria teoria) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(teoria);

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

	public void atualizarTeoria(Teoria teoria) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(teoria);

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
	
	public List<Teoria> recuperarTeorias () {

		Session sessao = null;
		List<Teoria> teorias = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Teoria> criteria = construtor.createQuery(Teoria.class);
			Root<Teoria> raizTeoria = criteria.from(Teoria.class);

			criteria.select(raizTeoria);

			teorias = sessao.createQuery(criteria).getResultList();

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

		return teorias;
	}
	
	public List<Teoria> recuperarTeoriasFase(Fase fase) {

		Session sessao = null;
		List<Teoria> teorias = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Teoria> criteria = construtor.createQuery(Teoria.class);
			Root<Teoria> raizTeoria = criteria.from(Teoria.class);

			Join<Teoria, Fase> juncaoFase = raizTeoria.join("fase");

			ParameterExpression<Long> idFase = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoFase.get("id"), idFase));

			teorias = sessao.createQuery(criteria).setParameter(idFase, fase.getId()).getResultList();

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

		return teorias;
	}

}