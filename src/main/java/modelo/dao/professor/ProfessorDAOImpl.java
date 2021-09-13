package modelo.dao.professor;

import java.util.List;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import modelo.entidade.estudantil.Disciplina;
import modelo.entidade.estudantil.Professor;

import modelo.factory.conexao.ConexaoFactory;

public class ProfessorDAOImpl implements ProfessorDAO{
	private ConexaoFactory fabrica;

	public ProfessorDAOImpl() {
		fabrica = new ConexaoFactory();
	}

	public void inserirProfessor(Professor professor) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.save(professor);

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

	public void deletarProfessor(Professor professor) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.delete(professor);

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

	public void atualizarProfessor(Professor professor) {

		Session sessao = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			sessao.update(professor);

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

	public List<Professor> recuperarProfessor() {

		Session sessao = null;
		List<Professor> professores = null;

		try {

			sessao = fabrica.getConexao().openSession();
			sessao.beginTransaction();

			CriteriaBuilder construtor = sessao.getCriteriaBuilder();

			CriteriaQuery<Professor> criteria = construtor.createQuery(Professor.class);
			Root<Professor> raizProfessor = criteria.from(Professor.class);

			criteria.select(raizProfessor);

			professores = sessao.createQuery(criteria).getResultList();

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

		return professores;
	}
	
	public Professor recuperarProfessorDisciplina (Disciplina disciplina) {

			Session sessao = null;
			Professor professor = null;

			try {

				sessao = fabrica.getConexao().openSession();
				sessao.beginTransaction();

				CriteriaBuilder construtor = sessao.getCriteriaBuilder();

				CriteriaQuery<Professor> criteria = construtor.createQuery(Professor.class);
				Root<Professor> raizProfessor = criteria.from(Professor.class);

				Join<Professor, Disciplina> juncaoDisciplina = raizProfessor.join("disciplina");

				ParameterExpression<Long> idDisciplina = construtor.parameter(Long.class);
				criteria.where(construtor.equal(juncaoDisciplina.get("id"), idDisciplina));

				professor = sessao.createQuery(criteria).setParameter(idDisciplina, disciplina.getId()).getSingleResult();

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

			return professor;
		}
	}
