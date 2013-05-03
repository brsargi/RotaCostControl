<% 
request.getSession().invalidate(); 
response.sendRedirect("${pageContext.request.contextPath}/pages/site/create-account.jsp"); 
%> 