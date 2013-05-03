<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="utf-8">
<title>Meu Dinheiro</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
</head>
<body>
	<c:import url="/pages/template/top-menu.jsp"></c:import>
	<div id="content" class="container">
		<div class="well">
			<div class="row-fluid">
				<div class="span12">
					<legend>
						<h3>Conta</h3>
					</legend>
				</div>
			</div>

			<div class="row-fluid">
				<div class="span12">
					<form class="form-horizontal">
						<div class="control-group">
							<label class="control-label" for="inputEmail">Email</label>
							<div class="controls">
								<input type="text" id="inputEmail" placeholder="Email">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputPassword">Senha</label>
							<div class="controls">
								<input type="password" id="inputPassword" placeholder="Password">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="inputConfirmPassword">Repita a senha</label>
							<div class="controls">
								<input type="password" id="inputConfirmPassword" placeholder="Password">
							</div>
						</div>
						<div class="control-group">
							<div class="controls">
								<button type="submit" class="btn btn-primary">Atualizar</button>
								<button type="submit" class="btn danger">Excluir conta</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<hr />
			<footer>
				<p>© Company 2013</p>
			</footer>
			<!-- IMPORT RESOURCES -->
			<tags:resource-tag type="javascript" value="js/jquery.js"></tags:resource-tag>
			<tags:resource-tag type="css" value="bootstrap/css/bootstrap.min.css"></tags:resource-tag>
			<tags:resource-tag type="css" value="bootstrap/css/bootstrap-responsive.min.css"></tags:resource-tag>
			<tags:resource-tag type="css" value="css/application.css"></tags:resource-tag>
			<tags:resource-tag type="javascript" value="bootstrap/js/bootstrap.min.js"></tags:resource-tag>
			<tags:resource-tag type="javascript" value="js/jquery.rest.js"></tags:resource-tag>
			<tags:resource-tag type="javascript" value="js/application.js"></tags:resource-tag>
</body>
</html>