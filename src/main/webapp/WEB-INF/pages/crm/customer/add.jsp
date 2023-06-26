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
	<form method="post" action="../customer/doAdd" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>客户名称：</label>
				<input name="cusName" class="required" type="text" size="30" alt="请输入客户名称"/>
			</p>
			<p>
				<label>客户年龄：</label>
				<input name="cusAge" class="required" type="text" size="30" alt="请输入客户年龄"/>
			</p>
			<p>
				<label>客户联系方式：</label>
				<input name="tel" class="required" type="text" size="30" alt="请输入客户联系方式"/>
			</p>
			<p>
				<label>客户地址：</label>
				<input name="cusLocation" class="required" type="text" size="30" alt="请输入客户地址"/>
			</p>
			<p>
				<label>客户公司：</label>
				<input name="cusCompany" class="required" type="text" size="30" alt="请输入客户公司"/>
			</p>
			<p>
				<label>客户职位：</label>
				<input name="cusPosition" class="required" type="text" size="30" alt="请输入客户职位"/>
			</p>
			
			<p>
				<label>客户归属团队：</label>
				<select id="team" name="teamId">
					<option selected="selected">请选择</option>
					<c:forEach items="${teamlist }" var="team">
						<option value="${team.teamId }">${team.teamName }</option>
					</c:forEach>
				</select>
			</p>
			
			<p>
				<label>客户归属人：</label>
				<select id="emp" name="empId">
					
				</select>
			</p>
			
			<p>
				<label>客户类型：</label>
				<select name="cusTypeId">
					<option selected="selected">请选择</option>
					<c:forEach items="${typelist }" var="custype">
						<option value="${custype.cusTypeId }">${custype.cusType }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>客户状态：</label>
				<select name="stateId">
					<option selected="selected">请选择</option>
					<c:forEach items="${statelist }" var="cusstate">
						<option value="${cusstate.stateId }">${cusstate.stateName }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>客户标签：</label>
				<select name="tagId">
					<option selected="selected">请选择</option>
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

