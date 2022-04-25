<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

	<a href="entrada?acao=RegistrarPonto"><img id="logo"
		class="img-responsive" src="img/PontoEmDia.png" /></a>
	<hr>
	<ul class="nav nav-pills flex-column mb-auto">

		<!-- Pagina dashBord Admin -->

		<c:if test="${ usuario.tipoUsuario  == 'admin'}">
			<c:if test="${pagina == 'dashbordAdmin' }">
				<li><a href="entrada?acao=DashbordAdmin"
					class="nav-link active"> <i class="fa fa-first-order"></i><span
						class="ms-2">DashBord - Admin</span>
				</a></li>
			</c:if>

			<c:if test="${pagina != 'dashbordAdmin' }">
				<li><a href="entrada?acao=DashbordAdmin"
					class="nav-link text-white"> <i class="fa fa-first-order"></i><span
						class="ms-2">DashBord - Admin</span>
				</a></li>
			</c:if>
		</c:if>

		<!-- Pagina dashBord usuário -->

		<c:if test="${pagina == 'dashbord' }">
			<li class="nav-item"><a href="entrada?acao=Dashbord"
				class="nav-link active" aria-current="page"> <i
					class="fa fa-home"></i><span class="ms-2">Dashbord</span>
			</a></li>
		</c:if>

		<c:if test="${pagina != 'dashbord' }">
			<li class="nav-item"><a href="entrada?acao=Dashbord"
				class="nav-link text-white" aria-current="page"> <i
					class="fa fa-home"></i><span class="ms-2">Dashbord</span>
			</a></li>
		</c:if>


		<!-- Pagina Registrar Ponto -->

		<c:if test="${pagina == 'registrarPonto' }">
			<li><a href="entrada?acao=ExibirRegistrar"
				class="nav-link active"> <i class="fa fa-dashboard"></i><span
					class="ms-2">Registrar Ponto</span>
			</a></li>
		</c:if>

		<c:if test="${pagina != 'registrarPonto' }">
			<li><a href="entrada?acao=ExibirRegistrar"
				class="nav-link text-white"> <i class="fa fa-dashboard"></i><span
					class="ms-2">Registrar Ponto</span>
			</a></li>
		</c:if>

		<!-- Pagina Historico de pontos Admin -->

		<c:if test="${ usuario.tipoUsuario  == 'admin'}">
			<c:if test="${pagina == 'historicoAdmin' }">
				<li><a href="entrada?acao=HistoricoUsuarioAdmin"
					class="nav-link active"> <i class="fa fa-first-order"></i><span
						class="ms-2">Historico - Admin</span>
				</a></li>
			</c:if>

			<c:if test="${pagina != 'historicoAdmin' }">
				<li><a href="entrada?acao=HistoricoUsuarioAdmin"
					class="nav-link text-white"> <i class="fa fa-first-order"></i><span
						class="ms-2">Historico - Admin</span>
				</a></li>
			</c:if>
		</c:if>

		<!-- Pagina Historico de pontos usuario individual -->

		<c:if test="${pagina == 'historico' }">
			<li><a href="entrada?acao=HistoricoUsuario"
				class="nav-link active"> <i class="fa fa-first-order"></i><span
					class="ms-2">Historico</span>
			</a></li>
		</c:if>

		<c:if test="${pagina != 'historico' }">
			<li><a href="entrada?acao=HistoricoUsuario"
				class="nav-link text-white"> <i class="fa fa-first-order"></i><span
					class="ms-2">Historico</span>
			</a></li>
		</c:if>

		<!-- Pagina Cadastrar usuario -->


		<c:if test="${ usuario.tipoUsuario  == 'admin'}">
			<c:if test="${pagina == 'cadastrarUsuario' }">
				<li><a href="entrada?acao=ExibirCadastrarUsuario"
					class="nav-link active"> <i class="fa fa-first-order"></i><span
						class="ms-2">Cadastrar Usuario</span>
				</a></li>
			</c:if>

			<c:if test="${pagina != 'cadastrarUsuario' }">
				<li><a href="entrada?acao=ExibirCadastrarUsuario"
					class="nav-link text-white"> <i class="fa fa-first-order"></i><span
						class="ms-2">Cadastrar Usuario</span>
				</a></li>
			</c:if>
		</c:if>
	</ul>
	<hr>

</body>
</html>