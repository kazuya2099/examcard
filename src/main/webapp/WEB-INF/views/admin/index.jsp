<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/layout.css" rel="stylesheet">

<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row">
		<div class="col-sm-12 header-block">
			<div class="header">
				<span class="glyphicon glyphicon-home" aria-hidden="true" style="font-size: 30px;"></span>
			</div>
			<span class="glyphicon glyphicon-home" aria-hidden="true" style="font-size: 30px;"></span>
			
		</div>
	</div>


	<div class="row">
		<div class="col-sm-2 content-block">
			<div class="body">
				<div>
					<div class="glyphicon glyphicon-user" aria-hidden="true" style="font-size: 30px;"></div><br>
					${userDto.firstName}　${userDto.lastName}<br>
					${userDto.department}<br>
					社員番号：${userDto.id}
				</div>
				<br>
				<div>
					<span class="module-title">■取引先管理</span>
					<div class="list-group">
						<a class="list-group-item" href="#">会社登録</a>
						<a class="list-group-item" href="#">会社検索</a>
					</div>
				</div>
				<br>
				<div>
					<span class="module-title">■商品管理</span>
					<div class="list-group">
						<a class="list-group-item" href="#">商品登録</a>
						<a class="list-group-item" href="#">商品検索</a>
					</div>
				</div>
				<br>
				<div>
					<span class="module-title">■ユーザ管理</span>
					<div class="list-group">
						<a class="list-group-item" href="#">ユーザ登録</a>
						<a class="list-group-item" href="#">ユーザ検索</a>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-10 content-block">
			<div class="contents">
				<font size="30">マニュアルは<a href="">こちら</a></font>
			</div>
		</div>
	</div>
</body>
</html>