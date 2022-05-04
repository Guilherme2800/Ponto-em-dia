<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<title>Ponto em dia - Dashbord Admin</title>
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

<%@ include file="css/dashbord.jsp"%>
</head>

<body id="body-pd">

	<%@ include file="css/sideBarCss.jsp"%>
	<%@ include file="scripts/sideBarScript.jsp"%>

	<c:set var="pagina" value="dashbordAdmin" scope="request" />
	<%@ include file="sideBarV2.jsp"%>

	<!--Container Main start-->
	<div class="height-100 bg-light">
		<div class="container center-block">

			<h1>DashBord - Todos usu�rios</h1>
			<hr>

			<div id="listaUsuarios">
				<c:forEach items="${listaDashbord}" var="dadosUsuario">

					<div class="card shadow-sm p-3 mb-5 bg-body rounded ">
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
												<h6 class="m-b-20">Total horas trabalhadas - M�s atual</h6>
												<h2 class="text-right">
													<i class="fa fa-cart-plus f-left"></i><span>${dadosUsuario.totalHorasMesAtual}
														Horas</span>
												</h2>
												<p class="m-b-0">
													Per�odo: <span class="f-right">${dadosUsuario.intervalo }</span>
												</p>
											</div>
										</div>
									</div>

									<div class="col-md-4 col-xl-4">
										<div class="card bg-c-pink order-card">
											<div class="card-block">
												<h6 class="m-b-20">Total horas extras trabalhadas - M�s
													atual</h6>
												<h2 class="text-right">
													<i class="fa fa-rocket f-left"></i><span>${dadosUsuario.totalHorasExtrasMesAtual}
														Horas</span>
												</h2>
												<p class="m-b-0">
													Per�odo: <span class="f-right">${dadosUsuario.intervalo }</span>
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
	</div>
</body>

</html>