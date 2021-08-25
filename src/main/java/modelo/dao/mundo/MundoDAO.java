package modelo.dao.mundo;

import java.util.List;

import modelo.entidades.jogo.Jogo;
import modelo.entidades.jogo.Mundo;

public interface MundoDAO {
	
	void inserirMundo(Mundo mundo);

	void deletarMundo(Mundo mundo);

	void atualizarMundo(Mundo mundo);

	List<Mundo> recuperarMundos();
	
	List<Mundo> recuperarMundosJogo(Jogo jogo);
}