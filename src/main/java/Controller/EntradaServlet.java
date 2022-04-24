package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.TipoUsuario;
import Model.Usuario;
import Service.acoes.AcaoInterface;

@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7369028029074797114L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getSession().getAttribute("usuario") == null) {
			resp.sendRedirect("/PontoEmDia/login");
			return;
		}

		String acao = req.getParameter("acao");
		String metodo = null;

		if(acao != null && acao.contains("Admin")) {
			Usuario user = (Usuario) req.getSession().getAttribute("usuario");
			if(user.getTipoUsuario() != TipoUsuario.admin) {
				resp.sendRedirect("/PontoEmDia/login");
				return;
			}
		}
		
		try {
			AcaoInterface newInstance = (AcaoInterface) Class.forName("Service.acoes." + acao).newInstance();
			metodo = newInstance.executar(req, resp);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		String[] split = metodo.split(":");
		if (split[0].equals("redirect")) {
			resp.sendRedirect(split[1]);
			return;
		}else if(split[0].equals("forward")){
			req.getRequestDispatcher("WEB-INF/view/"+split[1]).forward(req, resp);
			return;
		}
	}

}
