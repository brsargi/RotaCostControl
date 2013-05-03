<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<title>Meu Dinheiro - Criar conta</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<tags:resource-tag type="css" value="bootstrap/css/bootstrap.min.css"></tags:resource-tag>
<tags:resource-tag type="css" value="css/site.css"></tags:resource-tag>
</head>
<body>
	<div class="container">

		<c:import url="/pages/site/template/header.jsp"></c:import>

		<div id="createAccountSuccess" class="alert alert-success hide">
  			Foi enviado um email para confirmação do seu cadastro. Obs: Em alguns casos o email vai para a caixa de spam, verifique-a. Obrigado
		</div>

		<h2>Criar conta</h2>

		<br />
		<div class="form-horizontal">
			<div id="emailControlGroup" class="control-group">
				<label class="control-label" for="inputEmail">Email</label>
				<div class="controls">
					<input type="text" id="inputEmail" placeholder="Email">
					<p id="inputEmailMessage" class="help-block hide"></p>
				</div>
			</div>
			<div id="confirmEmailControlGroup" class="control-group">
				<label class="control-label" for="inputConfirmEmail">Confirmar
					email</label>
				<div class="controls">
					<input type="text" id="inputConfirmEmail"
						placeholder="Confirmar Email">
					<p id="inputConfirmEmailMessage" class="help-block hide"></p>
				</div>
			</div>
			<div id="passwordControlGroup" class="control-group">
				<label class="control-label" for="inputPassword">Senha</label>
				<div class="controls">
					<input type="password" id="inputPassword" placeholder="Senha">
					<p id="inputPasswordMessage" class="help-block hide"></p>
				</div>
			</div>
			<div id="confirmPasswordControlGroup" class="control-group">
				<label class="control-label" for="inputConfirmPassword">Confirmar
					senha</label>
				<div class="controls">
					<input type="password" id="inputConfirmPassword" placeholder="Confirmar senha">
					<p id="inputConfirmPasswordMessage" class="help-block hide"></p>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<button id="btnCreateAccount" class="btn">Criar</button>
				</div>
			</div>
		</div>

		<c:import url="/pages/site/template/footer.jsp"></c:import>
	</div>
	<!-- /container -->

	<!-- Le javascript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- Bootstrap -->
	<script src="http://code.jquery.com/jquery.js"></script>
	<tags:resource-tag type="javascript" value="bootstrap/js/bootstrap.min.js"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="js/jquery.rest.js"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="js/site/menu-site.js"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="js/application.js"></tags:resource-tag>
	<tags:resource-tag type="javascript" value="js/site/account.js"></tags:resource-tag>
</body>
</html>