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

				<c:if test="${ usuario.tipoUsuario  == 'admin'}">
					<li><a href="entrada?acao=DashbordAdmin"
						class="nav-link text-white"> <i class="fa fa-first-order"></i><span
							class="ms-2">DashBord - Admin</span>
					</a></li>
				</c:if>

				<li class="nav-item"><a href="entrada?acao=Dashbord"
					class="nav-link text-white" aria-current="page"> <i
						class="fa fa-home"></i><span class="ms-2">Dashbord</span>
				</a></li>
				<li><a href="entrada?acao=ExibirRegistrar"
					class="nav-link text-white"> <i class="fa fa-dashboard"></i><span
						class="ms-2">Registrar Ponto</span>
				</a></li>
				<c:if test="${ usuario.tipoUsuario  == 'admin'}">
					<li><a href="entrada?acao=HistoricoUsuarioAdmin"
						class="nav-link text-white"> <i class="fa fa-first-order"></i><span
							class="ms-2">Historico - Admin</span>
					</a></li>
				</c:if>

				<li><a href="entrada?acao=HistoricoUsuario"
					class="nav-link text-white"> <i class="fa fa-first-order"></i><span
						class="ms-2">Historico</span>
				</a></li>

				<c:if test="${ usuario.tipoUsuario  == 'admin'}">
					<li><a href="entrada?acao=ExibirCadastrarUsuario"
						class="nav-link text-white"> <i class="fa fa-first-order"></i><span
							class="ms-2">Cadastrar Usuario</span>
					</a></li>
				</c:if>
			</ul>
			<hr>

			<div class="dropdown">
				<a href="#"
					class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
					id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">

					<c:if test="${usuario.urlImagem != null }">
						<img src="${usuario.urlImagem}" alt="" width="32" height="32"
							class="rounded-circle me-2">
					</c:if> <c:if test="${usuario.urlImagem == null }">
						<img src="img/user-default.png" alt="" width="32" height="32"
							class="rounded-circle me-2">
					</c:if> <strong> ${usuario.nome} </strong>
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

			<h1>Perfil do usuário</h1>
			<hr>

			<div class="container bootstrap snippet">

				<div class="row">
					<div class="col-sm-3">

						<div class="text-center">

							<c:if test="${userFull.urlImagem != null }">
								<img src="${userFull.urlImagem}"
									class="avatar img-circle img-thumbnail" alt="avatar">
							</c:if>
							<c:if test="${userFull.urlImagem == null }">
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
									<div class="form-group">

										<div class="col-xs-6">
											<label for="first_name">Nome</label> <input type="text"
												class="form-control" name="nome" placeholder="Nome Completo"
												title="Nome do usuário" value="${userFull.nome}" readonly>
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
												placeholder="enter phone"
												title="enter your phone number if any."
												value="${userFull.urlImagem}">
										</div>
									</div>

									<div class="form-group">
										<div class="col-xs-12">
											<br>
											<button class="btn btn-lg btn-success" type="submit">
												<i class="glyphicon glyphicon-ok-sign"></i> Salvar Alterações
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