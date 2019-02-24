<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" contentType="text/html; charset=EUC-KR"%>
<html>
<head>
	<meta charset="EUC-KR">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Home</title>
	<c:set var="resources" value="${pageContext.request.contextPath}/resources" />
	<link href="${resources}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${resources}/css/nav-bar.css" rel="stylesheet">
	<style type="text/css">
		.jumbotron{
			background-image: url('${resources}/images/background0.png');
			text-shadow: black 0.2em 0.2em 0.2em;
			color: white;
		}
	</style>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">네비게이션 바</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">버튼1<span class="sr-only"></span></a></li>
					<li><a href="#">버튼2</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toogle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded='false'>리스트<span class="caret"></span></a>
						<ul class=dropdown-menu>
							<li>항목1</li>
							<li>항목2</li>
						</ul>
					<li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="입력">
					</div>
					<button type="submit" class="btn btn-default">검색</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toogle" data-toggle="dropdown" role="button"
						aria-haspopup="true" aria-expanded='false'>접속하기<span class="caret"></span></a>
						<ul class=dropdown-menu>
							<li>로그인</li>
							<li>회원가입</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="container">
		<div class="jumbotron">
			<h1 class="text-center">점보트론</h1>
			<P class="text-center">  The time on the server is ${serverTime}. </P>
			<P class="text-center">  <a class="btn btn-primary btn-lg" href="#" role="button">버튼</a> </P>
		</div>	
	</div>
	
	<footer style="background-color: #000000; color: #ffffff">
		<div>
			<br>
			<div class="row">
				<div class="col-sm-2" style="text-align: center;"><h5>푸터</h5><h5>footer</h5></div>
				<div class="col-sm-4" style="text-align: left;"><h4>푸터</h4><h4>footer</h4></div>
				<div class="col-sm-2" style="text-align: center;"><h4>리스트</h4>
					<div class="list-group">
					<a href="#" class="list-group-item">aaa</a>
					<a href="#" class="list-group-item">bbb</a>
					</div>
				</div>
				<div class="col-sm-4"><span class="glyphicon-ok"></span>ccc</div>
			</div>
		</div>
	</footer>
	
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
