package Service.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Service.PontoService;

public class ApagarRegistroAdmin implements AcaoInterface{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long user_id = Long.parseLong(req.getParameter("user_id"));
		String data = req.getParameter("data");
		new PontoService().apagarRegistro(user_id, data);;
		return "redirect:entrada?acao=HistoricoUsuarioAdmin";
	}

}
