import modelo.dao.aluno.AlunoDAO;
import modelo.dao.aluno.AlunoDAOImpl;
import modelo.dao.atividade.AtividadeDAO;
import modelo.dao.atividade.AtividadeDAOImpl;
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
import modelo.dao.opcao.OpcaoDAO;
import modelo.dao.opcao.OpcaoDAOImpl;
import modelo.dao.professor.ProfessorDAO;
import modelo.dao.professor.ProfessorDAOImpl;
import modelo.dao.teoria.TeoriaDAO;
import modelo.dao.teoria.TeoriaDAOImpl;
import modelo.dao.turma.TurmaDAO;
import modelo.dao.turma.TurmaDAOImpl;
import modelo.entidade.estudantil.Aluno;
import modelo.entidade.estudantil.Contato;
import modelo.entidade.estudantil.Disciplina;
import modelo.entidade.estudantil.Endereco;
import modelo.entidade.estudantil.Escola;
import modelo.entidade.estudantil.Professor;
import modelo.entidade.estudantil.Turma;
import modelo.entidades.jogo.Atividade;
import modelo.entidades.jogo.Fase;
import modelo.entidades.jogo.Jogo;
import modelo.entidades.jogo.Mundo;
import modelo.entidades.jogo.Opcao;
import modelo.entidades.jogo.Teoria;
import modelo.excecoes.endereco.CidadeInvalidaException;
import modelo.excecoes.endereco.EstadoInvalidoException;
import modelo.excecoes.endereco.NumeroInvalidoException;
import modelo.excecoes.pessoa.CpfInvalidoException;


public class Principal {

