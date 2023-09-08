<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/head.jsp"/>
<link href="${pageContext.request.contextPath}/css/top/top.css" rel="stylesheet">
<title>exampleカード エラー</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" flush="true" />
    <div class="row">
		<div class="contents">
			<div class="col-sm-1 content-block">
				<div class="contents-left"></div>
			</div>
		    <div class="col-sm-10 content-block">
				<div class="main-contents">
			<h1>権限エラー</h1>
			<div class="error">
			    <spring:message code="error.access.denied" />
			</div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
		    </div>
			<div class="col-sm-1 content-block">
				<div class="contents-right"></div>
			</div>
		</div>
	</div>
    <div class="row">
		<div class="col-sm-12">
			<jsp:include page="../common/footer.jsp" flush="true" />
		</div>
	</div>
</body>
</html>