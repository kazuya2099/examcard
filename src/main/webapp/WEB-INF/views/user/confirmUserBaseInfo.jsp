<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<jsp:include page="../common/head.jsp" flush="true" />
<link href="${pageContext.request.contextPath}/css/top/top.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/user/user.css"
	rel="stylesheet">
<title>exampleカード お客様情報の変更</title>
</head>
<body>
	<div class="row">
		<div class="header">
			<div class="col-sm-2">
				<div class="header-left"></div>
			</div>
			<div class="col-sm-8">
				<div class="header-contents">
					<ul class="nav nav-pills nav-justified">
						<li role="presentation"><a href="${pageContext.request.contextPath}/top"><span class="header-menu">トップ</span></a></li>
						<li role="presentation"><a href="#"><span class="header-menu">お支払い（ご利用明細）</span></a></li>
						<li role="presentation" class="active"><span class="header-menu">お客様情報の照会・変更</span></li>
						<li role="presentation"><a href="${pageContext.request.contextPath}/logout"><span class="header-menu">ログアウト</span></a></li>
					</ul>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="header-right"></div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="contents">
			<div class="col-sm-2 content-block">
				<div class="contents-left"></div>
			</div>

			<div class="col-sm-8 content-block">
				<div class="main-contents">
					<div class="user-info">
						<div class="user-info-title">
							<img src="${pageContext.request.contextPath}/images/h1.gif">お客様情報の照会・変更
						</div>
						<div class="user-info-body">
							<form:form action="${pageContext.request.contextPath}/user/complete" modelAttribute="userForm">
								<div class="user-info-body-base">
									カードに登録されているお客様情報の照会・変更をすることができます。<br>
									ご本人様情報・ご勤務先情報を変更する場合は、「変更する」ボタンを押し、変更ページにてお手続きください。<br>
									<h3>ご本人様情報</h3>
									<table class="">
										<tr>
											<th>郵便番号</th>
											<td><c:out value="${userForm.zip1}" />-<c:out value="${userForm.zip2}" /></td>
										</tr>
										<tr>
											<th>住所</th>
											<td>
												<c:out value="${userForm.addressPrefecture}" /><br>
												<c:out value="${userForm.addressCity}" /><br>
												<c:out value="${userForm.addressOoaza}" /><br>
												<c:out value="${userForm.addressAza}" /><br>
												<c:out value="${userForm.addressOther}" />
											</td>
										</tr>
										<tr>
											<th>電話番号</th>
											<td class=""><c:out value="${userForm.tel1}" />-<c:out value="${userForm.tel2}" />-<c:out value="${userForm.tel3}" /></td>
										</tr>
										<tr>
											<th>携帯電話番号</th>
											<td class=""><c:out value="${userForm.mobileTel1}" />-<c:out value="${userForm.mobileTel2}" />-<c:out value="${userForm.mobileTel3}" /></td>
										</tr>
										<tr>
											<th>メールアドレス</th>
											<td class=""><c:out value="${userForm.email}" /></td>
										</tr>
										<tr>
											<th>ご家族について</th>
											<td><c:out value="${userForm.setaiFamily}" /></td>
										</tr>
										<tr>
											<th>世帯人数(同一生計の人数)</th>
											<td><c:out value="${userForm.setaiCount}" />人世帯</td>
										</tr>
										<tr>
											<th>居住状況</th>
											<td><c:out value="${userForm.setaiStatus}" /></td>
										</tr>
										<tr>
											<th>居住年数</th>
											<td><c:out value="${userForm.setaiYear}" />年</td>
										</tr>
										<tr>
											<th>住宅ローンもしくは家賃のお支払い</th>
											<td><c:out value="${userForm.setaiLoan}" /></td>
										</tr>
										<tr>
											<th>本人年収</th>
											<td><c:out value="${userForm.income}" />万円</td>
										</tr>
										<tr>
											<th>預貯金額</th>
											<td><c:out value="${userForm.savings}" />万円</td>
										</tr>
									</table>
								</div>
								<div class="user-info-body-office">
									<h3>ご勤務先情報</h3>
									<table>
										<tr>
											<th>職業</th>
											<td><c:out value="${userForm.employmentStatus}" /></td>
										</tr>
										<tr>
											<th>勤務先</th>
											<td><c:out value="${userForm.companyName}" /></td>
										</tr>
										<tr>
											<th>郵便番号</th>
											<td><c:out value="${userForm.companyZip1}" />-<c:out value="${userForm.companyZip2}" /></td>
										</tr>
										<tr>
											<th>住所</th>
											<td>
												<c:out value="${userForm.companyAddressPrefecture}" /><br>
												<c:out value="${userForm.companyAddressCity}" /><br>
												<c:out value="${userForm.companyAddressOoaza}" /><br>
												<c:out value="${userForm.companyAddressAza}" /><br>
												<c:out value="${userForm.companyAddressOther}" />
											</td>
										</tr>
										<tr>
											<th>電話番号</th>
											<td><c:out value="${userForm.companyTel1}" />-<c:out value="${userForm.companyTel2}" />-<c:out value="${userForm.companyTel3}" /></td>
										</tr>
										<tr>
											<th>業種</th>
											<td><c:out value="${userForm.companyIndustryType}" /></td>
										</tr>
										<tr>
											<th>勤続年数</th>
											<td><c:out value="${userForm.companyWorkYears}" />年</td>
										</tr>
									</table>
									<form:hidden path="zip1" />
									<form:hidden path="zip2" />
									<form:hidden path="addressPrefecture" />
									<form:hidden path="addressCity" />
									<form:hidden path="addressOoaza" />
									<form:hidden path="addressAza" />
									<form:hidden path="addressOther" />
									<form:hidden path="tel1" />
									<form:hidden path="tel2" />
									<form:hidden path="tel3" />
									<form:hidden path="mobileTel1" />
									<form:hidden path="mobileTel2" />
									<form:hidden path="mobileTel3" />
									<form:hidden path="email" />
									<form:hidden path="setaiFamily" />
									<form:hidden path="setaiCount" />
									<form:hidden path="setaiStatus" />
									<form:hidden path="setaiYear" />
									<form:hidden path="setaiLoan" />
									<form:hidden path="income" />
									<form:hidden path="savings" />
									<form:hidden path="employmentStatus" />
									<form:hidden path="companyName" />
									<form:hidden path="companyZip1" />
									<form:hidden path="companyZip2" />
									<form:hidden path="companyAddressPrefecture" />
									<form:hidden path="companyAddressCity" />
									<form:hidden path="companyAddressOoaza" />
									<form:hidden path="companyAddressAza" />
									<form:hidden path="companyAddressOther" />
									<form:hidden path="companyTel1" />
									<form:hidden path="companyTel2" />
									<form:hidden path="companyTel3" />
									<form:hidden path="companyIndustryType" />
									<form:hidden path="companyWorkYears" />
									<form:button>変更する</form:button>
								</div>
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
			<jsp:include page="../common/footer.jsp" flush="true" />
		</div>
	</div>
</body>
</html>