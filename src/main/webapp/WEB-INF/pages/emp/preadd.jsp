<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>



<div class="pageContent">
	<form method="post" action="../emp/empDoAdd" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>员工姓名：</label>
				<input name="empName" class="required" type="text" size="30" alt="请输入员工姓名"/>
			</p>
			
			<p>
				<label>添加员工的：</label>
				<select id="user" name="userId">
					<option selected="selected">请选择</option>
					<c:forEach items="${userList }" var="user">
						<option value="${user.userId }">${user.userName }</option>
					</c:forEach>
				</select>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>

