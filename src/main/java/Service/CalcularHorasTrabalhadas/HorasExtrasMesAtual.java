package service.calcularHorasTrabalhadas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Ponto;
import model.Usuario;

public class HorasExtrasMesAtual extends CalcularHorasTrabalhadas {

	/**
	 * M�todo que calcula as horas extras trabalhadas no m�s atual
	 * do usu�rio autenticado no sistema
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
	 * M�todo que calcula as horas extras trabalhadas no m�s atual
	 * Do usu�rio passado como par�metro
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
	 * M�todo que calcula as horas extras trabalhadas no intervalo de tempo informado,
	 * do usu�rio passado como par�metro
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
	 * M�todo que realiza o processamento das horas trabalhadas dos pontos do usu�rio.
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
