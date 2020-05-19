<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="text-center"><img width="350px" height="115px" src="<c:url value="/resources/image/logo_main.png"/>"></div>
				<div class="panel-heading">
					<h3 class="panel-title">Please click button to login:</h3>
				</div>
				<!-- DEV -->
				<div class="panel-body">
					<a id="btnUserLogin"
						class="btn btn-lg btn-success btn-block" 
						href="http://github.com/login/oauth/authorize?client_id=4d211460686aae6ab414&redirect_uri=http://localhost:8080/ford-findx/authorization/callback">
						Start to Sign in
					</a>
				</div>
				<!-- STG 
				<div class="panel-body">
					<a id="btnUserLogin"
						class="btn btn-lg btn-success btn-block" 
						href="http://github.com/login/oauth/authorize?client_id=17c2fcd07dc49ce2fac1&redirect_uri=https://www.skymarlio.com/ford-findx/authorization/callback">
						Start to Sign in
					</a>
				</div>-->
			</div>
		</div>
	</div>
</div>