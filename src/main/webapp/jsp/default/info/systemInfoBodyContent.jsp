<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<div class="container">
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="basic-panel panel panel-default">
				<div class="text-center"><img src="<c:url value="${USER_CONFIG.avatarUrl}"/>"></div>
				<div class="panel-heading">
					<h3 class="panel-title">GLOBAL SYSTEM INFO PAGE :: Result from GitHub</h3>
				</div>
				<div class="panel-body table-responsive">
					<table class="table table-striped">
						<tr>
							<td>loginId:</td>
							<td><span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.loginId}"/></span></td>
						</tr>
						<tr>
							<td>avatarUrl:</td>
							<td><span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.avatarUrl}"/></span></td>
						</tr>
						<tr>
							<td>userName:</td>
							<td><span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.userName}"/></span></td>
						</tr>
						<tr>
							<td>userEmail:</td>
							<td><span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.userEmail}"/></span></td>
						</tr>
						<tr>
							<td>accessToken:</td>
							<td><span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.accessToken}"/></span></td>
						</tr>
						<tr>
							<td>localToken:</td>
							<td><span style="font-family:arial;font-size:16px;color:red;"><b><c:out value="${USER_CONFIG.localToken}"/></b></span> (Note: <b>use this token as 'X-Author-Token'</b>)</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>