<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<jsp:include page="/WEB-INF/views/common/head.jsp" flush="true" />
<link href="${pageContext.request.contextPath}/css/top/top.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/customer/customer.css" rel="stylesheet">
<title>exampleカード 申請情報の検索</title>
<script type="text/javascript">
<!--
function submit(no) {
	var form = document.search;
	form.pageNo.value = no;
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
			<div class="col-sm-1 content-block">
				<div class="contents-left"></div>
			</div>

			<div class="col-sm-10 content-block">
				<div class="main-contents">
					<div class="customer-search">
						<div class="customer-search-title">
							<img src="${pageContext.request.contextPath}/images/h1.gif">申請情報の検索
						</div>
						<form:form name="search" method="GET" action="${pageContext.request.contextPath}/application/search01/search" modelAttribute="applicationSearch01Form">
						<div class="customer-search-body">
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
									<td>
										<form:input path="email" />
										<form:errors path="email" class="validation-error"/>
									</td>
									<th>申請状況</th>
									<td>
										<form:select path="applicationStatus">
											<form:options items="${outputDto.applicationStatus}" />
										</form:select>
										<form:errors path="applicationStatus" class="validation-error"/>
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
									<th>携帯電話番号</th>
									<td>
										<form:input path="mobileTel1" size="4" maxlength="3" />-<form:input path="mobileTel2" size="4" maxlength="4" />-<form:input path="mobileTel3" size="4" maxlength="4" />
										<form:errors path="mobileTel1" class="validation-error"/>
										<form:errors path="mobileTel2" class="validation-error"/>
										<form:errors path="mobileTel3" class="validation-error"/>
									</td>
								</tr>
								</table>
								<form:button>検索</form:button>
							</div>
						</div>

						<c:if test="${message != null}">
							<div class="error"><c:out value="${message}"/></div>
						</c:if>
						
						<c:if test="${not empty outputDto.error}">
							<c:out value="${outputDto.error}"/>
						</c:if>
						
						<c:if test="${empty outputDto.error}">
							<c:if test="${outputDto.customerApplicationDtos != null}">
								<c:if test="${outputDto.searchCount == 0}">
									<div class="customer-search-result">
										<h3>該当するお客様はいませんでした。</h3>
									</div>
								</c:if>
								<c:if test="${outputDto.searchCount > 0}">
									<c:out value="${outputDto.searchCount}"/>件 該当しました。
									<div class="pagenation">
										<ul>
											<li><a>prev</a></li>
											<li><span><c:out value="${form.pageNo}"/></span></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 1}"/>)"><c:out value="${form.pageNo + 1}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 2}"/>)"><c:out value="${form.pageNo + 2}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 3}"/>)"><c:out value="${form.pageNo + 3}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 4}"/>)"><c:out value="${form.pageNo + 4}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 5}"/>)"><c:out value="${form.pageNo + 5}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 6}"/>)"><c:out value="${form.pageNo + 6}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 7}"/>)"><c:out value="${form.pageNo + 7}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 8}"/>)"><c:out value="${form.pageNo + 8}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 9}"/>)"><c:out value="${form.pageNo + 9}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 9}"/>)">next</a></li>
										</ul>
									</div>
									<div class="customer-search-result">
										<table>
										<tr>
											<th>氏名</th>
											<th>氏名（カナ）</th>
											<th>郵便番号</th>
											<th>住所</th>
											<th>電話番号</th>
											<th colspan="2">申請状況</th>
										</tr>
										<c:forEach var="customerApplication" items="${outputDto.customerApplicationDtos}" varStatus="rowStatus">
										<tr>
											<td><c:out value="${customerApplication.firstname}"/> <c:out value="${customerApplication.lastname}"/></td>
											<td><c:out value="${customerApplication.lastnameKana}"/> <c:out value="${customerApplication.firstnameKana}"/></td>
											<td><c:out value="${customerApplication.zip1}"/>-<c:out value="${customerApplication.zip2}"/></td>
											<td>
												<c:out value="${customerApplication.addressPrefecture}"/>
												<c:out value="${customerApplication.addressCity}"/>
												<c:out value="${customerApplication.addressOoaza}"/>
												<c:out value="${customerApplication.addressAza}"/>
												<c:out value="${customerApplication.addressOther}"/>
											</td>
											<td><c:out value="${customerApplication.tel1}"/>-<c:out value="${customerApplication.tel2}"/>-<c:out value="${customerApplication.tel3}"/></td>
											<td><c:out value="${customerApplication.dispApplicationStatus}"/></td>
											<td>
												<a href="${pageContext.request.contextPath}/application/detail01/index?id=${customerApplication.id}" class="btn btn-primary">参照</a>
											</td>
										</tr>
										</c:forEach>
										</table>
									</div>
									<div class="pagenation">
										<ul>
											<li><a>prev</a></li>
											<li><span><c:out value="${form.pageNo}"/></span></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 1}"/>)"><c:out value="${form.pageNo + 1}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 2}"/>)"><c:out value="${form.pageNo + 2}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 3}"/>)"><c:out value="${form.pageNo + 3}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 4}"/>)"><c:out value="${form.pageNo + 4}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 5}"/>)"><c:out value="${form.pageNo + 5}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 6}"/>)"><c:out value="${form.pageNo + 6}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 7}"/>)"><c:out value="${form.pageNo + 7}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 8}"/>)"><c:out value="${form.pageNo + 8}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 9}"/>)"><c:out value="${form.pageNo + 9}"/></a></li>
											<li><a href="#" onclick="submit(<c:out value="${form.pageNo + 9}"/>)">next</a></li>
										</ul>
									</div>
								</c:if>
							</c:if>
						</c:if>
						<form:hidden path="pageNo"/>
					</form:form>
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
			<jsp:include page="/WEB-INF/views/common/footer.jsp" flush="true" />
		</div>
	</div>
</body>
</html>