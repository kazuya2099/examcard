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
<link href="${pageContext.request.contextPath}/css/user/user.css" rel="stylesheet">
<title>exampleカード お客様情報の照会・変更</title>
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
							<div class="user-info-body-base">
								カードに登録されているお客様情報の照会・変更をすることができます。<br>
								ご本人様情報・ご勤務先情報を変更する場合は、「変更する」ボタンを押し、変更ページにてお手続きください。<br>
								<h3>ご本人様情報</h3>
								<table class="">
								<tr>
									<th>
										郵便番号
									</th>
									<td>
										<c:out value="${userDto.zip1}"/>-<c:out value="${userDto.zip2}"/>
									</td>
								</tr>
								<tr>
									<th>
										住所
									</th>
									<td class="">
										<c:out value="${userDto.addressPrefecture}"/><c:out value="${userDto.addressCity}"/><c:out value="${userDto.addressOoaza}"/><c:out value="${userDto.addressAza}"/> <c:out value="${userDto.addressOther}"/>
									</td>
								</tr>
								<tr>
									<th>
										電話番号
									</th>
									<td class="">
										<c:out value="${userDto.tel1}"/>-<c:out value="${userDto.tel2}"/>-<c:out value="${userDto.tel3}"/>
									</td>
								</tr>
								<tr>
									<th>
										携帯電話番号
									</th>
									<td class="">
										<c:out value="${userDto.mobileTel1}"/>-<c:out value="${userDto.mobileTel2}"/>-<c:out value="${userDto.mobileTel3}"/>
									</td>
								</tr>
								<tr>
									<th>
										メールアドレス
									</th>
									<td class="">
										<c:out value="${userDto.email}"/>
									</td>
								</tr>
								<tr>
									<th>
										ご家族について
									</th>
									<td>
										<c:out value="${userDto.setaiFamily}"/>
									</td>
								</tr>
								<tr>
									<th>
										世帯人数(同一生計の人数)
									</th>
									<td>
										<c:out value="${userDto.setaiCount}"/>人世帯
									</td>
								</tr>
								<tr>
									<th>
										居住状況
									</th>
									<td>
										<c:out value="${userDto.setaiStatus}"/>
									</td>
								</tr>
								<tr>
									<th>
										居住年数
									</th>
									<td>
										<c:out value="${userDto.setaiYear}"/>年
									</td>
								</tr>
								<tr>
									<th>
										住宅ローンもしくは家賃のお支払い
									</th>
									<td>
										<c:out value="${userDto.setaiLoan}"/>
									</td>
								</tr>
								<tr>
									<th>
										本人年収
									</th>
									<td>
										<c:out value="${userDto.income}"/>万円
									</td>
								</tr>
								<tr>
									<th>
										預貯金額
									</th>
									<td>
										<c:out value="${userDto.savings}"/>万円
									</td>
								</tr>
								</table>
							</div>
							<div class="user-info-body-office">
								<h3>ご勤務先情報</h3>
								<table>
								<tr>
									<th>
										職業
									</th>
									<td>
										<c:out value="${userDto.employmentStatus}"/>
									</td>
								</tr>
								<tr>
									<th>
										勤務先
									</th>
									<td>
										<c:out value="${userDto.companyName}"/>
									</td>
								</tr>
								<tr>
									<th>
										郵便番号
									</th>
									<td>
										<c:out value="${userDto.companyZip1}"/>-<c:out value="${userDto.companyZip2}"/>
									</td>
								</tr>
								<tr>
									<th>
										住所
									</th>
									<td>
										<c:out value="${userDto.companyAddressPrefecture}"/><c:out value="${userDto.companyAddressCity}"/><c:out value="${userDto.companyAddressOoaza}"/><c:out value="${userDto.companyAddressAza}"/> <c:out value="${userDto.companyAddressOther}"/>
									</td>
								</tr>
								<tr>
									<th>
										電話番号
									</th>
									<td>
										<c:out value="${userDto.companyTel1}"/>-<c:out value="${userDto.companyTel2}"/>-<c:out value="${userDto.companyTel3}"/>
									</td>
								</tr>
								<tr>
									<th>
										業種
									</th>
									<td>
										<c:out value="${userDto.companyIndustryType}"/>
									</td>
								</tr>
								<tr>
									<th>
										勤続年数
									</th>
									<td>
										<c:out value="${userDto.companyWorkYears}"/>年
									</td>
								</tr>
								</table>
								<a href="${pageContext.request.contextPath}/user/edit"><img src="${pageContext.request.contextPath}/images/change.gif"></a>
							</div>
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