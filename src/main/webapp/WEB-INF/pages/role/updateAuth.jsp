<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="pageContent">
	<form method="post" action="../role/updateAuth" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
		<div class="pageFormContent" layoutH="58">
			<div style="display: none" class="unit">
				 <input type="hidden" readonly="readonly" name="roleId" value="${role.roleId}" />
			</div>
			<p>
					<label>角色名：</label>
					<input type="text" name="roleName" size="30" readonly="readonly" value="${role.roleName }" />
				</p><br/><br/>
				<p>
					<label>权限：</label><br/><br/>
					<c:forEach var="auth" items="${authList }">
						<c:set var="isSelect" value="false" scope="request"></c:set>
						<c:forEach var="au" items="${auths}">
							<c:if test="${auth.authId==au.authId}">
								<c:set var="isSelect" value="true" scope="request"></c:set>
							</c:if>
						</c:forEach>
						<c:choose>
							<c:when test="${isSelect}">
								<input type="checkbox" checked="checked" name="authId" value="${auth.authId}"> ${auth.authName }
							</c:when>
							<c:otherwise>
								<input type="checkbox" name="authId" value="${auth.authId}"> ${auth.authName}
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
</div>