package Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Model.Ponto;
import Model.Usuario;

public class PontoRepository {

	private long idPonto;

	private static PontoRepository pontoRepository = null;

	private PontoRepository() {
	}

	public static PontoRepository getCurrentInstance() {
		if (pontoRepository == null) {
			pontoRepository = new PontoRepository();
		}
		return pontoRepository;
	}

	public void inserirPonto(Date dataHora, Usuario user) {

		String coluna = verificarPontoParaInserir(user);

		if (coluna != null) {

			Connection con = ConnectionFactory.conectar();

			if (coluna.equals("data_hora_entrada")) {

				try (PreparedStatement pstm = con
						.prepareStatement("INSERT INTO ponto (" + coluna + ", user_id, data) VALUES (?, ?, ?)")) {

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					pstm.setString(1, sdf.format(dataHora));
					pstm.setLong(2, user.getId());
					pstm.setString(3, new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					pstm.execute();

				} catch (Exception e) {
					e.printStackTrace();
				}

			} else {

				try (PreparedStatement pstm = con.prepareStatement("UPDATE ponto SET " + coluna + "=? WHERE id=?")) {

					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					pstm.setString(1, sdf.format(dataHora));
					pstm.setLong(2, idPonto);
					pstm.execute();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			ConnectionFactory.desconectar();

		}

	}

	private String verificarPontoParaInserir(Usuario user) {

		String colunaParaInserir = null;

		Connection con = ConnectionFactory.conectar();

		Date data_hora_entrada = null;
		Date data_hora_almoco = null;
		Date data_hora_volta_almoco = null;
		Date data_hora_saida = null;

		try (PreparedStatement pstm = con.prepareStatement(
				"SELECT * FROM ponto where user_id = ? and data = '"
						+ new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "'",
				Statement.RETURN_GENERATED_KEYS)) {

			pstm.setLong(1, user.getId());

			try (ResultSet result = pstm.executeQuery();) {
				while (result.next()) {
					idPonto = result.getLong("id");
					data_hora_entrada = result.getDate("data_hora_entrada");
					data_hora_almoco = result.getDate("data_hora_almoco");
					data_hora_volta_almoco = result.getDate("data_hora_volta_almoco");
					data_hora_saida = result.getDate("data_hora_saida");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

		if (data_hora_entrada == null) {
			colunaParaInserir = "data_hora_entrada";
		} else if (data_hora_almoco == null) {
			colunaParaInserir = "data_hora_almoco";
		} else if (data_hora_volta_almoco == null) {
			colunaParaInserir = "data_hora_volta_almoco";
		} else if (data_hora_saida == null) {
			colunaParaInserir = "data_hora_saida";
		}

		return colunaParaInserir;

	}

	public List<Ponto> buscarHistoricoDoUsuario(Usuario user) {

		List<Ponto> pontosList = new ArrayList<>();

		Connection con = ConnectionFactory.conectar();

		try (PreparedStatement pstm = con.prepareStatement("SELECT * FROM ponto WHERE user_id = ?")) {

			pstm.setLong(1, user.getId());
			try (ResultSet result = pstm.executeQuery();) {

				while (result.next()) {
					Ponto ponto = new Ponto();
					ponto.setUser_id(result.getLong("user_id"));
					ponto.setData(result.getDate("data"));
					ponto.setDataEntrada(result.getTime("data_hora_entrada"));
					ponto.setDataAlmoco(result.getTime("data_hora_almoco"));
					ponto.setDataVoltaAlmoco(result.getTime("data_hora_volta_almoco"));
					ponto.setDataSaida(result.getTime("data_hora_saida"));
					pontosList.add(ponto);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

		return pontosList;

	}
	
	public List<Ponto> buscarHistoricoTodosUsuario() {

		List<Ponto> pontosList = new ArrayList<>();

		Connection con = ConnectionFactory.conectar();

		try (PreparedStatement pstm = con.prepareStatement("SELECT * FROM ponto INNER JOIN usuario ON ponto.user_id = usuario.id WHERE tipo = 'user'", Statement.RETURN_GENERATED_KEYS)) {

			try (ResultSet result = pstm.executeQuery();) {

				while (result.next()) {
					Ponto ponto = new Ponto();
					ponto.setId(result.getLong("id"));
					ponto.setUser_id(result.getLong("user_id"));
					ponto.setData(result.getDate("data"));
					ponto.setDataEntrada(result.getTime("data_hora_entrada"));
					ponto.setDataAlmoco(result.getTime("data_hora_almoco"));
					ponto.setDataVoltaAlmoco(result.getTime("data_hora_volta_almoco"));
					ponto.setDataSaida(result.getTime("data_hora_saida"));
					pontosList.add(ponto);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

		return pontosList;

	}

	public List<Ponto> buscarPontosMesAtualDoUsuario(String mesAtual, Usuario user) {

		List<Ponto> pontosList = new ArrayList<>();

		Connection con = ConnectionFactory.conectar();

		try (PreparedStatement pstm = con.prepareStatement(
				"SELECT * FROM ponto WHERE user_id = ? and data like '%" + mesAtual + "%'")) {

			pstm.setLong(1, user.getId());
			try (ResultSet result = pstm.executeQuery();) {

				while (result.next()) {
					Ponto ponto = new Ponto();
					ponto.setUser_id(result.getLong("user_id"));
					ponto.setData(result.getDate("data"));
					ponto.setDataEntrada(result.getTime("data_hora_entrada"));
					ponto.setDataAlmoco(result.getTime("data_hora_almoco"));
					ponto.setDataVoltaAlmoco(result.getTime("data_hora_volta_almoco"));
					ponto.setDataSaida(result.getTime("data_hora_saida"));
					pontosList.add(ponto);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

		return pontosList;

	}

	public Ponto buscarPontoDiaAnteriorDoUsuario(String diaAnterior, Usuario user) {

		Ponto ponto = null;

		Connection con = ConnectionFactory.conectar();

		try (PreparedStatement pstm = con.prepareStatement(
				"SELECT * FROM ponto WHERE user_id = ? and data = '" + diaAnterior + "'")) {

			pstm.setLong(1, user.getId());
			try (ResultSet result = pstm.executeQuery();) {

				while (result.next()) {
					ponto = new Ponto();
					ponto.setUser_id(result.getLong("user_id"));
					ponto.setData(result.getDate("data"));
					ponto.setDataEntrada(result.getTime("data_hora_entrada"));
					ponto.setDataAlmoco(result.getTime("data_hora_almoco"));
					ponto.setDataVoltaAlmoco(result.getTime("data_hora_volta_almoco"));
					ponto.setDataSaida(result.getTime("data_hora_saida"));
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

		return ponto;
	}

	public List<Ponto> buscarPontoSemanaAtualDoUsuario(String inicioSemana, String fimSemana, Usuario user) {

		List<Ponto> pontosList = new ArrayList<>();

		Connection con = ConnectionFactory.conectar();

		try (PreparedStatement pstm = con.prepareStatement("SELECT * FROM ponto WHERE user_id = ? and data >= '"
				+ inicioSemana + "' and data <= '" + fimSemana + "'")) {

			pstm.setLong(1, user.getId());
			try (ResultSet result = pstm.executeQuery();) {

				while (result.next()) {
					Ponto ponto = new Ponto();
					ponto.setUser_id(result.getLong("user_id"));
					ponto.setData(result.getDate("data"));
					ponto.setDataEntrada(result.getTime("data_hora_entrada"));
					ponto.setDataAlmoco(result.getTime("data_hora_almoco"));
					ponto.setDataVoltaAlmoco(result.getTime("data_hora_volta_almoco"));
					ponto.setDataSaida(result.getTime("data_hora_saida"));
					pontosList.add(ponto);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

		return pontosList;
	}
	
	public List<Ponto> buscarPontosMesAtualTodosUsuarios(String mesAtual) {

		List<Ponto> pontosList = new ArrayList<>();

		Connection con = ConnectionFactory.conectar();

		try (PreparedStatement pstm = con.prepareStatement(
				"SELECT * FROM ponto WHERE data like '%" + mesAtual + "%'")) {

			try (ResultSet result = pstm.executeQuery();) {

				while (result.next()) {
					Ponto ponto = new Ponto();
					ponto.setUser_id(result.getLong("user_id"));
					ponto.setData(result.getDate("data"));
					ponto.setDataEntrada(result.getTime("data_hora_entrada"));
					ponto.setDataAlmoco(result.getTime("data_hora_almoco"));
					ponto.setDataVoltaAlmoco(result.getTime("data_hora_volta_almoco"));
					ponto.setDataSaida(result.getTime("data_hora_saida"));
					pontosList.add(ponto);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();

		return pontosList;

	}
	
	public Ponto buscarPonto(Long user_id, String data) {
		
		Connection con = ConnectionFactory.conectar();

		Ponto ponto = null;
		
		try (PreparedStatement pstm = con.prepareStatement("SELECT * FROM ponto where user_id = ? and data = '"+data+"'")) {

			pstm.setLong(1, user_id);
			
			try(ResultSet result = pstm.executeQuery();){
				
				while(result.next()) {
					ponto = new Ponto();
					ponto.setId(result.getLong("id"));
				}
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();
		
		return ponto;
	}
	
	public void editarPonto(Long id, String data, String horaEntrada, String horaAlmoco, String horaVoltaAlmoco,
			String horaSaida) {
		
		Connection con = ConnectionFactory.conectar();

		try (PreparedStatement pstm = con.prepareStatement("UPDATE ponto SET data_hora_entrada = ?, data_hora_almoco = ? "
				+ ", data_hora_volta_almoco = ?, data_hora_saida = ? WHERE id = ?")) {

			pstm.setString(1, data+" "+horaEntrada);
			pstm.setString(2, data+" "+horaAlmoco);
			pstm.setString(3, data+" "+horaVoltaAlmoco);
			pstm.setString(4, data+" "+horaSaida);
			pstm.setLong(5, id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();
		
	}
	
	public void apagarRegistro(Long user_id, String data) {

		Connection con = ConnectionFactory.conectar();

		try (PreparedStatement pstm = con.prepareStatement("DELETE FROM ponto WHERE user_id = ? AND data = '"+data+"'")) {

			pstm.setLong(1, user_id);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}

		ConnectionFactory.desconectar();
		
	}
}
