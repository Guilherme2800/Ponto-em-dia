package Service;

import java.util.ArrayList;
import java.util.List;

import Model.HorasTrabalhadas;
import Model.Usuario;
import Service.CalcularHorasTrabalhadas.HorasExtrasMesAtual;
import Service.CalcularHorasTrabalhadas.HorasTrabalhadasMesAtual;

/**
 * 
 * @author Guilherme2800
 *
 */
public class HorasTrabalhadasService {

	/**
	 * M�todo que processa os dados de horas trabalhadas do m�s atual para todos usu�rios
	 * 
	 * @return
	 */
	public List<HorasTrabalhadas> horasTrabalhadasMesAtualTodosUsuarios() {

		List<HorasTrabalhadas> listaHorasTrabalhadas = new ArrayList<HorasTrabalhadas>();

		List<Usuario> listaUsuarios = new UsuarioService().buscarTodosUsuario();

		for (Usuario usuario : listaUsuarios) {

			String horasTrabalhadas = new HorasTrabalhadasMesAtual().calcularHoras(usuario);
			String horasExtrasTrabalhadas = new HorasExtrasMesAtual().calcularHoras(usuario);
			String intervalo = new HorasTrabalhadasMesAtual().intervalo();

			HorasTrabalhadas registro = new HorasTrabalhadas();
			registro.setTotalHorasExtrasMesAtual(horasExtrasTrabalhadas);
			registro.setTotalHorasMesAtual(horasTrabalhadas);
			registro.setIntervalo(intervalo);
			registro.setNome_user(usuario.getNome());
			registro.setId_user(usuario.getId());
			listaHorasTrabalhadas.add(registro);

		}

		return listaHorasTrabalhadas;

	}

	/**
	 * M�todo que processa os dados de horas trabalhadas no intervalo de tempo informado pelo usu�rio Admin, 
	 * para todos os usu�rios
	 * 
	 * @return Lista de horas trabalhadas de todos usu�rios
	 */
	public List<HorasTrabalhadas> horasTrabalhadasIntervaloTodosUsuarios(String startDate, String endDate) {

		List<HorasTrabalhadas> listaHorasTrabalhadas = new ArrayList<HorasTrabalhadas>();

		List<Usuario> listaUsuarios = new UsuarioService().buscarTodosUsuario();

		for (Usuario usuario : listaUsuarios) {

			String horasTrabalhadas = new HorasTrabalhadasMesAtual().calcularHoras(usuario, startDate, endDate);
			String horasExtrasTrabalhadas = new HorasExtrasMesAtual().calcularHoras(usuario, startDate, endDate);
			String intervalo = startDate + " - " + endDate;

			HorasTrabalhadas registro = new HorasTrabalhadas();
			registro.setTotalHorasExtrasMesAtual(horasExtrasTrabalhadas);
			registro.setTotalHorasMesAtual(horasTrabalhadas);
			registro.setIntervalo(intervalo);
			registro.setNome_user(usuario.getNome());
			registro.setId_user(usuario.getId());
			listaHorasTrabalhadas.add(registro);

		}

		return listaHorasTrabalhadas;

	}

}
