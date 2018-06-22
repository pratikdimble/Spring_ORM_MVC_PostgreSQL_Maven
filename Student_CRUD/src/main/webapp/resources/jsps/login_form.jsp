<html ng-app = "mainApp">
	<head>
		<title>Login Form Responsive NEW</title>
		
			<!-- Meta tag Keywords -->
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script>
		addEventListener("load", function () {
			setTimeout(hideURLbar, 0);
		}, false);
		function hideURLbar() {
			window.scrollTo(0, 1);
		}
	</script>
	<!-- css files -->
	<link rel="stylesheet" href="resources/css/loginstyle.css" type="text/css" media="all" />
<!-- 	<link rel="stylesheet" href="resources/css/font-awesome.css"> -->
	<script  src = "resources/controller/firstpagecontroller.js"></script>
<!-- 	<script  src = "resources/service/genericservice.js"></script> -->
	
	 <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
    <script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular-route.min.js"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/1.0.18/angular-ui-router.min.js"></script>
    <script  src="//angular-ui.github.io/ui-router/release/angular-ui-router.js"></script>
   
	<!-- online-fonts -->
	<link href="//fonts.googleapis.com/css?family=Tangerine:400,700" rel="stylesheet">
	<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">

	<!--header-->
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Home</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
	</head>
<body>
	<form>
		<div class="header-w3l">
			<h1>
				<span>L</span>ogin
				<span>F</span>orm
			</h1>
		</div>
	<!--//header-->
	<div class="main-content-agile"  ng-controller = "logincontroller" ng-form="mvcForm">
		<div class="sub-main-w3">
			<div class="pom-agile">
				<span class="fa fa-user-o" aria-hidden="true"></span>
					<input placeholder="Username"  class="user" ng-model="form1.username" type="text" required="">
			</div>
			<div class="pom-agile">
				<span class="fa fa-key" aria-hidden="true"></span>
				<input placeholder="Password" class="pass" type="password" ng-model="form1.password" required="">
			</div>
				<div class="clear"></div>
				<div class="right-w3l">
					<button ng-click="login()">Login</button>
				</div>
				<p>Status::-----> {{msg}}</p>
<!-- 				{{status}} -->
			
		</div>
	</div>
	<!--//main-->
</form>
</body>
</html>
