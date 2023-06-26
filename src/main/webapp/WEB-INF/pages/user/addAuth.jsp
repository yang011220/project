<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="pageContent">
	<form method="post" action="../user/addAuth" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
		<div class="pageFormContent" layoutH="50">
		<input type="hidden" name="userId" size="30"  value="${user.userId }" />
			<div class="unit">
				<p>
					<label>用户名：</label>
					<input type="text" name="userName" size="30" readonly="readonly" value="${user.userName }" />
				</p><br/><br/>
				<p>
					<label>权限：</label><br/><br/>
					<c:forEach items="${authList}" var="auth">
					<input type="hidden" name="authId" value="${auth.authId}">
					<input type="checkbox" name="authName" size="30"  value="${auth.authName }" />${auth.authName }<br/>
					</c:forEach>
				</p>
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>