package modelo.dao.jogo;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.estudantil.Disciplina;
import modelo.entidades.jogo.Jogo;
import modelo.factory.conexao.ConexaoFactory;

public class JogoDAOImpl implements JogoDAO {

	private ConexaoFactory fabrica;

	public JogoDAOImpl() {
		fabrica = new ConexaoFactory();
	}
	
	public void inserirJogo(Jogo jogo) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(jogo);

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

	public void deletarJogo(Jogo jogo) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(jogo);

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

	public void atualizarJogo(Jogo jogo) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(jogo);

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
	
	public List<Jogo> recuperarJogos() {

		Session sessao = null;
		List<Jogo> jogos = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Jogo> criteria = construtor.createQuery(Jogo.class);
			Root<Jogo> raizJogo = criteria.from(Jogo.class);

			criteria.select(raizJogo);

			jogos = sessao.createQuery(criteria).getResultList();

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

		return jogos;
	}
	
	public Jogo recuperarJogoDisciplina(Disciplina disciplina) {

		Session sessao = null;
		Jogo jogo = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Jogo> criteria = construtor.createQuery(Jogo.class);
			Root<Jogo> raizJogo = criteria.from(Jogo.class);

			Join<Jogo, Disciplina> juncaoDisciplina = raizJogo.join("disciplina");

			ParameterExpression<Long> idDisciplina = construtor.parameter(Long.class);
			criteria.where(construtor.equal(juncaoDisciplina.get("id"), idDisciplina));

			jogo = sessao.createQuery(criteria).setParameter(idDisciplina, disciplina.getId()).getSingleResult();

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

		return jogo;
	}
	
}