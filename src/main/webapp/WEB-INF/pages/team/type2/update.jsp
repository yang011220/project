<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="pageContent">
	<form method="post" action="../team/type2/update" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<input type="hidden" name="teamType2Id" value="${type2.teamType2Id}">
		<p><label> 请选择行业大类：</label>
		<c:forEach items="${type1List}" var="type1">
		    <input type="radio" name="teamType1Id" value="${type1.teamType1Id}" 
		  
		      />${type1.teamType1Name }
	
				</c:forEach>	
		</p>
			<p>
				<label>行业小类：</label>
				<input name="teamType2Name" class="required" type="text" size="30"  />
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





