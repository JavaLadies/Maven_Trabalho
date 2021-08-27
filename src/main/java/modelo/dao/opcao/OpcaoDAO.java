package modelo.dao.opcao;

import java.util.List;

import modelo.entidades.jogo.Opcao;

public interface OpcaoDAO {
	
	void inserirOpcao (Opcao opcao);
	
	void deletarOpcao (Opcao opcao);
	
	void atualizarOpcao (Opcao opcao);
	
	List<Opcao> recuperarOpcoes();
	
}