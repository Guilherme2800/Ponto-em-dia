package Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Model.TipoUsuario;
import Model.Usuario;
import Repository.UsuarioRepository;

public class UsuarioService {

	public void inserirUsuario(String nome, String nascimento, String login, String senha, TipoUsuario tipoUsuario, String cargo) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date data = null;
		try {
			data = sdf.parse(nascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		UsuarioRepository.getCurrentInstance().inserirUsuario(nome, sdf.format(data), login, senha, tipoUsuario, cargo);
	}
	
	public Usuario buscarUsuario(String login, String senha) {
		return UsuarioRepository.getCurrentInstance().buscarUsuario(login, senha);
	}
	
	public Usuario buscarUsuario(Long id) {
		return UsuarioRepository.getCurrentInstance().buscarUsuario(id);
	}
	
	public List<Usuario> buscarTodosUsuario() {
		return UsuarioRepository.getCurrentInstance().buscarTodosUsuario();
	}
	
	public void atualizarPerfil(Long user_id, Long celular, String email, String urlImagem) {
		UsuarioRepository.getCurrentInstance().atualizarPerfil(user_id, celular, email, urlImagem);
	}
	
}
