package Service.acoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Ponto;
import Model.Usuario;
import Service.PontoService;

/**
 * 
 * @author Guilherme2800
 *
 */
public class HistoricoUsuario implements AcaoInterface{
	
	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String dataInicialString = (String) req.getParameter("dataInicial");
		String dataFinalString = (String) req.getParameter("dataFinal");
		
		if(dataInicialString == null || dataInicialString.isEmpty()
				|| (dataFinalString == null || dataFinalString.isEmpty())) {
			return "forward:historicoPontos.jsp";
		}
		
		Date dataInicial = null;
		Date dataFinal = null;
		try {
			dataInicial = sdf.parse(dataInicialString);
			dataFinal = sdf.parse(dataFinalString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		List<Ponto> pontosUsuario = new PontoService().buscarHistoricoDoUsuario((Usuario) req.getSession().getAttribute("usuario"), sdf.format(dataInicial), sdf.format(dataFinal));
		req.setAttribute("listaPontos", pontosUsuario);
		req.setAttribute("dataInicio", sdf.format(dataInicial));
		req.setAttribute("dataFinal", sdf.format(dataFinal));
		return "forward:historicoPontos.jsp";
	}


}
