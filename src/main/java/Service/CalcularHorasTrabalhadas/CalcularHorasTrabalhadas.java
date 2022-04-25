package Service.CalcularHorasTrabalhadas;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import Model.Ponto;
import Service.PontoService;

public abstract class CalcularHorasTrabalhadas {

	protected PontoService pontoService = new PontoService();
	
	public abstract String calcularHoras(HttpServletRequest req);
	
	public abstract String intervalo();
	
	public Long calcularMinutos(Ponto ponto) {
		
		Long totalMilesegundos = ponto.getDataEntrada().getTime() - ponto.getDataAlmoco().getTime()
				+ ponto.getDataVoltaAlmoco().getTime() - ponto.getDataSaida().getTime();
		
		TimeUnit time = TimeUnit.MINUTES;
		return time.convert(totalMilesegundos, TimeUnit.MILLISECONDS);
		
	}
	
	public String gerarHorasTrabalhadas(Long minutosTrabalhados) {
		
		Long totalHoras = 0l;
		
		if(minutosTrabalhados < 0) {
			minutosTrabalhados *= -1;
		}
		
		while (minutosTrabalhados >= 60) {
			minutosTrabalhados -= 60;
			totalHoras++;
		}
		
		if(minutosTrabalhados < 10) {
			return totalHoras.toString() + ":" + (minutosTrabalhados == 0 ? "00" : "0"+minutosTrabalhados) + "";
		}

		return totalHoras.toString() + ":" + (minutosTrabalhados == 0 ? "00" : minutosTrabalhados) + "";
	}
	
}
