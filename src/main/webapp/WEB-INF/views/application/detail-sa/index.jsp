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
<title>exampleカード 申請情報の照会・変更</title>
<script type="text/javascript">
<!--
	
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
							<img src="${pageContext.request.contextPath}/images/h1.gif">申請情報の詳細
						</div>
						<div class="customer-info-body">
							<div class="customer-info-body-status">
								■申請状況<br>
								<c:out value="${applicationDto.dispApplicationStatus}"/>
							</div>
							<c:if test="${!StringUtils.isEmpty(applicationDto.applicationComment)}">
								<div class="customer-info-body-comment">
									■コメント<br>
									<c:out value="${applicationDto.applicationComment}"/>
								</div>
							</c:if>
							<div class="customer-info-body-base">
								<h3>ご本人様情報</h3>
								<table class="customer">
									<tr>
										<th>氏名</th>
										<td><c:out value="${applicationDto.firstname}" /> <c:out value="${applicationDto.lastname}" /></td>
									</tr>
									<tr>
										<th>氏名（カナ）</th>
										<td><c:out value="${applicationDto.firstnameKana}" /> <c:out value="${applicationDto.lastnameKana}" /></td>
									</tr>
									<tr>
										<th>郵便番号</th>
										<td><c:out value="${applicationDto.zip1}" /> - <c:out value="${applicationDto.zip2}" /></td>
									</tr>
									<tr>
										<th>住所</th>
										<td><c:out value="${applicationDto.addressPrefecture}" /> <br> <c:out value="${applicationDto.addressCity}" /> <br> <c:out value="${applicationDto.addressOoaza}" /> <br> <c:out
												value="${applicationDto.addressAza}" /> <br> <c:out value="${applicationDto.addressOther}" /></td>
									</tr>
									<tr>
										<th>電話番号</th>
										<td class=""><c:out value="${applicationDto.tel1}" /> - <c:out value="${applicationDto.tel2}" /> - <c:out value="${applicationDto.tel3}" /></td>
									</tr>
									<tr>
										<th>携帯電話番号</th>
										<td class=""><c:out value="${applicationDto.mobileTel1}" /> - <c:out value="${applicationDto.mobileTel2}" /> - <c:out value="${applicationDto.mobileTel3}" /></td>
									</tr>
									<tr>
										<th>メールアドレス</th>
										<td class=""><c:out value="${applicationDto.email}" /></td>
									</tr>
									<tr>
										<th>ご家族について</th>
										<td><c:out value="${applicationDto.dispSetaiFamily}" /></td>
									</tr>
									<tr>
										<th>世帯人数(同一生計の人数)</th>
										<td><c:out value="${applicationDto.setaiCount}" /> 人世帯</td>
									</tr>
									<tr>
										<th>居住状況</th>
										<td><c:out value="${applicationDto.dispSetaiStatus}" /></td>
									</tr>
									<tr>
										<th>居住年数</th>
										<td><c:out value="${applicationDto.setaiYear}" /> 年</td>
									</tr>
									<tr>
										<th>住宅ローンもしくは家賃のお支払い</th>
										<td><c:out value="${applicationDto.dispSetaiLoan}" /></td>
									</tr>
									<tr>
										<th>本人年収</th>
										<td><c:out value="${applicationDto.income}" /> 万円</td>
									</tr>
									<tr>
										<th>預貯金額</th>
										<td><c:out value="${applicationDto.savings}" /> 万円</td>
									</tr>
								</table>
							</div>
							<div class="customer-info-body-office">
								<h3>ご勤務先情報</h3>
								<table>
									<tr>
										<th>職業</th>
										<td><c:out value="${applicationDto.dispEmploymentStatus}" /></td>
									</tr>
									<tr>
										<th>勤務先</th>
										<td><c:out value="${applicationDto.companyName}" /></td>
									</tr>
									<tr>
										<th>部署</th>
										<td><c:out value="${applicationDto.companyDepartment}" /></td>
									</tr>
									<tr>
										<th>郵便番号</th>
										<td><c:out value="${applicationDto.companyZip1}" /> - <c:out value="${applicationDto.companyZip2}" /></td>
									</tr>
									<tr>
										<th>住所</th>
										<td><c:out value="${applicationDto.companyAddressPrefecture}" /> <br> <c:out value="${applicationDto.companyAddressCity}" /> <br> <c:out value="${applicationDto.companyAddressOoaza}" />
											<br> <c:out value="${applicationDto.companyAddressAza}" /> <br> <c:out value="${applicationDto.companyAddressOther}" /></td>
									</tr>
									<tr>
										<th>電話番号</th>
										<td><c:out value="${applicationDto.companyTel1}" /> - <c:out value="${applicationDto.companyTel2}" /> - <c:out value="${applicationDto.companyTel3}" /></td>
									</tr>
									<tr>
										<th>業種</th>
										<td><c:out value="${applicationDto.dispCompanyIndustryType}" /></td>
									</tr>
									<tr>
										<th>勤続年数</th>
										<td><c:out value="${applicationDto.companyWorkYears}" /> 年</td>
									</tr>
								</table>
								<sec:authorize access="hasRole('SA')">
									<c:if test="${applicationDto.applicationStatus == '2'}">
										<a href="${pageContext.request.contextPath}/application/update-sa/input?id=${applicationDto.id}" class="btn btn-primary">変更申請</a>
									</c:if>
								</sec:authorize>
							</div>
							<br>
							<a href="${pageContext.request.contextPath}/application/search-sa/search" class="btn btn-primary">お客様検索へ戻る</a>
							<sec:authorize access="hasRole('SA')">
								<c:if test="${applicationDto.applicationStatus == '1'}">
									<a href="${pageContext.request.contextPath}/application/APLDL10/delete" class="btn btn-warning">取下げ</a>
								</c:if>
							</sec:authorize>
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
			<jsp:include page="/WEB-INF/views/common/footer.jsp" flush="true" />
		</div>
	</div>
</body>
</html>