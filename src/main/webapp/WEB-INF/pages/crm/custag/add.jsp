<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>


<div class="pageContent">
	<form method="post" action="../custag/doAdd" class="pageForm required-validate" enctype="multipart/form-data" onsubmit="return iframeCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			
			
			<p>
				<label>标签类型：</label>
				<select id="tagtypeId" name="tagtypeId">
					<option selected="selected">请选择</option>
					<c:forEach items="${list }" var="tagtype">
						<option value="${tagtype.tagtypeId }">${tagtype.tagtypeName }</option>
					</c:forEach>
				</select>
			</p>
			<p>
				<label>标签：</label>
				<input name="tagName" class="required" type="text" size="30" alt="请输入标签名"/>
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