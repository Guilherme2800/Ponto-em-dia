package Controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 
 * @author Guilherme2800
 *
 */
@WebFilter("/entrada")
public class CronometragemFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		Long init = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		chain.doFilter(request, response);
		
		Long end = System.currentTimeMillis();
		
		System.out.println("Executando ação: "+acao+" | tempo de processamento: " + (end - init) + " ms");
		
	}

}
