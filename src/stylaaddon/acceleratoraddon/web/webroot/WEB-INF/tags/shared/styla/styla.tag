<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${not empty stylaHtmlHead}">
		<c:out value="${stylaHtmlHead}" escapeXml="false" />
	</c:when>
</c:choose>
<c:choose>
	<c:when test="${not empty stylaCssUrl}">
		<link rel="stylesheet" type="text/css" href="${stylaCssUrl}" />
	</c:when>
</c:choose>
<c:choose>
	<c:when test="${not empty stylaJsUrl}">
		<script src="${stylaJsUrl}" async></script>
	</c:when>
</c:choose>