<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<div class="pageContent">
	<form method="post" action="../emp/empDoUpdate" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<input type="hidden" name="empId" value="${emp.empId }"/>
			<p>
				<label>员工姓名：</label>
				<input name="empName" class="required" type="text" size="30" value="${emp.empName }"/>
			</p>
			<p>
				<label>员工姓名：</label>
				<input name="empJob" class="required" type="text" size="30" value="${emp.empJob }"/>
			</p>
			<p>
				<label>添加员工的：</label>
				<select id="deptId" name="dept.deptId">
					<option selected="selected" value="${emp.dept.deptId }">${emp.dept.deptName }</option>
					<c:forEach items="${deptList }" var="dept">
						<option value="${dept.deptId }">${dept.deptName}</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>添加员工的：</label>
				<select id="roleId" name="role.roleId">
					<option selected="selected" value="${emp.role.roleId }">${emp.role.roleName }</option>
					<c:forEach items="${roleList }" var="role">
						<option value="${role.roleId }">${role.roleName }</option>
					</c:forEach>
				</select>
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>
