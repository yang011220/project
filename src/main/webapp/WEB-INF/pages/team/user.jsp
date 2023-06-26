<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <base href="<%=request.getContextPath()%>/">	
       <script src="js/jquery-2.1.0.js"></script>
</head>
<body>
	<a href="../team/pipi/guanli" target="navTab" rel="main">云之家管理员专用</a></br>
	<li><span>一般用户</span></br></li>
	用户名：${users.userName }</br>
	<a href="team/tuandui/presave" target="navTab" rel="main">创建团队</a> </br>
	加入的团队：</br>
	<c:forEach items="${list}" var="scale">
  	  	团队名称:${scale.teamName}<a href="team/dept/sessionTeam?id=${scale.teamId }" target="navTab" rel="main">进入该团队</a>
    	团队管理员：${scale.creator}
    	<a href="../team/tuandui/preupdate?id=${scale.teamId}" target="navTab" rel="main">修改团队名称</a>
    	<a href="../team/tuandui/delete?id=${scale.teamId}" target="navTab" rel="main">解散团队</a>
    	<a href="../team/tuandui/delete?id=${scale.teamId}" target="navTab" rel="main">退出团队</a></br>
    </c:forEach>
	
</body>
</html>
