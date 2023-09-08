<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<jsp:include page="../common/head.jsp" flush="true" />
<link href="${pageContext.request.contextPath}/css/top/top.css" rel="stylesheet">
<title>exampleカード トップ</title>
</head>
<body>
	<jsp:include page="../common/header.jsp" flush="true" />
	<div class="row">
		<div class="contents">
			<div class="col-sm-2 content-block">
				<div class="contents-left"></div>
			</div>

			<div class="col-sm-8 content-block">
				<div class="main-contents">
					<div class="top-user-info">
						<div class="top-user-info-title">
							ようこそ　<c:out value="${topDto.lastname}"></c:out>　<c:out value="${topDto.firstname}"></c:out>　さん
						</div>
						<div class="top-user-info-body">
							<table>
							<tr>
								<td class="top-user-info-body-info-title">
									お知らせ
								</td>
								<td class="top-user-info-body-info-contents">
									${topDto.information}
								</td>
							</tr>
							</table>
						</div>
					</div>
				</div>
			</div>

			<div class="col-sm-2 content-block">
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