<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2><b>GLOBAL SYSTEM INFO PAGE</b></h2>
<h3>Please copy the local token as front-end credential</h3>
loginId: <span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.loginId}"/></span><br>
avatarUrl: <span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.avatarUrl}"/></span><br>
userName: <span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.userName}"/></span><br>
userEmail: <span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.userEmail}"/></span><br>
accessToken: <span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.accessToken}"/></span><br>
localToken: <span style="font-family:arial;font-size:16px;color:blue;"><c:out value="${USER_CONFIG.localToken}"/></span>