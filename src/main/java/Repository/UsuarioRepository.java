package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Model.TipoUsuario;
import Model.Usuario;

public class UsuarioRepository {

	private static UsuarioRepository userRepository;

	private UsuarioRepository() {
	}

	public static UsuarioRepository getCurrentInstance() {
		if (userRepository == null) {
			userRepository = new UsuarioRepository();
		}
		return userRepository;
	}

	public void inserirUsuario(String nome, String nascimento, String login, String senha, TipoUsuario tipoUsuario,
			String cargo, Long cpf) {

		Connection con = ConnectionFactory.conectar();

		try (PreparedStatement pstm = con.prepareStatement(
				"INSERT INTO usuario (nome,data_nascimento, login, senha, tipo, cargo, cpf) VALUES (?, ?, ?, ?, ?, ?, ?)");) {

			pstm.setString(1, nome);
			pstm.setString(2, nascimento);
			pstm.setString(3, login);
			pstm.setString(4, senha);
			pstm.setString(5, tipoUsuario.toString());
			pstm.setString(6, cargo);
			pstm.setLong(7, cpf);

			pstm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

	}

	public Usuario buscarUsuario(String login, String senha) {

		Connection con = ConnectionFactory.conectar();
		Usuario user = null;

		try (PreparedStatement pstm = con.prepareStatement("SELECT * FROM usuario WHERE login = ? AND senha = ?",
				Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, login);
			pstm.setString(2, senha);

			try (ResultSet result = pstm.executeQuery();) {
				while (result.next()) {
					user = new Usuario();
					user.setId(result.getLong("id"));
					user.setNome(result.getString("nome"));
					user.setCargo(result.getString("cargo"));
					user.setTipoUsuario(TipoUsuario.valueOf(result.getString("tipo")));
					user.setUrlImagem(result.getString("url_imagem"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

		return user;
	}

	public Usuario buscarUsuario(Long id) {

		Connection con = ConnectionFactory.conectar();
		Usuario user = null;

		try (PreparedStatement pstm = con.prepareStatement("SELECT * FROM usuario WHERE id = ?")) {

			pstm.setLong(1, id);

			try (ResultSet result = pstm.executeQuery();) {
				while (result.next()) {
					user = new Usuario();
					user.setId(result.getLong("id"));
					user.setNome(result.getString("nome"));
					user.setCargo(result.getString("cargo"));
					user.setTipoUsuario(TipoUsuario.valueOf(result.getString("tipo")));
					user.setUrlImagem(result.getString("url_imagem"));
					user.setEmail(result.getString("email"));
					user.setCelular(result.getLong("celular"));
					user.setCpf(result.getLong("cpf"));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

		return user;
	}

	public List<Usuario> buscarTodosUsuario() {

		Connection con = ConnectionFactory.conectar();

		List<Usuario> listaUsuarios = new ArrayList<>();

		try (PreparedStatement pstm = con.prepareStatement("SELECT * FROM usuario",
				Statement.RETURN_GENERATED_KEYS)) {

			try (ResultSet result = pstm.executeQuery();) {
				while (result.next()) {
					Usuario user = new Usuario();
					user.setId(result.getLong("id"));
					user.setNome(result.getString("nome"));
					user.setCargo(result.getString("cargo"));
					user.setTipoUsuario(TipoUsuario.valueOf(result.getString("tipo")));
					listaUsuarios.add(user);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

		return listaUsuarios;
	}

	public void atualizarPerfil(Long user_id, Long celular, String email, String urlImagem) {

		Connection con = ConnectionFactory.conectar();

		try (PreparedStatement pstm = con
				.prepareStatement("UPDATE usuario SET celular = ?, email = ?, url_imagem = ? WHERE id = ?")) {

			pstm.setLong(1, celular);
			pstm.setString(2, email);
			pstm.setString(3, urlImagem);
			pstm.setLong(4, user_id);
			pstm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

	}

}
