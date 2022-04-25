package Service.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.HorasTrabalhadasService;

public class DashbordAdmin implements AcaoInterface{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("listaDashbord", new HorasTrabalhadasService().horasTrabalhadasMesAtualTodosUsuarios());
		return "forward:dashbordAdmin.jsp";
	}

	
	
}
