<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="shortcut icon" href="img/favicon-16x16.png" />
<link rel="stylesheet"
	href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
<%@ include file="css/cardUsuario.jsp"%>
</head>

<body id="body-pd">

	<%@ include file="css/sideBarCss.jsp"%>
	<%@ include file="scripts/sideBarScript.jsp"%>

    <c:set var="pagina" value="registrarPonto" scope="request" />
	<%@ include file="sideBarV2.jsp"%>

	<!--Container Main start-->
	<div class="height-100">
		<div class="container center-block">

			<h1>Registrar Ponto</h1>
			<hr>

			<div class="d-flex justify-content-around">
				<div class="col-md-6 col-lg-4 item shadow-lg p-3 mb-5 bg-body">
					<div class="box">

						<c:if
							test="${usuario.urlImagem != null and usuario.urlImagem != \"\"}">
							<img src="${usuario.urlImagem}" class="rounded-circle">
						</c:if>
						<c:if
							test="${usuario.urlImagem == null or usuario.urlImagem == \"\"}">
							<img class="rounded-circle" src="img/user-default.png">
						</c:if>
						<h3 class="name">${usuario.nome}</h3>
						<p class="title">${usuario.cargo}</p>
						<p class="description"></p>
						<div class="social">
							<a href="#"><i class="fa fa-facebook-official"></i></a><a
								href="#"><i class="fa fa-twitter"></i></a><a href="#"><i
								class="fa fa-instagram"></i></a>
						</div>
					</div>
				</div>

				<div class="col-md-6 col-lg-4 item shadow-lg p-3 mb-5 bg-body">
					<div class="box">
						<br> <br>
						<p>
							<b>Data e hora atual:</b>
							<%@ include file="scripts/DataHoraAtual.jsp"%>
						</p>
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
	</div>
</body>
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

</html>