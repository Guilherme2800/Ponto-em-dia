package Service.acoes;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Usuario;
import Repository.PontoRepository;

public class RegistrarPonto implements AcaoInterface{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Date date = new Date();
		Usuario user = (Usuario) req.getSession().getAttribute("usuario");
		PontoRepository.getCurrentInstance().inserirPonto(date, user);
		return "redirect:entrada?acao=ExibirRegistrar";
	}

}
