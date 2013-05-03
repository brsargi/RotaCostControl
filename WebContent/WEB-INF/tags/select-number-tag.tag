<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="startValue" required="true" rtexprvalue="false" %>
<%@ attribute name="finalValue" required="true" rtexprvalue="false" %>
<%@ attribute name="name" required="true" rtexprvalue="false" %>
<%@ attribute name="id" required="true" rtexprvalue="false" %>
<%@ attribute name="defaultValue" required="true" rtexprvalue="false" %>

<select id="${id}" size="1" name="${name}">
	<c:forEach begin="${startValue}" end="${finalValue}" var="row">
		<c:choose>
			<c:when test="${row} == ${defaultValue}">
				<option selected value="${row}">${row}</option>
			</c:when>
			<c:otherwise>
				<option value="${row}">${row}</option>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</select>	