	public static void main(String[] args) {
		
		try { 
		EscolaDAO escolaDao = new EscolaDAOImpl();
        TurmaDAO turmaDao = new TurmaDAOImpl();
        ContatoDAO contatoDao = new ContatoDAOImpl();
        AlunoDAO alunoDao = new AlunoDAOImpl();
        DisciplinaDAO disciplinaDao = new DisciplinaDAOImpl();
        EnderecoDAO enderecoDao = new EnderecoDAOImpl();
        ProfessorDAO professorDao = new ProfessorDAOImpl();
        
        String emailEscola = "SesiSenai@email.com";
        int celularEscola = 222221222;
        int telefoneEscola = 22221222;

        Contato contatoEscola = new Contato();

        contatoEscola.setEmail(emailEscola);
        contatoEscola.setCelular(celularEscola);
        contatoEscola.setTelefone(telefoneEscola);
        
        contatoDao.inserirContato(contatoEscola);
        
        String nomeEscola = "SesiSenai";
        String loginEscola = "Senaithebester2";
        String senhaEscola = "SesiSenaiSEscolaSSSSesi";
        
        Escola escola = new Escola();
        
        escola.setNome(nomeEscola);
        escola.setLogin(loginEscola);
        escola.setSenha(senhaEscola);
        escola.setContato(contatoEscola);
        
        escolaDao.inserirEscola(escola);
        
        String nomeTurma = "204";
        
        Turma turma = new Turma();
        
        turma.setNome(nomeTurma);
        turma.setEscola(escola);
        
        turmaDao.inserirTurma(turma);
        
        String emailAluno = "Kaue22@email.com";
        int celularAluno = 111111211;
        int telefoneAluno = 11112111;

        Contato contatoAluno = new Contato();

        contatoAluno.setEmail(emailAluno);
        contatoAluno.setCelular(celularAluno);
        contatoAluno.setTelefone(telefoneAluno);
        
        contatoDao.inserirContato(contatoAluno);
        
        String nomeAluno = "Kaue tribessbess";
        String cpf = "987.099.678-01";
        String loginALuno = "tribesskaue";
        String senhaAluno = "hamburgui";
	
        Aluno aluno = new Aluno();
        
        aluno.setNome(nomeAluno);
        aluno.setCpf(cpf);
        aluno.setLogin(loginALuno);
        aluno.setSenha(senhaAluno);
        aluno.setContato(contatoAluno);
        aluno.setTurma(turma);
        
        alunoDao.inserirAluno(aluno);
        
        String nomeDisciplina = "Fundamentos da tecnologia da informação";
        
        Disciplina disciplina = new Disciplina();
        
        disciplina.setNome(nomeDisciplina);
        disciplina.adicionarTurma(turma);
        disciplina.adicionarDisciplinaNaTurma(turma);
        
        disciplinaDao.inserirDisciplina(disciplina);
        
        String nomeEndereco = "Rua São Paulo";
        String complemento = "Bloco H";
        short numero = 222;
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
        
        String emailProfessor = "Bianca@email.com";
        int celularProfessor = 444444449;
        int telefoneProfessor = 44444449;

        Contato contatoProfessor = new Contato();

        contatoProfessor.setEmail(emailProfessor);
        contatoProfessor.setCelular(celularProfessor);
        contatoProfessor.setTelefone(telefoneProfessor);
        
        contatoDao.inserirContato(contatoProfessor);
        
        String nomeProfessor = "Bianca Alguma Coisa";
        String loginProfessor = "BiancaDoZoiPequeno";
        String senhaProfessor = "chicoliro";
        
        Professor professor = new Professor();
        
        professor.setNome(nomeProfessor);
        professor.setLogin(loginProfessor);
        professor.setSenha(senhaProfessor);
        professor.setContato(contatoProfessor);
        professor.setDisciplina(disciplina);
        
        professorDao.inserirProfessor(professor);
        
        JogoDAO jogoDao = new JogoDAOImpl();
        MundoDAO mundoDao = new MundoDAOImpl();
        FaseDAO faseDao = new FaseDAOImpl();
        TeoriaDAO teoriaDao = new TeoriaDAOImpl();
        AtividadeDAO atividadeDao = new AtividadeDAOImpl();
        OpcaoDAO opcaoDao = new OpcaoDAOImpl();
        
        float mediaJogo = 9;
        
        Jogo jogo = new Jogo();
        
        jogo.setMedia(mediaJogo);
        jogo.setDisciplina(disciplina);
        
        jogoDao.inserirJogo(jogo);
        
        String nomeMundo = "Segurança das Informações";
        float mediaMundo = 8;

        Mundo mundo = new Mundo();
        
        mundo.setMedia(mediaMundo);
        mundo.setNome(nomeMundo);
        mundo.setJogo(jogo);
        mundo.desbloquearMundo();
        
        mundoDao.inserirMundo(mundo);
        
        String nomeFase = "Malware";
        float notaFase = 8;
        
        Fase fase = new Fase();
        
        fase.setMundo(mundo);
        fase.setNome(nomeFase);
        fase.setNota(notaFase);
        fase.desbloquearFase();
        
        faseDao.inserirFase(fase);
        
        String texto = "Malware é poipipopopo";
        
        Teoria teoria = new Teoria();
        
        teoria.setTexto(texto);
        teoria.setFase(fase);
        
        teoriaDao.inserirTeoria(teoria);
        
        String enunciado = "O que é malware?";
        
        Atividade atividade = new Atividade();
        
        atividade.setEnunciado(enunciado);
        atividade.setFase(fase);
        
        atividadeDao.inserirAtividade(atividade);
        
        String texto1 = "pipipopopo";
        byte ordem1 = 1;
        boolean isCorreta1 = true;
        
        Opcao opcao1 = new Opcao();
        
        opcao1.setTexto(texto1);
        opcao1.setOrdem(ordem1);
        opcao1.setCorreta(isCorreta1);
        opcao1.setAtividade(atividade);
        
        opcaoDao.inserirOpcao(opcao1);
        
        String texto2 = "não é essa";
        byte ordem2 = 2;
        boolean isCorreta2 = false;
        
        Opcao opcao2 = new Opcao();
        
        opcao2.setTexto(texto2);
        opcao2.setOrdem(ordem2);
        opcao2.setCorreta(isCorreta2);
        opcao2.setAtividade(atividade);
        
        opcaoDao.inserirOpcao(opcao2);

        String texto3 = "nem essa";
        byte ordem3 = 3;
        boolean isCorreta3 = false;
        
        Opcao opcao3 = new Opcao();
        
        opcao3.setTexto(texto3);
        opcao3.setOrdem(ordem3);
        opcao3.setCorreta(isCorreta3);
        opcao3.setAtividade(atividade);
        
        opcaoDao.inserirOpcao(opcao3);

        String texto4 = "nao clica irmao";
        byte ordem4 = 4;
        boolean isCorreta4 = false;
        
        Opcao opcao4 = new Opcao();
        
        opcao4.setTexto(texto4);
        opcao4.setOrdem(ordem4);
        opcao4.setCorreta(isCorreta4);
        opcao4.setAtividade(atividade);
        
        opcaoDao.inserirOpcao(opcao4);
		}
		
		catch(CidadeInvalidaException e) {
			System.err.print("Cidade inválida: " + e);
		}
		
		catch(EstadoInvalidoException e) {
			System.err.print("Estado inválido: " + e);
		}
		
		catch(NumeroInvalidoException e) {
			System.err.print("Número inválido: " + e);
		}
	}
}
