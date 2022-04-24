package Service.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TipoUsuario;
import Service.UsuarioService;

public class CadastrarUsuario implements AcaoInterface{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String nascimento = req.getParameter("nascimento");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		TipoUsuario tipoUsuario = TipoUsuario.valueOf(req.getParameter("tipoUsuario"));
		String cargo = req.getParameter("cargo");
		
		new UsuarioService().inserirUsuario(nome, nascimento, login, senha, tipoUsuario, cargo);
		
		return "forward:cadastrarUsuario.jsp";
	}

}
