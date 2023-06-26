<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>



<div class="pageContent">
	<form method="post" action="../cushistory/doUpdate" class="pageForm required-validate" enctype="multipart/form-data" onsubmit="return iframeCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="historyId" value="${cushistory.historyId }"/>
			<p>
				<label>创建时间：</label>
				<input name="createTime" type="date" size="30"/>
			</p>
			
			<p>
				<label>客户人：</label>
				<select id="customer" name="cusId">
					<option value="${cushistory.customer.cusId }" selected="selected">${cushistory.customer.cusName }</option>
					<c:forEach items="${customerlist }" var="customer">
						<option value="${customer.cusId }">${customer.cusName }</option>
					</c:forEach>
				</select>
			</p>
			
			<input type="hidden" name="teamId" value="${team.teamId }"/>
			
			<p>
				<label>经办人：</label>
				<select id="emp" name="empId">
					<option value="${cushistory.emp.empId }" selected="selected">${cushistory.emp.empName }</option>
					<c:forEach items="${emplist }" var="emp">
						<option value="${emp.empId }">${emp.empName }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>内容：</label>
				<textarea name="context" class="required" rows="10" cols="100">${cushistory.context }</textarea>
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

