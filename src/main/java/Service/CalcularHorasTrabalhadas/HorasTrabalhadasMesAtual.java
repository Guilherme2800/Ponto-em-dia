package Service.CalcularHorasTrabalhadas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Model.Ponto;
import Model.Usuario;

public class HorasTrabalhadasMesAtual extends CalcularHorasTrabalhadas {

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
