<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE html>
<html lang="pt">
  <head>
    <title>Meu Dinheiro</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  </head>
  <body>
    <div class="container">
      
      <c:import url="/pages/site/template/header.jsp"></c:import>
      
      <!-- Jumbotron -->
      <div class="jumbotron">
        <h1>Meu Dinheiro</h1>
        <p class="lead">Controle facilmente seus gastos. Seu dinheiro é muito importante para ser desperdiçado.</p>
        <a class="btn btn-large btn-success" href="${pageContext.request.contextPath}/pages/site/create-account.jsp">Crie sua conta é grátis</a>
        <a class="btn btn-large btn-success" href="${pageContext.request.contextPath}/pages/application/entries/index.jsp">Acesse sua conta</a>
      </div>

      <hr>

      <!-- Example row of columns -->
      <div class="row-fluid">
        <div class="span4">
          <h2>Fácil de utilizar</h2>
          <p>O Meu Dinheiro é um sistema muito fácil de utilizar. O Meu dinheiro possui uma interface bonita, fácil e intuitiva. Você verá que nunca foi tão fácil controlar seus gastos. </p>
        </div>
        <div class="span4">
          <h2>Seguro</h2>
          <p>O Meu Dinheiro possui um confiável sistema de segurança, apenas você e mais ninguém terá acesso aos seus lançamentos no Meu Dinheiro. Além do mais nós não pedimos qualquer dado sigiloso para você começar a utilizá-lo. Basta você informar seu email e senha para começar a controlar os seus gastos de maneira fácil.  </p>
       </div>
        <div class="span4">
          <h2>Acesso em qualquer lugar</h2>
          <p>Você pode acessar o meu dinheiro de qualquer lugar. Basta ter um aparelho com conexão à internet e pronto. Você pode controlar seus gastos de qualquer lugar. </p>
        </div>
      </div>

    <c:import url="/pages/site/template/footer.jsp"></c:import>
      
    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- Bootstrap -->
    <tags:resource-tag type="javascript" value="js/jquery.js"></tags:resource-tag>
    <tags:resource-tag type="css" value="bootstrap/css/bootstrap.min.css"></tags:resource-tag>
	<tags:resource-tag type="css" value="css/site.css"></tags:resource-tag>
  	<tags:resource-tag type="javascript" value="bootstrap/js/bootstrap.min.js"></tags:resource-tag>      
	<tags:resource-tag type="javascript" value="js/site/menu-site.js"></tags:resource-tag>
</body>
</html>