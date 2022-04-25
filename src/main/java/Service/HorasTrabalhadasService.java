package Service;

import java.util.ArrayList;
import java.util.List;

import Model.HorasTrabalhadas;
import Model.Usuario;
import Service.CalcularHorasTrabalhadas.HorasExtrasMesAtual;
import Service.CalcularHorasTrabalhadas.HorasTrabalhadasMesAtual;

public class HorasTrabalhadasService {

	public List<HorasTrabalhadas> horasTrabalhadasMesAtualTodosUsuarios(){
		
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
	
}
