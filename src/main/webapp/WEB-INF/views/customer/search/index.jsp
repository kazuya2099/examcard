<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<jsp:include page="../../common/head.jsp" flush="true" />
<link href="${pageContext.request.contextPath}/css/top/top.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/customer/customer.css" rel="stylesheet">
<title>exampleカード お客様の検索</title>
<script type="text/javascript">
<!--
// -->
</script>
</head>
<body>
	<jsp:include page="../../common/header.jsp" flush="true" />
	<div class="row">
		<div class="contents">
			<div class="col-sm-1 content-block">
				<div class="contents-left"></div>
			</div>

			<div class="col-sm-10 content-block">
				<div class="main-contents">
					<div class="customer-search">
						<div class="customer-search-title">
							<img src="${pageContext.request.contextPath}/images/h1.gif">お客様の検索
						</div>
						<div class="customer-search-body">
							<form:form name="search" method="GET" action="${pageContext.request.contextPath}/customer/search/execute" modelAttribute="searchCustomerForm">
							<div class="customer-search-body-item">
								<table>
								<tr>
									<th>氏名</th>
									<td>
										<form:input path="firstname" size="5" maxlength="5"/> <form:input path="lastname"  size="5" maxlength="5"/>
										<form:errors path="firstname" class="validation-error"/>
										<form:errors path="lastname" class="validation-error"/>
									</td>
									<th>氏名（カナ）</th>
									<td>
										<form:input path="firstnameKana" size="5" maxlength="10"/> <form:input path="lastnameKana"  size="5" maxlength="10"/>
										<form:errors path="firstnameKana" class="validation-error"/>
										<form:errors path="lastnameKana" class="validation-error"/>
									</td>
									<th>メールアドレス</th>
									<td class="">
										<form:input path="email" />
										<form:errors path="email" class="validation-error"/>
									</td>
								</tr>
								<tr>
									<th>郵便番号</th>
									<td>
										<form:input path="zip1" size="3" maxlength="3"/>-<form:input path="zip2"  size="4" maxlength="4"/>
										<form:errors path="zip1" class="validation-error"/>
										<form:errors path="zip2" class="validation-error"/>
									</td>
									<th>ご住所</th>
									<td><form:input path="addressPrefecture" placeholder="都道府県"/>
										<form:input path="addressCity" placeholder="市区郡" /><br>
										<form:input path="addressOoaza" placeholder="町村" /><br>
										<form:input path="addressAza" placeholder="番地等" /><br>
										<form:input path="addressOther" placeholder="アパート/マンション等" /><br>
										<form:errors path="addressPrefecture" class="validation-error"/>
										<form:errors path="addressCity" class="validation-error"/>
										<form:errors path="addressOoaza" class="validation-error"/>
										<form:errors path="addressAza" class="validation-error"/>
										<form:errors path="addressOther" class="validation-error"/>
									</td>
									<th>電話番号</th>
									<td>
										<form:input path="tel1" size="4" maxlength="4" />-<form:input path="tel2" size="4" maxlength="4" />-<form:input path="tel3" size="4" maxlength="4" />
										<form:errors path="tel1" class="validation-error"/>
										<form:errors path="tel2" class="validation-error"/>
										<form:errors path="tel3" class="validation-error"/>
									</td>
								</tr>
								<tr>
									<th>携帯電話番号</th>
									<td>
										<form:input path="mobileTel1" size="4" maxlength="3" />-<form:input path="mobileTel2" size="4" maxlength="4" />-<form:input path="mobileTel3" size="4" maxlength="4" />
										<form:errors path="mobileTel1" class="validation-error"/>
										<form:errors path="mobileTel2" class="validation-error"/>
										<form:errors path="mobileTel3" class="validation-error"/>
									</td>
									<th>ご家族について</th>
									<td>
										<form:select path="setaiFamily">
											<cus:options id="setaiFamily" itemLabel="value" itemValue="key"/>
										</form:select>
										<form:errors path="setaiFamily" />
									</td>
									<th>世帯人数(同一生計の人数)</th>
									<td>
										<form:input path="setaiCount" size="2" maxlength="2"/>人世帯
										<form:errors path="setaiCount" class="validation-error"/>
									</td>
								</tr>
								<tr>
									<th>居住状況</th>
									<td>
										<form:select path="setaiStatus">
											<cus:options id="setaiStatus" itemLabel="value" itemValue="key"/>
										</form:select>
										<form:errors path="setaiStatus" class="validation-error"/>
									</td>
									<th>居住年数</th>
									<td>
										<form:input path="setaiYear" size="2" maxlength="2"/>年
										<form:errors path="setaiYear" />
									</td>
									<th>住宅ローンもしくは家賃のお支払い</th>
									<td>
										<form:select path="setaiLoan">
											<cus:options id="setaiLoan" itemLabel="value" itemValue="key"/>
										</form:select>
										<form:errors path="setaiLoan" class="validation-error"/>
									</td>
								</tr>
								<tr>
									<th>本人年収</th>
									<td>
										<form:input path="income" size="12" maxlength="12"/>万円
										<form:errors path="income" class="validation-error"/>
									</td>
									<th>預貯金額</th>
									<td>
										<form:input path="savings" size="12" maxlength="12"/>万円
										<form:errors path="savings" class="validation-error"/>
									</td>
									<th>職業</th>
									<td>
										<form:select path="employmentStatus">
											<cus:options id="employmentStatus" itemLabel="value" itemValue="key"/>
										</form:select>
										<form:errors path="employmentStatus" class="validation-error"/>
									</td>
								</tr>
								</table>
								<form:button>検索</form:button>
							</div>
						</form:form>
						</div>

						<c:if test="${customerDtoList != null}">
							<c:if test="${searchCount == 0}">
								<div class="customer-search-result">
									<h3>該当するお客様はいませんでした。</h3>
								</div>
							</c:if>
							<c:if test="${searchCount > 0}">
								<div class="customer-search-result">
									<table>
									<tr>
										<th>氏名</th>
										<th>氏名（カナ）</th>
										<th>郵便番号</th>
										<th>住所</th>
										<th colspan="2">電話番号</th>
									</tr>
									<c:forEach var="customer" items="${customerDtoList}" varStatus="rowStatus">
									<tr>
										<td><c:out value="${customer.firstname}"/> <c:out value="${customer.lastname}"/></td>
										<td><c:out value="${customer.firstnameKana}"/> <c:out value="${customer.lastnameKana}"/></td>
										<td><c:out value="${customer.zip1}"/>-<c:out value="${customer.zip2}"/></td>
										<td>
											<c:out value="${customer.addressPrefecture}"/>
											<c:out value="${customer.addressCity}"/>
											<c:out value="${customer.addressOoaza}"/>
											<c:out value="${customer.addressAza}"/>
											<c:out value="${customer.addressOther}"/>
										</td>
										<td><c:out value="${customer.tel1}"/>-<c:out value="${customer.tel2}"/>-<c:out value="${customer.tel3}"/></td>
										<td>
											<a href="${pageContext.request.contextPath}/customer/edit/detail?id=${customer.id}" class="btn btn-primary">参照</a>
										</td>
									</tr>
									</c:forEach>
									</table>
								</div>
							</c:if>
						</c:if>
					</div>
				</div>
			</div>
			<div class="col-sm-1 content-block">
				<div class="contents-right"></div>
			</div>
		</div>
	</div>

	<div class="row">
		<div class="col-sm-12">
			<jsp:include page="../../common/footer.jsp" flush="true" />
		</div>
	</div>
</body>
</html>