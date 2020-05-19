<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-default">
				<div class="text-center"><img width="350px" height="115px" src="<c:url value="/resources/image/logo_main.png"/>"></div>
				<div class="panel-heading">
					<h3 class="panel-title">User Logout Page</h3>
				</div>
				<div class="panel-body">
					<a href="<c:url value="/user/default/loginform"/>">Back to Login</a>
					<br>
					<p>${message}</p>
				</div>
			</div>
		</div>
	</div>
</div>