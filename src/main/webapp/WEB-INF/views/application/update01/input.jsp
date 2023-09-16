<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/tld/customtag" prefix="cus"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/head.jsp" flush="true" />
<link href="${pageContext.request.contextPath}/css/top/top.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/customer/customer.css" rel="stylesheet">
<title>exampleカード お客様情報の変更申請</title>
<script type="text/javascript">
<!--
	function submit() {
		var form = document.input;
		form.submit();
		return true;
	}
// -->
</script>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" flush="true" />
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
							<form:form name="input" action="${pageContext.request.contextPath}/application/update01/input" modelAttribute="applicationUpdateSaForm">
								<div>
									お客様情報の新規登録を行います。<br> ご本人様情報・ご勤務先情報を入力し、「確認する」ボタンを押してください。<br>
									<h3>■お客様情報</h3>

									<c:if test="${error != null}">
										<div class="error">
											<c:out value="${error}" />
										</div>
									</c:if>

									<table class="customer-info">
										<tr>
											<th>氏名</th>
											<td><form:input path="firstname" size="10" maxlength="10" /> <form:input path="lastname" size="10" maxlength="10" /> <form:errors path="firstname" class="validation-error" /> <form:errors
													path="lastname" class="validation-error" /></td>
										</tr>
										<tr>
											<th>氏名（カナ）</th>
											<td><form:input path="firstnameKana" size="10" maxlength="10" /> <form:input path="lastnameKana" size="10" maxlength="10" /> <form:errors path="firstnameKana" class="validation-error" />
												<form:errors path="lastnameKana" class="validation-error" /></td>
										</tr>
										<tr>
											<th>郵便番号</th>
											<td><form:input path="zip1" size="3" maxlength="3" />-<form:input path="zip2" size="4" maxlength="4" /> <form:errors path="zip1" class="validation-error" /> <form:errors path="zip2"
													class="validation-error" /></td>
										</tr>
										<tr>
											<th>住所</th>
											<td><form:input path="addressPrefecture" placeholder="都道府県" /> <form:errors path="addressPrefecture" class="validation-error" /><br> <form:input path="addressCity"
													placeholder="市区郡" /> <form:errors path="addressCity" class="validation-error" /><br> <form:input path="addressOoaza" placeholder="丁目" /> <form:errors path="addressOoaza"
													class="validation-error" /><br> <form:input path="addressAza" placeholder="番地・号" /> <form:errors path="addressAza" class="validation-error" /><br> <form:input
													path="addressOther" placeholder="マンション名など" /> <form:errors path="addressOther" class="validation-error" /></td>
										</tr>
										<tr>
											<th>電話番号</th>
											<td><form:input path="tel1" size="4" maxlength="4" />-<form:input path="tel2" size="4" maxlength="4" />-<form:input path="tel3" size="4" maxlength="4" /> <form:errors path="tel1"
													class="validation-error" /> <form:errors path="tel2" class="validation-error" /> <form:errors path="tel3" class="validation-error" /></td>
										</tr>
										<tr>
											<th>携帯電話番号</th>
											<td><form:input path="mobileTel1" size="4" maxlength="4" />-<form:input path="mobileTel2" size="4" maxlength="4" />-<form:input path="mobileTel3" size="4" maxlength="4" /> <form:errors
													path="mobileTel1" class="validation-error" /> <form:errors path="mobileTel2" class="validation-error" /> <form:errors path="mobileTel3" class="validation-error" /></td>
										</tr>
										<tr>
											<th>メールアドレス</th>
											<td><form:input path="email" /> <form:errors path="email" class="validation-error" /></td>
										</tr>
										<tr>
											<th>ご家族について</th>
											<td><form:select path="setaiFamily">
													<cus:options id="setaiFamily" itemLabel="value" itemValue="key" />
												</form:select> <form:errors path="setaiFamily" class="validation-error" /></td>
										</tr>
										<tr>
											<th>世帯人数(同一生計の人数)</th>
											<td><form:input path="setaiCount" size="2" maxlength="2" />人世帯 <form:errors path="setaiCount" class="validation-error" /></td>
										</tr>
										<tr>
											<th>居住状況</th>
											<td><form:select path="setaiStatus">
													<cus:options id="setaiStatus" itemLabel="value" itemValue="key" />
												</form:select> <form:errors path="setaiStatus" class="validation-error" /></td>
										</tr>
										<tr>
											<th>居住年数</th>
											<td><form:input path="setaiYear" size="2" maxlength="2" />年 <form:errors path="setaiYear" class="validation-error" /></td>
										</tr>
										<tr>
											<th>住宅ローンもしくは家賃のお支払い</th>
											<td><form:select path="setaiLoan">
													<cus:options id="setaiLoan" itemLabel="value" itemValue="key" />
												</form:select> <form:errors path="setaiLoan" class="validation-error" /></td>
										</tr>
										<tr>
											<th>本人年収</th>
											<td><form:input path="income" size="12" maxlength="12" />万円 <form:errors path="income" class="validation-error" /></td>
										</tr>
										<tr>
											<th>預貯金額</th>
											<td><form:input path="savings" size="12" maxlength="12" />万円 <form:errors path="savings" class="validation-error" /></td>
										</tr>
									</table>
								</div>
								<div>
									<h3>■ご勤務先情報</h3>
									<table class="customer-info-office">
										<tr>
											<th>職業</th>
											<td><form:select path="employmentStatus">
													<cus:options id="employmentStatus" itemLabel="value" itemValue="key" />
												</form:select> <form:errors path="employmentStatus" class="validation-error" /></td>
										</tr>
										<tr>
											<th>勤務先</th>
											<td><form:input path="companyName" /> <form:errors path="companyName" class="validation-error" /></td>
										</tr>
										<tr>
											<th>部署</th>
											<td><form:input path="companyDepartment" /> <form:errors path="companyDepartment" class="validation-error" /></td>
										</tr>
										<tr>
											<th>郵便番号</th>
											<td><form:input path="companyZip1" size="4" maxlength="3" />-<form:input path="companyZip2" size="4" maxlength="4" /> <form:errors path="companyZip1" class="validation-error" /> <form:errors
													path="companyZip2" class="validation-error" /></td>
										</tr>
										<tr>
											<th>住所</th>
											<td><form:input path="companyAddressPrefecture" placeholder="都道府県" /> <form:errors path="companyAddressPrefecture" class="validation-error" /><br> <form:input
													path="companyAddressCity" placeholder="市区郡" /> <form:errors path="companyAddressCity" class="validation-error" /><br> <form:input path="companyAddressOoaza" placeholder="丁目" /> <form:errors
													path="companyAddressOoaza" class="validation-error" /><br> <form:input path="companyAddressAza" placeholder="番地・号" /> <form:errors path="companyAddressAza" class="validation-error" /><br>
												<form:input path="companyAddressOther" placeholder="マンション名など" /> <form:errors path="companyAddressOther" class="validation-error" /></td>
										</tr>
										<tr>
											<th>電話番号</th>
											<td><form:input path="companyTel1" size="4" maxlength="4" />-<form:input path="companyTel2" size="4" maxlength="4" />-<form:input path="companyTel3" size="4" maxlength="4" /> <form:errors
													path="companyTel1" class="validation-error" /> <form:errors path="companyTel2" class="validation-error" /> <form:errors path="companyTel3" class="validation-error" /></td>
										</tr>
										<tr>
											<th>業種</th>
											<td><form:select path="companyIndustryType">
													<cus:options id="companyIndustryType" itemLabel="value" itemValue="key" />
												</form:select> <form:errors path="companyIndustryType" class="validation-error" /></td>
										</tr>
										<tr>
											<th>勤続年数</th>
											<td><form:input path="companyWorkYears" size="2" maxlength="2" />年 <form:errors path="companyWorkYears" class="validation-error" /></td>
										</tr>
									</table>
									<form:hidden path="id" />
									<form:hidden path="updateDate" />
								</div>
								<a href="${pageContext.request.contextPath}/application/detail01/index?id=${customerApplicationForm.id}" class="btn btn-primary">戻る</a>
								<a onclick="return submit();" class="btn btn-primary">確認する</a>
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

	<jsp:include page="/WEB-INF/views/common/footer.jsp" flush="true" />
</body>
</html>