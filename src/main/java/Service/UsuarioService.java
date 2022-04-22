package Service;

import Model.Usuario;
import Repository.UsuarioRepository;

public class UsuarioService {

	public void inserirUsuario(Usuario user) {
		UsuarioRepository.getCurrentInstance().inserirUsuario(user);
	}
	
	public Usuario buscarUsuario(String login, String senha) {
		return UsuarioRepository.getCurrentInstance().buscarUsuario(login, senha);
	}
	
}
