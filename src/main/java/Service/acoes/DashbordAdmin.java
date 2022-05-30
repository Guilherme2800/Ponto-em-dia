package Service.acoes;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.HorasTrabalhadasService;

/**
 * Classe para realizar processamento do dashBord 
 * de usuário admin.
 * 
 * @author guilh
 * 
*/
public class DashbordAdmin implements AcaoInterface{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		String dataInicialString = (String) req.getParameter("dataInicial");
		String dataFinalString = (String) req.getParameter("dataFinal");

		if (dataInicialString == null || dataInicialString.isEmpty()
				|| (dataFinalString == null || dataFinalString.isEmpty())) {
			req.setAttribute("listaDashbord", new HorasTrabalhadasService().horasTrabalhadasMesAtualTodosUsuarios());
		}else {
			
			Date dataInicial = null;
			Date dataFinal = null;
			try {
				dataInicial = sdf.parse(dataInicialString);
				dataFinal = sdf.parse(dataFinalString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			req.setAttribute("listaDashbord", new HorasTrabalhadasService().horasTrabalhadasIntervaloTodosUsuarios(sdf.format(dataInicial),
					sdf.format(dataFinal)));
			
		}
		
		
		return "forward:dashbordAdmin.jsp";
	}

	
	
}
