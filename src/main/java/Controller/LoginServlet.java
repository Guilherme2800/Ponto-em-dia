package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import service.UsuarioService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7238838170063760770L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String senha = req.getParameter("senha");

		if (login == null || senha == null) {
			resp.sendRedirect("FormularioLogin.jsp");
			return;
		}

		Usuario usuarioBucado = new UsuarioService().buscarUsuario(login, senha);
		if (usuarioBucado != null) {
			req.getSession().setAttribute("usuario", usuarioBucado);
		}
		resp.sendRedirect("entrada?acao=ExibirRegistrar");

	}

}
