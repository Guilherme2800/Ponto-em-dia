package Service.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Usuario;
import Service.UsuarioService;

public class ExibirPerfil implements AcaoInterface{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario user = (Usuario) req.getSession().getAttribute("usuario");
		Usuario userFull = new UsuarioService().buscarUsuario(user.getId());
		req.setAttribute("userFull", userFull);
		return "forward:perfil.jsp";
	}

	
	
}
