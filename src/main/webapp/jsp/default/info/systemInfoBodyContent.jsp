<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<div class="container align">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="basic-panel panel panel-default">
				<div class="text-center"><img width="350px" height="115px" src="<c:url value="/resources/image/logo_main.png"/>"></div>
				<div class="panel-heading">
					<h3 class="panel-title">GLOBAL SYSTEM INFO PAGE :: Result from GitHub</h3>
				</div>
				<div class="panel-body">
					loginId: <span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.loginId}"/></span><br>
					avatarUrl: <span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.avatarUrl}"/></span><br>
					userName: <span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.userName}"/></span><br>
					userEmail: <span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.userEmail}"/></span><br>
					accessToken: <span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.accessToken}"/></span><br>
					localToken: <span style="font-family:arial;font-size:16px;color:red;"><b><c:out value="${USER_CONFIG.localToken}"/></b></span> (Note: <b>use this token as 'X-Author-Token'</b>)
				</div>
			</div>
		</div>
	</div>
</div>