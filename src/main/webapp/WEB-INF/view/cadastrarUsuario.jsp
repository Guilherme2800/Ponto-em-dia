<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<title>Ponto em dia - Cadastrar usuário</title>
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

<link rel="stylesheet" href="css/sidebar.css"/>
<link rel="stylesheet" href="css/cardUsuario.css"/>

</head>

<body id="body-pd">

    <c:set var="pagina" value="cadastrarUsuario" scope="request" />
	<%@ include file="sideBarV2.jsp"%>

	<!--Container Main start-->
	<div class="height-100 bg-light">
		<div class="container center-block">

			<h1>Cadastrar Usuário</h1>
			<hr>

			<div class="container d-flex justify-content-around ">
				<div class="row">
					<div class="col-sm-15 col-md-15 col-lg-15">

						<form action="entrada?acao=CadastrarUsuario"
							class="shadow-lg p-3 mb-8 rounded border border-success"
							method="post" style="background: #FFFAFA">
							<div class="row mb-4">
								<div class="col">
									<div class="form-outline">
										<input type="text" name="login" class="form-control"
											placeholder="Informe o login" autocomplete="off" required />
										<label class="form-label">Login</label>
									</div>
								</div>
								<div class="col">
									<div class="form-outline">
										<input type="password" name="senha" class="form-control"
											placeholder="Informe a senha" required /> <label
											class="form-label">Senha</label>
									</div>
								</div>
							</div>

							<div class="form-outline mb-4">
								<input type="text" name="nome" class="form-control"
									placeholder="Informe o nome" autocomplete="off" required /> <label
									class="form-label">Nome <small>(Primeiro e
										último)</small></label>
							</div>

							<div class="row mb-4">
								<div class="col">
									<input type="date" name="nascimento" class="form-control"
										autocomplete="off" required /> <label class="form-label">Nascimento</label>
								</div>
								<div class="col">
									<div class="form-outline">
										<input type="text" name="cpf" class="form-control"
											placeholder="Informe o cpf" autocomplete="off" required /> <label
											class="form-label">Cpf <small>(Apenas
												números)</small></label>
									</div>
								</div>
							</div>

							<div class="form-outline mb-4">
								<input type="text" name="cargo" class="form-control"
									placeholder="Informe o cargo" autocomplete="off" required /> <label
									class="form-label">Cargo</label>
							</div>

							<div class="form-outline mb-4">
								<select class="form-select form-select-sm"
									aria-label=".form-select-sm example" name="tipoUsuario"
									required>
									<option selected>Selecione o tipo do usuário</option>
									<option value="admin">Administrador</option>
									<option value="user">Usuário comum</option>
								</select> <label class="form-label">Tipo de usuário</label>
							</div>
							<!-- Submit button -->
							<button type="submit" class="btn btn-success btn-block mb-4">Cadastrar
								Usuário</button>

						</form>

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
<script src="scripts/sidebar.js"></script>	
</html>