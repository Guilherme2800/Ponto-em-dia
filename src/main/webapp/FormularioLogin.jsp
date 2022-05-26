<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Ponto em dia - Login</title>
<link rel="stylesheet" href="css/login.css"/>
</head>
<body>

 <div class="container">
    <div class="row">
      <div class="col-sm-12 col-md-12 col-lg-12">
        <div class="card login-content shadow-lg border-0">
          <div class="card-body">
            <div class="text-center">
              <img id="logo" class="img-responsive"
				src="img/PontoEmDia.png" />
            </div>
            <br>
            <br>
            <br>
            <form class="text-center" action="login" method="post">
              <input class="form-control border-0" type="text" name="login" placeholder="Login" autocomplete="off">
              <br>
              <input class="form-control border-0" type="password" name="senha" placeholder="Senha">
              <br>
              <button class="btn btn-primary btn-sm border-0" type="submit" name="submit">Login</button>
            </form>
          </div>
          <div class="nomember">
            <p class="text-center">Sem cadastro? 
            <a href="https://www.linkedin.com/in/guilherme-henrique-a333151ba/" target="_blank">Consulte o Admin do sistema</a></p>
          </div>
        </div>
      </div>
    </div>
  </div>

</body>
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</html>