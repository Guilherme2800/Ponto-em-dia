package Service.CalcularHorasTrabalhadas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import Model.Ponto;
import Model.Usuario;

public class HorasTrabalhadasSemanaAtual extends CalcularHorasTrabalhadas {

	@Override
	public String calcularHoras(HttpServletRequest req) {

		List<Ponto> pontosUsuario = pontoService
				.buscarPontoSemanaAtualDoUsuario((Usuario) req.getSession().getAttribute("usuario"));

		long totalMinutos = 0l;
		Integer totalHoras = 0;

		for (Ponto ponto : pontosUsuario) {

			pontoService.validarHorarios(ponto);
			totalMinutos += this.calcularMinutos(ponto);

		}

		totalMinutos *= -1;
		while (totalMinutos >= 60) {
			totalMinutos -= 60;
			totalHoras++;
		}

		return totalHoras.toString() + ":" + (totalMinutos == 0 ? "00" : totalMinutos) + "";
	}

	@Override
	public String intervalo() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

		Date dataAtual = new Date();

		GregorianCalendar calendar = new GregorianCalendar();

		calendar.setFirstDayOfWeek(Calendar.SUNDAY);
		calendar.setTime(dataAtual);

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		String inicioSemana = df.format(calendar.getTime());

		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		String fimSemana = df.format(calendar.getTime());

		return inicioSemana + " - " + fimSemana;
	}

}
