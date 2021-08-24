package modelo.entidade.estudantil;

import java.io.Serializable;
import java.util.InputMismatchException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import modelo.excecoes.LoginInvalidoException;
import modelo.excecoes.NomeInvalidoException;
import modelo.excecoes.SenhaInvalidaException;
import modelo.excecoes.pessoa.CpfInvalidoException;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa extends Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nome_pessoa", length = 30, nullable = false, unique = false)
	private String nome;
	
	@Id
	@Column(name = "cpf_pessoa", length = 14, nullable = false, unique = true)
	private String cpf;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "id_contato")
	private Contato contato;

	public Pessoa() {}
	
	public Pessoa(String nome, String cpf, String login, String senha, Contato contato)
			throws NomeInvalidoException, CpfInvalidoException, SenhaInvalidaException,
			LoginInvalidoException {
		super(login, senha);
		setNome(nome);
		setCpf(cpf);
		setContato(contato);
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws NomeInvalidoException {

		if (nome.isEmpty())
			throw new NomeInvalidoException("Não pode ser vazio!");

		for (char c : nome.toCharArray()) {
			if (!Character.isLetter(c) & !Character.isSpaceChar(c)) {
				throw new NomeInvalidoException("Insira apenas letras!");
			}
		}

		this.nome = nome;
	}

	public String getCpf () {
		return cpf;
	}
	
	public void setCpf (String cpf) throws CpfInvalidoException {
		
		if (cpf.isEmpty())
			throw new CpfInvalidoException("Não pode ser vazio!");
		
		if (!isCPF(cpf))
			throw new CpfInvalidoException("Esse cpf não existe!");
		
		this.cpf = cpf;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }

        public static String imprimeCPF(String CPF) {
            return(CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." +
            CPF.substring(6, 9) + "-" + CPF.substring(9, 11));
        }


}
