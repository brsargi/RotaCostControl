<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid colored">
			<a class="brand" href="${pageContext.request.contextPath}/pages/site/index.jsp"><strong>Meu Dinheiro</strong></a>
			
			<c:if test="${pageContext.request.userPrincipal != null}">
				<p class="navbar-text pull-right">Olá,  <strong>${pageContext.request.userPrincipal.name}</strong>&nbsp;<a href="${pageContext.request.contextPath}/LogoutServlet">Sair</a></p>
			</c:if>
			
		</div>
		<div id="menu" class="container-fluid">
			<div>
				<ul class="nav nav-pills">
					<li class=""><a href="${pageContext.request.contextPath}/pages/application/entries">Lançamentos</a></li>
					<!-- <li class=""><a href="">Relatório</a></li> -->
					<li class=""><a href="${pageContext.request.contextPath}/pages/application/account">Conta</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>