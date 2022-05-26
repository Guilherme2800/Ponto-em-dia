package service.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.calcularHorasTrabalhadas.HorasExtrasMesAtual;
import service.calcularHorasTrabalhadas.HorasTrabalhadasDiaAnterior;
import service.calcularHorasTrabalhadas.HorasTrabalhadasMesAtual;
import service.calcularHorasTrabalhadas.HorasTrabalhadasSemanaAtual;

public class Dashbord implements AcaoInterface {

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("horasExtrasMes", new HorasExtrasMesAtual().calcularHoras(req));
		req.setAttribute("horasTrabalhadasMes", new HorasTrabalhadasMesAtual().calcularHoras(req));
		req.setAttribute("intervaloMes", new HorasTrabalhadasMesAtual().intervalo());
		
		req.setAttribute("horasTrabalhadasSemana", new HorasTrabalhadasSemanaAtual().calcularHoras(req));
		req.setAttribute("intervaloSemana", new HorasTrabalhadasSemanaAtual().intervalo());
		
		req.setAttribute("horasTrabalhadasDiaAnterior", new HorasTrabalhadasDiaAnterior().calcularHoras(req));
		req.setAttribute("intervaloDia", new HorasTrabalhadasDiaAnterior().intervalo());
		return "forward:dashbord.jsp";
	}

}
