<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ attribute name="type" required="true" rtexprvalue="false" %>
<%@ attribute name="value" required="true" rtexprvalue="false" %>

<c:if test="${type == 'css'}">
	<link rel="stylesheet" href="<c:url value="/resources/" />${value}" type="text/css" />
</c:if>
<c:if test="${type == 'javascript'}">
	<script src="<c:url value="/resources/" />${value}" type="text/javascript"></script>
</c:if>