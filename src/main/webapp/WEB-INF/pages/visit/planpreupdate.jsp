<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<div class="pageContent">
	<form method="post" action="../plan/planDoUpdate" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			
			<p>
				<input type="hidden" name="visitId" value="${visitPlan.visitId}"/>
			</p>
			<p>
				<label>要拜访的客户：</label>
				<select id="cust" name="cust.cusId">
					<option selected="selected" value="${visitPlan.cust.cusId }">${visitPlan.cust.cusName }</option>
					<c:forEach items="${mycust }" var="cust">
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
				<textarea rows="10" cols="20" name="plan" class="required" placeholder="${visitPlan.plan }"></textarea>
			</p>
			
			<p>
				<label>拜访原因：</label>
				<textarea rows="10" cols="20" name="reason" class="required" placeholder="${visitPlan.reason }"></textarea>
			</p>
			<p>
			 	<input type="hidden" name="emp.empId" value="${visitPlan.emp.empId}"/> 
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

