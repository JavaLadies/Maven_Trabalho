package modelo.dao.usuario;

import java.util.List;

import modelo.entidade.estudantil.Usuario;
import modelo.entidade.estudantil.Visitante;

public interface UsuarioDAO {

	void inserirUsuario (Usuario usuario);
	
	void deletarUsuario (Usuario usuario);
	
	void atualizarUsuario (Usuario usuario, String novoLogin);
	
	List<Usuario> recuperarUsuarios();
	
	List<Usuario> recuperarUsuariosVisitantes(Visitante visitante);
}
