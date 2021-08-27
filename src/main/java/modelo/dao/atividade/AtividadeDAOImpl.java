package modelo.dao.atividade;

import java.util.List;



import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidades.jogo.Atividade;
import modelo.entidades.jogo.Fase;
import modelo.factory.conexao.ConexaoFactory;

public class AtividadeDAOImpl implements AtividadeDAO {
	
	private ConexaoFactory fabrica;

	public AtividadeDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirAtividade(Atividade atividade) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(atividade);

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

	public void deletarAtividade(Atividade atividade) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(atividade);

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

	public void atualizarAtividade(Atividade atividade) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(atividade);

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
	
	public List<Atividade> recuperarAtividades () {

		Session sessao = null;
		List<Atividade> atividades = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atividade> criteria = construtor.createQuery(Atividade.class);
			Root<Atividade> raizAtividade = criteria.from(Atividade.class);

			criteria.select(raizAtividade);

			atividades = sessao.createQuery(criteria).getResultList();

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

		return atividades;
	}
	
	public List<Atividade> recuperarAtividadesFase(Fase fase) {

		Session sessao = null;
		List<Atividade> atividades = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Atividade> criteria = construtor.createQuery(Atividade.class);
			Root<Atividade> raizAtividade = criteria.from(Atividade.class);

			Join<Atividade, Fase> juncaoFase = raizAtividade.join("fase");

			ParameterExpression<Long> idFase = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoFase.get("id"), idFase));

			atividades = sessao.createQuery(criteria).setParameter(idFase, fase.getId()).getResultList();

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

		return atividades;
	}
}