<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<script>
	$(function () {
		$("#team").change(function () {
			$.get("../customer/findEmplist",{"teamId":$("#team").val()},function(data){
				var emp=$("#emp")[0];
				emp.options.length=0;
				$.each(data,function(index,obj){
					emp.options.add(new Option(obj.empName,obj.empId));
				});
			});
		});
	});
</script>

<div class="pageContent">
	<form method="post" action="../customer/doUpdate" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<input type="hidden" name="cusId" value="${customer.cusId }"/>
			<p>
				<label>客户名称：</label>
				<input name="cusName" class="required" type="text" size="30" value="${customer.cusName }"/>
			</p>
			<p>
				<label>客户年龄：</label>
				<input name="cusAge" class="required" type="text" size="30" value="${customer.cusAge }"/>
			</p>
			<p>
				<label>客户联系方式：</label>
				<input name="tel" class="required" type="text" size="30" value="${customer.tel }"/>
			</p>
			<p>
				<label>客户地址：</label>
				<input name="cusLocation" class="required" type="text" size="30" value="${customer.cusLocation }"/>
			</p>
			<p>
				<label>客户公司：</label>
				<input name="cusCompany" class="required" type="text" size="30" value="${customer.cusCompany }"/>
			</p>
			<p>
				<label>客户职位：</label>
				<input name="cusPosition" class="required" type="text" size="30" value="${customer.cusPosition }"/>
			</p>
			
			<p>
				<label>客户归属团队：</label>
				<select id="team" name="teamId">
					<option value="${team.teamId }" selected="selected">${team.teamName }</option>
					<c:forEach items="${teamlist }" var="team">
						<option value="${team.teamId }">${team.teamName }</option>
					</c:forEach>
				</select>
			</p>
			
			<p>
				<label>客户归属人：</label>
				<select id="emp" name="empId">
					<option value="${customer.emp.empId }" selected="selected">${customer.emp.empName }</option>
					
				</select>
			</p>
			
			<p>
				<label>客户类型：</label>
				<select name="cusTypeId">
					<option value="${customer.custype.cusTypeId }" selected="selected">${customer.custype.cusType }</option>
					<c:forEach items="${typelist }" var="custype">
						<option value="${custype.cusTypeId }">${custype.cusType }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>客户状态：</label>
				<select name="stateId">
					<option value="${customer.cusstate.stateId }" selected="selected">${customer.cusstate.stateName }</option>
					<c:forEach items="${statelist }" var="cusstate">
						<option value="${cusstate.stateId }">${cusstate.stateName }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>客户标签：</label>
				<select name="tagId">
					<option value="${customer.custag.tagId }" selected="selected">${customer.custag.tagName }</option>
					<c:forEach items="${taglist }" var="custag">
						<option value="${custag.tagId }">${custag.tagName }</option>
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

