<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE html>
<html lang="pt">
  <head>
    <title>Meu Dinheiro - Contato</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  </head>
  <body>
    <div class="container">
      
      <c:import url="/pages/site/template/header.jsp"></c:import>
      
      <h2>Contato</h2>
	  <br/>	
	  Qualquer dúvida envie email para <strong>contato.meudinheiro@gmail.com</strong>	
    <c:import url="/pages/site/template/footer.jsp"></c:import>
      
    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <!-- Bootstrap -->
    <tags:resource-tag type="css" value="bootstrap/css/bootstrap.min.css"></tags:resource-tag>
    <tags:resource-tag type="css" value="css/site.css"></tags:resource-tag>
    <tags:resource-tag type="javascript" value="js/jquery.js"></tags:resource-tag>
  	<tags:resource-tag type="javascript" value="bootstrap/js/bootstrap.min.js"></tags:resource-tag>      
	<tags:resource-tag type="javascript" value="js/site/menu-site.js"></tags:resource-tag>
</body>
</html>