<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meu Dinheiro - Login</title>
</head>
<body>
<c:import url="/pages/template/header.jsp"></c:import>
<div id="login_container" class="container">
	<div class="well">
	      <form class="form-signin" method="post" action="j_security_check">
	        <h2 class="form-signin-heading">Entrar</h2>
	        <input type="text" class="input-block-level" placeholder="Email" name="j_username">
	        <input type="password" class="input-block-level" placeholder="Senha" name="j_password">
	       	
	        <input class="btn btn-large btn-primary" type="submit" value="Entrar"></input>

	      </form>
      </div>
</div>

<!-- IMPORT RESOURCES -->
<tags:resource-tag type="css" value="bootstrap/css/bootstrap.min.css"></tags:resource-tag>
<tags:resource-tag type="css" value="bootstrap/css/bootstrap-responsive.min.css"></tags:resource-tag>
<tags:resource-tag type="css" value="css/application.css"></tags:resource-tag>
<tags:resource-tag type="javascript" value="js/jquery.js"></tags:resource-tag>
<tags:resource-tag type="javascript" value="bootstrap/js/bootstrap.min.js"></tags:resource-tag>
</body>
</html>