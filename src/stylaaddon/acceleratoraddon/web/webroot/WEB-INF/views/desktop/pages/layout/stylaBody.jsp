<%@ taglib prefix="template" tagdir="/WEB-INF/tags/desktop/template" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="stylaMagazine">
	<c:choose>
		<c:when test="${not empty stylaHtmlBody}">
			<c:out value="${stylaHtmlBody}" escapeXml="false" />
		</c:when>
	</c:choose>
</div>
