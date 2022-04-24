<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<title>Ponto em dia - Registrar Ponto</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<%@ include file="css/sidebar.jsp"%>
<%@ include file="css/cardUsuario.jsp"%>


</head>
<body>

	<div id="wrapper" class="toggled ">

		<!-- Sidebar -->
		<div id="sidebar-wrapper"
			class="d-flex flex-column vh-100 flex-shrink-0 p-3 text-white bg-dark">
			<a href="entrada?acao=RegistrarPonto"><img id="logo"
				class="img-responsive" src="img/PontoEmDia.png" /></a>
			<hr>
			<ul class="nav nav-pills flex-column mb-auto">

				<li class="nav-item"><a href="entrada?acao=Dashbord"
					class="nav-link text-white" aria-current="page"> <i
						class="fa fa-home"></i><span class="ms-2">Dashbord</span>
				</a></li>
				<li><a href="entrada?acao=ExibirRegistrar"
					class="nav-link active"> <i class="fa fa-dashboard"></i><span
						class="ms-2">Registrar Ponto</span>
				</a></li>
				<c:if test="${ usuario.tipoUsuario  == 'admin'}"> 
				<li><a href="entrada?acao=HistoricoUsuarioAdmin"
					class="nav-link text-white"> <i class="fa fa-first-order"></i><span
						class="ms-2">Historico de Pontos</span>
				</a></li>
				 </c:if>
				 
				<li><a href="entrada?acao=HistoricoUsuario"
					class="nav-link text-white"> <i class="fa fa-first-order"></i><span
						class="ms-2">Historico de Pontos</span>
				</a></li>
			</ul>
			<hr>

			<div class="dropdown">
				<a href="#"
					class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
					id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
					<img src="https://freesvg.org/img/abstract-user-flat-3.png" alt=""
					width="32" height="32" class="rounded-circle me-2"> <strong>
						${usuario.nome} </strong>
				</a>
				<ul class="dropdown-menu dropdown-menu-dark text-small shadow"
					aria-labelledby="dropdownUser1">
					<li><a class="dropdown-item" href="#">Profile</a></li>
					<li>
						<hr class="dropdown-divider">
					</li>
					<li><a class="dropdown-item" href="entrada?acao=Logout">Sign
							out</a></li>
				</ul>
			</div>



		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div class="container center-block">

			<h1>Registrar Ponto</h1>
			<hr>

			<div class="d-flex justify-content-around">
				<div class="col-md-6 col-lg-4 item shadow-lg p-3 mb-5 bg-body" >
					<div class="box">
						<img class="rounded-circle"
							src="https://freesvg.org/img/abstract-user-flat-3.png">
						<h3 class="name">${usuario.nome}</h3>
						<p class="title">Desenvolvedor</p>
						<p class="description"></p>
						<div class="social">
							<a href="#"><i class="fa fa-facebook-official"></i></a><a
								href="#"><i class="fa fa-twitter"></i></a><a href="#"><i
								class="fa fa-instagram"></i></a>
						</div>
					</div>
				</div>
				
				<div class="col-md-6 col-lg-4 item shadow-lg p-3 mb-5 bg-body" >
					<div class="box">
					<br>
					<br>
						<p>
							<b>Data e hora atual:</b>
							<%@ include file="scripts/DataHoraAtual.jsp"%></p>
						<br>
						<p class="description"></p>
						<div>
							<a href="entrada?acao=RegistrarPonto"
							class="btn btn-success text-center" id="menu-toggle">Registrar
							Ponto</a>
						</div>
					</div>
				</div>
		</div>

	</div>



</body>
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</html>