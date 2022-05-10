package Controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class AutenticadoFilter
 */
@WebFilter("/entrada")
public class AutenticadoFilter extends HttpFilter implements Filter {
       
	/**
	 * 
	 */
	private static final long serialVersionUID = 6829750339736856574L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if (req.getSession().getAttribute("usuario") == null) {
			resp.sendRedirect("/PontoEmDia/login");
			return;
		}
		
		chain.doFilter(request, response);
	}


}
