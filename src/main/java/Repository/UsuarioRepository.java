package Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Model.TipoUsuario;
import Model.Usuario;

public class UsuarioRepository {
	
	private static UsuarioRepository userRepository;
	
	private UsuarioRepository() {}
	
	public static UsuarioRepository getCurrentInstance() {
		if(userRepository == null) {
			userRepository = new UsuarioRepository();
		}
		return userRepository;
	}

	public void inserirUsuario(Usuario user) {

		Connection con = ConnectionFactory.conectar();

		try (PreparedStatement pstm = con
				.prepareStatement("INSERT INTO usuario (nome,data_nascimento, login, senha) VALUES (?, ?, ?, ?)");) {

			pstm.setString(1, user.getNome());
			pstm.setDate(2, (Date) user.getDataNascimento());
			pstm.setString(3, user.getLogin());
			pstm.setString(4, user.getSenha());

			pstm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

	}

	public Usuario buscarUsuario(String login, String senha) {

		Connection con = ConnectionFactory.conectar();
		Usuario user = null;

		try (PreparedStatement pstm = con.prepareStatement("SELECT * FROM usuario WHERE login = ? AND senha = ?", Statement.RETURN_GENERATED_KEYS)) {

			pstm.setString(1, login);
			pstm.setString(2, senha);

			try (ResultSet result = pstm.executeQuery();) {
				while(result.next()) {
					user = new Usuario();
					user.setId(result.getLong("id"));
					user.setNome(result.getString("nome"));
					user.setCargo(result.getString("cargo"));
					user.setTipoUsuario(TipoUsuario.valueOf(result.getString("tipo")));
					
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();
		
		return user;
	}

}
