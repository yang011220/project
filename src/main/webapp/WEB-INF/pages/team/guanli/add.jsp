






<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <base href="<%=request.getContextPath()%>/">
   <script src="js/jquery-2.1.0.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="../team/tuandui/save" method="post">
	团队名称<input type="text" name="teamName"></br>
	<c:forEach items="${list.type1Volist}" var="type1">
		<span>
		${type1.teamType1Name }
		</span></br>
		<span>
			<c:forEach items="${type1.list}" var="type2">
			<input type="radio" name="teamType2Id" value="${type2.teamType2Id }" >${type2.teamType2Name }
			</c:forEach>
		</span></br>	
		
	</c:forEach></br>
		规模<select name="scaleId">
				<c:forEach items="${list.scaleList}" var="scale">
					<option  value="${scale.scaleId }">${scale.scaleName }</option>
				</c:forEach>
		</select>
			<input type="submit" value="提交">
	</form>	
</body>
</html>
