<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

	<a href="#"
		class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
		id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
		<c:if
			test="${usuario.urlImagem != null and usuario.urlImagem != \"\"}">
			<img src="${usuario.urlImagem}" alt="" width="32" height="32"
				class="rounded-circle me-2">
		</c:if> <c:if
			test="${usuario.urlImagem == null or  usuario.urlImagem == \"\"}">
			<img src="img/user-default.png" alt="" width="32" height="32"
				class="rounded-circle me-2">
		</c:if> 
		<strong> ${usuario.nome} </strong>
	</a>
	<ul class="dropdown-menu dropdown-menu-dark text-small shadow"
		aria-labelledby="dropdownUser1">
		<li><a class="dropdown-item" href="entrada?acao=ExibirPerfil">Profile</a></li>
		<li>
			<hr class="dropdown-divider">
		</li>
		<li><a class="dropdown-item" href="entrada?acao=Logout">Sign
				out</a></li>
	</ul>

</body>
</html>