<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<div class="pageContent">
	<form method="post" action="../team/tuandui/save" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		
			<p><label>团队名称：</label>
	<input type="text" name="teamName"></br>
	</p>
	<p>
	</p>
	<p><label>请选择规模：</label>

		<select name="scaleId">
				<c:forEach items="${list.scaleList}" var="scale">
					<option  value="${scale.scaleId }">${scale.scaleName }</option>
				</c:forEach>
		
			</select>
			</p>
				
				<p>
	<c:forEach items="${list.type1Volist}" var="type1">
		<p>
		${type1.teamType1Name }
		<p>
			<c:forEach items="${type1.list}" var="type2">
			<p><input type="radio" name="teamType2Id" value="${type2.teamType2Id }" >${type2.teamType2Name }</p>
			</c:forEach>
	
		</c:forEach>
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








