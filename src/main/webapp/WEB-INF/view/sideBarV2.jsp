<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>

	<header class="header" id="header">
		<div class="header_toggle">
			<i class='bx bx-menu' id="header-toggle"></i>
		</div>
		<div class="header_img"> 
		   <c:if test="${usuario.urlImagem != null and usuario.urlImagem != ''}">
		      <img src="${usuario.urlImagem}" alt=""> 
		   </c:if>
		   <c:if test="${usuario.urlImagem == null or usuario.urlImagem == ''}">
		      <img src="img/user-default.png" alt=""> 
		   </c:if>
		</div>
	</header>
	<div class="l-navbar" id="nav-bar">
		<nav class="nav">
			<div>
				<a href="entrada?acao=ExibirRegistrar" class="nav_logo"> <i
					class='bx bx-alarm nav_logo-icon'></i> <span class="nav_logo-name">Ponto em Dia</span>
				</a>
				<div class="nav_list">
				    
				    <!-- Pagina de Registrar ponto -->
				    
				    <c:if test="${pagina == 'registrarPonto'}">
				       <a href="entrada?acao=ExibirRegistrar" class="nav_link active"> <i class='bx bx-message-square-detail nav_icon'></i> 
					   <span class="nav_name">Registrar Ponto</span>
					   </a>
				    </c:if>
				    
				    <c:if test="${pagina != 'registrarPonto'}">
				       <a href="entrada?acao=ExibirRegistrar" class="nav_link"> <i class='bx bx-message-square-detail nav_icon'></i> 
					   <span class="nav_name">Registrar Ponto</span>
					   </a>
				    </c:if>
				    
				    <!-- Pagina de dashBord Admin -->
				
				    <c:if test="${ usuario.tipoUsuario  == 'admin'}">
				       <c:if test="${ pagina == 'dashbordAdmin'}"> 
				       <a href="entrada?acao=DashbordAdmin" class="nav_link active"> <i class='bx bx-grid-alt nav_icon'></i> 
					      <span class="nav_name">DashBord - Admin</span>
					      </a>
				       </c:if>
				       
				       <c:if test="${ pagina != 'dashbordAdmin'}"> 
				       <a href="entrada?acao=DashbordAdmin" class="nav_link"> <i class='bx bx-grid-alt nav_icon'></i> 
					      <span class="nav_name">DashBord - Admin</span>
					      </a>
				       </c:if>

				    </c:if>
					
					 <!-- Pagina de dashBord --> 
					
					<c:if test="${ pagina == 'dashbord'}">
					   <a href="entrada?acao=Dashbord" class="nav_link active"> <i class='bx bx-grid-alt nav_icon'></i>
					   <span class="nav_name">Dashbord</span>
					   </a> 
					</c:if>
					
					<c:if test="${ pagina != 'dashbord'}">
					   <a href="entrada?acao=Dashbord" class="nav_link"> <i class='bx bx-grid-alt nav_icon'></i>
					   <span class="nav_name">Dashbord</span>
					   </a> 
					</c:if>  
					
					<!-- Pagina de historico de pontos admin --> 

                    <c:if test="${ usuario.tipoUsuario  == 'admin'}">
                       <c:if test="${ pagina == 'historicoAdmin'}">
                          <a href="entrada?acao=ExibirHistoricoAdmin" class="nav_link active"> <i class='bx bx-folder nav_icon'></i> 
					      <span class="nav_name">Historico - Admin</span>
					      </a> 
                       </c:if>
                       
                       <c:if test="${ pagina != 'historicoAdmin'}">
                          <a href="entrada?acao=ExibirHistoricoAdmin" class="nav_link"> <i class='bx bx-folder nav_icon'></i> 
					      <span class="nav_name">Historico - Admin</span>
					      </a> 
                       </c:if>
					</c:if>
					
					<!-- Pagina de historico de pontos individual --> 
					
					<c:if test="${ pagina == 'historico'}">
					   <a href="entrada?acao=ExibirHistoricoUsuario" class="nav_link active"> <i class='bx bx-folder nav_icon'></i>
					   <span class="nav_name">Historico</span>
					   </a>
					</c:if>
					
					<c:if test="${ pagina != 'historico'}">
					   <a href="entrada?acao=ExibirHistoricoUsuario" class="nav_link"> <i class='bx bx-folder nav_icon'></i>
					   <span class="nav_name">Historico</span>
					   </a>
					</c:if>
					
					<!-- Pagina de historico de cadastro de usu�rios -->  
					
					<c:if test="${ usuario.tipoUsuario  == 'admin'}">
					
					   <c:if test="${ pagina == 'cadastrarUsuario'}">
					      <a href="entrada?acao=ExibirCadastrarUsuario" class="nav_link active"> <i class='bx bx-bar-chart-alt-2 nav_icon'></i> 
					      <span class="nav_name">Cadastrar Usuario</span>
					      </a>
					   </c:if>
					   
					   <c:if test="${ pagina != 'cadastrarUsuario'}">
					      <a href="entrada?acao=ExibirCadastrarUsuario" class="nav_link"> <i class='bx bx-bar-chart-alt-2 nav_icon'></i> 
					      <span class="nav_name">Cadastrar Usuario</span>
					      </a>
					   </c:if>
					   
					</c:if>
					
					
					<c:if test="${ pagina == 'perfil'}">
					      <a href="entrada?acao=ExibirPerfil" class="nav_link active"> <i class='bx bx-user nav_icon'></i> 
					      <span class="nav_name">Meu perfil</span>
					      </a>
					</c:if>
					   
					<c:if test="${ pagina != 'perfil'}">
					      <a href="entrada?acao=ExibirPerfil" class="nav_link"> <i class='bx bx-user nav_icon'></i> 
					      <span class="nav_name">Meu perfil</span>
					      </a>
					</c:if>
					
					
				</div>
			</div>
			<a href="entrada?acao=Logout" class="nav_link"> <i class='bx bx-log-out nav_icon'></i>
				<span class="nav_name">SignOut</span>
			</a>
		</nav>
	</div>

</body>
</html>