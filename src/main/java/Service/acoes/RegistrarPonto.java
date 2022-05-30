package service.acoes;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import repository.PontoRepository;

/**
 * 
 * @author Guilherme2800
 *
 */
public class RegistrarPonto implements AcaoInterface{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Date date = new Date();
		Usuario user = (Usuario) req.getSession().getAttribute("usuario");
		PontoRepository.getCurrentInstance().inserirPonto(date, user);
		return "redirect:entrada?acao=ExibirRegistrar";
	}

}
