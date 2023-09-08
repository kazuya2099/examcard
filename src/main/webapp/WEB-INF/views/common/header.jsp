<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
	<div class="row">
		<div class="header">
			<div class="col-sm-2">
				<div class="header-left"></div>
			</div>
			<div class="col-sm-8">
				<div class="header-contents">
					<form:form name="header" action="${pageContext.request.contextPath}/logout">
					<ul class="nav nav-pills nav-justified">
						<li role="presentation"><a href="${pageContext.request.contextPath}/top"><span class="header-menu">トップ</span></a></li>
						<li role="presentation"><a href="${pageContext.request.contextPath}/application/create01/input"><span class="header-menu">新規申請</span></a></li>
						<li role="presentation"><a href="${pageContext.request.contextPath}/application/search01"><span class="header-menu">照会・変更申請</span></a></li>
						<li role="presentation"><a href="${pageContext.request.contextPath}/application/search02"><span class="header-menu">判定</span></a></li>
						<li role="presentation"><a href="javascript:header.submit();"><span class="header-menu">ログアウト</span></a></li>
					</ul>
					</form:form>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="header-right"></div>
			</div>
		</div>
	</div>