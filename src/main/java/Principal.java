import modelo.dao.aluno.AlunoDAO;
import modelo.dao.aluno.AlunoDAOImpl;
import modelo.dao.contato.ContatoDAO;
import modelo.dao.contato.ContatoDAOImpl;
import modelo.dao.disciplina.DisciplinaDAO;
import modelo.dao.disciplina.DisciplinaDAOImpl;
import modelo.dao.endereco.EnderecoDAO;
import modelo.dao.endereco.EnderecoDAOImpl;
import modelo.dao.escola.EscolaDAO;
import modelo.dao.escola.EscolaDAOImpl;
import modelo.dao.professor.ProfessorDAO;
import modelo.dao.professor.ProfessorDAOImpl;
import modelo.dao.turma.TurmaDAO;
import modelo.dao.turma.TurmaDAOImpl;
import modelo.entidade.estudantil.Aluno;
import modelo.entidade.estudantil.Contato;
import modelo.entidade.estudantil.Disciplina;
import modelo.entidade.estudantil.Endereco;
import modelo.entidade.estudantil.Escola;
import modelo.entidade.estudantil.Professor;
import modelo.entidade.estudantil.Turma;


public class Principal {

	public static void main(String[] args) {
		
		EscolaDAO escolaDao = new EscolaDAOImpl();
        TurmaDAO turmaDao = new TurmaDAOImpl();
        ContatoDAO contatoDao = new ContatoDAOImpl();
        AlunoDAO alunoDao = new AlunoDAOImpl();
        DisciplinaDAO disciplinaDao = new DisciplinaDAOImpl();
        EnderecoDAO enderecoDao = new EnderecoDAOImpl();
        ProfessorDAO professorDao = new ProfessorDAOImpl();
        
        String email = "Senac28@gmail.com";
        int celular = 444566666;
        int telefone = 33383732;

        Contato contato = new Contato();

        contato.setEmail(email);
        contato.setCelular(celular);
        contato.setTelefone(telefone);
        
        contatoDao.inserirContato(contato);
        
        String nome = "Senac28";
        String login = "SenacEscola28";
        String senha = "3332128";
        
        Escola escola = new Escola();
        
        escola.setNome(nome);
        escola.setLogin(login);
        escola.setSenha(senha);
        escola.setContato(contato);
        
        escolaDao.inserirEscola(escola);
        
        String nomeTurma = "Java Web Vespertino";
        
        Turma turma = new Turma();
        
        turma.setNome(nomeTurma);
        turma.setEscola(escola);
        
        turmaDao.inserirTurma(turma);
        
        String emailAluno = "GustagolXD@gmail.com";
        int celularAluno = 987765433;
        int telefoneAluno = 79654567;

        Contato contatoAluno = new Contato();

        contatoAluno.setEmail(emailAluno);
        contatoAluno.setCelular(celularAluno);
        contatoAluno.setTelefone(telefoneAluno);
        
        contatoDao.inserirContato(contatoAluno);
        
        String nomeAluno = "Gustavo Henrique Junkes";
        String cpf = "888.234.764-90";
        String loginALuno = "GustagolXD";
        String senhaAluno = "Omundoébelo";
	
        Aluno aluno = new Aluno();
        
        aluno.setNome(nomeAluno);
        aluno.setCpf(cpf);
        aluno.setLogin(loginALuno);
        aluno.setSenha(senhaAluno);
        aluno.setContato(contatoAluno);
        aluno.setTurma(turma);
        
        alunoDao.inserirAluno(aluno);
        
        String nomeDisciplina = "C#";
        
        Disciplina disciplina = new Disciplina();
        
        disciplina.setNome(nomeDisciplina);
        disciplina.adicionarTurma(turma);
        disciplina.adicionarDisciplinaNaTurma(turma);
        
        disciplinaDao.inserirDisciplina(disciplina);
        
        String nomeEndereco = "Rua da palmirinha e do loro josé";
        String complemento = "apartamento 9";
        short numero = 134;
        String cidade = "Blumenau";
        String estado = "Santa Catarina";
        
        Endereco endereco = new Endereco();
        
        endereco.setNome(nomeEndereco);
        endereco.setComplemento(complemento);
        endereco.setNumero(numero);
        endereco.setCidade(cidade);
        endereco.setEstado(estado);
        endereco.setEscola(escola);
        
        enderecoDao.inserirEndereco(endereco);
        
        String emailProfessor = "GustagolXD@gmail.com";
        int celularProfessor = 987765433;
        int telefoneProfessor = 79654567;

        Contato contatoProfessor = new Contato();

        contatoProfessor.setEmail(emailProfessor);
        contatoProfessor.setCelular(celularProfessor);
        contatoProfessor.setTelefone(telefoneProfessor);
        
        contatoDao.inserirContato(contatoProfessor);
        
        String nomeProfessor = "";
        String loginProfessor = "";
        String senhaProfessor = "";
        
        Professor professor = new Professor();
        
        professor.setNome(nomeProfessor);
        professor.setLogin(loginProfessor);
        professor.setSenha(senhaProfessor);
        professor.setContato(contatoProfessor);
        
        professorDao.inserirProfessor(professor);
	}
}
