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
<title>exampleカード 申請情報の判定</title>
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
							<img src="${pageContext.request.contextPath}/images/h1.gif">申請情報の詳細
						</div>
						<form:form name="input" action="${pageContext.request.contextPath}/application/update-cr/input" modelAttribute="applicationUpdateCrForm">
						<div class="customer-info-body">
							<div class="customer-info-body-status">
								■申請状況<br>
								<form:select path="applicationStatus">
									<cus:options id="applicationStatusCr" itemLabel="value" itemValue="key"/>
								</form:select>
								<form:errors path="applicationStatus" class="validation-error"/>
							</div>
							<div class="customer-info-body-comment">
								■審査内容<br>
								<form:textarea path="applicationComment" htmlEscape="true" rows="5" cols="80"/>
								<form:errors path="applicationComment" class="validation-error"/>
							</div>
							<div class="customer-info-body-base">
								<h3>ご本人様情報</h3>
								<table class="customer">
									<tr>
										<th>氏名</th>
										<td><c:out value="${customerApplicationDto.firstname}" /> <c:out value="${customerApplicationDto.lastname}" /></td>
									</tr>
									<tr>
										<th>氏名（カナ）</th>
										<td><c:out value="${customerApplicationDto.firstnameKana}" /> <c:out value="${customerApplicationDto.lastnameKana}" /></td>
									</tr>
									<tr>
										<th>郵便番号</th>
										<td><c:out value="${customerApplicationDto.zip1}" /> - <c:out value="${customerApplicationDto.zip2}" /></td>
									</tr>
									<tr>
										<th>住所</th>
										<td><c:out value="${customerApplicationDto.addressPrefecture}" /> <br> <c:out value="${customerApplicationDto.addressCity}" /> <br> <c:out value="${customerApplicationDto.addressOoaza}" /> <br> <c:out
												value="${customerApplicationDto.addressAza}" /> <br> <c:out value="${customerApplicationDto.addressOther}" /></td>
									</tr>
									<tr>
										<th>電話番号</th>
										<td class=""><c:out value="${customerApplicationDto.tel1}" /> - <c:out value="${customerApplicationDto.tel2}" /> - <c:out value="${customerApplicationDto.tel3}" /></td>
									</tr>
									<tr>
										<th>携帯電話番号</th>
										<td class=""><c:out value="${customerApplicationDto.mobileTel1}" /> - <c:out value="${customerApplicationDto.mobileTel2}" /> - <c:out value="${customerApplicationDto.mobileTel3}" /></td>
									</tr>
									<tr>
										<th>メールアドレス</th>
										<td class=""><c:out value="${customerApplicationDto.email}" /></td>
									</tr>
									<tr>
										<th>ご家族について</th>
										<td><c:out value="${customerApplicationDto.dispSetaiFamily}" /></td>
									</tr>
									<tr>
										<th>世帯人数(同一生計の人数)</th>
										<td><c:out value="${customerApplicationDto.setaiCount}" /> 人世帯</td>
									</tr>
									<tr>
										<th>居住状況</th>
										<td><c:out value="${customerApplicationDto.dispSetaiStatus}" /></td>
									</tr>
									<tr>
										<th>居住年数</th>
										<td><c:out value="${customerApplicationDto.setaiYear}" /> 年</td>
									</tr>
									<tr>
										<th>住宅ローンもしくは家賃のお支払い</th>
										<td><c:out value="${customerApplicationDto.dispSetaiLoan}" /></td>
									</tr>
									<tr>
										<th>本人年収</th>
										<td><c:out value="${customerApplicationDto.income}" /> 万円</td>
									</tr>
									<tr>
										<th>預貯金額</th>
										<td><c:out value="${customerApplicationDto.savings}" /> 万円</td>
									</tr>
								</table>
							</div>
							<div class="customer-info-body-office">
								<h3>ご勤務先情報</h3>
								<table>
									<tr>
										<th>職業</th>
										<td><c:out value="${customerApplicationDto.dispEmploymentStatus}" /></td>
									</tr>
									<tr>
										<th>勤務先</th>
										<td><c:out value="${customerApplicationDto.companyName}" /></td>
									</tr>
									<tr>
										<th>部署</th>
										<td><c:out value="${customerApplicationDto.companyDepartment}" /></td>
									</tr>
									<tr>
										<th>郵便番号</th>
										<td><c:out value="${customerApplicationDto.companyZip1}" /> - <c:out value="${customerApplicationDto.companyZip2}" /></td>
									</tr>
									<tr>
										<th>住所</th>
										<td><c:out value="${customerApplicationDto.companyAddressPrefecture}" /> <br> <c:out value="${customerApplicationDto.companyAddressCity}" /> <br> <c:out value="${customerApplicationDto.companyAddressOoaza}" />
											<br> <c:out value="${customerApplicationDto.companyAddressAza}" /> <br> <c:out value="${customerApplicationDto.companyAddressOther}" /></td>
									</tr>
									<tr>
										<th>電話番号</th>
										<td><c:out value="${customerApplicationDto.companyTel1}" /> - <c:out value="${customerApplicationDto.companyTel2}" /> - <c:out value="${customerApplicationDto.companyTel3}" /></td>
									</tr>
									<tr>
										<th>業種</th>
										<td><c:out value="${customerApplicationDto.dispCompanyIndustryType}" /></td>
									</tr>
									<tr>
										<th>勤続年数</th>
										<td><c:out value="${customerApplicationDto.companyWorkYears}" /> 年</td>
									</tr>
								</table>
							</div>
							<br>
							<a href="${pageContext.request.contextPath}/application/search-cr/search" class="btn btn-primary">申請情報の検索</a>
							<a href="#" onclick="submit();" class="btn btn-warning">判定登録</a>
						</div>
						<form:hidden path="id"/>
						<form:hidden path="updateDate"/>
						</form:form>
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