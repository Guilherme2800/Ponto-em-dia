<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<title>Ponto em dia - Meu Perfil</title>
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

    <c:set var="pagina" value="perfil" scope="request" />
	<%@ include file="sideBarV2.jsp"%>

	<!--Container Main start-->
	<div class="height-100 bg-light">
		<div class="container center-block">

			<h1>Perfil do usuário</h1>
			<hr>

			<div class="container bootstrap snippet">

				<div class="row">
					<div class="col-sm-3">

						<div class="text-center">

							<c:if test="${userFull.urlImagem != null and userFull.urlImagem != \"\"}">
								<img src="${userFull.urlImagem}"
									class="avatar img-circle img-thumbnail" alt="avatar">
							</c:if>
							<c:if test="${userFull.urlImagem == null or userFull.urlImagem == \"\"}">
								<img src="img/user-default.png"
									class="avatar img-circle img-thumbnail" alt="avatar">
							</c:if>
						</div>

					</div>

					<div class="col-sm-9">

						<div class="tab-content">
							<div class="tab-pane active" id="home">
								<form class="form" action="entrada?acao=AlterarPerfil"
									method="post" id="registrationForm">

									<div class="row mb-4">
										<div class="col">
											<div class="col-xs-6">
												<label for="first_name">Nome</label> <input type="text"
													class="form-control" name="nome"
													placeholder="Nome Completo" title="Nome do usuário"
													value="${userFull.nome}" readonly>
											</div>
										</div>
										<div class="col">
											<div class="col-xs-6">
												<label for="first_name">CPF</label> <input type="text"
													class="form-control" name="nome"
													placeholder="Nome Completo" title="Nome do usuário"
													value="${userFull.cpf}" readonly>
											</div>
										</div>
									</div>


									<div class="form-group">

										<div class="col-xs-6">
											<label for="phone">Celular</label> <input type="text"
												class="form-control" name="celular"
												placeholder="Informe o numero do seu celular"
												title="Informe o numero do celular"
												value="${userFull.celular}">
										</div>
									</div>

									<div class="form-group">

										<div class="col-xs-6">
											<label for="email">Email</label> <input type="email"
												class="form-control" name="email"
												placeholder="you@email.com" title="enter your email."
												value="${userFull.email}">
										</div>
									</div>

									<div class="form-group">

										<div class="col-xs-6">
											<label for="phone">Url Imagem</label> <input type="text"
												class="form-control" name="url_imagem"
												placeholder="Insira a URL de uma imagem"
												title="Insira a URL de uma imagem"
												value="${userFull.urlImagem}">
										</div>
									</div>

									<div class="form-group">
										<div class="col-xs-12">
											<br>
											<button class="btn btn-lg btn-success" type="submit">
												<i class="glyphicon glyphicon-ok-sign"></i> Salvar
												Alterações
											</button>
										</div>
									</div>
								</form>

							</div>

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