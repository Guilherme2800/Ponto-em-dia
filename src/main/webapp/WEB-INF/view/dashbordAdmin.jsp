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
<link rel="shortcut icon" href="img/favicon-16x16.png" />
<%@ include file="css/sidebar.jsp"%>
<%@ include file="css/dashbord.jsp"%>
</head>

<body>

	<div id="wrapper" class="toggled ">

		<!-- Sidebar -->
		<div id="sidebar-wrapper"
			class="d-flex flex-column vh-100 flex-shrink-0 p-3 text-white bg-dark">
			
			<c:set var="pagina" value="dashbordAdmin" scope="request" />
			<%@ include file="opcoesSideBar.jsp"%>

			<div class="dropdown">
				<%@ include file="footerSideBar.jsp"%>
			</div>

		</div>
		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div class="container center-block">

			<h1>DashBord - Todos usuários</h1>
			<hr>

			<c:forEach items="${listaDashbord}" var="dadosUsuario">

				<div class="card shadow-lg p-3 mb-5 bg-body rounded ">
					<div class="card-header">
						<h4>Registros de ${dadosUsuario.nome_user } | id:
							${dadosUsuario.id_user }</h4>
					</div>
					<div class="card-body">
						<div class="container">
							<div class="row">
								<div class="col-md-4 col-xl-4">
									<div class="card bg-c-blue order-card">
										<div class="card-block">
											<h6 class="m-b-20">Total horas trabalhadas - Mês atual</h6>
											<h2 class="text-right">
												<i class="fa fa-cart-plus f-left"></i><span>${dadosUsuario.totalHorasMesAtual}
													Horas</span>
											</h2>
											<p class="m-b-0">
												Período: <span class="f-right">${dadosUsuario.intervalo }</span>
											</p>
										</div>
									</div>
								</div>

								<div class="col-md-4 col-xl-4">
									<div class="card bg-c-pink order-card">
										<div class="card-block">
											<h6 class="m-b-20">Total horas extras trabalhadas - Mês
												atual</h6>
											<h2 class="text-right">
												<i class="fa fa-rocket f-left"></i><span>${dadosUsuario.totalHorasExtrasMesAtual}
													Horas</span>
											</h2>
											<p class="m-b-0">
												Período: <span class="f-right">${dadosUsuario.intervalo }</span>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</c:forEach>

		</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>

</html>