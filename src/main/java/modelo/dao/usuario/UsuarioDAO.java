package modelo.dao.usuario;

import java.util.List;
import modelo.entidade.estudantil.Usuario;

public interface UsuarioDAO {

	void inserirUsuario (Usuario usuario);
	
	void deletarUsuario (Usuario usuario);
	
	void atualizarUsuario (Usuario usuario);
	
	Usuario recuperarUsuario(Usuario usuario);
	
	List<Usuario> recuperarUsuarios();
	
}
