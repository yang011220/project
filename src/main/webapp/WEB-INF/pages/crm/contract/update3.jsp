<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>



<div class="pageContent">
	<form method="post" action="../contract/doUpdate" class="pageForm required-validate" enctype="multipart/form-data" onsubmit="return iframeCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="contractId" value="${contract.contractId }"/>
			<p>
				<label>合同名称：</label>
				<input name="contractName" class="required" type="text" size="30" value="${contract.contractName }"/>
			</p>
			<p>
				<label>合同时间：</label>
				<input name="contractTime"  type="date" />
			</p>
			<p>
				<label>合同地点：</label>
				<input name="contractPlace" class="required" type="text" size="30" value="${contract.contractPlace }"/>
			</p>
			
			<p>
				<label>客户人：</label>
				<select id="customer" name="cusId">
					<option value="${contract.customer.cusId }" selected="selected">${contract.customer.cusName }</option>
					<c:forEach items="${customerlist }" var="customer">
						<option value="${customer.cusId }">${customer.cusName }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>合同金额：</label>
				<input name="money" class="required" type="text" size="30" value="${contract.money }"/>
			</p>
			
			<input type="hidden" name="teamId" value="${team.teamId }"/>
			
			<p>
				<label>合同签署人：</label>
				<select id="emp" name="empId">
					<option value="${contract.emp.empId }" selected="selected">${contract.emp.empName }</option>
					<c:forEach items="${emplist }" var="emp">
						<option value="${emp.empId }">${emp.empName }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>合同图片：</label>
				<input name="file"  type="file" size="30" />
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

