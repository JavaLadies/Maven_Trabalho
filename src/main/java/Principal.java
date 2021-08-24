import modelo.dao.usuario.UsuarioDAO;
import modelo.dao.usuario.UsuarioDAOImpl;
import modelo.entidade.estudantil.Usuario;

public class Principal {

	public static void main(String[] args) {
		
		UsuarioDAO dao = new UsuarioDAOImpl();
		
		dao.inserirUsuario(new Usuario("Brunabarbie33@gmail.com", "1234"));
	}
}
