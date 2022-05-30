package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.TipoUsuario;
import model.Usuario;
import repository.UsuarioRepository;

/**
 * 
 * @author Guilherme2800
 *
 */
public class UsuarioService {

	/**
	 * Método que cadastra um novo usuário no sistema
	 * 
	 * @param nome
	 * @param nascimento
	 * @param login
	 * @param senha
	 * @param tipoUsuario
	 * @param cargo
	 * @param cpf
	 */
	public void inserirUsuario(String nome, String nascimento, String login, String senha, TipoUsuario tipoUsuario,
			String cargo, Long cpf) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date data = null;
		try {
			data = sdf.parse(nascimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UsuarioRepository.getCurrentInstance().inserirUsuario(nome, sdf.format(data), login, senha, tipoUsuario, cargo, cpf);
	}

	public Usuario buscarUsuario(String login, String senha) {
		return UsuarioRepository.getCurrentInstance().buscarUsuario(login, senha);
	}

	public Usuario buscarUsuario(Long id) {
		return UsuarioRepository.getCurrentInstance().buscarUsuario(id);
	}

	/**
	 * Método que busca todos os usuários do sistema
	 * 
	 * @return Lista de todos os usuários do sistema
	 */
	public List<Usuario> buscarTodosUsuario() {
		return UsuarioRepository.getCurrentInstance().buscarTodosUsuario();
	}

	/**
	 * Atualiza o perfil do usuário
	 * 
	 * @param user_id
	 * @param celular
	 * @param email
	 * @param urlImagem
	 */
	public void atualizarPerfil(Long user_id, Long celular, String email, String urlImagem) {
		UsuarioRepository.getCurrentInstance().atualizarPerfil(user_id, celular, email, urlImagem);
	}

}
