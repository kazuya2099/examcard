<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<jsp:include page="../../../common/head.jsp" flush="true" />
<link href="${pageContext.request.contextPath}/css/top/top.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/customer/customer.css"
	rel="stylesheet">
<title>exampleカード お客様情報の変更申請</title>
<script type="text/javascript">
<!--
function back() {
	var form = document.confirm;
	form.action = "${pageContext.request.contextPath}/customer/sales/edit/input?back";
	form.submit();
	return true;
}
function submit() {
	var form = document.confirm;
	form.submit();
	return true;
}
// -->
</script>
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
					<div class="customer-info">
						<div class="customer-info-title">
							<img src="${pageContext.request.contextPath}/images/h1.gif">お客様情報の変更申請
						</div>
						<div class="customer-info-body">
							<form:form name="confirm" action="${pageContext.request.contextPath}/customer/sales/edit/confirm" modelAttribute="customerApplicationForm">
								<jsp:include page="../commonConfirm.jsp" flush="true" />
								<a onclick="return back();" class="btn btn-primary">戻る</a>
								<a onclick="return submit();" class="btn btn-primary">再申請する</a>
							</form:form>
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
			<jsp:include page="../../../common/footer.jsp" flush="true" />
		</div>
	</div>
</body>
</html>