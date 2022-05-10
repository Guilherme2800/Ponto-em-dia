<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<title>Ponto em Dia - Historico</title>
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

<link href="//cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

<link rel="stylesheet" href="css/sidebar.css" />
<link rel="stylesheet" href="css/historicoPontos.css" />

</head>


<body id="body-pd">

	<c:set var="pagina" value="historico" scope="request" />
	<%@ include file="sideBarV2.jsp"%>

	<!--Container Main start-->

	<div class="container center-block">

		<h1>Historico de pontos registrados</h1>
		<hr>
		<div class="shadow-sm p-3 mb-5 bg-body rounded inputDatas">
			<label><b>Filtragem de dados</b></label>
			<form action="entrada?acao=HistoricoUsuario" method="post">
				<label>Data inicial: </label> <input type="date" name="dataInicial">
				<label>Data final: <input type="date" name="dataFinal">
					<input type="submit" value="Pesquisar" class="btn btn-success">
				</label>
			</form>
		</div>

		<div class="shadow-sm p-3 mb-5 bg-body rounded tabelaPontos">
			<c:if test="${dataInicio != ''}">
				<small><b>Periodo: ${dataInicio} até ${dataFinal}</b></small>
				<br>
			</c:if>
			<br>
			<table class="table" id="tabelaHistorico">
				<thead>
					<tr>
						<th>Id usuario</th>
						<th>Data</th>
						<th>Horario chegada</th>
						<th>Horario Almoco</th>
						<th>Horario volta do Almoco</th>
						<th>Horario saida</th>
					</tr>

				</thead>
				<tbody>

					<c:forEach items="${listaPontos}" var="ponto">
						<tr>
							<td>${ponto.user_id}</td>
							<td>${ponto.data}</td>
							<td>${ponto.dataEntrada}</td>
							<td>${ponto.dataAlmoco}</td>
							<td>${ponto.dataVoltaAlmoco}</td>
							<td>${ponto.dataSaida}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>

		<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
		<script src="//cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>


	</div>
	<script>
		$(document)
				.ready(
						function() {
							$('#tabelaHistorico')
									.DataTable(
											{
												"language" : {
													"lengthMenu" : "Registros por página:  _MENU_",
													"zeroRecords" : "Nada encontrado - Utilize o formulário acima",
													"info" : "Mostrando página _PAGE_ de _PAGES_",
													"infoEmpty" : "Nenhum registro disponível",
													"infoFiltered" : "(filtrado de _MAX_ registros no total)"
												}
											});
						});
	</script>
</body>



<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<script src="scripts/sidebar.js"></script>

</html>