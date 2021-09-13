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
import modelo.dao.fase.FaseDAO;
import modelo.dao.fase.FaseDAOImpl;
import modelo.dao.jogo.JogoDAO;
import modelo.dao.jogo.JogoDAOImpl;
import modelo.dao.mundo.MundoDAO;
import modelo.dao.mundo.MundoDAOImpl;
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
import modelo.entidades.jogo.Fase;
import modelo.entidades.jogo.Jogo;
import modelo.entidades.jogo.Mundo;


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
        
        String nome = "Senac08";
        String login = "SenacEs0ola28";
        String senha = "3332120";
        
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
        
        String emailAluno = "Gustag0lXD@gmail.com";
        int celularAluno = 987765403;
        int telefoneAluno = 79654507;

        Contato contatoAluno = new Contato();

        contatoAluno.setEmail(emailAluno);
        contatoAluno.setCelular(celularAluno);
        contatoAluno.setTelefone(telefoneAluno);
        
        contatoDao.inserirContato(contatoAluno);
        
        String nomeAluno = "Gustavo Henrique J0nkes";
        String cpf = "888.234.964-90";
        String loginALuno = "GustagolXD4";
        String senhaAluno = "Omundoébelomentirakkk";
	
        Aluno aluno = new Aluno();
        
        aluno.setNome(nomeAluno);
        aluno.setCpf(cpf);
        aluno.setLogin(loginALuno);
        aluno.setSenha(senhaAluno);
        aluno.setContato(contatoAluno);
        aluno.setTurma(turma);
        
        alunoDao.inserirAluno(aluno);
        
        String nomeDisciplina = "python";
        
        Disciplina disciplina = new Disciplina();
        
        disciplina.setNome(nomeDisciplina);
        disciplina.adicionarTurma(turma);
        disciplina.adicionarDisciplinaNaTurma(turma);
        
        disciplinaDao.inserirDisciplina(disciplina);
        
        String nomeEndereco = "Rua da palmirinha e do loro josé e o ratinho";
        String complemento = "apartamento 90";
        short numero = 134;
        String cidade = "Blumenauiina";
        String estado = "Santa Catarinaina";
        
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
        
        String nomeProfessor = "rui";
        String loginProfessor = "ruibarbosou";
        String senhaProfessor = "rinoceronte";
        
        Professor professor = new Professor();
        
        professor.setNome(nomeProfessor);
        professor.setLogin(loginProfessor);
        professor.setSenha(senhaProfessor);
        professor.setContato(contatoProfessor);
        
        professorDao.inserirProfessor(professor);
        
        JogoDAO jogoDao = new JogoDAOImpl();
        MundoDAO mundoDao = new MundoDAOImpl();
        FaseDAO faseDao = new FaseDAOImpl();
        
        float mediaJogo = 9;
        
        Jogo jogo = new Jogo();
        
        jogo.setMedia(mediaJogo);
        jogo.setDisciplina(disciplina);
        
        jogoDao.inserirJogo(jogo);
        
        String nomeMundo = "Lógica gamer";
        float mediaMundo = 9;

        Mundo mundo = new Mundo();
        
        mundo.setMedia(mediaMundo);
        mundo.setNome(nomeMundo);
        mundo.setJogo(jogo);
        mundo.desbloquearMundo();
        
        mundoDao.inserirMundo(mundo);
        
        String nomeFase = "algoritmo";
        float notaFase = 9;
        
        Fase fase = new Fase();
        
        fase.setMundo(mundo);
        fase.setNome(nomeFase);
        fase.setNota(notaFase);
        fase.desbloquearFase();
        
        faseDao.inserirFase(fase);
        
        
	}
}
