<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<jsp:include page="../../../common/head.jsp" flush="true" />
<link href="${pageContext.request.contextPath}/css/top/top.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/customer/customer.css" rel="stylesheet">
<title>exampleカード 申請情報の照会・変更</title>
<script type="text/javascript">
<!--
	
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
							<img src="${pageContext.request.contextPath}/images/h1.gif">申請情報の詳細
						</div>
						<div class="customer-info-body">
							<div class="customer-info-body-status">
								■申請状況<br>
								<c:out value="${customerApplicationDto.dispApplicationStatus}"/>
							</div>
							<c:if test="${!StringUtils.isEmpty(customerApplicationDto.applicationComment)}">
								<div class="customer-info-body-comment">
									■コメント<br>
									<c:out value="${customerApplicationDto.applicationComment}"/>
								</div>
							</c:if>
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
								<c:if test="${customerApplicationDto.applicationStatus == '2'}">
									<a href="${pageContext.request.contextPath}/application/update-sa/input?id=${customerApplicationDto.id}" class="btn btn-primary">変更申請</a>
								</c:if>
							</div>
							<br>
							<a href="${pageContext.request.contextPath}/application/search-sa/search/execute" class="btn btn-primary">お客様検索へ戻る</a>
							<c:if test="${customerApplicationDto.applicationStatus == '1'}">
								<a href="${pageContext.request.contextPath}/application/APLDL10/delete" class="btn btn-warning">取下げ</a>
							</c:if>
							
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