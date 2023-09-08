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
							<form:form action="${pageContext.request.contextPath}/user/edit" modelAttribute="userForm">
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
										<form:input path="zip1" size="3" maxlength="3"/>-<form:input path="zip2"  size="4" maxlength="4"/>
										<form:errors path="zip1" />
										<form:errors path="zip2" />
									</td>
								</tr>
								<tr>
									<th>
										住所
									</th>
									<td class="">
										<form:input path="addressPrefecture" /><br>
										<form:input path="addressCity" /><br>
										<form:input path="addressOoaza" /><br>
										<form:input path="addressAza" /><br>
										<form:input path="addressOther" /><br>
										<form:errors path="addressPrefecture" />
										<form:errors path="addressCity" />
										<form:errors path="addressOoaza" />
										<form:errors path="addressAza" />
										<form:errors path="addressOther" />
									</td>
								</tr>
								<tr>
									<th>
										電話番号
									</th>
									<td class="">
										<form:input path="tel1" />-<form:input path="tel2" />-<form:input path="tel3" />
										<form:errors path="tel1" />
										<form:errors path="tel2" />
										<form:errors path="tel3" />
									</td>
								</tr>
								<tr>
									<th>
										携帯電話番号
									</th>
									<td class="">
										<form:input path="mobileTel1" />-<form:input path="mobileTel2" />-<form:input path="mobileTel3" />
										<form:errors path="mobileTel1" />
										<form:errors path="mobileTel2" />
										<form:errors path="mobileTel3" />
									</td>
								</tr>
								<tr>
									<th>
										メールアドレス
									</th>
									<td class="">
										<form:input path="email" />
										<form:errors path="email" />
									</td>
								</tr>
								<tr>
									<th>
										ご家族について
									</th>
									<td>
										<form:select path="setaiFamily">
											<form:options items="${setaiFamilySet}" itemLabel="value" itemValue="key"/>
										</form:select>
										<form:errors path="setaiFamily" />
									</td>
								</tr>
								<tr>
									<th>
										世帯人数(同一生計の人数)
									</th>
									<td>
										<form:input path="setaiCount" />人世帯
										<form:errors path="setaiCount" />
									</td>
								</tr>
								<tr>
									<th>
										居住状況
									</th>
									<td>
										<form:select path="setaiStatus">
											<form:options items="${setaiStatusSet}" itemLabel="value" itemValue="key"/>
										</form:select>
										<form:errors path="setaiStatus" />
									</td>
								</tr>
								<tr>
									<th>
										居住年数
									</th>
									<td>
										<form:input path="setaiYear" />年
										<form:errors path="setaiYear" />
									</td>
								</tr>
								<tr>
									<th>
										住宅ローンもしくは家賃のお支払い
									</th>
									<td>
										<form:select path="setaiLoan">
											<form:options items="${setaiLoanSet}" itemLabel="value" itemValue="key"/>
										</form:select>
										<form:errors path="setaiLoan" />
									</td>
								</tr>
								<tr>
									<th>
										本人年収
									</th>
									<td>
										<form:input path="income" />万円
										<form:errors path="income" />
									</td>
								</tr>
								<tr>
									<th>
										預貯金額
									</th>
									<td>
										<form:input path="savings" />万円
										<form:errors path="savings" />
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
										<form:select path="employmentStatus">
											<form:options items="${employmentStatusSet}" itemLabel="value" itemValue="key"/>
										</form:select>
										<form:errors path="employmentStatus" />
									</td>
								</tr>
								<tr>
									<th>
										勤務先
									</th>
									<td>
										<form:input path="companyName" />
										<form:errors path="companyName" />
									</td>
								</tr>
								<tr>
									<th>
										郵便番号
									</th>
									<td>
										<form:input path="companyZip1" />-<form:input path="companyZip2" />
										<form:errors path="companyZip1" /><form:errors path="companyZip2" />
									</td>
								</tr>
								<tr>
									<th>
										住所
									</th>
									<td>
										<form:input path="companyAddressPrefecture" /><br>
										<form:input path="companyAddressCity" /><br>
										<form:input path="companyAddressOoaza" /><br>
										<form:input path="companyAddressAza" /><br>
										<form:input path="companyAddressOther" />
										<form:errors path="companyAddressPrefecture" />
										<form:errors path="companyAddressCity" />
										<form:errors path="companyAddressOoaza" />
										<form:errors path="companyAddressAza" />
										<form:errors path="companyAddressOther" />
									</td>
								</tr>
								<tr>
									<th>
										電話番号
									</th>
									<td>
										<form:input path="companyTel1" />-<form:input path="companyTel2" />-<form:input path="companyTel3" />
										<form:errors path="companyTel1" />
										<form:errors path="companyTel2" />
										<form:errors path="companyTel3" />
									</td>
								</tr>
								<tr>
									<th>
										業種
									</th>
									<td>
										<form:select path="companyIndustryType">
											<form:options items="${companyIndustryTypeSet}" itemLabel="value" itemValue="key"/>
										</form:select>
										<form:errors path="companyIndustryType" />
									</td>
								</tr>
								<tr>
									<th>
										勤続年数
									</th>
									<td>
										<form:input path="companyWorkYears" />年
										<form:errors path="companyWorkYears" />
									</td>
								</tr>
								</table>
								<form:button>確認する</form:button>
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