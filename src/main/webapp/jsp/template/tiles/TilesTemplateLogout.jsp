<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<title><tiles:getAsString name="PageTitle" ignore="true" /></title>
	<link rel="shortcut icon" href="<c:url value="/resources/favicon.ico"/>" />
	<!-- Bootstrap CSS -->
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/plugin/bootstrap-3.3.7/css/bootstrap.min.css"/>" />
	<!-- Customized CSS -->
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/css/login/login.css"/>?<%=System.currentTimeMillis() %>" />
</head>
<body>
	<tiles:insertAttribute name="BodyContent" />
</body>
<!-- jQuery -->
<script type="text/javascript" src="<c:url value="/resources/plugin/jQuery-3.3.1/jquery-min.js"/>"></script>
<!-- Bootstrap Core JavaScript -->
<script type="text/javascript" src="<c:url value="/resources/plugin/bootstrap-3.3.7/js/bootstrap.min.js"/>"></script>
<script type="text/javascript">var _contextRoot = '<%=request.getContextPath() %>';</script>
</html>