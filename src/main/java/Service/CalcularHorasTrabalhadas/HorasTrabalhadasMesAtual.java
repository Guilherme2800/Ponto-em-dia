package service.calcularHorasTrabalhadas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Ponto;
import model.Usuario;

public class HorasTrabalhadasMesAtual extends CalcularHorasTrabalhadas {

	/**
	 * Método que calcula as horas trabalhadas no mês atual, do usuário autenticado no sistema
	 * 
	 * @param req
	 * @return Retorna a quantidade de horas trabalhadas do usuário
	 */
	@Override
	public String calcularHoras(HttpServletRequest req) {

		List<Ponto> pontosUsuario = pontoService
				.buscarPontosMesAtualDoUsuario((Usuario) req.getSession().getAttribute("usuario"));

		long totalMinutos = 0l;

		for (Ponto ponto : pontosUsuario) {
			pontoService.validarHorarios(ponto);
			totalMinutos += calcularMinutos(ponto);
		}

		return gerarHorasTrabalhadas(totalMinutos);
	}
	

	/**
	 * Método que calcula as horas trabalhadas no mês atual, do usuário informado no parametro
	 * 
	 * @param user
	 * @return Retorna a quantidade de horas trabalhadas do usuário
	 */
	public String calcularHoras(Usuario user) {

		List<Ponto> pontosUsuario = pontoService
				.buscarPontosMesAtualDoUsuario(user);

		long totalMinutos = 0l;

		for (Ponto ponto : pontosUsuario) {
			pontoService.validarHorarios(ponto);
			totalMinutos += calcularMinutos(ponto);
		}

		return gerarHorasTrabalhadas(totalMinutos);
	}
	
	/**
	 * Método que calcula as horas trabalhadas no intervalo de tempo informado, do usuário passado
	 * como parametro
	 * 
	 * @param user
	 * @param startDate
	 * @param endDate
	 * @return Retorna a quantidade de horas trabalhadas do usuário
	 */
	public String calcularHoras(Usuario user, String startDate, String endDate) {

		List<Ponto> pontosUsuario = pontoService
				.buscarPontosIntervaloDoUsuario(user, startDate, endDate);

		long totalMinutos = 0l;

		for (Ponto ponto : pontosUsuario) {
			pontoService.validarHorarios(ponto);
			totalMinutos += calcularMinutos(ponto);
		}

		return gerarHorasTrabalhadas(totalMinutos);
	}

	/**
	 * @return intervalo de tempo do mês atual
	 */
	@Override
	public String intervalo() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		String inicioMes = df.format(cal.getTime());

		cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		String fimMes = df.format(cal.getTime());

		return inicioMes + " - " + fimMes;
	}

}
