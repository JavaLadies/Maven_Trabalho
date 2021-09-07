import modelo.dao.contato.ContatoDAO;
import modelo.dao.contato.ContatoDAOImpl;
import modelo.entidade.estudantil.Contato;

public class Principal {

	public static void main(String[] args) {
		
		ContatoDAO dao = new ContatoDAOImpl();
		
		dao.inserirContato(new Contato("robertinho23@gmail.com", 99999999, 33333333));
	}
}
