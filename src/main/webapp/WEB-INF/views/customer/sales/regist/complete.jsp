<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<jsp:include page="../../../common/head.jsp" flush="true" />
<link href="${pageContext.request.contextPath}/css/top/top.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/customer/customer.css"
	rel="stylesheet">
<title>exampleカード お客様情報の新規登録申請</title>
</head>
<body>
	<jsp:include page="../../../common/header.jsp" flush="true" />
	<div class="row">
		<div class="contents">
			<div class="col-sm-2 content-block">
				<div class="contents-left"></div>
			</div>
			<div class="col-sm-8 content-block">
				<div class="main-contents">
					お客様情報の新規登録を申請しました。<br>
					<a href="${pageContext.request.contextPath}/customer/application/regist/input" class="btn btn-primary">新規登録申請</a>
				</div>
			</div>
			<div class="col-sm-2 content-block">
				<div class="contents-right"></div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<jsp:include page="../../../common/footer.jsp" flush="true" />
		</div>
	</div>
</body>
</html>