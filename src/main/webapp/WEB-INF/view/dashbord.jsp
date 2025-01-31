<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<title>Ponto em dia - Dashbord</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

<link rel="shortcut icon" href="img/favicon-16x16.png" />

<link rel="stylesheet" href="css/dashbord.css"/>
<link rel="stylesheet" href="css/sidebar.css"/>
</head>

<body id="body-pd">

	<c:set var="pagina" value="dashbord" scope="request" />
	<%@ include file="sideBarV2.jsp"%>


	<!--Container Main start-->
	<div class="height-100" >
		<div class="container center-block">

			<h1>DashBord - ${usuario.nome}</h1>
			<hr>


			<div id="listaUsuarios">
				<div class="card">
					<div class="card-header headerCard">
						<h4>Total horas trabalhadas</h4>
					</div>
					<div class="card-body">
						<div class="container">
							<div class="row">
								<div class="col-md-4 col-xl-4">
									<div class="card bg-c-blue order-card">
										<div class="card-block">
											<h6 class="m-b-20">M�s atual</h6>
											<h2 class="text-right">
												<i class="fa fa-cart-plus f-left"></i><span>${horasTrabalhadasMes}
													Horas</span>
											</h2>
											<p class="m-b-0">
												Per�odo: <span class="f-right">${intervaloMes }</span>
											</p>
										</div>
									</div>
								</div>

								<div class="col-md-4 col-xl-4">
									<div class="card bg-c-pink order-card">
										<div class="card-block">
											<h6 class="m-b-20">Semana atual</h6>
											<h2 class="text-right">
												<i class="fa fa-rocket f-left"></i><span>${horasTrabalhadasSemana}
													Horas</span>
											</h2>
											<p class="m-b-0">
												Per�odo: <span class="f-right">${intervaloSemana}</span>
											</p>
										</div>
									</div>
								</div>

								<div class="col-md-4 col-xl-4">
									<div class="card bg-c-yellow order-card">
										<div class="card-block">
											<h6 class="m-b-20">Dia Anterior</h6>
											<h2 class="text-right">
												<i class="fa fa-refresh f-left"></i><span>${horasTrabalhadasDiaAnterior}
													Horas</span>
											</h2>
											<p class="m-b-0">
												Per�odo: <span class="f-right">${intervaloDia}</span>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div class="card">
					<div class="card-header headerCard">
						<h4>Horas extras trabalhadas</h4>
					</div>
					<div class="card-body">
						<div class="container">
							<div class="row">
								<div class="col-md-4 col-xl-4">
									<div class="card bg-c-blue order-card">
										<div class="card-block">
											<h6 class="m-b-20">M�s atual</h6>
											<h2 class="text-right">
												<i class="fa fa-cart-plus f-left"></i><span>${horasExtrasMes}
													Horas</span>
											</h2>
											<p class="m-b-0">
												Per�odo: <span class="f-right">${intervaloMes }</span>
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
	</div>
</body>

<script src="scripts/sidebar.js"></script>	
</html>