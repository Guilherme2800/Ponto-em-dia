package service.calcularHorasTrabalhadas;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import model.Ponto;
import model.Usuario;

public class HorasTrabalhadasDiaAnterior extends CalcularHorasTrabalhadas {

	@Override
	public String calcularHoras(HttpServletRequest req) {

		long totalMinutos = 0l;

		Ponto ponto = pontoService.buscarPontoDiaAnteriorDoUsuario((Usuario) req.getSession().getAttribute("usuario"));

		if(ponto == null) {
			return "0";
		}
		pontoService.validarHorarios(ponto);

		return gerarHorasTrabalhadas(totalMinutos);
	}

	@Override
	public String intervalo() {
		Calendar data = Calendar.getInstance();
		data.add(Calendar.DAY_OF_MONTH, -1);

		return new SimpleDateFormat("dd/MM/yyyy").format(data.getTime());
	}

}
