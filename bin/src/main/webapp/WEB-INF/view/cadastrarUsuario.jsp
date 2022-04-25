<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <title>Ponto em dia - Cadastrar usuário</title>
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
            <!-- CSS only -->
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                crossorigin="anonymous">
             
             <link rel="shortcut icon" href="img/favicon-16x16.png" />

            <%@ include file="css/sidebar.jsp" %>
                <%@ include file="css/cardUsuario.jsp" %>


        </head>

        <body>

            <div id="wrapper" class="toggled ">

                <!-- Sidebar -->
                <div id="sidebar-wrapper" class="d-flex flex-column vh-100 flex-shrink-0 p-3 text-white bg-dark">
                    <a href="entrada?acao=RegistrarPonto"><img id="logo" class="img-responsive"
                            src="img/PontoEmDia.png" /></a>
                    <hr>
                    <ul class="nav nav-pills flex-column mb-auto">

                        <c:if test="${ usuario.tipoUsuario  == 'admin'}">
                            <li><a href="entrada?acao=DashbordAdmin" class="nav-link text-white"> <i
                                        class="fa fa-first-order"></i><span class="ms-2">DashBord - Admin</span>
                                </a></li>
                        </c:if>

                        <li class="nav-item"><a href="entrada?acao=Dashbord" class="nav-link text-white"
                                aria-current="page"> <i class="fa fa-home"></i><span class="ms-2">Dashbord</span>
                            </a></li>
                        <li><a href="entrada?acao=ExibirRegistrar" class="nav-link text-white"> <i
                                    class="fa fa-dashboard"></i><span class="ms-2">Registrar Ponto</span>
                            </a></li>
                        <c:if test="${ usuario.tipoUsuario  == 'admin'}">
                            <li><a href="entrada?acao=HistoricoUsuarioAdmin" class="nav-link text-white"> <i
                                        class="fa fa-first-order"></i><span class="ms-2">Historico - Admin</span>
                                </a></li>
                        </c:if>

                        <li><a href="entrada?acao=HistoricoUsuario" class="nav-link text-white"> <i
                                    class="fa fa-first-order"></i><span class="ms-2">Historico</span>
                            </a></li>

                        <c:if test="${ usuario.tipoUsuario  == 'admin'}">
                            <li><a href="entrada?acao=ExibirCadastrarUsuario" class="nav-link active"> <i
                                        class="fa fa-first-order"></i><span class="ms-2">Cadastrar Usuario</span>
                                </a></li>
                        </c:if>
                    </ul>
                    <hr>

                    <div class="dropdown">
                        <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
                            id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                            <c:if test="${usuario.urlImagem != null }">
                            <img src="${usuario.urlImagem}" alt="" width="32" height="32"
                                class="rounded-circle me-2">
                            </c:if>
                            <c:if test="${usuario.urlImagem == null }">
                            <img src="img/user-default.png"" alt="" width="32" height="32"
                                class="rounded-circle me-2">
                            </c:if> <strong>
                                ${usuario.nome} </strong>
                        </a>
                        <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                            <li><a class="dropdown-item" href="entrada?acao=ExibirPerfil">Profile</a></li>
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

                    <h1>Cadastrar Usuário</h1>
                    <hr>

                    <div class="container d-flex justify-content-around ">
                        <div class="row">
                            <div class="col-sm-10 col-md-10 col-lg-10">

                                <form action="entrada?acao=CadastrarUsuario"
                                    class="shadow-lg p-3 mb-5 rounded border border-success" method="post" style="background:#FFFAFA">
                                    <div class="row mb-4">
                                        <div class="col">
                                            <div class="form-outline">
                                                <input type="text" name="login" class="form-control" placeholder="Informe o login" required />
                                                <label class="form-label">Login</label>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="form-outline">
                                                <input type="password" name="senha" class="form-control" placeholder="Informe a senha" required />
                                                <label class="form-label">Senha</label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" name="nome" class="form-control" placeholder="Informe o nome" required />
                                        <label class="form-label">Nome</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="date" name="nascimento" class="form-control" required /> <label
                                            class="form-label">Nascimento</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" name="cargo" class="form-control" placeholder="Informe o cargo" required />
                                        <label class="form-label">Cargo</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <select class="form-select form-select-sm" aria-label=".form-select-sm example"
                                            name="tipoUsuario" required>
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
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>

        </html>