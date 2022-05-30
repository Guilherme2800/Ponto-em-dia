package Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import Model.Ponto;
import Model.Usuario;
import Repository.PontoRepository;

/**
 * 
 * @author Guilherme2800
 *
 */
public class PontoService {

	private SimpleDateFormat formatacaoSemdia = new SimpleDateFormat("yyyy-MM");
	private SimpleDateFormat formatacaoSemHora = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat formatacaoComHora = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");

	public Ponto buscarPontoDiaAnteriorDoUsuario(Usuario user) {

		Calendar data = Calendar.getInstance();
		data.add(Calendar.DAY_OF_MONTH, -1);

		return PontoRepository.getCurrentInstance()
				.buscarPontoDiaAnteriorDoUsuario(formatacaoSemHora.format(data.getTime()), user);

	}

	public List<Ponto> buscarPontoSemanaAtualDoUsuario(Usuario user) {

		Date dataAtual = new Date();

		GregorianCalendar calendar = new GregorianCalendar();

		calendar.setFirstDayOfWeek(Calendar.SUNDAY);
		calendar.setTime(dataAtual);

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String inicioSemana = formatacaoSemHora.format(calendar.getTime());

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String fimSemana = formatacaoSemHora.format(calendar.getTime());

		return PontoRepository.getCurrentInstance().buscarPontoSemanaAtualDoUsuario(inicioSemana, fimSemana, user);
	}

	public List<Ponto> buscarPontosMesAtualDoUsuario(Usuario user) {

		Calendar dataAtual = Calendar.getInstance();

		String mesAtual = formatacaoSemdia.format(dataAtual.getTime());

		return PontoRepository.getCurrentInstance().buscarPontosMesAtualDoUsuario(mesAtual, user);

	}
	
	public List<Ponto> buscarPontosIntervaloDoUsuario(Usuario user, String startDate, String endDate) {
		return PontoRepository.getCurrentInstance().buscarPontosIntervaloDoUsuario(user, startDate, endDate);
	}

	public Ponto validarHorarios(Ponto ponto) {

		if (ponto.getDataAlmoco() == null) {
			ponto.setDataAlmoco(ponto.getDataEntrada());
		}

		if (ponto.getDataVoltaAlmoco() == null) {
			ponto.setDataVoltaAlmoco(ponto.getDataAlmoco());
		}

		if (ponto.getDataSaida() == null) {
			ponto.setDataSaida(ponto.getDataVoltaAlmoco());
		}

		return ponto;

	}

	/**
	 * Método que busca o histórico de pontos de todos os usuários do sistema
	 * 
	 * @param dataInicial
	 * @param dataFinal
	 * @return
	 */
	public List<Ponto> buscarHistoricoTodosUsuario(String dataInicial, String dataFinal) {
		return PontoRepository.getCurrentInstance().buscarHistoricoTodosUsuario(dataInicial, dataFinal);
	}

	/**
	 * Método que busca o historico de pontos do usuário autenticado
	 * 
	 * @param user
	 * @param dataInicial
	 * @param dataFinal
	 * @return
	 */
	public List<Ponto> buscarHistoricoDoUsuario(Usuario user, String dataInicial, String dataFinal) {
		return PontoRepository.getCurrentInstance().buscarHistoricoDoUsuario(user, dataInicial, dataFinal);
	}

	/**
	 * Método que remove o registro do ponto de um usuário
	 * 
	 * @param user_id
	 * @param data
	 */
	public void apagarRegistro(Long user_id, String data) {
		PontoRepository.getCurrentInstance().apagarRegistro(user_id, data);
	}

	/**
	 * Método que edita o registro de um ponto do usuário
	 * 
	 * @param user_id
	 * @param data
	 * @param horaEntrada
	 * @param horaAlmoco
	 * @param horaVoltaAlmoco
	 * @param saida
	 */
	public void editarRegistro(Long user_id, String data, String horaEntrada, String horaAlmoco, String horaVoltaAlmoco,
			String saida) {

		PontoRepository pontoRepository = PontoRepository.getCurrentInstance();

		Ponto ponto = pontoRepository.buscarPonto(user_id, data);

		if (ponto != null) {
			pontoRepository.editarPonto(ponto.getId(), data, horaEntrada, horaAlmoco, horaVoltaAlmoco, saida);
		}

	}

}
