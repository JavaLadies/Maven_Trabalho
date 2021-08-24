package modelo.dao.teoria;

import java.util.List;

import modelo.entidades.jogo.Fase;
import modelo.entidades.jogo.Teoria;

public interface TeoriaDAO {
	
	void inseirTeoria (Teoria toria);
	
	void deletarTeoria (Teoria teoria);
	
	void atualizarTeoria (Teoria teoria);
	
	List<Teoria> recuperarTeorias();
	
	List<Teoria> recuperarTeoriasFase(Fase fase);
}