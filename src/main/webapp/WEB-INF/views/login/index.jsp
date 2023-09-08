<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<jsp:include page="../common/head.jsp" flush="true" />
<link href="${pageContext.request.contextPath}/css/login/login.css" rel="stylesheet">
<title>exampleカード ログイン</title>
</head>
<body>
	<div class="row">
		<div class="header">
			<div class="col-sm-2">
				<div class="header-left"></div>
			</div>
			<div class="col-sm-8">
				<div class="header-contents">
					<form:form action="${pageContext.request.contextPath}/login/execute" modelAttribute="loginForm">
						<div class="login-contents">
							<table>
							<tr>
								<td>
									<form:label path="mailAddress">メールアドレス</form:label> :
								</td>
								<td>
									<form:input path="mailAddress" />
									<form:errors path="mailAddress" />
								</td>
							</tr>
							<tr>
								<td>
									<form:label path="password">パスワード</form:label> :
								</td>
								<td>
									<form:input path="password" />
									<form:errors path="password" />
								</td>
							<tr>
								<td colspan="2">
									<form:button>ログイン</form:button>
								</td>
							</tr>
							</table>
						</div>
					</form:form>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="header-right"></div>
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