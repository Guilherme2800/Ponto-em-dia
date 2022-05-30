package service.acoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Guilherme2800
 *
 */
public interface AcaoInterface {

	public String executar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
}
