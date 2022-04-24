package Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import Model.Ponto;
import Model.Usuario;
import Repository.PontoRepository;

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

	public Ponto validarHorarios(Ponto ponto) {

		String format = formatacaoSemHora.format(ponto.getData());
		try {
			if (ponto.getDataAlmoco() == null) {
				ponto.setDataAlmoco(formatacaoComHora.parse(format + " 12:00:00"));
			}

			if (ponto.getDataVoltaAlmoco() == null) {
				ponto.setDataVoltaAlmoco(formatacaoComHora.parse(format + " 14:00:00"));
			}

			if (ponto.getDataSaida() == null) {
				ponto.setDataSaida(formatacaoComHora.parse(format + " 18:00:00"));
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return ponto;

	}

	public List<Ponto> buscarHistoricoTodosUsuario() {
		return PontoRepository.getCurrentInstance().buscarHistoricoTodosUsuario();
	}

	public List<Ponto> buscarHistoricoDoUsuario(Usuario user) {
		return PontoRepository.getCurrentInstance().buscarHistoricoDoUsuario(user);
	}

	public void apagarRegistro(Long user_id, String data) {
		PontoRepository.getCurrentInstance().apagarRegistro(user_id, data);
	}

	public void editarRegistro(Long user_id, String data, String horaEntrada, String horaAlmoco, String horaVoltaAlmoco,
			String saida) {
		
		PontoRepository pontoRepository = PontoRepository.getCurrentInstance();
		
		Ponto ponto = pontoRepository.buscarPonto(user_id, data);
		
		if(ponto != null) {
			pontoRepository.editarPonto(ponto.getId(), data, horaEntrada, horaAlmoco, horaVoltaAlmoco, saida);
		}
		
	}

}
