package modelo.dao.mundo;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidades.jogo.Jogo;
import modelo.entidades.jogo.Mundo;
import modelo.factory.conexao.ConexaoFactory;

public class MundoDAOImpl implements MundoDAO {

	private ConexaoFactory fabrica;

	public MundoDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirMundo(Mundo mundo) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(mundo);

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

	public void deletarMundo(Mundo mundo) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(mundo);

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

	public void atualizarMundo(Mundo mundo) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(mundo);

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
	
	public List<Mundo> recuperarMundos() {

		Session sessao = null;
		List<Mundo> mundos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Mundo> criteria = construtor.createQuery(Mundo.class);
			Root<Mundo> raizMundo = criteria.from(Mundo.class);

			criteria.select(raizMundo);

			mundos = sessao.createQuery(criteria).getResultList();

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

		return mundos;
	}
	
	public List<Mundo> recuperarMundosJogo(Jogo jogo) {

		Session sessao = null;
		List<Mundo> mundos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Mundo> criteria = construtor.createQuery(Mundo.class);
			Root<Mundo> raizMundo = criteria.from(Mundo.class);

			Join<Mundo, Jogo> juncaoJogo = raizMundo.join("jogo");

			ParameterExpression<Long> idJogo = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoJogo.get("id"), idJogo));

			mundos = sessao.createQuery(criteria).setParameter(idJogo, jogo.getId()).getResultList();

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

		return mundos;
	}
}