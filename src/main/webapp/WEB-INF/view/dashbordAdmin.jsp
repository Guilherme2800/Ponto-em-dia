<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ponto em Dia - Dashbord</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<%@ include file="css/sidebar.jsp"%>
<%@ include file="css/dashbord.jsp"%>
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

				<li class="nav-item"><a href="entrada?acao=Dashbord" class="nav-link active"
					aria-current="page"> <i class="fa fa-home"></i><span
						class="ms-2">Dashbord</span>
				</a></li>
				<li><a href="entrada?acao=ExibirRegistrar"
					class="nav-link text-white"> <i class="fa fa-dashboard"></i><span
						class="ms-2">Registrar Ponto</span>
				</a></li>
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
					<img src="https://freesvg.org/img/abstract-user-flat-3.png" alt="" width="32" height="32"
					class="rounded-circle me-2"> <strong>
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

			<h1>DashBord</h1>
			<hr>



			<div class="card shadow-lg p-3 mb-5 bg-body rounded ">
				<div class="card-header"><h4>Total horas trabalhadas</h4></div>
				<div class="card-body">
					<div class="container">
						<div class="row">
							<div class="col-md-4 col-xl-4">
								<div class="card bg-c-blue order-card">
									<div class="card-block">
										<h6 class="m-b-20">Mês atual</h6>
										<h2 class="text-right">
											<i class="fa fa-cart-plus f-left"></i><span>${horasTrabalhadasMes} Horas</span>
										</h2>
										<p class="m-b-0">
											Período: <span class="f-right">${intervaloMes }</span>
										</p>
									</div>
								</div>
							</div>

							<div class="col-md-4 col-xl-4">
								<div class="card bg-c-pink order-card">
									<div class="card-block">
										<h6 class="m-b-20">Semana atual</h6>
										<h2 class="text-right">
											<i class="fa fa-rocket f-left"></i><span>${horasTrabalhadasSemana} Horas</span>
										</h2>
										<p class="m-b-0">
											Período: <span class="f-right">${intervaloSemana}</span>
										</p>
									</div>
								</div>
							</div>

							<div class="col-md-4 col-xl-4">
								<div class="card bg-c-yellow order-card">
									<div class="card-block">
										<h6 class="m-b-20">Dia Anterior</h6>
										<h2 class="text-right">
											<i class="fa fa-refresh f-left"></i><span>${horasTrabalhadasDiaAnterior} Horas</span>
										</h2>
										<p class="m-b-0">
											Período: <span class="f-right">${intervaloDia}</span>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="card shadow-lg p-3 mb-5 bg-body rounded ">
				<div class="card-header"><h4>Horas extras trabalhadas</h4></div>
				<div class="card-body">
					<div class="container">
						<div class="row">
							<div class="col-md-4 col-xl-4">
								<div class="card bg-c-blue order-card">
									<div class="card-block">
										<h6 class="m-b-20">Mês atual</h6>
										<h2 class="text-right">
											<i class="fa fa-cart-plus f-left"></i><span>${horasExtrasMes} Horas</span>
										</h2>
										<p class="m-b-0">
											Período: <span class="f-right">${intervaloMes }</span>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>


<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</body>
</html>