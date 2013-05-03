<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meu Dinheiro - Conta criada com sucesso</title>
</head>
<body>

<c:import url="/pages/template/header.jsp"></c:import>

<div class="container">
	<div class="well">
	      
	      <legend>Usuário criado com sucesso!</legend>
	      
	      <a class="btn btn-large btn-primary" href="${pageContext.request.contextPath}/pages/application/entries/index.jsp">Clique aqui para entrar</a>
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