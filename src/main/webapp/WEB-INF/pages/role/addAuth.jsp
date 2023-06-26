<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="pageContent">
	<form method="post" action="../role/addAuth" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
		<div class="pageFormContent" layoutH="50">
		<input type="hidden" name="roleId" size="30"  value="${role.roleId }" />
			<div class="unit">
				<p>
					<label>角色名：</label>
					<input type="text" name="roleName" size="30" readonly="readonly" value="${role.roleName }" />
				</p><br/><br/>
				<p>
					<label>权限：</label><br/><br/>
					<c:forEach items="${authList}" var="auth">
					<input type="checkbox" name="authName" size="30"  value="${auth.authId }" />${auth.authName }<br/>
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