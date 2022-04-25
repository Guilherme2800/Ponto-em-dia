package Service.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Usuario;
import Service.UsuarioService;

public class AlterarPerfil implements AcaoInterface{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long celular = 0l;
		
		if(req.getParameter("celular") != null && !req.getParameter("celular").isEmpty()) {
			celular = Long.parseLong(req.getParameter("celular"));
		}

		String email = req.getParameter("email");
		String urlImagem = req.getParameter("url_imagem");
		
		Usuario user = (Usuario) req.getSession().getAttribute("usuario");
		
		new UsuarioService().atualizarPerfil(user.getId(), celular, email, urlImagem);
		
		atualizarUsuarioSession(req, urlImagem);
		
		return "redirect:entrada?acao=ExibirPerfil";
	}
	
	private void atualizarUsuarioSession(HttpServletRequest req, String urlImagem) {
		Usuario user = (Usuario) req.getSession().getAttribute("usuario");
		user.setUrlImagem(urlImagem);
	}

	
	
}
