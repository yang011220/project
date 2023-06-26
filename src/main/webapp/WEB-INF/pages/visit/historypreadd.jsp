<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<div class="pageContent">
	<form method="post" action="../history/historyDoAdd" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			
			<p>
				<label>拜访的客户：</label>
				<select id="cust" name="cust.cusId">
					<option selected="selected">请选择</option>
					<c:forEach items="${custList }" var="cust">
						<option value="${cust.cusId }">${cust.cusName }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>拜访时间：</label>
			 	<input type="date" name="visitTime" /> 
			</p>
			<p>
				<label>拜访计划：</label>
				<textarea rows="10" cols="20" name="visitRecord" class="required" placeholder="请输入计划结果"></textarea>
			</p>
			
			<p>
				<label>拜访原因：</label>
				<textarea rows="10" cols="20" name="visitReason" class="required" placeholder="请输入拜访计划起因"></textarea>
			</p>
			
			<p>
				<label>拜访位置：</label>
				<textarea rows="10" cols="20" name="visitPlace" class="required" placeholder="请输入拜访的位置"></textarea>
			</p>
			<p>
			 	<input type="hidden" name="emp.empId" value="${currentEmp.empId}"/> 
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

