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
	
}
