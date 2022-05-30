package service.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TipoUsuario;
import service.UsuarioService;

/**
 * 
 * @author Guilherme2800
 *
 */
public class CadastrarUsuario implements AcaoInterface{

	@Override
	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("nome");
		String nascimento = req.getParameter("nascimento");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		TipoUsuario tipoUsuario = TipoUsuario.valueOf(req.getParameter("tipoUsuario"));
		String cargo = req.getParameter("cargo");
		Long cpf = Long.parseLong(req.getParameter("cpf"));
		
		new UsuarioService().inserirUsuario(nome, nascimento, login, senha, tipoUsuario, cargo, cpf);
		
		return "forward:cadastrarUsuario.jsp";
	}

}
