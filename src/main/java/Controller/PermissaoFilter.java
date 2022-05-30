package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TipoUsuario;
import model.Usuario;

/**
 * 
 * @author Guilherme2800
 *
 */
@WebFilter("/entrada")
public class PermissaoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;

		HttpServletResponse resp = (HttpServletResponse) response;

		String acao = req.getParameter("acao");

		if (acao != null && acao.contains("Admin")) {
			Usuario user = (Usuario) req.getSession().getAttribute("usuario");
			if (user.getTipoUsuario() != TipoUsuario.admin) {
				req.getSession().invalidate();
				resp.sendRedirect("/PontoEmDia/login");
				return;
			}
		}

		chain.doFilter(request, response);

	}

}
