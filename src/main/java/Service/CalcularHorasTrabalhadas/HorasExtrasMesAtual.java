package service.calcularHorasTrabalhadas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Ponto;
import model.Usuario;

public class HorasExtrasMesAtual extends CalcularHorasTrabalhadas {

	/**
	 * Método que calcula as horas extras trabalhadas no mês atual
	 * do usuário autenticado no sistema
	 * 
	 * @param req
	 * @return
	 */
	@Override
	public String calcularHoras(HttpServletRequest req) {
		List<Ponto> pontosUsuario = pontoService
				.buscarPontosMesAtualDoUsuario((Usuario) req.getSession().getAttribute("usuario"));

		return gerarHoras(pontosUsuario);

	}
	
	/**
	 * Método que calcula as horas extras trabalhadas no mês atual
	 * Do usuário passado como parâmetro
	 * 
	 * @param user
	 * @return
	 */
	public String calcularHoras(Usuario user) {
		List<Ponto> pontosUsuario = pontoService
				.buscarPontosMesAtualDoUsuario(user);

		return gerarHoras(pontosUsuario);

	}
	
	/**
	 * Método que calcula as horas extras trabalhadas no intervalo de tempo informado,
	 * do usuário passado como parâmetro
	 * 
	 * @param user
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public String calcularHoras(Usuario user, String startDate, String endDate) {
		List<Ponto> pontosUsuario = pontoService
				.buscarPontosIntervaloDoUsuario(user, startDate, endDate);

		return gerarHoras(pontosUsuario);
	}
	
	/**
	 * Método que realiza o processamento das horas trabalhadas dos pontos do usuário.
	 * 
	 * @param pontosUsuario
	 * @return
	 */
	private String gerarHoras(List<Ponto> pontosUsuario) {
		
		long totalMinutos = 0l;
		Integer totalHorasExtras = 0;

		for (Ponto ponto : pontosUsuario) {
			pontoService.validarHorarios(ponto);
			totalMinutos += calcularMinutos(ponto);
		}

		totalMinutos *= -1;
		
		for(int i = 0; i < pontosUsuario.size(); i++) {
			totalMinutos -= 480;
		}
		
		while(totalMinutos >= 60) {
			totalHorasExtras++;
			totalMinutos -= 60;
		}
		
		if(totalMinutos < 0) {
			totalMinutos = 0;
		}
		
		return totalHorasExtras.toString() + ":" + (totalMinutos == 0 ? "00" : totalMinutos) + "";
		
	}

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
