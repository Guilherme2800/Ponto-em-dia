package service.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Guilherme2800
 *
 */
public class ExibirHistoricoUsuario implements AcaoInterface{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("dataInicio", "");
		req.setAttribute("dataFinal", "");
		return "forward:historicoPontos.jsp";
	}

}
